package mattparks.mods.gliese.vesta.dimension;

import mattparks.mods.gliese.vesta.GCVestaConfigManager;
import mattparks.mods.gliese.vesta.wgen.GCVestaChunkProvider;
import mattparks.mods.gliese.vesta.wgen.GCVestaWorldChunkManager;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.api.world.ISolarLevel;
import micdoodle8.mods.galacticraft.core.GCCoreConfigManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCVestaWorldProvider extends WorldProvider implements IGalacticraftWorldProvider, ISolarLevel
{
    @Override
    public float[] calcSunriseSunsetColors(float var1, float var2)
    {
        return null;
    }

    @Override
    public float calculateCelestialAngle(long par1, float par3)
    {
        return super.calculateCelestialAngle(par1, par3);
    }

    public float calculateDeimosAngle(long par1, float par3)
    {
        return this.calculatePhobosAngle(par1, par3) * 0.0000000001F;
    }

    public float calculatePhobosAngle(long par1, float par3)
    {
        return this.calculateCelestialAngle(par1, par3) * 3000;
    }

    @Override
    public boolean canBlockFreeze(int x, int y, int z, boolean byWater)
    {
        return false;
    }

    @Override
    public boolean canCoordinateBeSpawn(int var1, int var2)
    {
        return true;
    }

    @Override
    public boolean canDoLightning(Chunk chunk)
    {
        return false;
    }

    @Override
    public boolean canDoRainSnowIce(Chunk chunk)
    {
        return false;
    }

    @Override
    public boolean canRespawnHere()
    {
        return !GCCoreConfigManager.forceOverworldRespawn;
    }

    @Override
    public boolean canSnowAt(int x, int y, int z)
    {
        return false;
    }

    @Override
    public boolean canSpaceshipTierPass(int tier)
    {
        return tier >= 4;
    }

    @Override
    public IChunkProvider createChunkGenerator()
    {
        return new GCVestaChunkProvider(this.worldObj, this.worldObj.getSeed(), this.worldObj.getWorldInfo().isMapFeaturesEnabled());
    }

    @Override
    protected void generateLightBrightnessTable()
    {
        final float var1 = 0.0F;

        for (int var2 = 0; var2 <= 15; ++var2)
        {
            final float var3 = 1.0F - var2 / 15.0F;
            this.lightBrightnessTable[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
        }
    }

    @Override
    public int getAverageGroundLevel()
    {
        return 44;
    }

    @Override
    public String getDepartMessage()
    {
        return "Leaving Vesta";
    }

    @Override
    public String getDimensionName()
    {
        return "Vesta";
    }

    @Override
    public float getFallDamageModifier()
    {
        return 0.38F;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public Vec3 getFogColor(float var1, float var2)
    {
        return this.worldObj.getWorldVec3Pool().getVecFromPool((double) 0F / 255F, (double) 0F / 255F, (double) 0F / 255F);
    }

    @Override
    public double getFuelUsageMultiplier()
    {
        return 0.9D;
    }

    @Override
    public float getGravity()
    {
        return 0.058F;
    }

    @Override
    public int getHeight()
    {
        return 800;
    }

    @Override
    public double getHorizon()
    {
        return 44.0D;
    }

    @Override
    public double getMeteorFrequency()
    {
        return 10.0D;
    }

    @Override
    public String getSaveFolder()
    {
        return "DIM" + GCVestaConfigManager.dimensionIDVesta;
    }

    @Override
    public Vec3 getSkyColor(Entity cameraEntity, float partialTicks)
    {
        return this.worldObj.getWorldVec3Pool().getVecFromPool(0, 0, 0);
    }

    @Override
    public double getSolarEnergyMultiplier()
    {
        return 2.5D;
    }

    @Override
    public float getSoundVolReductionAmount()
    {
        return 10.0F;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float getStarBrightness(float par1)
    {
        final float var2 = this.worldObj.getCelestialAngle(par1);
        float var3 = 1.0F - (MathHelper.cos(var2 * (float) Math.PI * 2.0F) * 2.0F + 0.25F);

        if (var3 < 0.0F)
        {
            var3 = 0.0F;
        }

        if (var3 > 1.0F)
        {
            var3 = 1.0F;
        }

        return var3 * var3 * 0.5F + 0.3F;
    }

    @Override
    public String getWelcomeMessage()
    {
        return "Entering Vesta";
    }

    @Override
    public boolean isSkyColored()
    {
        return true;
    }

    @Override
    public boolean isSurfaceWorld()
    {
        return true;
    }

    @Override
    public void registerWorldChunkManager()
    {
        this.worldChunkMgr = new GCVestaWorldChunkManager();
    }

    @Override
    public void setDimension(int var1)
    {
        this.dimensionId = var1;
        super.setDimension(var1);
    }

    @Override
    public void updateWeather()
    {
        this.worldObj.getWorldInfo().setRainTime(0);
        this.worldObj.getWorldInfo().setRaining(false);
        this.worldObj.getWorldInfo().setThunderTime(0);
        this.worldObj.getWorldInfo().setThundering(false);
    }
}