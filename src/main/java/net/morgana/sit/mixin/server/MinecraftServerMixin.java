package net.morgana.sit.mixin.server;

import net.morgana.sit.SitMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.server.MinecraftServer.class)
public class MinecraftServerMixin {

    @Inject(method="shutdown", at=@At("HEAD"))
    void shutdown(CallbackInfo ci)
    {
        SitMod.Cleanup();
    }

}

