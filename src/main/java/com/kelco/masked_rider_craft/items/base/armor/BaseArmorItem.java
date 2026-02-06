package com.kelco.masked_rider_craft.items.base.armor;


import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.kelco.masked_rider_craft.items.base.BaseItem;
import static com.kelco.masked_rider_craft.MaskedRiderCore.MODID;
import com.kelco.masked_rider_craft.items.base.armor.renderer.RiderArmorRenderer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.manager.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.object.PlayState;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.constant.dataticket.DataTicket;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;
import java.util.function.Consumer;


public class BaseArmorItem extends BaseItem implements GeoItem {

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public static final DataTicket<String> TEXTURE = DataTicket.create("texture", String.class);


    public BaseArmorItem(ArmorMaterial material, ArmorType type, Properties properties) {
        super(properties.humanoidArmor(material, type));
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


    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() {
            private final Supplier<GeoArmorRenderer<BaseArmorItem, ?>> renderer = Suppliers.memoize(() -> new RiderArmorRenderer<>(BaseArmorItem.this));
            @Nullable
            @Override
            public GeoArmorRenderer<?, ?> getGeoArmorRenderer(ItemStack itemStack, EquipmentSlot equipmentSlot) {
                return this.renderer.get();
            }
        });
    }
}
