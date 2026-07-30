package net.morgana.sit.command.server;
import net.minecraft.entity.player.PlayerEntity;
import net.morgana.sit.SitMod;

public class SitCmd {
    public static void SitCommand(PlayerEntity p)
    {
        if (!SitMod.seated(p)) {
            if (!p.isAlive()) {
                p.sendMessage("§4Cannot sit while dead!");
                return;
            }

            if (!p.onGround) {
                p.sendMessage("§4Cannot sit in mid air!");
                return;
            }

            if (p.isSleeping()) {
                p.sendMessage("§4Cannot sit while sleeping!");
                return;
            }

            if (p.isInsideWall()) {
                p.sendMessage("§4Cannot sit while inside a wall!");
                return;
            }
        }

        SitMod.toggleSit(p);
    }
}
