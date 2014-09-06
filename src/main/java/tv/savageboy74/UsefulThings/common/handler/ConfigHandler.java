package tv.savageboy74.usefulthings.common.handler;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import tv.savageboy74.usefulthings.common.util.Reference;

import java.io.File;

public class ConfigHandler
{
    public static Configuration configuration;
    public static boolean checkForUpdates = true;
    public static Block[] woodBlocks;

    public static void init(File configFile)
    {
        // Create the configuration object from the given configuration file
        if (configuration == null)
        {
            configuration = new Configuration(new File("config/savageboy74/UsefulThings.cfg"));
            loadConfiguration();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
        {
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
        checkForUpdates = configuration.getBoolean("Check For Updates", Configuration.CATEGORY_GENERAL, true, "Allow usefulthings to check for updates");
        Property prop = configuration.get(Configuration.CATEGORY_GENERAL, "Wooden Blocks", new String[]{"log", "log2"}, "Add more wood blocks here, such as Biome's O' Plenty's trees.");
        String[] names = prop.getStringList();
        woodBlocks = new Block[names.length];
        for (int i = 0; i < names.length; i++) {
            woodBlocks[i] = Block.getBlockFromName(names[i]);
        }

        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }
}
