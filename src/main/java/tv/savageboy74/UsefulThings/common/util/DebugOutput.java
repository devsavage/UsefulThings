package tv.savageboy74.usefulthings.common.util;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class DebugOutput
{
    @SubscribeEvent
    public void damageVsEntity(LivingHurtEvent event, EntityLivingBase entityLivingBase, DamageSource damageSource, float f, EntityCow entityCow)
    {
        System.out.println("Damage Dealt" + event.ammount);
        System.out.println("Amount" + event.source);
        System.out.println(event.getResult());
        System.out.println(event.entityLiving.getHealth());
        System.out.println(entityLivingBase.getHealth());
        System.out.println(entityCow.getHealth());
        System.out.println(entityCow.getEntityId());
        ForgeHooks.onLivingHurt(entityLivingBase, damageSource, f);
    }

}
