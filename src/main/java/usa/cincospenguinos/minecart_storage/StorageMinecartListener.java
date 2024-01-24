package usa.cincospenguinos.minecart_storage;

import org.bukkit.entity.Vehicle;
import org.bukkit.entity.minecart.StorageMinecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleCreateEvent;
import java.util.HashMap;
import java.util.Map;

public class StorageMinecartListener implements Listener {
    private Map<Integer, StorageMinecart> _minecartsToTrack = new HashMap();

    public boolean isTrackingCart(int id) {
        return _minecartsToTrack.containsKey(id);
    }

    @EventHandler
    public void onVehicleCreated(VehicleCreateEvent event) {
        Vehicle vehicle = event.getVehicle();
        if (vehicle instanceof StorageMinecart) {
            _minecartsToTrack.put(vehicle.getEntityId(), (StorageMinecart) vehicle);
        }
    }
}
