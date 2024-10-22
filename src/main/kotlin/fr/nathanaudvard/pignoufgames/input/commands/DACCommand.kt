package fr.nathanaudvard.pignoufgames.input.commands

import fr.nathanaudvard.pignoufgames.AppData
import fr.nathanaudvard.pignoufgames.domain.usecases.joinDAC
import fr.nathanaudvard.pignoufgames.domain.usecases.startDAC
import fr.nathanaudvard.pignoufgames.models.DAC
import fr.nathanaudvard.pignoufgames.utils.enum.DACStatus
import io.papermc.paper.command.brigadier.BasicCommand
import io.papermc.paper.command.brigadier.CommandSourceStack

class DACCommand : BasicCommand {
    override fun execute(commandSourceStack: CommandSourceStack, args: Array<String>) {
        if (commandSourceStack.executor == null) {
            commandSourceStack.sender.sendMessage("Il faut être un joueur pour rejoindre la partie.")
            return
        }
        when (args[0]) {
            ""
            "start" -> startDAC(commandSourceStack.sender)
            "join" -> joinDAC(commandSourceStack.sender, commandSourceStack.executor.uniqueId, args)
        }
    }
}