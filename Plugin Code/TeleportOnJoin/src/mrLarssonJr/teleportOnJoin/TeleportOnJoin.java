package mrLarssonJr.teleportOnJoin;

import mrLarssonJr.teleportOnJoin.utillty.Commands;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class TeleportOnJoin extends JavaPlugin implements Listener {
	
	private Commands cmd;	//Commands variable
	
	public void onEnable() {	//Initiates the plugin when the plugin is enabled
		this.saveDefaultConfig();	//If there is no config the default gets saved
		
		cmd = new Commands(this);	//Declare the commands variable to a new commandes instance
		
		this.getServer().getPluginManager().registerEvents(this, this);	//Register class as listener
		this.getLogger().info("Plugin: " + this.getDescription().getName() + " version: " + this.getDescription().getVersion() + " has been enabled.");	//Log messages that the plugin has been enabled
	}
	
	public void onDisable() {	//Handles the shutdown of the plugin when the plugin is disabled
		this.getLogger().info("Pluing: " + this.getDescription().getName() + " version: " + this.getDescription().getVersion() + " has been disabled.	");	//Log messages that the plugin has been dsabled
	}
	
	private Location getUpdatedToSpot() {
		this.reloadConfig();	//Reload the config file so the one in memory is up to date
		Location updatedLocation = new Location(this.getServer().getWorld(this.getConfig().getString("worldId")), this.getConfig().getInt("X"), this.getConfig().getInt("Y"), this.getConfig().getInt("Z"));	//create a new up to date location from the config file values
		this.getLogger().info(updatedLocation.toString());
		return updatedLocation;	//return a new location
	}
	
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event) {
		Player player = event.getPlayer();	//Extract the player assoicated with the event for convenience
		
		if(player.hasPermission("teleportOnJoin.teleport")) {	//Controls if the player has said permission
			player.teleport(this.getUpdatedToSpot());	//Teleports player to the location provided by the getUpdateToSpot method
		}
	}

}
