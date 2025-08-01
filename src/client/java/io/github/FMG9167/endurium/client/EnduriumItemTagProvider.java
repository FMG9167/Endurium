package io.github.FMG9167.endurium.client;

import io.github.FMG9167.endurium.Endurium;
import io.github.FMG9167.endurium.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagBuilder;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class EnduriumItemTagProvider extends FabricTagProvider<Item> {
    public EnduriumItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.ITEM, registriesFuture);
    }

    public static final TagKey<Item> REPAIRS_ENDURIUM_ITEMS = TagKey.of(RegistryKeys.ITEM, Identifier.of(Endurium.MOD_ID, "repairs_endurium_items"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getTagBuilder(REPAIRS_ENDURIUM_ITEMS).add(Identifier.of(Endurium.MOD_ID, "endurium_ingot"));
    }
}
