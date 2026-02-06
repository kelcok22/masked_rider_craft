package com.kelco.masked_rider_craft.items.base.armor.renderer;

import com.kelco.masked_rider_craft.items.base.armor.BaseArmorItem;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

import static com.kelco.masked_rider_craft.MaskedRiderCore.MODID;


public class RiderModel extends DefaultedItemGeoModel<BaseArmorItem> {

    public RiderModel() {
        super(Identifier.fromNamespaceAndPath(MODID, "armor/masked_rider"));
    }

    @Override
    public void addAdditionalStateData(BaseArmorItem animatable, Object relatedObject, GeoRenderState renderState) {
         renderState.addGeckolibData(BaseArmorItem.TEXTURE, "masked_rider");
    }
    @Override
    public Identifier getModelResource(GeoRenderState renderState) {
        return Identifier.fromNamespaceAndPath(MODID, "armor/masked_rider");
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