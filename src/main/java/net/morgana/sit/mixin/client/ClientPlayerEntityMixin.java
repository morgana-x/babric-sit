package net.morgana.sit.mixin.client;

import com.matthewperiut.retrocommands.mixin.client.MinecraftMixinChatEnabler;
import net.minecraft.entity.player.ClientPlayerEntity;
import net.morgana.sit.SitMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerEntityMixin {
    @Shadow public abstract void sendChatMessage(String message);

    @Inject(method = "updateKey", at = @At("TAIL"))
    void updateKey(int key, boolean state, CallbackInfo callbackInfo)
    {
        if (SitMod.SitKeybind.code == key && state)
            sendChatMessage("/sit");
    }

}
