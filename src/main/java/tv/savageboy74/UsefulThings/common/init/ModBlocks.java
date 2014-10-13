package tv.savageboy74.usefulthings.common.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import tv.savageboy74.usefulthings.common.blocks.DyeMixer;
import tv.savageboy74.usefulthings.common.blocks.ItemBlockDyeMixer;
import tv.savageboy74.usefulthings.common.util.GUI;

public class ModBlocks
{
    public static Block blockDyeMixer = new DyeMixer();
    public static final int guiDyeMixer = 0;

    public static void init()
    {
        GameRegistry.registerBlock(blockDyeMixer, ItemBlockDyeMixer.class, "dyeMixer");
    }
}
