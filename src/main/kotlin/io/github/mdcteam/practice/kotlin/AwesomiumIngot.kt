package io.github.mdcteam.practice.kotlin

import com.teamwizardry.librarianlib.features.base.item.ItemMod
import com.teamwizardry.librarianlib.features.kotlin.sendSpamlessMessage
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.ActionResult
import net.minecraft.util.EnumActionResult
import net.minecraft.util.EnumHand
import net.minecraft.util.text.TextComponentTranslation
import net.minecraft.world.World

object AwesomiumIngot: ItemMod("awesomium_ingot") {

    override fun onItemRightClick(worldIn: World, playerIn: EntityPlayer, handIn: EnumHand): ActionResult<ItemStack> {
        return if (worldIn.isRemote) {
            playerIn.sendSpamlessMessage(TextComponentTranslation("practice.awesomium.message", playerIn.displayName),
                    "awesomium_ingot")
            ActionResult.newResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn))
        } else super.onItemRightClick(worldIn, playerIn, handIn)
    }
}