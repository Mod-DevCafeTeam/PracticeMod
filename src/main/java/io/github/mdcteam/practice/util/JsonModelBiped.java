package io.github.mdcteam.practice.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.mdcteam.practice.util.objects.JsonModelObj;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nullable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class JsonModelBiped extends ModelBiped {

    private static final Gson gson;

    private JsonModelObj obj;

    private List<ModelRenderer> renderers = new ArrayList<>();
    private Map<ModelRenderer, ModelRenderer> parentedRenderers = new HashMap<>();

    private Map<ModelRenderer, ResourceLocation> textures = new HashMap<>();

    public JsonModelBiped(float scale, ResourceLocation rl) {
        super(scale);
        rebuildModelFromJson(rl);

        ((IReloadableResourceManager)Minecraft.getMinecraft().getResourceManager()).registerReloadListener(resourceManager -> rebuildModelFromJson(rl));
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        //scale = 0.5f;
        super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);

        GlStateManager.pushMatrix();
        GlStateManager.rotate(180, 0, 0, 0F);
        for (ModelRenderer renderer : renderers) {
            GlStateManager.pushMatrix();
            if (parentedRenderers.containsKey(renderer)) {
                ModelRenderer parent = parentedRenderers.get(renderer);
                GlStateManager.translate(parent.rotationPointX * scale, parent.rotationPointY * scale, parent.rotationPointZ * scale);

                if (parent.rotateAngleZ != 0.0F)
                {
                    GlStateManager.rotate(parent.rotateAngleZ * (180F / (float)Math.PI), 0.0F, 0.0F, 1.0F);
                }

                if (parent.rotateAngleY != 0.0F)
                {
                    GlStateManager.rotate(parent.rotateAngleY * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
                }

                if (parent.rotateAngleX != 0.0F)
                {
                    GlStateManager.rotate(parent.rotateAngleX * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
                }
            }
            GlStateManager.translate(-0.5f, isSneak ? -0.2f : 0f, -0.5f);
            Minecraft.getMinecraft().getTextureManager().bindTexture(textures.get(renderer));
            renderer.render(scale);
            GlStateManager.popMatrix();
        }
        GlStateManager.popMatrix();
    }

    public void addRenderer(ModelRenderer renderer, @Nullable ModelRenderer parentTo) {
        renderers.add(renderer);
        if (parentTo != null) {
            //parentTo.addChild(renderer);
            parentedRenderers.put(renderer, parentTo);
        }
    }

    private void rebuildModelFromJson(ResourceLocation rl) {
        textures.clear();
        parentedRenderers.clear();
        renderers.clear();

        InputStream jsonStream = this.getClass().getResourceAsStream("/assets/"+rl.getResourceDomain()+"/model/"+rl.getResourcePath()+".json");
        obj = gson.fromJson(new InputStreamReader(jsonStream), JsonModelObj.class);

        setTextureOffset("default", 0, 0);

        for (JsonModelObj.ModelElementObj elementObj : obj.elements) {
            ModelRenderer renderer = new ModelRenderer(this, 0, 0);
            // String name = getTextureOffset(elementObj.name) == null ? "default" : elementObj.name;
            renderer.addBox(elementObj.from[0], elementObj.from[1], elementObj.from[2], (int)(elementObj.to[0]-elementObj.from[0]), (int)(elementObj.to[1]-elementObj.from[1]), (int)(elementObj.to[2]-elementObj.from[2]));
            addRenderer(renderer, bipedHead);

            String tx = new ArrayList<>(elementObj.faces.values()).get(0).texture;
            if (tx.startsWith("#")) tx = obj.textures.get(tx.replace("#", ""));
            String[] split = ResourceLocation.splitObjectName(tx);
            ResourceLocation rel = new ResourceLocation(StringUtils.isEmpty(split[0]) ? "minecraft" : split[0].toLowerCase(Locale.ROOT), "textures/"+split[1].toLowerCase(Locale.ROOT)+".png");
            textures.put(renderer, rel);
        }
    }

    static {
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

}
