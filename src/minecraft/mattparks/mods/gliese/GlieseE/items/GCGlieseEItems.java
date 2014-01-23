package mattparks.mods.gliese.GlieseE.items;

import mattparks.mods.gliese.GlieseE.GCGlieseEConfigManager;
import net.minecraft.item.Item;

public class GCGlieseEItems
{
    public static Item GlieseEItemBasic;

    public static void initItems()
    {
    	GCGlieseEItems.GlieseEItemBasic = new GCGlieseEItem(GCGlieseEConfigManager.idItemGlieseEBasic).setUnlocalizedName("GlieseEBasic");
    }
    
    public static void registerHarvestLevels()
    {
    }
}