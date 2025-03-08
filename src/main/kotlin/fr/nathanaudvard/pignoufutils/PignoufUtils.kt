package fr.nathanaudvard.pignoufutils

import fr.nathanaudvard.pignoufutils.commands.EnchantMoreCommand
import fr.nathanaudvard.pignoufutils.events.ChatListener
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents
import org.bukkit.plugin.java.JavaPlugin
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.dsl.module


class PignoufUtils : JavaPlugin(), KoinComponent {
    private val enchantMoreCommand: EnchantMoreCommand by inject()

    override fun onEnable() {
        startKoin {
            modules(module {
                single { EnchantMoreCommand() }
            })
        }

        server.pluginManager.registerEvents(ChatListener(), this)

        lifecycleManager.registerEventHandler(LifecycleEvents.COMMANDS) { event ->
            event.registrar().register(enchantMoreCommand.execute())
        }
    }
}
