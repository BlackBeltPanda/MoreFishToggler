package org.pandacraft.MoreFishToggler.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.pandacraft.MoreFishToggler.MoreFishToggler;

import me.elsiff.morefish.event.PlayerCatchCustomFishEvent;

public class FishListener implements Listener {
	
	@EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
	public void onMoreFish(PlayerCatchCustomFishEvent event) {
		
		if (MoreFishToggler.getInstance().getPlayers().contains(event.getPlayer().getUniqueId().toString())) {
			event.setCancelled(true);
		}
	}

}
