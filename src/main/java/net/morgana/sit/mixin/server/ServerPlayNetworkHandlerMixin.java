package net.morgana.sit.mixin.server;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInputC2SPacket;
import net.morgana.sit.SitMod;
import net.morgana.sit.command.server.SitCmd;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.server.network.ServerPlayNetworkHandler.class)
public class ServerPlayNetworkHandlerMixin {

    @Shadow
    ServerPlayerEntity player;

    @Inject(at = @At("HEAD"), method="handleCommand", cancellable = true)
    void handleCommand(String cmd, CallbackInfo ci)
    {
        if (SitMod.CustomCommandSystem)
            return;

        if (!cmd.toLowerCase().startsWith("/sit"))
            return;

        SitCmd.SitCommand(this.player);

        ci.cancel();
    }

    @Inject(at = @At("HEAD"), method = "handleClientCommand")
    void handleAction(ClientCommandC2SPacket action, CallbackInfo ci)
    {
        if (action.mode == 1) // Sneaking
            SitMod.unMountSeat(this.player);
    }
}
