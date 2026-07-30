package net.morgana.sit.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.entity.mob.SlimeEntity.class)
public abstract class SlimeEntityMixin extends LivingEntity {
    public SlimeEntityMixin(World world) {
        super(world);
    }

    @Shadow public abstract int getSize();

    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    void tick(CallbackInfo ci)
    {
        if (this.getSize() <= 0)
        {
            this.height = 1;
            this.width = 1;
            ci.cancel();
        }
    }

}
