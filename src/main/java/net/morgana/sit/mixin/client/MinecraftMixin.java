package net.morgana.sit.mixin.client;

import net.minecraft.entity.player.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.ClientWorld;
import net.minecraft.world.World;
import net.morgana.sit.SitMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.client.Minecraft.class)
public class MinecraftMixin {
    @Shadow public ClientPlayerEntity player;

    @Shadow public World world;


    @Inject(method = "setWorld(Lnet/minecraft/world/World;Ljava/lang/String;Lnet/minecraft/entity/player/PlayerEntity;)V", at = @At("HEAD"))
    void setWorld(World world, String message, PlayerEntity player, CallbackInfo ci)
    {
        SitMod.Cleanup();
    }

}
