package mattparks.mods.gliese.sun;

import mattparks.mods.gliese.galaxy.GalacticraftGlieseGalaxy;
import mattparks.mods.gliese.sun.client.GCGlieseSunMap;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import net.minecraft.world.WorldProvider;

public class GCGlieseSun implements IPlanet{

	@Override
	public String getName() {
		return "GlieseSun";
	}

	@Override
	public boolean isReachable() {
		return false;
	}

	@Override
	public IMapObject getMapObject() {
		return new GCGlieseSunMap();
	}

	@Override
	public boolean addToList() {
		return false;
	}

	@Override
	public boolean autoRegister() {
		return false;
	}

	@Override
	public Class<? extends WorldProvider> getWorldProvider() {
		return null;
	}

	@Override
	public int getDimensionID() {
		return -3;
	}

	@Override
	public IGalaxy getParentGalaxy() {
		return GalacticraftGlieseGalaxy.GlieseGalaxy;
	}

}
