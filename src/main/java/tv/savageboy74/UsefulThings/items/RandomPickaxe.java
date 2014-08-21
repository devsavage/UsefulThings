package tv.savageboy74.usefulthings.items;

import net.minecraft.item.ItemPickaxe;
import tv.savageboy74.usefulthings.init.ModToolMaterial;

public class RandomPickaxe extends ItemPickaxe
{
    public RandomPickaxe()
    {
        super(ModToolMaterial.randomTool);
        this.setMaxStackSize(1);
    }
}
