package tv.savageboy74.RandomJunk.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import tv.savageboy74.RandomJunk.init.ModToolMaterial;

public class RandomShovel extends ItemSpade
{
    public RandomShovel()
    {
        super(ModToolMaterial.randomTool);
        this.setMaxStackSize(1);
    }
}
