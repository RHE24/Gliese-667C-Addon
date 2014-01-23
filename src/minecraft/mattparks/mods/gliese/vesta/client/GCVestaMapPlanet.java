package mattparks.mods.gliese.vesta.client;

import mattparks.mods.gliese.galaxy.GalacticraftGlieseGalaxy;
import micdoodle8.mods.galacticraft.api.world.ICelestialBodyRenderer;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;

public class GCVestaMapPlanet implements IMapObject
{
	@Override
	public float getDistanceFromCenter() 
	{
		return 5.20F;
	}

	@Override
    public IGalaxy getParentGalaxy()
    {
        return GalacticraftGlieseGalaxy.GlieseGalaxy;
    }

	@Override
	public float getPhaseShift() 
	{
		return 2.8F;
	}

	@Override
	public float getPlanetSize() 
	{
		return 0.53191489361702127659574468085106F;
	}

    @Override
    public ICelestialBodyRenderer getSlotRenderer()
    {
        return new GCVestaSlotRenderer();
    }

    @Override
	public float getStretchValue() 
	{
		return 11.86F;
	}
}