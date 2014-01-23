package mattparks.mods.gliese.sun.client;

import mattparks.mods.gliese.galaxy.GalacticraftGlieseGalaxy;
import micdoodle8.mods.galacticraft.api.world.ICelestialBodyRenderer;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;

public class GCGlieseSunMap implements IMapObject
{
    @Override
    public float getPlanetSize()
    {
        return 108F;
    }

    @Override
    public float getDistanceFromCenter()
    {
        return 0F;
    }

    @Override
    public float getPhaseShift()
    {
        return 0;
    }

    @Override
    public float getStretchValue()
    {
        return 0F;
    }

    @Override
    public ICelestialBodyRenderer getSlotRenderer()
    {
        return new GCGlieseSunSlotRender();
    }

    @Override
    public IGalaxy getParentGalaxy()
    {
        return GalacticraftGlieseGalaxy.GlieseGalaxy;
    }
}