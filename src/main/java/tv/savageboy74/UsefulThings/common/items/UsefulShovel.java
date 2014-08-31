package tv.savageboy74.usefulthings.common.items;

import net.minecraft.item.ItemSpade;
import tv.savageboy74.usefulthings.common.init.ModToolMaterial;

public class UsefulShovel extends ItemSpade
{
    public UsefulShovel()
    {
        super(ModToolMaterial.randomTool);
        this.setMaxStackSize(1);
    }
}
