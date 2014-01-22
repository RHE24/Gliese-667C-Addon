package mattparks.mods.gliese.sun;

import mattparks.mods.gliese.galaxy.GalaxyCommonProxy;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid="GalacticraftGlieseSun", name="GalacticraftGlieseSun", version="0.0.1", dependencies = "required-after:GalacticraftCore")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class GalacticraftGlieseSun {
	
	public static GCGlieseSun gliesesun;
	
        @Instance("GalacticraftGlieseSun")
        public static GalacticraftGlieseSun instance;
       
        public static GalaxyCommonProxy proxy;
       
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) 
        {
        	GalacticraftGlieseSun.gliesesun = new GCGlieseSun();
        	GalacticraftRegistry.registerCelestialBody(GalacticraftGlieseSun.gliesesun);
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
