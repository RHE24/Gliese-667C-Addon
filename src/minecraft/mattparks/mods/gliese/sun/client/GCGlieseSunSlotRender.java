package mattparks.mods.gliese.sun.client;

import mattparks.mods.gliese.galaxy.GalacticraftGlieseGalaxy;
import micdoodle8.mods.galacticraft.api.world.ICelestialBodyRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;

public class GCGlieseSunSlotRender implements ICelestialBodyRenderer{

	@Override
	public ResourceLocation getPlanetSprite() {
		return new ResourceLocation(GalacticraftGlieseGalaxy.ASSET_DOMAIN, "textures/gui/planets/sun.png");
	}

	@Override
	public String getPlanetName() {
		return "GlieseSun";
	}

	@Override
	public void renderSlot(int index, int x, int y, float slotHeight, Tessellator tessellator)
    {
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(x - slotHeight * 0.9, y + slotHeight * 0.9, -90.0D, 0.0, 1.0);
        tessellator.addVertexWithUV(x + slotHeight * 0.9, y + slotHeight * 0.9, -90.0D, 1.0, 1.0);
        tessellator.addVertexWithUV(x + slotHeight * 0.9, y - slotHeight * 0.9, -90.0D, 1.0, 0.0);
        tessellator.addVertexWithUV(x - slotHeight * 0.9, y - slotHeight * 0.9, -90.0D, 0.0, 0.0);
        tessellator.draw();
    }
}
