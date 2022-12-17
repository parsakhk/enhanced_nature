package net.frayon.esn.item;

import net.frayon.esn.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroups {
    public static final CreativeModeTab NATURE_PLUS_TAB = new CreativeModeTab("nature_plus") {
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.PERIODETITE.get());
        }
    };
}
