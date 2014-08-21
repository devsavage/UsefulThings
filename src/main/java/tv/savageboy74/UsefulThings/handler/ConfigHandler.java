package tv.savageboy74.usefulthings.handler;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import tv.savageboy74.usefulthings.util.Reference;

import java.io.File;

public class ConfigHandler
{
    public static Configuration configuration;
    public static boolean checkForUpdates = true;

    public static void init(File configFile)
    {
        // Create the configuration object from the given configuration file
        if (configuration == null)
        {
            configuration = new Configuration(new File("config/savageboy74/usefulthings.cfg"));
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

        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }
}
