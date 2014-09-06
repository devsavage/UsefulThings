package tv.savageboy74.usefulthings.common.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import tv.savageboy74.usefulthings.common.items.*;

public class ModItems
{

    public static Item usefulSword = new UsefulSword();
    public static Item usefulHoe = new UsefulHoe();
    public static Item usefulAxe = new UsefulAxe();
    public static Item usefulShovel = new UsefulShovel();
    public static Item usefulPickaxe = new UsefulPickaxe();

    public static Item usefulHelmet = new UsefulArmor(0).setUnlocalizedName("usefulthings:usefulHelmet");
    public static Item usefulChest = new UsefulArmor(1).setUnlocalizedName("usefulthings:usefulChest");
    public static Item usefulLeggings = new UsefulArmor(2).setUnlocalizedName("usefulthings:usefulLeggings");
    public static Item usefulBoots = new UsefulArmor(3).setUnlocalizedName("usefulthings:usefulBoots");

    public static LumberAxe lumberAxe = new LumberAxe(4.0F, Item.ToolMaterial.IRON);

    public static void init()
    {
        GameRegistry.registerItem(usefulAxe, "usefulAxe");
        //GameRegistry.registerItem(usefulPickaxe, "usefulPickaxe");
        //GameRegistry.registerItem(usefulHoe, "usefulHoe");
        //GameRegistry.registerItem(usefulShovel, "usefulShovel");
        GameRegistry.registerItem(usefulSword, "usefulSword");
        GameRegistry.registerItem(usefulHelmet, "usefulHelmet");
        GameRegistry.registerItem(usefulChest, "usefulChest");
        GameRegistry.registerItem(usefulLeggings, "usefulLeggings");
        GameRegistry.registerItem(usefulBoots, "usefulBoots");
        GameRegistry.registerItem(lumberAxe, "lumberAxe");
    }
}
