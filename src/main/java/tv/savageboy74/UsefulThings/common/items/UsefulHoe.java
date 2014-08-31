package tv.savageboy74.usefulthings.common.items;

import net.minecraft.item.ItemHoe;
import tv.savageboy74.usefulthings.common.init.ModToolMaterial;

public class UsefulHoe extends ItemHoe
{
    public UsefulHoe()
    {
        super(ModToolMaterial.randomTool);
        this.setMaxStackSize(1);
    }
}
