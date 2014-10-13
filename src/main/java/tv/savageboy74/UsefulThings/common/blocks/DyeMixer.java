package tv.savageboy74.usefulthings.common.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import tv.savageboy74.usefulthings.UsefulThings;
import tv.savageboy74.usefulthings.common.init.ModBlocks;
import tv.savageboy74.usefulthings.common.init.ModCreativeTab;
import tv.savageboy74.usefulthings.common.util.Reference;

public class DyeMixer extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon dyeMixerTop;

    public DyeMixer() {
        super(Material.cloth);

        this.setHardness(3.5F);
        this.setResistance(3.5F);
        this.setStepSound(soundTypeCloth);
        this.setBlockName("dyeMixer");
        this.setCreativeTab(ModCreativeTab.USEFULTHINGS_TAB);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
        return side == 1 ? this.dyeMixerTop : this.blockIcon;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + "blockDyeMixerSide");
        this.dyeMixerTop = iconRegister.registerIcon(Reference.MOD_ID + ":" + "blockDyeMixerTop");
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {

        if (!player.isSneaking()) {
            player.openGui(UsefulThings.instance, ModBlocks.guiDyeMixer, world, x, y, z);
            return true;
        } else {
            return false;
        }
    }
}
