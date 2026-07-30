package net.morgana.sit.mixin.server;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.morgana.sit.SitMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.server.PlayerManager.class)
public class PlayerManagerMixin {
    @Inject(method="disconnect", at=@At("HEAD"))
    void disconnect(ServerPlayerEntity p, CallbackInfo ci)
    {
        SitMod.unMountSeat(p);
    }
}
