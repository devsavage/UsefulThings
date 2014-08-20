package tv.savageboy74.RandomJunk.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import tv.savageboy74.RandomJunk.init.ModToolMaterial;

public class RandomHoe extends ItemHoe
{
    public RandomHoe()
    {
        super(ModToolMaterial.randomTool);
        this.setMaxStackSize(1);
    }
}
