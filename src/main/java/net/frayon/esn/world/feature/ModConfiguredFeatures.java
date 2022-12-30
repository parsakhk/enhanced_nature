package net.frayon.esn.world.feature;

import com.google.common.base.Suppliers;
import net.frayon.esn.NaturePlus;
import net.frayon.esn.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.DarkOakFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.rootplacers.RootPlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.OptionalInt;
import java.util.function.Supplier;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, NaturePlus.MOD_ID);

    private static final BeehiveDecorator BEEHIVE_0002 = new BeehiveDecorator(0.002F);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_PERIODETITE_PATCH = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.PERIODETITE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_SAVONIST_PATCH = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SAVONIST.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> SULPHUR_PERIODETITE_PATCH = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(ModBlocks.PERIODETITE.get()), ModBlocks.SULPHUR.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> LIMESTONE_PATCH = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.NATURAL_STONE, ModBlocks.LIMESTONE.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> PERIODETITE = CONFIGURED_FEATURES.register("periodetite_patch",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_PERIODETITE_PATCH.get(),64)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> SAVONIST = CONFIGURED_FEATURES.register("savonist_patch",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_SAVONIST_PATCH.get(),25)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> SULPHUR = CONFIGURED_FEATURES.register("sulphur_patch",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SULPHUR_PERIODETITE_PATCH.get(),56)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> LIMESTONE = CONFIGURED_FEATURES.register("limestone",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(LIMESTONE_PATCH.get(),33)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> SAGUARO_CACTUS = CONFIGURED_FEATURES.register("saguaro_cactus",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(40, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SAGUARO_CACTUS.get()))))));

    public static final RegistryObject<ConfiguredFeature<?,?>> CURATELLA =
            CONFIGURED_FEATURES.register("curatella", () ->
                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(ModBlocks.CURATELLA_LOG.get()),
                            new GiantTrunkPlacer(7,5,3),
                            BlockStateProvider.simple(ModBlocks.CURATELLA_LEAVES.get()),
                            new DarkOakFoliagePlacer(ConstantInt.of(1), ConstantInt.of(0)),
                            new ThreeLayersFeatureSize(2, 1, 1,0, 2, OptionalInt.empty())).decorators(List.of(BEEHIVE_0002)).build()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> CURATELLA_SPAWN =
            CONFIGURED_FEATURES.register("curatella_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            ModPlacedFeature.CURATELLA_CHECKED.getHolder().get(),
                            0.5F)), ModPlacedFeature.CURATELLA_CHECKED.getHolder().get())));

    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
