package tv.savageboy74.usefulthings.client.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import tv.savageboy74.usefulthings.client.settings.KeyBindings;
import tv.savageboy74.usefulthings.common.util.Keys;
import tv.savageboy74.usefulthings.common.util.Strings;

public class KeyInputEventHandler
{
    private static Keys getPressedKeyBinding()
    {
        if (KeyBindings.placeholder.isPressed())
        {
            return Keys.PLACEHOLDER;
        }
        else if (KeyBindings.placeholder2.isPressed())
        {
            return Keys.PLACEHOLDER2;
        }

        return Keys.UNKNOWN;
    }

    @SubscribeEvent
    public void handleKeyInputEvent(InputEvent.KeyInputEvent event)
    {
    }
}
