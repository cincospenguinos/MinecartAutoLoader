package usa.cincospenguinos.minecart_storage.mocks;

import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Vehicle;
import org.bukkit.entity.minecart.StorageMinecart;
import org.bukkit.inventory.Inventory;
import org.bukkit.loot.LootTable;
import org.bukkit.material.MaterialData;
import org.bukkit.util.Vector;

public class MockStorageMinecart extends MockEntity implements StorageMinecart {
    private int _entityId;

    public MockStorageMinecart(int entityId) {
        _entityId = entityId;
    }

    @Override
    public int getEntityId() {
        return _entityId;
    }

    @Override
    public void setDamage(double damage) {

    }

    @Override
    public double getDamage() {
        return 0;
    }

    @Override
    public double getMaxSpeed() {
        return 0;
    }

    @Override
    public void setMaxSpeed(double speed) {

    }

    @Override
    public boolean isSlowWhenEmpty() {
        return false;
    }

    @Override
    public void setSlowWhenEmpty(boolean slow) {

    }

    @Override
    public Vector getFlyingVelocityMod() {
        return null;
    }

    @Override
    public void setFlyingVelocityMod(Vector flying) {

    }

    @Override
    public Vector getDerailedVelocityMod() {
        return null;
    }

    @Override
    public void setDerailedVelocityMod(Vector derailed) {

    }

    @Override
    public void setDisplayBlock(MaterialData material) {

    }

    @Override
    public MaterialData getDisplayBlock() {
        return null;
    }

    @Override
    public void setDisplayBlockData(BlockData blockData) {

    }

    @Override
    public BlockData getDisplayBlockData() {
        return null;
    }

    @Override
    public void setDisplayBlockOffset(int offset) {

    }

    @Override
    public int getDisplayBlockOffset() {
        return 0;
    }

    @Override
    public Inventory getInventory() {
        return null;
    }

    @Override
    public void setLootTable(LootTable table) {

    }

    @Override
    public LootTable getLootTable() {
        return null;
    }

    @Override
    public void setSeed(long seed) {

    }

    @Override
    public long getSeed() {
        return 0;
    }
}
