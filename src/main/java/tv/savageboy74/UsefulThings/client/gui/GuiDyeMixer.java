package tv.savageboy74.usefulthings.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;
import tv.savageboy74.usefulthings.common.container.ContainerDyeMixer;
import tv.savageboy74.usefulthings.common.util.Reference;

public class GuiDyeMixer extends GuiContainer
{
    private ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":" + "textures/gui/guiDyeMixer.png");

    public GuiDyeMixer(InventoryPlayer invPlayer, World world, int x, int y, int z) {
        super(new ContainerDyeMixer(invPlayer, world, x, y, z));

        this.xSize = 176;
        this.ySize = 166;

    }

    public void onGuiClosed() {
        super.onGuiClosed();
    }



    protected void drawGuiContainerForegroundLayer(int i, int j) {
        String name = "Dye Mixer";

        this.fontRendererObj.drawString(name, this.xSize * 1/3 - this.fontRendererObj.getStringWidth(name) / 100, 5, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 95 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {

        GL11.glColor4f(1F, 1F, 1F, 1F);

        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);

        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

    }
}
