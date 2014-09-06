package tv.savageboy74.usefulthings.common.util;

public class Reference
{
    public static final String MOD_ID = "usefulthings";
    public static final String MOD_NAME = "UsefulThings";
    public static final String VERSION = "1.7.10-0.0.3";
    public static final String MC_VERSION = "1.7.10";

    public static final String CLIENT_PROXY = "tv.savageboy74.usefulthings.common.proxy.ClientProxy";
    public static final String SERVER_PROXY = "tv.savageboy74.usefulthings.common.proxy.ServerProxy";

    public static final String GUI_FACTORY_CLASS = "tv.savageboy74.usefulthings.client.gui.GuiFactory";

    public static final String DEPENDENCIES = "required-after:SavageCore@[" + Reference.MC_VERSION +"-0.1,)";

    public static final int UPDATE_NUMBER = 1;
    public static String UPDATES = "";
    public static boolean OUTDATED = false;

    public static String CURRENTVERSION = VERSION;
    public static String NEWVERSION = "";
}
