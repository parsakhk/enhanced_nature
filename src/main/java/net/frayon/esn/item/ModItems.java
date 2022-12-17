package net.frayon.esn.item;

import net.frayon.esn.NaturePlus;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, NaturePlus.MOD_ID);

    public static final RegistryObject<Item> EXTRACTED_SAVON = ITEMS.register("extracted_savon",
            () -> new Item(new Item.Properties().tab(ModItemGroups.NATURE_PLUS_TAB)));

    public static final RegistryObject<Item> SOAP = ITEMS.register("soap",
            () -> new Item(new Item.Properties().tab(ModItemGroups.NATURE_PLUS_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
