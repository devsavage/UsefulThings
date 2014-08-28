package tv.savageboy74.usefulthings.common.items;

import net.minecraft.item.ItemHoe;
import tv.savageboy74.usefulthings.common.init.ModToolMaterial;

public class RandomHoe extends ItemHoe
{
    public RandomHoe()
    {
        super(ModToolMaterial.randomTool);
        this.setMaxStackSize(1);
    }
}
