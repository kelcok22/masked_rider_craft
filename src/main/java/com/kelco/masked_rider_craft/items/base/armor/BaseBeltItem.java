package com.kelco.masked_rider_craft.items.base.armor;


import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.manager.AnimatableManager;
import software.bernie.geckolib.constant.dataticket.DataTicket;
import software.bernie.geckolib.util.GeckoLibUtil;


public class BaseBeltItem extends BaseArmorItem  {

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public static String NAME;
    public Item HEAD;
    public Item TORSO;
    public Item LEGS;

    public BaseBeltItem(String name, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, ArmorMaterial material, Properties properties) {
        super(material,  ArmorType.BOOTS, properties);
        NAME=name;
        HEAD=head.get();
        TORSO=torso.get();
        LEGS=legs.get();
    }


    public String getRiderName(ItemStack itemstack)
    {
        return NAME;
    }

    public boolean isTransformed(LivingEntity player) {
        if (!(player.getItemBySlot(EquipmentSlot.FEET).getItem()instanceof BaseBeltItem))return false;
        return player.getItemBySlot(EquipmentSlot.HEAD).getItem()==HEAD.asItem()
                &&player.getItemBySlot(EquipmentSlot.CHEST).getItem()==TORSO.asItem()
                &&player.getItemBySlot(EquipmentSlot.LEGS).getItem()==LEGS.asItem()
                &&player.getItemBySlot(EquipmentSlot.FEET).getItem()==this;
    }

    public String getTexture(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName)
    {
        boolean fly = rider instanceof Player player && player.getAbilities().flying;
        if (equipmentSlot == EquipmentSlot.FEET) {
            String belt = "ecto_accelerator_belt_belt";
            return "belt/"+belt;
        } else if (isTransformed(rider)) return riderName;
        else return "blank";
    }

    public String getModel(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName)
    {
        boolean fly = rider instanceof Player player && player.getAbilities().flying;
        if (equipmentSlot == EquipmentSlot.FEET) {
            String belt = "riderbelt";
            return "belt/"+belt;
        }
        else return riderName;
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, @Nullable EquipmentSlot slot) {

    }


    // Let's add our animation controller
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

}
