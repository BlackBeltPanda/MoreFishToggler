package org.pandacraft.MoreFishToggler;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.pandacraft.MoreFishToggler.Utils.SimpleConfig;

public class ToggleCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {

			String uuid = ((Player) sender).getUniqueId().toString();

			SimpleConfig playerData = MoreFishToggler.getInstance().getPlayerData();

			if (playerData.contains(uuid)) {
				playerData.removeKey(uuid);
			}
				
			playerData.createSection(uuid);;
			playerData.saveConfig();

			MoreFishToggler.getInstance().getPlayers().add(uuid);
		}
		return false;
	}

}
