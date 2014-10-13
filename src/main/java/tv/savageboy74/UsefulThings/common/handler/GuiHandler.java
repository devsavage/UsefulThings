package tv.savageboy74.usefulthings.common.handler;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import tv.savageboy74.usefulthings.client.gui.GuiDyeMixer;
import tv.savageboy74.usefulthings.common.container.ContainerDyeMixer;
import tv.savageboy74.usefulthings.common.init.ModBlocks;

public class GuiHandler implements IGuiHandler
{
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);
/*
        if(entity != null) {
            switch(ID) {

                case BlockRegistry.guiIDIronFurnace:
                    if (entity instanceof TileEntityIronFurnace) {
                        return new ContainerIronFurnace(player.inventory, (TileEntityIronFurnace) entity);
                    }
                    return null;

                case BlockRegistry.guiIDRedstoneFurnace:
                    if (entity instanceof TileEntityRedstoneFurnace) {
                        return new ContainerRedstoneFurnace(player.inventory, (TileEntityRedstoneFurnace) entity);
                    }
                    return null;

                case BlockRegistry.guiIDPulverizer:
                    if (entity instanceof TileEntityPulverizer) {
                        return new ContainerPulverizer(player.inventory, (TileEntityPulverizer) entity);
                    }
                    return null;

            }
        }
*/
        if (ID == ModBlocks.guiDyeMixer) {
            return ID == ModBlocks.guiDyeMixer && world.getBlock(x, y, z) == ModBlocks.blockDyeMixer ? new ContainerDyeMixer(player.inventory, world, x, y, z) : null;
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);
/*
        if(entity != null) {
            switch(ID) {
                case BlockRegistry.guiIDIronFurnace:
                    if (entity instanceof TileEntityIronFurnace) {
                        return new GuiIronFurnace(player.inventory, (TileEntityIronFurnace) entity);
                    }
                    return null;

                case BlockRegistry.guiIDRedstoneFurnace:
                    if (entity instanceof TileEntityRedstoneFurnace) {
                        return new GuiRedstoneFurnace(player.inventory, (TileEntityRedstoneFurnace) entity);
                    }
                    return null;

                case BlockRegistry.guiIDPulverizer:
                    if (entity instanceof TileEntityPulverizer) {
                        return new GuiPulverizer(player.inventory, (TileEntityPulverizer) entity);
                    }
                    return null;
            }
        }
*/

        if (ID == ModBlocks.guiDyeMixer) {
            return ID == ModBlocks.guiDyeMixer && world.getBlock(x, y, z) == ModBlocks.blockDyeMixer ? new GuiDyeMixer(player.inventory, world, x, y, z) : null;
        }

        return null;
    }
}
