package io.github.mdcteam.practice.util;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class JsonModelRenderer extends ModelRenderer {

    public JsonModelRenderer(ModelBase model, int texOffX, int texOffY) {
        super(model, texOffX, texOffY);
    }

    @Override
    public void render(float scale) {
//        setRotationPoint(-8, -15,0);
//        rotateAngleX = rotateAngleY = rotateAngleZ = 0;
//        scale = 0.0f;
        super.render(scale);
    }
}
