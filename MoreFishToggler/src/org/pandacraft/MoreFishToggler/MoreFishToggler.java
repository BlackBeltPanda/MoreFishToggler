package org.pandacraft.MoreFishToggler;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.pandacraft.MoreFishToggler.Listeners.FishListener;
import org.pandacraft.MoreFishToggler.Listeners.JoinListener;
import org.pandacraft.MoreFishToggler.Utils.SimpleConfig;
import org.pandacraft.MoreFishToggler.Utils.SimpleConfigManager;

public class MoreFishToggler extends JavaPlugin {
	
	public static MoreFishToggler plugin;
	private static SimpleConfigManager manager;
	private static SimpleConfig playerData;
	private static Set<String> players = new HashSet<String>();
	
	@Override
	public void onEnable() {
		plugin = this;
		
		//Register events
		registerEvents(new FishListener(), new JoinListener());
		
		//Register command
		getCommand("mftoggle").setExecutor(new ToggleCommand());
		
		// Load config files
		createFiles();
	}
	
	@Override
	public void onDisable() {
		playerData.saveConfig();
		
		//Cleanup public static instances
		plugin = null;
	}
	
	public static MoreFishToggler getInstance() {
		return plugin;
	}
	
	public Set<String> getPlayers() {
		return players;
	}
	
	public SimpleConfig getPlayerData() {
		return playerData;
	}
	
	private void createFiles() {
		manager = new SimpleConfigManager(this);
		playerData = manager.getNewConfig("playerData.yml");
	}
	
	public void registerEvents(Listener... listeners) {
		for (Listener listener : listeners) {
			getServer().getPluginManager().registerEvents(listener, this);
		}
	}

}
