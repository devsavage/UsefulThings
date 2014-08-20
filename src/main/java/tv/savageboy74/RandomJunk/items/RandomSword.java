package tv.savageboy74.RandomJunk.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import tv.savageboy74.RandomJunk.init.ModToolMaterial;

public class RandomSword extends ItemSword
{
    public RandomSword()
    {
        super(ModToolMaterial.randomTool);
        this.setMaxStackSize(1);

    }
}
