package usa.cincospenguinos.minecart_storage;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.Vehicle;
import org.bukkit.entity.minecart.StorageMinecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleCreateEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.event.vehicle.VehicleMoveEvent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StorageMinecartListener implements Listener {
    private Map<Integer, StorageMinecart> _minecartsToTrack = new HashMap<>();
    private Map<Integer, Set<Chunk>> _chunksPreserved = new HashMap<>();
    private BetterLogger _logger;

    public StorageMinecartListener() {}

    public StorageMinecartListener(BetterLogger logger) {
        _logger = logger;
    }

    public boolean isTrackingCart(int id) {
        return _minecartsToTrack.containsKey(id);
    }

    @EventHandler
    public void onVehicleCreated(VehicleCreateEvent event) {
        vehicleRequiresTracking(event.getVehicle());
    }

    @EventHandler
    public void onVehicleMoved(VehicleMoveEvent event) {
        Vehicle cart = event.getVehicle();
        if (vehicleRequiresTracking(cart)) {
            Chunk chunk = event.getTo().getChunk();
            Set<Chunk> chunksRelevantToCart = _chunksPreserved.get(cart.getEntityId());

            if (!chunksRelevantToCart.contains(chunk)) {
                chunk.setForceLoaded(true);
                chunksRelevantToCart.add(chunk);
            }
        }
    }

    private boolean vehicleRequiresTracking(Vehicle vehicle) {
        if (vehicle instanceof StorageMinecart && !_minecartsToTrack.containsKey(vehicle.getEntityId())) {
            log("Registering " + vehicle.getEntityId());
            _minecartsToTrack.put(vehicle.getEntityId(), (StorageMinecart) vehicle);
            _chunksPreserved.put(vehicle.getEntityId(), new HashSet<>());
            return true;
        }

        return _minecartsToTrack.containsKey(vehicle.getEntityId());
    }

    @EventHandler
    public void onVehicleDestroyed(VehicleDestroyEvent event) {
        Vehicle vehicle = event.getVehicle();
        if (vehicle instanceof StorageMinecart) {
            log("Removing " + vehicle.getEntityId());
            _minecartsToTrack.remove(vehicle.getEntityId());
            _chunksPreserved.get(vehicle.getEntityId()).forEach(c -> c.setForceLoaded(false));
            _chunksPreserved.remove(vehicle.getEntityId());
        }
    }

    private void log(String msg) {
        if (_logger != null) {
            _logger.info(msg);
        }
    }

    public void clearRegisteredCarts() {
        _minecartsToTrack.clear();
    }
}
