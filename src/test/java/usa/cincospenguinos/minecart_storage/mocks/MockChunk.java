package usa.cincospenguinos.minecart_storage.mocks;

import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Entity;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;

import java.util.Collection;

public class MockChunk implements Chunk {
    private boolean _isForceLoaded = false;

    public MockChunk() {}

    @Override
    public void setForceLoaded(boolean forced) {
        _isForceLoaded = forced;
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getZ() {
        return 0;
    }

    @Override
    public World getWorld() {
        return null;
    }

    @Override
    public Block getBlock(int x, int y, int z) {
        return null;
    }

    @Override
    public ChunkSnapshot getChunkSnapshot() {
        return null;
    }

    @Override
    public ChunkSnapshot getChunkSnapshot(boolean includeMaxblocky, boolean includeBiome, boolean includeBiomeTempRain) {
        return null;
    }

    @Override
    public boolean isEntitiesLoaded() {
        return false;
    }

    @Override
    public Entity[] getEntities() {
        return new Entity[0];
    }

    @Override
    public BlockState[] getTileEntities() {
        return new BlockState[0];
    }

    @Override
    public boolean isGenerated() {
        return false;
    }

    @Override
    public boolean isLoaded() {
        return false;
    }

    @Override
    public boolean load(boolean generate) {
        return false;
    }

    @Override
    public boolean load() {
        return false;
    }

    @Override
    public boolean unload(boolean save) {
        return false;
    }

    @Override
    public boolean unload() {
        return false;
    }

    @Override
    public boolean isSlimeChunk() {
        return false;
    }

    @Override
    public boolean isForceLoaded() {
        return _isForceLoaded;
    }

    @Override
    public boolean addPluginChunkTicket(Plugin plugin) {
        return false;
    }

    @Override
    public boolean removePluginChunkTicket(Plugin plugin) {
        return false;
    }

    @Override
    public Collection<Plugin> getPluginChunkTickets() {
        return null;
    }

    @Override
    public long getInhabitedTime() {
        return 0;
    }

    @Override
    public void setInhabitedTime(long ticks) {

    }

    @Override
    public boolean contains(BlockData block) {
        return false;
    }

    @Override
    public boolean contains(Biome biome) {
        return false;
    }

    @Override
    public LoadLevel getLoadLevel() {
        return null;
    }

    @Override
    public PersistentDataContainer getPersistentDataContainer() {
        return null;
    }
}
