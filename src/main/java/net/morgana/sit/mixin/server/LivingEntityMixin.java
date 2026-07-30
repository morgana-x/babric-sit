package net.morgana.sit.mixin.server;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.morgana.sit.SitMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(net.minecraft.entity.LivingEntity.class)
public abstract class LivingEntityMixin extends Entity  {

    @Shadow public int health;

    public LivingEntityMixin(World world) {
        super(world);
    }

    @Inject(method = "damage", at = @At("TAIL"))
    void onKilledBy(Entity amount, int par2, CallbackInfoReturnable<Boolean> cir)
    {
        if (this.health > 0)
            return;

        if (this.passenger != null) {
            if (this.passenger instanceof PlayerEntity pas)
                SitMod.unMountSeat(pas);
            this.passenger.setVehicle(null);
        }

        if (this.vehicle != null) {
            if ( (LivingEntity)(Object)this instanceof PlayerEntity rid)
                SitMod.unMountSeat(rid);

            this.setVehicle(null);
        }

    }

}
