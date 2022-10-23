package git.desertgamer.shoppingcart

import git.desertgamer.shoppingcart.commands.FlyTabCompleter
import git.desertgamer.shoppingcart.commands.Heal
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    companion object {
        lateinit var instance : Main;
    }

    init {
        instance = this;
    }

    override fun onEnable() {
        logger.info("Enable plugin")

        server.pluginManager.registerEvents(Events, this);
        getCommand("fly")?.setExecutor(Heal);
        getCommand("fly")?.tabCompleter = FlyTabCompleter;
    }
    override fun onDisable() {
        logger.info("Disable plugin")
    }

    public fun getPlugin(){
        return this.getPlugin();
    }
}