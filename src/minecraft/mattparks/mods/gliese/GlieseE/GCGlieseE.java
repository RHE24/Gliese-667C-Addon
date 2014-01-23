package mattparks.mods.gliese.GlieseE;

import java.io.File;
import java.util.HashMap;

import mattparks.mods.gliese.GlieseE.dimension.GCGlieseETeleportType;
import mattparks.mods.gliese.GlieseE.dimension.GCGlieseEWorldProvider;
import mattparks.mods.gliese.GlieseE.network.GCGlieseEPacketHandlerServer;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.core.GCLog;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid="StarcraftGlieseE", name="StarcraftGlieseE", version="0.0.1", dependencies = "required-after:GalacticraftCore")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class GCGlieseE
{
    public static final String NAME = "Starcraft GlieseE";
    public static final String MODID = "GCGlieseE";
    public static final String CHANNEL = "GCGlieseE";
    public static final String CHANNELENTITIES = "GCGlieseEEntities";

    public static final String LANGUAGE_PATH = "/assets/starcraftgliesee/lang/";
    private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US" };

    @SidedProxy(clientSide = "mattparks.mods.gliese.GlieseE.client.ClientProxyGlieseE", serverSide = "mattparks.mods.gliese.GlieseE.CommonProxyGlieseE")
    public static CommonProxyGlieseE proxy;

    @Instance(GCGlieseE.MODID)
    public static GCGlieseE instance;

    public static final String ASSET_DOMAIN = "starcraftgliesee";
    public static final String ASSET_PREFIX = GCGlieseE.ASSET_DOMAIN + ":";

	public static CreativeTabs starcraftGlieseETab = new CreativeTabs("starcraftGlieseETab") {
		@Override
		public ItemStack getIconItemStack() {
			return new ItemStack(GCGlieseEBlocks.GlieseEDirt, 1, 0);
		}
	};
    
    public static HashMap<String, ItemStack> blocksList = new HashMap<String, ItemStack>();

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        int languages = 0;

        for (String language : GCGlieseE.LANGUAGES_SUPPORTED)
        {
            LanguageRegistry.instance().loadLocalization(GCGlieseE.LANGUAGE_PATH + language + ".lang", language, false);

            if (LanguageRegistry.instance().getStringLocalization("children", language) != "")
            {
                try
                {
                    String[] children = LanguageRegistry.instance().getStringLocalization("children", language).split(",");

                    for (String child : children)
                    {
                        if (child != "" || child != null)
                        {
                            LanguageRegistry.instance().loadLocalization(GCGlieseE.LANGUAGE_PATH + language + ".lang", child, false);
                            languages++;
                        }
                    }
                }
                catch (Exception e)
                {
                    FMLLog.severe("Failed to load a child language file.");
                    e.printStackTrace();
                }
            }

            languages++;
        }

        GCLog.info("Starcraft GlieseE Loaded: " + languages + " Languages.");

        NetworkRegistry.instance().registerGuiHandler(GCGlieseE.instance, GCGlieseE.proxy);
        this.registerTileEntities();
        this.registerCreatures();
        this.registerOtherEntities();
        GCGlieseE.proxy.init(event);

        GalacticraftRegistry.registerTeleportType(GCGlieseEWorldProvider.class, new GCGlieseETeleportType());
        GalacticraftRegistry.registerCelestialBody(new GCGlieseEPlanet());
        GalacticraftRegistry.registerRocketGui(GCGlieseEWorldProvider.class, new ResourceLocation(GCGlieseE.ASSET_DOMAIN, "textures/gui/GlieseERocketGui.png"));
    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
        GCGlieseE.proxy.postInit(event);
        GCGlieseE.proxy.registerRenderInformation();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new GCGlieseEConfigManager(new File(event.getModConfigurationDirectory(), "starcraft/GlieseE.conf"));

        GCGlieseE.proxy.preInit(event);
    }

    public void registerCreatures()
    {
    	;
    }

    public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
    {
        EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
        EntityRegistry.registerModEntity(var0, var1, id, GCGlieseE.instance, 80, 3, true);
    }

    public void registerGalacticraftNonMobEntity(Class<? extends Entity> var0, String var1, int id, int trackingDistance, int updateFreq, boolean sendVel)
    {
        EntityRegistry.registerModEntity(var0, var1, id, this, trackingDistance, updateFreq, sendVel);
    }
    
    public void registerOtherEntities()
    {
    	;
    }

    public void registerTileEntities()
    {
    	;
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        NetworkRegistry.instance().registerChannel(new GCGlieseEPacketHandlerServer(), GCGlieseE.CHANNEL, Side.SERVER);
    }
}
