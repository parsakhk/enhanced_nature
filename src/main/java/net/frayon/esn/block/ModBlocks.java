package net.frayon.esn.block;

import net.frayon.esn.NaturePlus;
import net.frayon.esn.block.block.LimestoneBlock;
import net.frayon.esn.block.block.RotateablePillarBlocks;
import net.frayon.esn.block.block.SaguaroBlock;
import net.frayon.esn.item.ModItemGroups;
import net.frayon.esn.item.ModItems;
import net.frayon.esn.world.feature.tree.CuratellaTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.concurrent.Flow;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, NaturePlus.MOD_ID);

    public static final RegistryObject<Block> PERIODETITE = registerBlock("periodetite",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3f).explosionResistance(5f).requiresCorrectToolForDrops())
                , ModItemGroups.NATURE_PLUS_TAB);

    public static final RegistryObject<Block> SAVONIST = registerBlock("savonist",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(7f).explosionResistance(19f).requiresCorrectToolForDrops())
            , ModItemGroups.NATURE_PLUS_TAB);

    public static final RegistryObject<Block> LIMESTONE = registerBlock("limestone",
            () -> new LimestoneBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4f).explosionResistance(3f).requiresCorrectToolForDrops())
            , ModItemGroups.NATURE_PLUS_TAB);

    public static final RegistryObject<Block> SULPHUR = registerBlock("sulphur",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f).explosionResistance(3f).requiresCorrectToolForDrops().instabreak())
            , ModItemGroups.NATURE_PLUS_TAB);

    public static final RegistryObject<Block> CURATELLA_LOG = registerBlock("curatella_log",
            () -> new RotateablePillarBlocks(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).requiresCorrectToolForDrops())
            , ModItemGroups.NATURE_PLUS_TAB);
    public static final RegistryObject<Block> CURATELLA_PLANKS = registerBlock("curatella_planks",
            () -> new RotateablePillarBlocks(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).requiresCorrectToolForDrops()) {
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            }
            , ModItemGroups.NATURE_PLUS_TAB);
    public static final RegistryObject<Block> CURATELLA_LEAVES = registerBlock("curatella_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).requiresCorrectToolForDrops())
            , ModItemGroups.NATURE_PLUS_TAB);
    public static final RegistryObject<Block> CURATELLA_SAPLING = registerBlock("curatella_sapling",
            () -> new SaplingBlock(new CuratellaTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).requiresCorrectToolForDrops())
            , ModItemGroups.NATURE_PLUS_TAB);


    public static final RegistryObject<Block> SAGUARO_CACTUS = registerBlock("saguaro_cactus",
            () -> new SaguaroBlock(BlockBehaviour.Properties.of(Material.CACTUS).instabreak())
            , ModItemGroups.NATURE_PLUS_TAB);

    public static final RegistryObject<Block> POTTED_SAGUARO_CACTUS = BLOCKS.register("potted_saguaro_cactus",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.SAGUARO_CACTUS,
                    BlockBehaviour.Properties.copy(Blocks.CACTUS)));
    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
