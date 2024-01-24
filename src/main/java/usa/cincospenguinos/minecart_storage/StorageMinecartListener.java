package usa.cincospenguinos.minecart_storage;

import org.bukkit.entity.Vehicle;
import org.bukkit.entity.minecart.StorageMinecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleCreateEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;

import java.util.HashMap;
import java.util.Map;

public class StorageMinecartListener implements Listener {
    private Map<Integer, StorageMinecart> _minecartsToTrack = new HashMap();
    private BetterLogger _logger;

    public StorageMinecartListener() {}

    public StorageMinecartListener(BetterLogger logger) {
        _logger = logger;

        _logger.info("Created storage minecart listener!");
    }

    public boolean isTrackingCart(int id) {
        return _minecartsToTrack.containsKey(id);
    }

    @EventHandler
    public void onVehicleCreated(VehicleCreateEvent event) {
        Vehicle vehicle = event.getVehicle();
        if (vehicle instanceof StorageMinecart) {
            log("Registering " + vehicle.getEntityId());
            _minecartsToTrack.put(vehicle.getEntityId(), (StorageMinecart) vehicle);
        }
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
