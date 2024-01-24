package usa.cincospenguinos.minecart_storage;

import org.bukkit.entity.Vehicle;
import org.bukkit.entity.minecart.StorageMinecart;
import org.bukkit.event.vehicle.VehicleCreateEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.junit.Test;
import usa.cincospenguinos.minecart_storage.mocks.MockStorageMinecart;

import static org.junit.Assert.*;

public class StorageMinecartListenerTest {

    @Test
    public void test_AddsStorageMinecartOnCreate() {
        StorageMinecartListener listener = new StorageMinecartListener();
        listener.onVehicleCreated(new VehicleCreateEvent(new MockStorageMinecart(12)));
        assertTrue(listener.isTrackingCart(12));
    }

    @Test
    public void test_RemovesStorageMinecartOnDestroy() {
        StorageMinecart cart = new MockStorageMinecart(12);
        StorageMinecartListener listener = new StorageMinecartListener();
        listener.onVehicleCreated(new VehicleCreateEvent(cart));
        assertTrue(listener.isTrackingCart(12));

        listener.onVehicleDestroyed(new VehicleDestroyEvent(cart, null));
        assertFalse(listener.isTrackingCart(12));
    }
}