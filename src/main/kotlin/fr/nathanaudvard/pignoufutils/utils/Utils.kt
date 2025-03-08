package fr.nathanaudvard.pignoufutils.utils

import com.mojang.brigadier.Command
import org.bukkit.command.CommandSender

fun earlyReturn(sender: CommandSender, message: String): Int {
    sender.sendPlainMessage(message)
    return Command.SINGLE_SUCCESS
}