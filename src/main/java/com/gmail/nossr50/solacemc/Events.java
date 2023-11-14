package com.gmail.nossr50.solacemc;

import com.gmail.nossr50.datatypes.player.McMMOPlayer;
import com.gmail.nossr50.mcMMO;
import com.gmail.nossr50.util.player.UserManager;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataType;

/*
Jsinco
 */
public class Events implements Listener {

    private final mcMMO plugin;

    public Events(mcMMO plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!player.getPersistentDataContainer().has(new NamespacedKey(plugin, "disablexpbar"), PersistentDataType.BOOLEAN)) return;

        McMMOPlayer mmoPlayer = UserManager.getPlayer(player);

        assert mmoPlayer != null;
        mmoPlayer.getExperienceBarManager().disableAllBars();
    }
}
