package fr.nathanaudvard.pignoufgames.input.commands

import io.papermc.paper.command.brigadier.BasicCommand
import io.papermc.paper.command.brigadier.CommandSourceStack

class PignoufGamesCommand : BasicCommand {
    override fun execute(commandSourceStack: CommandSourceStack, args: Array<String>) {
        if (args[0] == "info") {
            commandSourceStack.sender.sendRichMessage("<rainbow>Le prime du divertissement")
        }
    }
}