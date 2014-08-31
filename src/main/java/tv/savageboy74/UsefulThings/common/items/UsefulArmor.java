package tv.savageboy74.usefulthings.common.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.ISpecialArmor;
import tv.savageboy74.usefulthings.common.init.ModCreativeTab;
import tv.savageboy74.usefulthings.common.init.ModItems;
import tv.savageboy74.usefulthings.common.util.NBTGlobalOwner;
import tv.savageboy74.usefulthings.common.util.Reference;

import java.util.List;

public class UsefulArmor extends ItemArmor implements ISpecialArmor
{
    private IIcon helmetIcon;
    private IIcon chestIcon;
    private IIcon leggingsIcon;
    private IIcon bootsIcon;

    public UsefulArmor(int armorType)
    {
        super(ArmorMaterial.DIAMOND, 0, armorType);
        this.setMaxDamage(1000);
        this.setCreativeTab(ModCreativeTab.USEFULTHINGS_TAB);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + "armor");
        this.helmetIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + "helmet");
        this.chestIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + "chestplate");
        this.leggingsIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + "leggings");
        this.bootsIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + "boots");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int i)
    {
        if (this.equals(ModItems.usefulHelmet))
        {
            return this.helmetIcon;
        }

        if (this.equals(ModItems.usefulChest))
        {
            return this.chestIcon;
        }

        if (this.equals(ModItems.usefulLeggings))
        {
            return this.leggingsIcon;
        }

        if (this.equals(ModItems.usefulBoots))
        {
            return this.bootsIcon;
        }

        return this.itemIcon;
    }

    @Override
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return false;
    }

    @Override
    public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot)
    {
        if (source.equals(DamageSource.drown))
        {
            return new ArmorProperties(-1, 0, 0);
        }

        ItemStack helmet = player.getEquipmentInSlot(4);
        ItemStack plate = player.getEquipmentInSlot(3);
        ItemStack leggings = player.getEquipmentInSlot(2);
        ItemStack boots = player.getEquipmentInSlot(1);

        if (helmet == null || plate == null || leggings == null || boots == null)
        {
            return new ArmorProperties(-1, 0, 0);
        }

        if (helmet.getItem().equals(ModItems.usefulHelmet) && plate.getItem().equals(ModItems.usefulChest) && leggings.getItem().equals(ModItems.usefulLeggings) && boots.getItem().equals(ModItems.usefulBoots))
        {
            if (source.isUnblockable())
            {
                return new ArmorProperties(-1, 0.25 * 0.8d, 100000);
            }

            return new ArmorProperties(-1, 0.25, 100000);
        }

        return new ArmorProperties(-1, 0, 0);
    }

    @Override
    public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot)
    {
        if (armor.equals(ModItems.usefulHelmet))
        {
            return 3;
        }

        if (armor.equals(ModItems.usefulChest))
        {
            return 8;
        }

        if (armor.equals(ModItems.usefulLeggings))
        {
            return 6;
        }

        if (armor.equals(ModItems.usefulBoots))
        {
            return 3;
        }

        return 5;
    }

    @Override
    public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot)
    {
        if (entity instanceof EntityPlayer)
        {
            NBTGlobalOwner.checkAndSetItemOwner(stack, (EntityPlayer) entity);
        }

        stack.setItemDamage(stack.getItemDamage() + damage);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean par1)
    {
        list.add("Provides some sort of protection.");

        if (!(itemStack.stackTagCompound == null))
        {
            if (!itemStack.stackTagCompound.getString("ownerName").equals(""))
            {
                list.add("Current Owner: " + itemStack.stackTagCompound.getString("ownerName"));
            }
        }
    }
}
