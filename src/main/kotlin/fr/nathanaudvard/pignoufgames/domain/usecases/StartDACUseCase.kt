package fr.nathanaudvard.pignoufgames.domain.usecases

import fr.nathanaudvard.pignoufgames.AppData
import fr.nathanaudvard.pignoufgames.models.DAC
import fr.nathanaudvard.pignoufgames.utils.enum.DACStatus
import org.bukkit.command.CommandSender

fun startDAC(sender: CommandSender) {
    if (AppData.dac?.status == DACStatus.RUNNING) {
        sender.sendMessage("Un dé à coudre est déjà en cours.")
        return
    }

    AppData.dac = DAC(status = DACStatus.RUNNING)
}