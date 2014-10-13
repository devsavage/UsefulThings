package tv.savageboy74.usefulthings.common.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.input.Keyboard;

import java.util.List;

public class ItemBlockDyeMixer extends ItemBlock
{
    public ItemBlockDyeMixer(Block block)
    {
        super(block);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean flag)
    {
        if (!Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
        {
            list.add("Hold " + EnumChatFormatting.GOLD + "shift" + EnumChatFormatting.GRAY + " for details.");
        }
        else {
            list.add("You mix dye to make new dye.");
        }
    }

}
