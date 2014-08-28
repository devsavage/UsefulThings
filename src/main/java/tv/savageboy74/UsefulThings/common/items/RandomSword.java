package tv.savageboy74.usefulthings.common.items;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import tv.savageboy74.usefulthings.common.init.ModCreativeTab;
import tv.savageboy74.usefulthings.common.init.ModToolMaterial;
import tv.savageboy74.usefulthings.common.util.LogHelper;
import tv.savageboy74.usefulthings.common.util.NBTGlobalOwner;
import tv.savageboy74.usefulthings.common.util.Reference;
import tv.savageboy74.usefulthings.common.util.Strings;

import java.util.List;
import java.util.Random;

public class RandomSword extends ItemSword
{
    //TODO Implement Active Stages

    private float hitDamage;
    private NBTTagCompound toolData;

    public RandomSword()
    {
        super(ModToolMaterial.randomTool);
        this.setMaxStackSize(1);
        this.setFull3D();
        hitDamage = 5.0F;
        this.setCreativeTab(ModCreativeTab.USEFULTHINGS_TAB);
        this.setUnlocalizedName("usefulthings:usefulSword");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + Strings.Items.randomSword);
    }

    public boolean hitEntity(ItemStack itemStack, EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase1)
    {
        if (entityLivingBase1 instanceof EntityPlayer)
        {
            NBTGlobalOwner.checkAndSetItemOwner(itemStack, (EntityPlayer) entityLivingBase1);
        }

        return true;
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

    public float getDamageVsEntity(Entity entity, Random random, ItemStack itemStack)
    {
        if (getActivated(itemStack))
        {
            return this.hitDamage * random.nextInt(1);
        }

        else if (!getActivated(itemStack))
        {
            return this.hitDamage;
        }

        return this.hitDamage;
    }

    public float func_82803_g()
    {
        return 4.0F;
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean par4)
    {
        list.add("Random chance of power!");

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
                list.add(EnumChatFormatting.DARK_AQUA + "Current Owner: " + EnumChatFormatting.GOLD + itemStack.stackTagCompound.getString("ownerName"));
            }
        }
    }

    @Override
    public float getDigSpeed(ItemStack par1ItemStack, Block par2Block, int meta)
    {
        if (par2Block.equals(Blocks.web))
        {
            return 10.0F;
        } else
        {
            Material material = par2Block.getMaterial();
            return material != Material.plants && material != Material.vine && material != Material.coral && material != Material.leaves && material != Material.gourd ? 1.0F : 1.5F;
        }
    }

    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return false;
    }
}
