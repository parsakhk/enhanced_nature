package net.frayon.esn.world.feature;

import net.frayon.esn.NaturePlus;
import net.frayon.esn.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeature {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, NaturePlus.MOD_ID);

    public static final RegistryObject<PlacedFeature> PERIODETITE_PATCH_PLACED = PLACED_FEATURES.register("periodetite_patch_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.PERIODETITE.getHolder().get(),
                    commonOrePlacement(32, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(210)))));

    public static final RegistryObject<PlacedFeature> SULPHUR_PATCH_PLACED = PLACED_FEATURES.register("sulphur_patch_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SULPHUR.getHolder().get(),
                    commonOrePlacement(42, // VeinsPerChunk
                            HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-190), VerticalAnchor.aboveBottom(310)))));

    public static final RegistryObject<PlacedFeature> LIMESTONE_PLACED = PLACED_FEATURES.register("limestone_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.LIMESTONE.getHolder().get(),
                    commonOrePlacement(54, // VeinsPerChunk
                            HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-190), VerticalAnchor.aboveBottom(120)))));

    public static final RegistryObject<PlacedFeature> SAVONIST_PATCH_PLACED = PLACED_FEATURES.register("savonist_patch_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SAVONIST.getHolder().get(),
                    commonOrePlacement(38, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(180)))));

    public static final RegistryObject<PlacedFeature> SAGUARO_PLACED = PLACED_FEATURES.register("saguaro_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SAGUARO_CACTUS.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(16),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));


    public static final RegistryObject<PlacedFeature> CURATELLA_CHECKED = PLACED_FEATURES.register("curatella_checked",
            () -> new PlacedFeature(ModConfiguredFeatures.CURATELLA.getHolder().get(),
                    List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.CURATELLA_SAPLING.get()))));

    public static final RegistryObject<PlacedFeature> CURATELLA_PLACED = PLACED_FEATURES.register("curatella_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.CURATELLA_SPAWN.getHolder().get(), VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(3, 0.1f, 2))));

    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}
