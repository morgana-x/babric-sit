package net.morgana.sit.mixin.client;

import net.minecraft.client.resource.language.TranslationStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;
import java.util.Properties;

@Mixin(net.minecraft.client.resource.language.TranslationStorage.class)
public class TranslationStorageMixin {
    @Shadow private Properties translations;

    @Inject(method ="<init>", at=@At("TAIL"))
    private void constructor(CallbackInfo ci)
    {
        try
        {
            translations.load(TranslationStorage.class.getResourceAsStream("/assets/sit/lang/en_US.lang"));
        }
        catch (IOException e)
        {
            System.err.println("error loading translations for sit " + e);
        }
    }
}
