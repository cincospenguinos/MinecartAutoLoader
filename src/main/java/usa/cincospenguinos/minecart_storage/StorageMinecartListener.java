package usa.cincospenguinos.minecart_storage;

import org.bukkit.entity.Vehicle;
import org.bukkit.entity.minecart.StorageMinecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleCreateEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.event.vehicle.VehicleMoveEvent;

import java.util.HashMap;
import java.util.Map;

public class StorageMinecartListener implements Listener {
    private Map<Integer, StorageMinecart> _minecartsToTrack = new HashMap();
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
        if (vehicleRequiresTracking(event.getVehicle())) {
            // TODO: Go ahead and set what chunks need to be loaded
            log(">>> Moving to " + event.getTo().toString());
        }
    }

    private boolean vehicleRequiresTracking(Vehicle vehicle) {
        if (vehicle instanceof StorageMinecart) {
            log("Registering " + vehicle.getEntityId());
            _minecartsToTrack.put(vehicle.getEntityId(), (StorageMinecart) vehicle);
            return true;
        }

        return false;
    }

    @EventHandler
    public void onVehicleDestroyed(VehicleDestroyEvent event) {
        Vehicle vehicle = event.getVehicle();
        if (vehicle instanceof StorageMinecart) {
            log("Removing " + vehicle.getEntityId());
            _minecartsToTrack.remove(vehicle.getEntityId());
        }
    }

    private void log(String msg) {
        if (_logger != null) {
            _logger.info(msg);
        }
    }
}
