package com.kelco.masked_rider_craft.items.base;

import com.kelco.masked_rider_craft.items.base.armor.BaseArmorItem;
import com.kelco.masked_rider_craft.items.base.armor.BaseBeltItem;
import com.kelco.masked_rider_craft.tabs.RiderTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.kelco.masked_rider_craft.MaskedRiderCore.MODID;

public class MakedRiderItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);


    public static final DeferredItem<Item> MASKED_RIDER_LOGO = ITEMS.registerItem("masked_rider_logo",
            (properties) -> new BaseItem(properties).AddToList(RiderTabs.MASKED_RIDER_TAB_ITEM));

    public static final DeferredItem<Item> MASKED_ECTO_GEM = ITEMS.registerItem("masked_ecto_gem",
            (properties) -> new BaseItem(properties.fireResistant()).AddToList(RiderTabs.MASKED_RIDER_TAB_ITEM));

    public static final DeferredItem<Item> MASKED_RIDER_HELMET = ITEMS.registerItem("masked_rider_helmet",
            (properties) -> new BaseArmorItem(ArmorMaterials.DIAMOND, ArmorType.HELMET,properties).AddToList(RiderTabs.MASKED_RIDER_TAB_ITEM));

    public static final DeferredItem<Item> MASKED_RIDER_CHESTPLATE = ITEMS.registerItem("masked_rider_chestplate",
            (properties) -> new BaseArmorItem(ArmorMaterials.DIAMOND, ArmorType.CHESTPLATE,properties).AddToList(RiderTabs.MASKED_RIDER_TAB_ITEM));

    public static final DeferredItem<Item> MASKED_RIDER_LEGGINGS = ITEMS.registerItem("masked_rider_legging",
            (properties) -> new BaseArmorItem(ArmorMaterials.DIAMOND, ArmorType.LEGGINGS,properties).AddToList(RiderTabs.MASKED_RIDER_TAB_ITEM));

    public static final DeferredItem<Item> ECTO_ACCELERATOR_BELT = ITEMS.registerItem("ecto_accelerator_belt",
            (properties) -> new BaseBeltItem("masked_rider",MASKED_RIDER_HELMET,MASKED_RIDER_CHESTPLATE,MASKED_RIDER_LEGGINGS,ArmorMaterials.DIAMOND,properties).AddToList(RiderTabs.MASKED_RIDER_TAB_ITEM));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
