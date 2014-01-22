package mattparks.mods.gliese.galaxy;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid="GalacticraftGlieseGalaxy", name="GalacticraftGlieseGalaxy", version="0.0.1", dependencies = "required-after:GalacticraftCore")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class GalacticraftGlieseGalaxy {
	
	public static String ASSET_DOMAIN = "starcraftgliese";

	
    public static final IGalaxy GlieseGalaxy = new GCGlieseGalaxy();
	
        @Instance("GalacticraftGlieseGalaxy")
        public static GalacticraftGlieseGalaxy instance;
       
        public static GalaxyCommonProxy proxy;
       
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) 
        {
            GalacticraftRegistry.registerGalaxy(GalacticraftGlieseGalaxy.GlieseGalaxy);
        }
       
        @EventHandler
        public void load(FMLInitializationEvent event) 
        {
        	;
        }
       
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) 
        {
        	;
        } 
}
