package com.kelco.masked_rider_craft.items.base.armor.renderer;

import com.kelco.masked_rider_craft.items.base.armor.BaseArmorItem;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;
import software.bernie.geckolib.renderer.layer.builtin.AutoGlowingGeoLayer;

import java.util.List;

import static com.kelco.masked_rider_craft.MaskedRiderCore.MODID;

public class RiderArmorRenderer <R extends HumanoidRenderState & GeoRenderState & GeoAnimatable> extends GeoArmorRenderer<BaseArmorItem, R> {

    public RiderArmorRenderer(BaseArmorItem baseArmorItem) {
        super(new RiderModel());
        //withRenderLayer(AutoGlowingGeoLayer::new);
    }

    @Override
    public RenderType getRenderType(R renderState, Identifier texture) {
        // Our texture is transparent, so we need a transparent RenderType
        return RenderTypes.entityTranslucent(texture);
    }



    public List<ArmorSegment> getSegmentsForSlot(R renderState, EquipmentSlot slot) {
        return switch (slot) {
            case HEAD -> List.of(ArmorSegment.HEAD);
            case CHEST -> List.of(ArmorSegment.CHEST, ArmorSegment.LEFT_ARM, ArmorSegment.RIGHT_ARM);
            case LEGS -> List.of(ArmorSegment.LEFT_LEG, ArmorSegment.RIGHT_LEG);
            case FEET -> List.of(ArmorSegment.HEAD,ArmorSegment.CHEST, ArmorSegment.LEFT_ARM, ArmorSegment.RIGHT_ARM,ArmorSegment.LEFT_LEG, ArmorSegment.RIGHT_LEG);
            default -> List.of();
        };
    }
}
