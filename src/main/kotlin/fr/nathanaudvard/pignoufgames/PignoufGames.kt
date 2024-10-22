package fr.nathanaudvard.pignoufgames

import fr.nathanaudvard.pignoufgames.input.commands.DACCommand
import fr.nathanaudvard.pignoufgames.input.commands.PignoufGamesCommand
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents
import org.bukkit.plugin.java.JavaPlugin


class PignoufGames : JavaPlugin() {

    override fun onEnable() {
        logger.info("PignoufGames is starting")

        lifecycleManager.registerEventHandler(LifecycleEvents.COMMANDS) { event ->
            val commands = event.registrar()
            commands.register("pignoufgames", "PignoufGames, le prime.", listOf("pg"), PignoufGamesCommand())
            commands.register("dac", "Dé à coudre", DACCommand())
        }
    }
}
