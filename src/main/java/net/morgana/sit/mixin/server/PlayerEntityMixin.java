package net.morgana.sit.mixin.server;

import net.minecraft.entity.player.PlayerEntity;
import net.morgana.sit.SitMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(net.minecraft.entity.player.PlayerEntity.class)
public class PlayerEntityMixin {

    /*
    @Inject(method = "isInsideWall", at=@At("RETURN"), cancellable = true)
    void isInsideWall(CallbackInfoReturnable<Boolean> cir)
    {
        if (SitMod.seated((PlayerEntity)(Object)this)) {
            cir.setReturnValue( cir.getReturnValue() && !SitMod.seated((PlayerEntity)(Object)this));
        }
    }*/
}
