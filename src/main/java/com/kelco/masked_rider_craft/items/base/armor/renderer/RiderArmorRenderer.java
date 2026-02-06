package com.kelco.masked_rider_craft.items.base.armor.renderer;

import com.kelco.masked_rider_craft.items.base.armor.BaseArmorItem;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;

import java.util.List;

import static com.kelco.masked_rider_craft.MaskedRiderCore.MODID;

public class RiderArmorRenderer <R extends HumanoidRenderState & GeoRenderState & GeoAnimatable> extends GeoArmorRenderer<BaseArmorItem, R> {

    public RiderArmorRenderer(BaseArmorItem baseArmorItem) {
        super(new RiderModel());

    }



    public List<ArmorSegment> getSegmentsForSlot(R renderState, EquipmentSlot slot) {
        return List.of(ArmorSegment.HEAD,ArmorSegment.CHEST, ArmorSegment.LEFT_ARM, ArmorSegment.RIGHT_ARM,ArmorSegment.LEFT_LEG, ArmorSegment.RIGHT_LEG);
    }
}
