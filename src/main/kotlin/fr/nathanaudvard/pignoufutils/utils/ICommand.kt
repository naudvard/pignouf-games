package fr.nathanaudvard.pignoufutils.utils

import com.mojang.brigadier.tree.LiteralCommandNode
import io.papermc.paper.command.brigadier.CommandSourceStack

interface ICommand {
    fun execute() : LiteralCommandNode<CommandSourceStack>
}