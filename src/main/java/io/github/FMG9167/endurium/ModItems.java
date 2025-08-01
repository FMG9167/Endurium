package io.github.FMG9167.endurium;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.player.PlayerEquipment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

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
    public static final Item ENDURIUM_DUST = register("endurium_dust", Item::new, new Item.Settings());
    public static final Item ENDURIUM_INGOT = register("endurium_ingot", Item::new, new Item.Settings().fireproof());

//    public static final Item ENDURIUM_HELMET = register(
//            "endurium_helmet",
//            settings -> new PlayerEquipment(ModArmorMaterials.INSTANCE, EquipmentType.HELMET, settings),
//            new Item.Settings().maxDamage(EquipmentType.HELMET.getMaxDamage(ModArmorMaterials.BASE_DURABILITY))
//    );

    public static final Item ENDURIUM_HELMET = register("endurium_helmet", Item::new, new Item.Settings().fireproof().armor(ModArmorMaterials.ENDURIUM, EquipmentType.HELMET).maxDamage(EquipmentType.HELMET.getMaxDamage(15)).enchantable(15));
    public static final Item ENDURIUM_CHESTPLATE = register("endurium_chestplate", Item::new, new Item.Settings().fireproof().armor(ModArmorMaterials.ENDURIUM, EquipmentType.CHESTPLATE).maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(15)).enchantable(15));
    public static final Item ENDURIUM_LEGGINGS = register("endurium_leggings", Item::new, new Item.Settings().fireproof().armor(ModArmorMaterials.ENDURIUM, EquipmentType.LEGGINGS).maxDamage(EquipmentType.LEGGINGS.getMaxDamage(15)));
    public static final Item ENDURIUM_BOOTS = register("endurium_boots", Item::new, new Item.Settings().fireproof().armor(ModArmorMaterials.ENDURIUM, EquipmentType.BOOTS).maxDamage(EquipmentType.BOOTS.getMaxDamage(15)));

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
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> itemGroup.add(ModItems.ENDURIUM_HELMET));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> itemGroup.add(ModItems.ENDURIUM_CHESTPLATE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> itemGroup.add(ModItems.ENDURIUM_LEGGINGS));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> itemGroup.add(ModItems.ENDURIUM_BOOTS));
    }
}
