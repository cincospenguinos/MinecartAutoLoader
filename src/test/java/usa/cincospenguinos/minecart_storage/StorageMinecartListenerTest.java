package usa.cincospenguinos.minecart_storage;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Vehicle;
import org.bukkit.entity.minecart.StorageMinecart;
import org.bukkit.event.vehicle.VehicleCreateEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.junit.Test;
import usa.cincospenguinos.minecart_storage.mocks.MockChunk;
import usa.cincospenguinos.minecart_storage.mocks.MockMinecart;
import usa.cincospenguinos.minecart_storage.mocks.MockStorageMinecart;
import usa.cincospenguinos.minecart_storage.mocks.MockWorld;

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

    @Test
    public void test_DoesNotAddARegularMinecartOnCreate() {
        Minecart regularCart = new MockMinecart(12);
        StorageMinecartListener listener = new StorageMinecartListener();
        listener.onVehicleCreated(new VehicleCreateEvent(regularCart));
        assertFalse(listener.isTrackingCart(12));
    }

    @Test
    public void test_AddsStorageCartOnMovement() {
        MockWorld mockWorld = new MockWorld();
        mockWorld.setChunkToReturn(new MockChunk());

        StorageMinecart cart = new MockStorageMinecart(12);
        StorageMinecartListener listener = new StorageMinecartListener();
        listener.onVehicleMoved(new VehicleMoveEvent(cart, new Location(mockWorld, 0, 0, 0), new Location(mockWorld, 1, 1, 1)));
        assertTrue(listener.isTrackingCart(12));
    }

    @Test
    public void test_ForceLoadsChunksCartMovesInto() {
        Chunk mockChunk = new MockChunk();
        assertFalse(mockChunk.isForceLoaded());
        MockWorld mockWorld = new MockWorld();
        mockWorld.setChunkToReturn(mockChunk);
        StorageMinecart cart = new MockStorageMinecart(12);
        StorageMinecartListener listener = new StorageMinecartListener();
        listener.onVehicleCreated(new VehicleCreateEvent(cart));
        listener.onVehicleMoved(new VehicleMoveEvent(cart, new Location(mockWorld, 0, 0, 0), new Location(mockWorld, 0, 1, 12)));
        assertTrue(mockChunk.isForceLoaded());
    }
}
