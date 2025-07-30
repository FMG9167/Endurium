package io.github.FMG9167.endurium;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Function;

public class ModItems {
    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Endurium.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);
        return item;
    }

    public static final Item ENDER_DUST = register("ender_dust", Item::new, new Item.Settings());
    public static final Item MORTAR = register(("mortar"), Item::new, new Item.Settings().maxCount(1));
    public static final Item INGOT_MOLD = register("ingot_mold", Item::new, new Item.Settings());
    public static final Item ENDURIUM_DUST = register("endurium_dust", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
    public static final Item ENDURIUM_INGOT = register("endurium_ingot", Item::new, new Item.Settings().rarity(Rarity.RARE).fireproof());

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(ModItems.ENDER_DUST));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(ModItems.INGOT_MOLD));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(ModItems.ENDURIUM_DUST));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                        .register((itemGroup) -> itemGroup.add(ModItems.ENDURIUM_INGOT));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register((itemGroup) -> itemGroup.add(ModItems.MORTAR));
    }
}
