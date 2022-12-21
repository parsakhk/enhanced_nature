package net.frayon.esn.util;

import net.frayon.esn.NaturePlus;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
        public static class TMBlockTags {

            private static TagKey<Block> tag(String name) {
                return BlockTags.create(new ResourceLocation(NaturePlus.MOD_ID, name));
            }

            private static TagKey<Block> forgeTag(String name) {
                return BlockTags.create(new ResourceLocation("forge", name));
            }
        }
        public static class TMItemTags {

            public static final TagKey<Item> SUGARS =
                    tag("sugars");

            private static TagKey<Item> tag(String name) {
                return ItemTags.create(new ResourceLocation(NaturePlus.MOD_ID, name));
            }

            private static TagKey<Item> forgeTag(String name) {
                return ItemTags.create(new ResourceLocation("forge", name));
            }
        }
}
