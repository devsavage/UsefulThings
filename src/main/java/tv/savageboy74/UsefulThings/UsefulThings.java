package tv.savageboy74.usefulthings;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.MinecraftForge;
import tv.savageboy74.usefulthings.client.handler.KeyInputEventHandler;
import tv.savageboy74.usefulthings.common.handler.ConfigHandler;
import tv.savageboy74.usefulthings.common.init.ModBlocks;
import tv.savageboy74.usefulthings.common.init.ModItems;
import tv.savageboy74.usefulthings.common.proxy.IProxy;
import tv.savageboy74.usefulthings.common.util.DebugOutput;
import tv.savageboy74.usefulthings.common.util.LogHelper;
import tv.savageboy74.usefulthings.common.util.Reference;
import tv.savageboy74.usefulthings.common.util.UpdateChecker;

import java.io.IOException;

@Mod(modid = Reference.MOD_ID, version = Reference.VERSION, name = Reference.MOD_NAME, guiFactory = Reference.GUI_FACTORY_CLASS) //dependencies = Reference.DEPENDENCIES)
public class UsefulThings
{

    @Mod.Instance(Reference.MOD_ID)
    public static UsefulThings instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static IProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        FMLCommonHandler.instance().bus().register(this);
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(DebugOutput.class);
        ConfigHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigHandler());
        proxy.registerKeyBindings();

        if (ConfigHandler.checkForUpdates == true) {

            try {
                LogHelper.info("Checking for updates...");
                UpdateChecker.checkForUpdates();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        LogHelper.info("Pre-Initialization Complete.");
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        FMLCommonHandler.instance().bus().register(new KeyInputEventHandler());

        ModItems.init();
        ModBlocks.init();

        LogHelper.info("Initialization Complete.");

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

        LogHelper.info("Post-Initialization Complete.");
    }

    @SubscribeEvent
    public void checkUpdate(PlayerEvent.PlayerLoggedInEvent event) {
        if (Reference.OUTDATED) {
            event.player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.AQUA + "usefulthings " +  EnumChatFormatting.WHITE + "is " + EnumChatFormatting.DARK_RED + "outdated!"));
            event.player.addChatComponentMessage(new ChatComponentText("Current Version: " + EnumChatFormatting.DARK_RED + Reference.CURRENTVERSION + EnumChatFormatting.WHITE +  " Newest Version: " + EnumChatFormatting.DARK_GREEN + Reference.NEWVERSION));
        }
    }
}
