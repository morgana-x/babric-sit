package net.morgana.sit.command.server;
import net.minecraft.entity.player.PlayerEntity;
import net.morgana.sit.SitMod;

public class SitCmd {
    public static void SitCommand(PlayerEntity p)
    {
        SitMod.toggleSit(p);
    }
}
