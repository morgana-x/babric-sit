package net.morgana.sit.fabric;

import com.matthewperiut.retrocommands.util.RetroChatUtil;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.morgana.sit.SitMod;
import net.morgana.sit.command.server.SitCmdRetro;

public class SitFabricMod implements ModInitializer {
    @Override
    public void onInitialize() {

        boolean retroCommands = FabricLoader.getInstance().isModLoaded("retrocommands");

        SitMod.Init(FabricLoader.getInstance().getEnvironmentType() == EnvType.SERVER, retroCommands);

        if (retroCommands)
            RetroChatUtil.commands.add(new SitCmdRetro());
    }
}
