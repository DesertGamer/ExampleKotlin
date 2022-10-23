package git.desertgamer.shoppingcart.commands

import git.desertgamer.shoppingcart.Main
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player

object Heal : CommandExecutor {
    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<out String>): Boolean
    {
//        if(sender.hasPermission())

        when (args.size) {
            0 -> {
                sender.sendMessage("Неверные параметры")
                return true
            }
            1 -> {
                val target : Player? = Bukkit.getPlayer(args[0])
                if(target !is Player){
                    sender.sendMessage("Your not player!")
                    return true
                }

                target.allowFlight = target.allowFlight != true
                return true
            }
            else -> {
                sender.sendMessage(Main.instance.config.getString(""))
                return true
            }
        }

        return true
    }
}

object FlyTabCompleter : TabCompleter {
    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): MutableList<String>? {
        if(args.size != 1) return ArrayList();
//        if(sender !is Player) return ArrayList();

        val list = ArrayList<String>();
        for(player in Bukkit.getOnlinePlayers()){
//            if(player.name.contains(args[0], true)){
                list.add("Test");
//            }
        }

        return list;
    }
}