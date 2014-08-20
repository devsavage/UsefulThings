package tv.savageboy74.RandomJunk.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import tv.savageboy74.RandomJunk.init.ModToolMaterial;

public class RandomPickaxe extends ItemPickaxe
{
    public RandomPickaxe()
    {
        super(ModToolMaterial.randomTool);
        this.setMaxStackSize(1);
    }
}
