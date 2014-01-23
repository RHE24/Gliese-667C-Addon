package mattparks.mods.gliese.GlieseE;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class GCGlieseEConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    // DIMENSIONS
    public static int dimensionIDGlieseE;

    public static boolean generateOtherMods;

    // BLOCKS

    // ITEMS
    public static int idItemGlieseEBasic;
    
    // ARMOR

    // TOOLS

    // ENTITIES

    // GUI

    // SCHEMATIC

    // ACHIEVEMENTS

    // GENERAL
  
    public GCGlieseEConfigManager(File file)
    {
        if (!GCGlieseEConfigManager.loaded)
        {
            GCGlieseEConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    private void setDefaultValues()
    {
        try
        {
            GCGlieseEConfigManager.configuration.load();

            GCGlieseEConfigManager.dimensionIDGlieseE = GCGlieseEConfigManager.configuration.get("Dimensions", "GlieseE Dimension ID", -51).getInt(-51);
        
            GCGlieseEConfigManager.idItemGlieseEBasic = GCGlieseEConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemGlieseEItemBasic", 3756).getInt(3756);
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Starcraft GlieseE has a problem loading it's configuration");
        }
        finally
        {
            GCGlieseEConfigManager.configuration.save();
            GCGlieseEConfigManager.loaded = true;
        }
    }
}
