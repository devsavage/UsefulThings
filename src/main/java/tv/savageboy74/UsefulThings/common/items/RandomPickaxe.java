package tv.savageboy74.usefulthings.common.items;

import net.minecraft.item.ItemPickaxe;
import tv.savageboy74.usefulthings.common.init.ModToolMaterial;

public class RandomPickaxe extends ItemPickaxe
{
    public RandomPickaxe()
    {
        super(ModToolMaterial.randomTool);
        this.setMaxStackSize(1);
    }
}
