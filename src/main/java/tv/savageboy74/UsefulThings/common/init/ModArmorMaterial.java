package tv.savageboy74.usefulthings.common.init;

import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ModArmorMaterial
{
    public static ItemArmor.ArmorMaterial randomArmor = EnumHelper.addArmorMaterial("Random Armor", 33, new int[]{3, 8, 6, 3}, 30);
}
