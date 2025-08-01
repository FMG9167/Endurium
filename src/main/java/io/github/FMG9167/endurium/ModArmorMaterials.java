package io.github.FMG9167.endurium;

import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Map;

import static net.minecraft.registry.tag.ItemTags.REPAIRS_NETHERITE_ARMOR;

public class ModArmorMaterials {
    public static final int BASE_DURABILITY = 25;
    public static final RegistryKey<EquipmentAsset> ENDURIUM_ARMOR_MATERIAL_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(Endurium.MOD_ID, "endurium"));
    public static final ArmorMaterial ENDURIUM = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 4,
                    EquipmentType.CHESTPLATE, 9,
                    EquipmentType.LEGGINGS, 7,
                    EquipmentType.BOOTS, 4
            ),
            5,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
            2.0F,
            0.2F,
            REPAIRS_NETHERITE_ARMOR,
            ENDURIUM_ARMOR_MATERIAL_KEY
    );

    public static void initialize() {};
}
