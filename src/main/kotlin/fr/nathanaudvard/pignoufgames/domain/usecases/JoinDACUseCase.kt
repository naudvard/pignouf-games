package fr.nathanaudvard.pignoufgames.domain.usecases

import fr.nathanaudvard.pignoufgames.AppData
import fr.nathanaudvard.pignoufgames.utils.enum.DACStatus
import org.bukkit.command.CommandSender
import java.util.*

fun joinDAC(sender: CommandSender, playerId: UUID, args: Array<String>) {
    if (AppData.dac?.status == DACStatus.RUNNING) {
        sender.sendMessage("La partie a déjà commencé.")
        return
    } else if (AppData.dac == null) {
        sender.sendMessage("Veuillez lancer une partie avec /dac start.")
        return
    }

    if (args.size > 1) {
        if (args[1] == "red") {
            AppData.dac?.redTeam?.add(playerId)
        } else if (args[1] == "green") {
            AppData.dac?.greenTeam?.add(playerId)
        } else {
            sender.sendMessage("Veuillez saisir green, red ou ne rien mettre.")
        }
    } else {
    }
}