package tv.savageboy74.usefulthings.common.crafting;

import net.minecraft.item.crafting.IRecipe;

import java.util.Comparator;

public class DyeMixerRecipeSorter implements Comparator
{
    final  DyeMixerCraftingManager mixer;

    public DyeMixerRecipeSorter( DyeMixerCraftingManager  mixerCraftingManager) {
        this.mixer = mixerCraftingManager;
    }

    public int compareRecipes(IRecipe irecipe1, IRecipe irecipe2) {
        return irecipe1 instanceof DyeMixerShapelessRecipes && irecipe2 instanceof DyeMixerShapedRecipes ? 1: (irecipe2 instanceof DyeMixerShapelessRecipes && irecipe1 instanceof DyeMixerShapedRecipes ? -1 : (irecipe2.getRecipeSize() < irecipe1.getRecipeSize() ? -1 : (irecipe2.getRecipeSize() > irecipe1.getRecipeSize() ? 1 : 0)));
    }

    @Override
    public int compare(Object o1, Object o2) {
        return this.compareRecipes((IRecipe)o1, (IRecipe)o2);
    }
}
