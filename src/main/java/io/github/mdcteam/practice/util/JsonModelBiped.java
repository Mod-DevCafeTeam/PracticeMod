package io.github.mdcteam.practice.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.mdcteam.practice.util.objects.JsonModelObj;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JsonModelBiped extends ModelBiped {

    private static final Gson gson;

    private JsonModelObj obj;

    private List<ModelRenderer> renderers = new ArrayList<>();

    public JsonModelBiped(float scale, ResourceLocation rl) {
        super(scale);
        InputStream jsonStream = this.getClass().getResourceAsStream("/assets/"+rl.getResourceDomain()+"/model/"+rl.getResourcePath()+".json");
        obj = gson.fromJson(new InputStreamReader(jsonStream), JsonModelObj.class);

        setTextureOffset("default", 0, 0);

        for (JsonModelObj.ModelElementObj elementObj : obj.elements) {
            ModelRenderer renderer = new ModelRenderer(this, 0, 0);
           // String name = getTextureOffset(elementObj.name) == null ? "default" : elementObj.name;
            renderer.addBox(elementObj.from[0], elementObj.from[1], elementObj.from[2], (int)(elementObj.to[0]-elementObj.from[0]), (int)(elementObj.to[1]-elementObj.from[1]), (int)(elementObj.to[2]-elementObj.from[2]));
            renderers.add(renderer);
            bipedHead.addChild(renderer);
        }
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        //setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);

        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("minecraft:textures/blocks/iron_block.png"));
        //GlStateManager.pushMatrix();
        //GlStateManager.translate(0.5f, 0.5f, 0.5f);
        //GlStateManager.rotate(180, 0, 0, 0);
        for (ModelRenderer renderer : renderers) {
            renderer.render(scale);
        }
        //GlStateManager.popMatrix();
    }

    static {
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }
}
