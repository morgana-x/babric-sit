package net.morgana.sit.mixin.client;

import net.minecraft.entity.player.PlayerEntity;
import net.morgana.sit.SitMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.client.input.KeyboardInput.class)
public class KeyboardInputMixin extends net.minecraft.client.input.Input{

    @Inject(method="update", at=@At("TAIL"))
    void update(PlayerEntity p, CallbackInfo ci)
    {
        if (this.sneaking)
            SitMod.unMountSeat(p);
    }

}
