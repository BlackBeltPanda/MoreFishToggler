package org.pandacraft.MoreFishToggler.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.pandacraft.MoreFishToggler.MoreFishToggler;

public class JoinListener implements Listener {
	
	@EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
	public void onMoreFishPlayerJoin(PlayerJoinEvent event) {
		
		String uuid = event.getPlayer().getUniqueId().toString();
		
		if (MoreFishToggler.getInstance().getPlayerData().contains(uuid)) {
			MoreFishToggler.getInstance().getPlayers().add(uuid);
		}
	}

}
