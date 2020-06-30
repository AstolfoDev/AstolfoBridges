package tech.astolfo.astolfobridges;

import org.bukkit.plugin.java.JavaPlugin;
import tech.astolfo.astolfobridges.Listener.ABridgesListener;
import tech.astolfo.astolfobridges.commands.Start;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class AstolfoBridges extends JavaPlugin {

    @Override
    public void onEnable() {
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        this.getServer().getPluginManager().registerEvents(new ABridgesListener(), this);
        this.getCommand("start").setExecutor(new Start());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
