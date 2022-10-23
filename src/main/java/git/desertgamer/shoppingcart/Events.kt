package git.desertgamer.shoppingcart

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerBedEnterEvent
import org.bukkit.event.player.PlayerJoinEvent
import java.lang.Exception

object Events : Listener {
    
    @EventHandler
    fun onPlayerJoin(e: PlayerJoinEvent) {
        val player = e.player

//        e.joinMessage = "Hello ${player.name}!"

        // Свитчи в Kotlin меняются на when и немного меняется их вид, есть возможность использовать как в одну строку, так и в несколько строк с помощью фигурных скобок
        when(player.name) {
            "Maksim" -> "Ты самый лучший зритель"
            "MrDefri" -> {
                "Ты самый лучший разработчик на Kotlin"
            }
            else -> {
                "Что-то пошло не так"
            }
        }
    }

    @EventHandler
    fun onPlayerBedEnter(e: PlayerBedEnterEvent){
        val player = e.player

        val list = listOf<String>("Test", "Test2", "Test3") // Создание списка объектов в любом формате
        val array_list = arrayListOf<String>("Test", "Test2", "Test3") // Создание массива объектов в любом формате
        val array_int = intArrayOf(1, 2, 3) // Создание массива объектов в Int формате
        val array_long = longArrayOf(2, 3, 5) // Создание массива объектов в Long формате

        // Как работает forEach в Kotlin, в данном случае it является элементом
        list.forEach({
            player.sendMessage(it);
        })

        // Как работают циклы for в Kotlin, если нужно перебрать массив объектов
        for (item in list){
            player.sendMessage(item);
        }

        // Как работаю циклы for в Kotlin, если нужно например вывести цифры с 1 до 5
        for(i in 1..5){
            player.sendMessage(i.toString());
        }

        try {
            for (elem in player.server.whitelistedPlayers) {
                player.sendMessage("Ник: ${elem.name}\nСтатус онлайна:${if(elem.isOnline == true) "Онлайн" else if(elem.isOnline == false) "Оффлайн" else "Не найден"}");
            }
        } catch(e: Exception){

        }
    }
}