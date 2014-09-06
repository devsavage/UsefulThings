package tv.savageboy74.usefulthings.common.items;

import com.google.common.collect.Sets;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import tv.savageboy74.usefulthings.common.handler.ConfigHandler;
import tv.savageboy74.usefulthings.common.init.ModCreativeTab;
import tv.savageboy74.usefulthings.common.util.Reference;
import tv.savageboy74.usefulthings.common.util.Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class LumberAxe extends ItemTool
{
    private static class AxePosition
    {
        public int x;
        public int y;
        public int z;

        public AxePosition(int x, int y, int z)
        {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public boolean equals(Object object)
        {
            if (!(object instanceof AxePosition))
            {
                return false;
            }

            AxePosition position = (AxePosition)object;

            return (position.x == this.x) && (position.y == this.y) && (position.z == this.z);
        }
    }

    private static final Set set = Sets.newHashSet(new Block[]{Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin});

    public LumberAxe(float damage, Item.ToolMaterial toolMaterial)
    {
        super(damage, toolMaterial, set);
        this.setUnlocalizedName("usefulthings:lumberAxe");
        this.setCreativeTab(ModCreativeTab.USEFULTHINGS_TAB);
    }

    public boolean onBlockStartBreak(ItemStack stack, int x, int y, int z, EntityPlayer player)
    {
        World world = player.worldObj;
        AxePosition pos1 = new AxePosition(x, y, z);
        if (isValidWoodBlock(world, pos1))
        {
            List<AxePosition> woodBlocks = getConnectedWoodBlocks(world, x, y, z);
            for (AxePosition pos : woodBlocks) {
                if (!pos.equals(pos1))
                {
                    Block block = world.getBlock(pos.x, pos.y, pos.z);
                    int meta = world.getBlockMetadata(pos.x, pos.y, pos.z);
                    world.setBlockToAir(pos.x, pos.y, pos.z);
                    block.dropBlockAsItem(world, pos.x, pos.y, pos.z, meta, 0);
                }
            }
            stack.damageItem(1, player);
        }
        return false;
    }

    private List<AxePosition> getConnectedWoodBlocks(World world, int x, int y, int z)
    {
        List<AxePosition> res = new ArrayList();
        Stack<AxePosition> positions = new Stack();
        positions.push(new AxePosition(x, y, z));
        do
        {
            AxePosition pos = (AxePosition)positions.pop();
            for (int i = 0; i < 6; i++)
            {
                ForgeDirection dir = ForgeDirection.getOrientation(i);
                AxePosition newPos = new AxePosition(pos.x + dir.offsetX, pos.y + dir.offsetY, pos.z + dir.offsetZ);
                if ((isValidWoodBlock(world, newPos)) && (!positions.contains(newPos)) && (!res.contains(newPos))) {
                    positions.push(newPos);
                }
            }
            res.add(pos);
        } while (!positions.empty());
        return res;
    }

    private boolean isValidWoodBlock(World world, AxePosition pos)
    {
        for (int i = 0; i < ConfigHandler.woodBlocks.length; i++)
        {
            if (world.getBlock(pos.x, pos.y, pos.z) == ConfigHandler.woodBlocks[i])
            {
                return true;
            }
        }

        return false;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int par1)
    {
        return this.itemIcon;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + Strings.Items.lumberAxe);
    }
}
