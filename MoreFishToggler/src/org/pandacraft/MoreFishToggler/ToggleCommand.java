package org.pandacraft.MoreFishToggler;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.pandacraft.MoreFishToggler.Utils.SimpleConfig;

import net.md_5.bungee.api.ChatColor;

public class ToggleCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			
			Player player = (Player) sender;

			String uuid = player.getUniqueId().toString();

			SimpleConfig playerData = MoreFishToggler.getInstance().getPlayerData();

			if (playerData.contains(uuid)) {
				playerData.removeKey(uuid);
				if (MoreFishToggler.getInstance().getPlayers().contains(uuid)) {
					MoreFishToggler.getInstance().getPlayers().remove(uuid);
				}
				player.sendMessage(ChatColor.AQUA + "[MFT]" + ChatColor.GOLD + " Toggled MoreFish" + ChatColor.GREEN + " On.");
				return true;
			}
				
			playerData.createSection(uuid);;
			playerData.saveConfig();

			MoreFishToggler.getInstance().getPlayers().add(uuid);
			
			player.sendMessage(ChatColor.AQUA + "[MFT]" + ChatColor.GOLD + " Toggled MoreFish" + ChatColor.RED + " Off.");
			return true;
		}
		return false;
	}

}
