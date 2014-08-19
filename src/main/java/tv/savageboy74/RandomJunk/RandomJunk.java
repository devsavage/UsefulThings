package tv.savageboy74.RandomJunk;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.MinecraftForge;
import tv.savageboy74.RandomJunk.handler.ConfigHandler;
import tv.savageboy74.RandomJunk.util.LogHelper;
import tv.savageboy74.RandomJunk.util.Reference;
import tv.savageboy74.RandomJunk.util.UpdateChecker;

import java.io.IOException;

@Mod(modid = Reference.MOD_ID, version = Reference.VERSION, name = Reference.MOD_NAME, guiFactory = Reference.GUI_FACTORY_CLASS)
public class RandomJunk
{

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        FMLCommonHandler.instance().bus().register(this);
        MinecraftForge.EVENT_BUS.register(this);
        FMLCommonHandler.instance().bus().register(new ConfigHandler());

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
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    }

    @SubscribeEvent
    public void checkUpdate(PlayerEvent.PlayerLoggedInEvent event) {
        if (Reference.OUTDATED) {
            event.player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.AQUA + "RandomJunk " +  EnumChatFormatting.WHITE + "is " + EnumChatFormatting.DARK_RED + "outdated!"));
            event.player.addChatComponentMessage(new ChatComponentText("Current Version: " + EnumChatFormatting.DARK_RED + Reference.CURRENTVERSION + EnumChatFormatting.WHITE +  " Newest Version: " + EnumChatFormatting.DARK_GREEN + Reference.NEWVERSION));
        }
    }
}
