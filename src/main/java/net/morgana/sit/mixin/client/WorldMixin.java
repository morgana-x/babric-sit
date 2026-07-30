package net.morgana.sit.mixin.client;

import net.minecraft.entity.Entity;
import net.morgana.sit.SitMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.world.World.class)
public class WorldMixin {

    @Inject(method="remove", at=@At("HEAD"))
    void remove(Entity e, CallbackInfo ci)
    {
        SitMod.OnEntityRemoved(e);
    }

}
