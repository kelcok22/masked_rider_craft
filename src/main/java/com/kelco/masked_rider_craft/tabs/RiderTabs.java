package com.kelco.masked_rider_craft.tabs;

import com.kelco.masked_rider_craft.items.base.MakedRiderItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static com.kelco.masked_rider_craft.MaskedRiderCore.MODID;


public class RiderTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static List<Item> MASKED_RIDER_TAB_ITEM= new ArrayList<>();
/**
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> Masked_Rider_Tab = CREATIVE_MODE_TABS.register("masked_rider_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(MakedRiderItems.MASKED_RIDER_LOGO.get())).backgroundTexture(Identifier.fromNamespaceAndPath(MODID,"textures/gui/tab_iichigo_items.png"))
                    .title(Component.translatable("itemGroup.masked_rider.masked_rider_items")).build());
**/
public static final Supplier<CreativeModeTab> MASKED_RIDER_TAB = CREATIVE_MODE_TAB.register("masked_rider_tab",
        () -> CreativeModeTab.builder().icon(() -> new ItemStack(MakedRiderItems.MASKED_RIDER_LOGO.get()))
                .backgroundTexture(Identifier.fromNamespaceAndPath(MODID,"textures/gui/tab_iichigo_items.png"))
                .title(Component.translatable("itemGroup.masked_rider.masked_rider_items"))
                .displayItems((itemDisplayParameters, output) -> {

                        for (int i = 0; i < RiderTabs.MASKED_RIDER_TAB_ITEM.size(); i++)
                        {
                            output.accept( RiderTabs.MASKED_RIDER_TAB_ITEM.get(i));
                        }

                }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }


}