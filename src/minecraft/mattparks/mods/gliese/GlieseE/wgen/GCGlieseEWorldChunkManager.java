package mattparks.mods.gliese.GlieseE.wgen;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.world.ChunkPosition;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;

public class GCGlieseEWorldChunkManager extends WorldChunkManager
{
    @SuppressWarnings("rawtypes")
    @Override
    public boolean areBiomesViable(int par1, int par2, int par3, List par4List)
    {
        return par4List.contains(GCGlieseEBiomeGenBase.GlieseEFlat);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public ChunkPosition findBiomePosition(int par1, int par2, int par3, List par4List, Random par5Random)
    {
        return par4List.contains(GCGlieseEBiomeGenBase.GlieseEFlat) ? new ChunkPosition(par1 - par3 + par5Random.nextInt(par3 * 2 + 1), 0, par2 - par3 + par5Random.nextInt(par3 * 2 + 1)) : null;
    }

    @Override
    public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5, boolean par6)
    {
        return this.loadBlockGeneratorData(par1ArrayOfBiomeGenBase, par2, par3, par4, par5);
    }

    @Override
    public BiomeGenBase getBiomeGenAt(int par1, int par2)
    {
        return GCGlieseEBiomeGenBase.GlieseEFlat;
    }

    @Override
    public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5)
    {
        if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5)
        {
            par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
        }

        Arrays.fill(par1ArrayOfBiomeGenBase, 0, par4 * par5, GCGlieseEBiomeGenBase.GlieseEFlat);
        return par1ArrayOfBiomeGenBase;
    }

    @Override
    public float[] getRainfall(float[] par1ArrayOfFloat, int par2, int par3, int par4, int par5)
    {
        if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5)
        {
            par1ArrayOfFloat = new float[par4 * par5];
        }

        Arrays.fill(par1ArrayOfFloat, 0, par4 * par5, 0);
        return par1ArrayOfFloat;
    }

    @Override
    public float[] getTemperatures(float[] par1ArrayOfFloat, int par2, int par3, int par4, int par5)
    {
        if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5)
        {
            par1ArrayOfFloat = new float[par4 * par5];
        }

        Arrays.fill(par1ArrayOfFloat, 0, par4 * par5, 0);
        return par1ArrayOfFloat;
    }

    @Override
    public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5)
    {
        if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5)
        {
            par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
        }

        Arrays.fill(par1ArrayOfBiomeGenBase, 0, par4 * par5, GCGlieseEBiomeGenBase.GlieseEFlat);
        return par1ArrayOfBiomeGenBase;
    }
}
