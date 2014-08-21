package tv.savageboy74.usefulthings.items;

import net.minecraft.item.ItemHoe;
import tv.savageboy74.usefulthings.init.ModToolMaterial;

public class RandomHoe extends ItemHoe
{
    public RandomHoe()
    {
        super(ModToolMaterial.randomTool);
        this.setMaxStackSize(1);
    }
}
