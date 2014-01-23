package mattparks.mods.gliese.GlieseE;

import mattparks.mods.gliese.GlieseE.client.GCGlieseEMapPlanet;
import mattparks.mods.gliese.GlieseE.dimension.GCGlieseEWorldProvider;
import mattparks.mods.gliese.galaxy.GalacticraftGlieseGalaxy;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import net.minecraft.world.WorldProvider;

public class GCGlieseEPlanet implements IPlanet
{
    private final IMapObject GlieseE = new GCGlieseEMapPlanet();

    @Override
    public boolean addToList()
    {
        return false;
    }

    @Override
    public boolean autoRegister()
    {
        return true;
    }

    @Override
    public int getDimensionID()
    {
        return GCGlieseEConfigManager.dimensionIDGlieseE;
    }

    @Override
    public IMapObject getMapObject()
    {
        return this.GlieseE;
    }

    @Override
    public String getName()
    {
        return "GlieseE";
    }

    @Override
    public IGalaxy getParentGalaxy()
    {
        return GalacticraftGlieseGalaxy.GlieseGalaxy;
    }

    @Override
    public Class<? extends WorldProvider> getWorldProvider()
    {
        return GCGlieseEWorldProvider.class;
    }

    @Override
    public boolean isReachable()
    {
        return true;
    }
}
