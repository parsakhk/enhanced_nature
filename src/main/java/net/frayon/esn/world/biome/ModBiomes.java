package net.frayon.esn.world.biome;

import net.frayon.esn.NaturePlus;
import net.frayon.esn.world.biome.surface_regions.ESNBiomes;
import net.frayon.esn.world.biome.surface_regions.ESNOverworldBiomes;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBiomes {
    public static DeferredRegister<Biome> BIOMES = DeferredRegister.create(Registry.BIOME_REGISTRY, NaturePlus.MOD_ID);

    public static void registerBiomes()
    {
        register(ESNBiomes.PERIOLAKH, ESNOverworldBiomes::periolakh);
    }

    public static RegistryObject<Biome> register(ResourceKey<Biome> key, Supplier<Biome> biomeSupplier)
    {
        return BIOMES.register(key.location().getPath(), biomeSupplier);
    }
}
