package usa.cincospenguinos.minecart_storage;

import org.bukkit.plugin.java.JavaPlugin;

public final class MinecartStorage extends JavaPlugin {
    private final BetterLogger _logger = new BetterLogger(getLogger());
    private final StorageMinecartListener listener = new StorageMinecartListener(_logger);

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(listener, this);
    }

    @Override
    public void onDisable() {
        listener.clearRegisteredCarts();
    }
}
