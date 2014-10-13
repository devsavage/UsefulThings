package tv.savageboy74.usefulthings.common.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import tv.savageboy74.usefulthings.common.crafting.DyeMixerCraftingManager;

public class ModRecipes
{
    public static void init()
    {
       //Dye Mixer
        DyeMixerCraftingManager.addRecipe(new ItemStack(Items.dye, 1, 2), new Object[]{"X", "Y", 'X', new ItemStack(Items.dye, 1, 4), 'Y', new ItemStack(Items.dye, 1, 11)});
    }
}
