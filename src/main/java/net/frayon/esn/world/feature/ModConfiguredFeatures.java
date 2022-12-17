package net.frayon.esn.world.feature;

import com.google.common.base.Suppliers;
import net.frayon.esn.NaturePlus;
import net.frayon.esn.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, NaturePlus.MOD_ID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_PERIODETITE_PATCH = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.PERIODETITE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_SAVONIST_PATCH = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SAVONIST.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> SULPHUR_PERIODETITE_PATCH = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(ModBlocks.PERIODETITE.get()), ModBlocks.SULPHUR.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> PERIODETITE = CONFIGURED_FEATURES.register("periodetite_patch",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_PERIODETITE_PATCH.get(),64)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> SAVONIST = CONFIGURED_FEATURES.register("savonist_patch",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_SAVONIST_PATCH.get(),25)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> SULPHUR = CONFIGURED_FEATURES.register("sulphur_patch",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SULPHUR_PERIODETITE_PATCH.get(),56)));


    public static final RegistryObject<ConfiguredFeature<?, ?>> SAGUARO_CACTUS = CONFIGURED_FEATURES.register("saguaro_cactus",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(40, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SAGUARO_CACTUS.get()))))));

    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
