package usa.cincospenguinos.minecart_storage;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class MinecartStorage extends JavaPlugin {
    private final BetterLogger _logger = new BetterLogger(getLogger());

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new StorageMinecartListener(), this);
    }

    @Override
    public void onDisable() {
        _logger.info("Goodbye, world!");
    }
}