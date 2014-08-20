package tv.savageboy74.RandomJunk.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import tv.savageboy74.RandomJunk.init.ModToolMaterial;
import tv.savageboy74.RandomJunk.util.NBTGlobalOwner;
import tv.savageboy74.RandomJunk.util.Reference;
import tv.savageboy74.RandomJunk.util.Strings;

import java.util.List;

public class RandomAxe extends ItemAxe
{
    public static final Block[] blockAffectiveAgainst = new Block[]{Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin, Blocks.bed, Blocks.oak_stairs, Blocks.acacia_stairs, Blocks.birch_stairs, Blocks.dark_oak_stairs, Blocks.jungle_stairs, Blocks.spruce_stairs, Blocks.standing_sign, Blocks.wall_sign};

    public float efficiencyOnProperMaterial = 12.0F;

    public float damageVsEntity;

    private static IIcon activeIcon;
    private static IIcon passiveIcon;

    public RandomAxe()
    {
        super(ModToolMaterial.randomTool);
        this.setMaxStackSize(1);
        this.efficiencyOnProperMaterial = 15.0F;
        this.damageVsEntity = 5;
        this.setUnlocalizedName("randomAxe");
    }

    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean i)
    {
        if (!(itemStack.stackTagCompound == null))
        {
            if (itemStack.stackTagCompound.getBoolean("isActive"))
            {
                list.add(EnumChatFormatting.DARK_GREEN + "Activated");
            } else
            {
                list.add(EnumChatFormatting.DARK_RED + "Deactivated");
            }

            if (!itemStack.stackTagCompound.getString("ownerName").equals(""))
            {
                list.add(EnumChatFormatting.DARK_AQUA + "Current Owner: " + EnumChatFormatting.GOLD +  itemStack.stackTagCompound.getString("ownerName"));
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + Strings.Items.randomAxe);
        this.activeIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + Strings.Items.randomAxe_activated);
        this.passiveIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + Strings.Items.randomAxe);
    }

    @Override
    public IIcon getIcon(ItemStack itemStack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
    {
        if (itemStack.stackTagCompound == null)
        {
            itemStack.setTagCompound(new NBTTagCompound());
        }

        NBTTagCompound tag = itemStack.stackTagCompound;

        if (tag.getBoolean("isActive"))
        {
            return this.activeIcon;
        } else
        {
            return this.itemIcon;
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
    {
        NBTGlobalOwner.checkAndSetItemOwner(itemStack, entityPlayer);

        if (entityPlayer.isSneaking())
        {
            this.setActivated(itemStack, !getActivated(itemStack));
            itemStack.stackTagCompound.setInteger("worldTimeDelay", (int) (world.getWorldTime() - 1) % 200);
            return itemStack;
        }

        if (!getActivated(itemStack))
        {
            return itemStack;
        }

        return itemStack;
    }

    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int i, boolean j)
    {
        if (!(entity instanceof EntityPlayer))
        {
            return;
        }

        EntityPlayer entityPlayer = (EntityPlayer) entity;

        if (itemStack.stackTagCompound == null)
        {
            itemStack.setTagCompound(new NBTTagCompound());
        }
    }

    public void setActivated(ItemStack par1ItemStack, boolean newActivated)
    {
        NBTTagCompound itemTag = par1ItemStack.stackTagCompound;

        if (itemTag == null)
        {
            par1ItemStack.setTagCompound(new NBTTagCompound());
        }

        itemTag.setBoolean("isActive", newActivated);
    }

    public boolean getActivated(ItemStack par1ItemStack)
    {
        NBTTagCompound itemTag = par1ItemStack.stackTagCompound;

        if (itemTag == null)
        {
            par1ItemStack.setTagCompound(new NBTTagCompound());
        }

        return itemTag.getBoolean("isActive");
    }

    @Override
    public float func_150893_a(ItemStack par1ItemStack, Block par2Block)
    {
        if (!getActivated(par1ItemStack))
        {
            return 0.0F;
        }

        return super.func_150893_a(par1ItemStack, par2Block);
    }

    public boolean isFull3D()
    {
        return true;
    }

    @Override
    public int getItemEnchantability()
    {
        return 30;
    }

    @Override
    public float getDigSpeed(ItemStack stack, Block block, int meta)
    {
        if (!getActivated(stack))
        {
            return 0.0F;
        }

        if (ForgeHooks.isToolEffective(stack, block, meta))
        {
            return efficiencyOnProperMaterial;
        }

        return func_150893_a(stack, block);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
        return !getActivated(stack);
    }

    @Override
    public int getHarvestLevel(ItemStack stack, String toolClass)
    {
        if("axe".equals(toolClass))
        {
            return 5;
        }

        return 0;
    }
}
