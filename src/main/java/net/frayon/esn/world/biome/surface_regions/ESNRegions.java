package net.frayon.esn.world.biome.surface_regions;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.List;
import java.util.function.Consumer;

public class ESNRegions extends Region {

    public ESNRegions(ResourceLocation name, int weight)
    {
        super(name, RegionType.OVERWORLD, weight);
    }
    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper)
    {
        this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
            // Simple example:
            // Replace the Vanilla desert with our hot_red biome
            builder.replaceBiome(Biomes.SAVANNA, ESNBiomes.PERIOLAKH);

            // More complex example:
            // Replace specific parameter points for the frozen peaks with our cold_blue biome
        });
    }
}
