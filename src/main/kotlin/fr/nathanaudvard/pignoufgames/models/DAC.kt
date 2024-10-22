package fr.nathanaudvard.pignoufgames.models

import fr.nathanaudvard.pignoufgames.utils.enum.DACStatus
import java.util.*
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
data class DAC(
    val id: Uuid = Uuid.random(),
    var status: DACStatus,
    val redTeam: MutableList<UUID> = mutableListOf(),
    val greenTeam: MutableList<UUID> = mutableListOf(),
)