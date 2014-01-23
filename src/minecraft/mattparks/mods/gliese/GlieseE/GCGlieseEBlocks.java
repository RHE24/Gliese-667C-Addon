package mattparks.mods.gliese.GlieseE;

import mattparks.mods.gliese.GlieseE.blocks.StarcraftBlock;
import mattparks.mods.gliese.GlieseE.blocks.StarcraftGrass;
import mattparks.mods.gliese.GlieseE.blocks.GlieseEStone;
import net.minecraft.block.Block;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid="StarcraftGlieseEBlocks", name="StarcraftGlieseEBlocks", version="0.0.1", dependencies = "required-after:GalacticraftCore")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class GCGlieseEBlocks 
{
    public static final String NAME = "Starcraft GlieseE Blocks";
    public static final String MODID = "StarcraftGlieseEBlocks";
    public static final String CHANNEL = "StarcraftGlieseEBlocks";
    public static final String CHANNELENTITIES = "StarcraftGlieseEBlocksEntities";

    
	// Block GlieseE, Grass
	public static final Block GlieseEGrass = new StarcraftGrass(650, null)
			.setHardness(1.5F).setStepSound(Block.soundGrassFootstep)
			.setUnlocalizedName("GlieseEGrass")
			.setTextureName("starcraftGlieseE:GlieseEGrass")
			.setCreativeTab(GCGlieseE.starcraftGlieseETab);

	// Block GlieseE, Dirt
	public static final Block GlieseEDirt = new StarcraftBlock(651, null)
			.setHardness(0.4F).setStepSound(Block.soundGravelFootstep)
			.setUnlocalizedName("GlieseEDirt")
			.setTextureName("starcraftGlieseE:GlieseEDirt")
			.setCreativeTab(GCGlieseE.starcraftGlieseETab);

	// Block GlieseE, Stone
	public static final Block GlieseEStone = new GlieseEStone(652, null)
			.setHardness(0.3F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("GlieseEStone")
			.setTextureName("starcraftGlieseE:GlieseEStone")
			.setCreativeTab(GCGlieseE.starcraftGlieseETab);

	// Block GlieseE, Brick
	public static final Block GlieseEBrick = new StarcraftBlock(653, null)
			.setHardness(1000.0F).setStepSound(Block.soundStoneFootstep)
			.setUnlocalizedName("GlieseEBrick")
			.setTextureName("starcraftGlieseE:GlieseEBrick")
			.setCreativeTab(GCGlieseE.starcraftGlieseETab)
			.setBlockUnbreakable();
	

        @Instance(value = "GCGlieseEBlocks")
        public static GCGlieseEBlocks instance;
        
        @SidedProxy(clientSide = "mattparks.mods.gliese.GlieseE.client.ClientProxyGlieseE", serverSide = "mattparks.mods.gliese.GlieseE.CommonProxyGlieseE")
        public static CommonProxyGlieseE proxy;
        
        @EventHandler
        public void load(FMLInitializationEvent event) 
        {
                GameRegistry.registerBlock(GCGlieseEBlocks.GlieseEGrass, "GlieseEGrass");
                GameRegistry.registerBlock(GCGlieseEBlocks.GlieseEDirt, "GlieseEDirt");
                GameRegistry.registerBlock(GCGlieseEBlocks.GlieseEStone, "GlieseEStone");
                GameRegistry.registerBlock(GCGlieseEBlocks.GlieseEBrick, "GlieseEBrick");   
        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) 
        {
        	;
        }
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) 
        {
        	;
        }
}