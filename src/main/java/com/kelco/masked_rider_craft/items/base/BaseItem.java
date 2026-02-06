package com.kelco.masked_rider_craft.items.base;

import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class BaseItem extends Item  {

    public String Model_Name = null;

    public BaseItem(Properties prop) {
        super(prop);
    }


    public boolean is(TagKey<Item> tag) {
        return this.builtInRegistryHolder().is(tag);
    }


    public BaseItem AddToList(List<Item> TabList, int num) {
        for (int i = 0; i < num; i++)
        {
            TabList.add(this);
        }
        return this;
    }

    public BaseItem AddToList(List<Item> TabList) {
        TabList.add(this);
        return this;
    }

}