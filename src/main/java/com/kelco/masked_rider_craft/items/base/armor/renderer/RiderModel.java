package com.kelco.masked_rider_craft.items.base.armor.renderer;

import com.kelco.masked_rider_craft.items.base.armor.BaseArmorItem;
import com.kelco.masked_rider_craft.items.base.armor.BaseBeltItem;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlot;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;

import static com.kelco.masked_rider_craft.MaskedRiderCore.MODID;


public class RiderModel extends DefaultedItemGeoModel<BaseArmorItem> {

    public RiderModel() {
        super(Identifier.fromNamespaceAndPath(MODID, "armor/masked_rider"));
    }

    @Override
    public void addAdditionalStateData(BaseArmorItem animatable, Object relatedObject, GeoRenderState renderState) {
        GeoArmorRenderer.RenderData renderData = ((GeoArmorRenderer.RenderData)relatedObject);
        if (renderData.entity().getItemBySlot(EquipmentSlot.FEET).getItem()instanceof BaseBeltItem baseBeltItem) {
            String name = baseBeltItem.getRiderName((renderData.entity().getItemBySlot(EquipmentSlot.FEET)));
            renderState.addGeckolibData(BaseArmorItem.TEXTURE, baseBeltItem.getTexture(renderData.entity().getItemBySlot(EquipmentSlot.FEET), renderData.slot(), renderData.entity(), name));
            renderState.addGeckolibData(BaseArmorItem.MODEL, baseBeltItem.getModel(renderData.entity().getItemBySlot(EquipmentSlot.FEET), renderData.slot(), renderData.entity(), name));
        }
        else {
            renderState.addGeckolibData(BaseArmorItem.TEXTURE, "blank");
            renderState.addGeckolibData(BaseArmorItem.MODEL, "masked_rider");
        }
    }
    @Override
    public Identifier getModelResource(GeoRenderState renderState) {
        return Identifier.fromNamespaceAndPath(MODID, "armor/"+renderState.getGeckolibData(BaseArmorItem.MODEL));
    }

    @Override
    public Identifier getTextureResource(GeoRenderState renderState) {
        return Identifier.fromNamespaceAndPath(MODID, "textures/armor/"+renderState.getGeckolibData(BaseArmorItem.TEXTURE)+".png");
    }

    @Override
    public Identifier getAnimationResource(BaseArmorItem animatable) {
        return Identifier.fromNamespaceAndPath(MODID, "animations/ichigo");
    }
}