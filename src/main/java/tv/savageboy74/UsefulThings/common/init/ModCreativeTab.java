package tv.savageboy74.usefulthings.common.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import tv.savageboy74.usefulthings.common.util.Reference;

public class ModCreativeTab
{
    public static final CreativeTabs USEFULTHINGS_TAB = new CreativeTabs(Reference.MOD_ID)
    {
        @Override
        public Item getTabIconItem()
        {
            return ModItems.lumberAxe;
        }
    };
}
