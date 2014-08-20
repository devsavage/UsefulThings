package tv.savageboy74.RandomJunk.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class NBTGlobalOwner
{
    public static void checkAndSetItemOwner(ItemStack item, EntityPlayer player)
    {
        if (item.stackTagCompound == null)
        {
            item.setTagCompound(new NBTTagCompound());
        }

        if (item.stackTagCompound.getString("ownerName").equals(""))
        {
            item.stackTagCompound.setString("ownerName", RandomHelper.getUserDisplayName(player));
        }
    }
}
