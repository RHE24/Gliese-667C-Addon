package mattparks.mods.gliese.GlieseE.blocks;

import micdoodle8.mods.galacticraft.api.block.IPlantableBlock;
import micdoodle8.mods.galacticraft.api.block.ITerraformableBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

public class StarcraftGrass extends Block implements ITerraformableBlock, IPlantableBlock
{
    public StarcraftGrass(int par1, String name)
    {
        super(par1, Material.rock);
        this.setUnlocalizedName(name);
//        this.setTextureName(StarcraftCore.ASSET_PREFIX + name);
        this.setHardness(2.0F);
    }

//    @Override
//    @SideOnly(Side.CLIENT)
//    public CreativeTabs getCreativeTabToDisplayOn()
//    {
//        return StarcraftCore.starcraftCoreTab;
//    }

    @Override
    public boolean canSustainPlant(World world, int x, int y, int z, ForgeDirection direction, IPlantable plant)
    {
        final int metadata = world.getBlockMetadata(x, y, z);

        if (metadata < 5 && metadata > 13)
        {
            return false;
        }

        plant.getPlantID(world, x, y + 1, z);

        if (plant instanceof BlockFlower)
        {
            return true;
        }

        return false;
    }

    @Override
    public boolean isPlantable(int metadata)
    {
        if (metadata >= 5 && metadata <= 13)
        {
            return true;
        }

        return false;
    }

    @Override
    public boolean isTerraformable(World world, int x, int y, int z)
    {
        int meta = world.getBlockMetadata(x, y, z);

        if (meta >= 5 && meta <= 13)
        {
            return world.getBlockId(x, y + 1, z) == 0;
        }

        return false;
    }

    @Override
    public int requiredLiquidBlocksNearby()
    {
        return 4;
    }
}
