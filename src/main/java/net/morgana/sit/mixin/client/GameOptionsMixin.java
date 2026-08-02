package net.morgana.sit.mixin.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import net.morgana.sit.SitMod;
import net.morgana.sit.keybind.Keybinds;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mixin(GameOptions.class)
public class GameOptionsMixin {

    @Shadow public KeyBinding[] allKeys;

    @Inject(method = "<init>()V", at=@At("TAIL"))
    void init(CallbackInfo ci)
    {
        addKeybind();
    }

    @Inject(method = "<init>(Lnet/minecraft/client/Minecraft;Ljava/io/File;)V", at=@At("TAIL"))
    void init(Minecraft mc, File f, CallbackInfo ci)
    {
        addKeybind();
    }

    void addKeybind()
    {
        List<KeyBinding> keys = new ArrayList<>(Arrays.stream(this.allKeys).toList());

        keys.add(Keybinds.SitKeybind);

        this.allKeys = keys.toArray(new KeyBinding[0]);
    }

}
