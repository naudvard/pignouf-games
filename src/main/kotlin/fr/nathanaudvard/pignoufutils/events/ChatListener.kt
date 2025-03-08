package fr.nathanaudvard.pignoufutils.events

import io.papermc.paper.event.player.AsyncChatEvent
import net.kyori.adventure.text.TextComponent
import org.bukkit.Bukkit
import org.bukkit.Sound
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class ChatListener : Listener {
    @EventHandler
    fun onChat(event: AsyncChatEvent) {
        val message = (event.message() as? TextComponent)?.content() ?: return

        Bukkit.getOnlinePlayers()
            .filter { message.contains(it.name) }
            .forEach {
                it.playSound(it.location, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f)
            }
    }
}