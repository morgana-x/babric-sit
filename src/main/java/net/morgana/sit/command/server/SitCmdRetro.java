package net.morgana.sit.command.server;

import com.matthewperiut.retrocommands.api.Command;
import com.matthewperiut.retrocommands.util.SharedCommandSource;

public class SitCmdRetro implements Command {
    @Override
    public void command(SharedCommandSource sharedCommandSource, String[] strings) {
        SitCmd.SitCommand(sharedCommandSource.getPlayer());
    }

    @Override
    public String name() {
        return "sit";
    }

    @Override
    public void manual(SharedCommandSource commandSource) {
        commandSource.sendFeedback("Usage: /sit");
        commandSource.sendFeedback("Info: Toggles sitting down");
    }

    @Override
    public boolean disableInSingleplayer() {
        return false;
    }

    @Override
    public boolean needsPermissions() {
        return false;
    }
}
