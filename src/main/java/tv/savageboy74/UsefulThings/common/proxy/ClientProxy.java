package tv.savageboy74.usefulthings.common.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import tv.savageboy74.usefulthings.client.settings.KeyBindings;

public class ClientProxy extends CommonProxy
{

    @Override
    public void registerKeyBindings()
    {
        ClientRegistry.registerKeyBinding(KeyBindings.placeholder);
        ClientRegistry.registerKeyBinding(KeyBindings.placeholder2);
    }

    public void registerRenderThings()
    {

    }

    public void registerTileEntitySpecialRenderer()
    {

    }
}
