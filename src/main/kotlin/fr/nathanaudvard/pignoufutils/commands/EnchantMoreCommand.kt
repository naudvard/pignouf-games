package fr.nathanaudvard.pignoufutils.commands

import com.mojang.brigadier.Command
import com.mojang.brigadier.context.CommandContext
import com.mojang.brigadier.tree.LiteralCommandNode
import fr.nathanaudvard.pignoufutils.utils.ICommand
import fr.nathanaudvard.pignoufutils.utils.earlyReturn
import io.papermc.paper.command.brigadier.CommandSourceStack
import io.papermc.paper.command.brigadier.Commands
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack


class EnchantMoreCommand : ICommand {
    override fun execute(): LiteralCommandNode<CommandSourceStack> {
        val command = Commands.literal("efficiency-max")
        val info = Commands.literal("info").executes { runInfo(it) }
        val enchant = Commands.literal("enchant").executes { runEnchant(it) }

        return command
            .then(info)
            .then(enchant)
            .build()
    }

    private fun runEnchant(ctx: CommandContext<CommandSourceStack>): Int {
        val sender = ctx.source.sender as? Player
            ?: return earlyReturn(ctx.source.sender, "Vous devez être un joueur pour utiliser cette commande.")
        val currentItem = sender.inventory.itemInMainHand

        if (currentItem.isEmpty || !currentItem.isPickaxe()) {
            return earlyReturn(sender, "Prend une pioche dans ta main principale.")
        }

        if (sender.level < 70) {
            return earlyReturn(sender, "Il te manque ${sender.level - 70} niveaux pour obtenir efficiency 255.")
        }

        sender.giveExp(-levelToExp(70))
        currentItem.addUnsafeEnchantment(Enchantment.EFFICIENCY, 255)

        sender.sendPlainMessage("Ta pioche a été enchantée avec succès.")

        return Command.SINGLE_SUCCESS
    }

    private fun runInfo(ctx: CommandContext<CommandSourceStack>): Int {
        ctx.source.sender.sendPlainMessage("Efficiency 255 coûte ${levelToExp(70)} exp (70 niveaux).")
        return Command.SINGLE_SUCCESS
    }

    private fun ItemStack.isPickaxe() =
        this.type.name.contains("pickaxe", ignoreCase = true)

    private fun levelToExp(level: Int): Int {
        return when {
            level <= 16 -> level * level + 6 * level
            level <= 31 -> (2.5 * level * level - 40.5 * level + 360).toInt()
            else -> (4.5 * level * level - 162.5 * level + 2220).toInt()
        }
    }
}