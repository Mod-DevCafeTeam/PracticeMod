package io.github.mdcteam.practice.kotlin

import com.teamwizardry.librarianlib.features.base.ModCreativeTab
import net.minecraft.item.ItemStack
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

/**
 * Used to set up all the things plain java isn't as good at, like classloading items.
 */
object KSetup {

    fun preInit(preinit: FMLPreInitializationEvent) {
        AwesomiumIngot
        tab
    }

    object tab : ModCreativeTab() {
        override val iconStack: ItemStack
            get() = ItemStack(AwesomiumIngot)
    }
}