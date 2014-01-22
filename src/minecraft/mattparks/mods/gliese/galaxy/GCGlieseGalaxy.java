package mattparks.mods.gliese.galaxy;

import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import net.minecraft.util.StatCollector;

public class GCGlieseGalaxy implements IGalaxy
{

	@Override
	public String getGalaxyName() {
		return "GlieseGalaxy";
	}

	@Override
	public int getXCoord() {
		return 4;
	}

	@Override
	public int getYCoord() {
		return 4;
	}

	@Override
	public Vector3 getRGBRingColors() {
		return new Vector3(256.0D / 256.0D, 256.0D / 256.0D, 50.0D / 256.0D);
	}
	
}
