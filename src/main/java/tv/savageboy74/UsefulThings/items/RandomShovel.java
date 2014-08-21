package tv.savageboy74.usefulthings.items;

import net.minecraft.item.ItemSpade;
import tv.savageboy74.usefulthings.init.ModToolMaterial;

public class RandomShovel extends ItemSpade
{
    public RandomShovel()
    {
        super(ModToolMaterial.randomTool);
        this.setMaxStackSize(1);
    }
}
