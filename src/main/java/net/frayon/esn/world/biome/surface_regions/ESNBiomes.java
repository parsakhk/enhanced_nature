package net.frayon.esn.world.biome.surface_regions;

import net.frayon.esn.NaturePlus;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.ForgeRegistries;

public class ESNBiomes {
    public static final ResourceKey<Biome> PERIOLAKH = register("periolakh");

    private static ResourceKey<Biome> register(String name)
    {
        return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(NaturePlus.MOD_ID, name));
    }
}
