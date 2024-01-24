package usa.cincospenguinos.minecart_storage.mocks;

import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Minecart;
import org.bukkit.material.MaterialData;
import org.bukkit.util.Vector;

public class MockMinecart extends MockEntity implements Minecart {
    public MockMinecart(int id) {
        super(id);
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
}
