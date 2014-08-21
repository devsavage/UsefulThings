package tv.savageboy74.usefulthings.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import tv.savageboy74.usefulthings.items.*;

public class ModItems
{

    public static Item randomSword = new RandomSword();
    public static Item randomHoe = new RandomHoe();
    public static Item randomAxe = new RandomAxe();
    public static Item randomShovel = new RandomShovel();
    public static Item randomPickaxe = new RandomPickaxe();

    public static void init()
    {
        GameRegistry.registerItem(randomAxe, "randomAxe");
        //GameRegistry.registerItem(randomPickaxe, "randomPickaxe");
        //GameRegistry.registerItem(randomHoe, "randomHoe");
        //GameRegistry.registerItem(randomShovel, "randomShovel");
        GameRegistry.registerItem(randomSword, "randomSword");

    }
}
