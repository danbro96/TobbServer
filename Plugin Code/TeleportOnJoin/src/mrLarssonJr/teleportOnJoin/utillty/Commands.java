package mrLarssonJr.teleportOnJoin.utillty;


import mrLarssonJr.teleportOnJoin.TeleportOnJoin;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
	private TeleportOnJoin plugin;	//Declare a variable for easy access to the plugin

	public Commands(TeleportOnJoin plugin) {	//Setup a new Commands instance
		this.plugin = plugin;	//Stores given plugin in the easy access variable
		
		plugin.getCommand("tpOnJoin_setTpLocation").setExecutor(this);	//Register set location command
		//plugin.getCommand("tpOnJoin_getTpLocation").setExecutor(this);	//Register get location command
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {	//The on command which gets executed when a player executes a command
		if(cmd.getName().equalsIgnoreCase("tpOinJoin_setTpLocation")) {	//Checks if the command is the set location command
			
		}
		/*else if(cmd.getName().equalsIgnoreCase("tpOnJoin_getTpLocation")) {	//Checks if the command is the get location command
			
		}*/
		return false;	//Command failed for some reason
	}
	
	private boolean setTpLocation(CommandSender sender, Command cmd, String cmdLabel, String[] args) {	//Method for setting location, moved here for keeping code neat and clean
		if(sender instanceof Player) {	//Control if the sender is a player
			plugin.getLogger().info("A player");	//Debug
			Location newToLocation = ((Player) sender).getLocation();	//Isolates the players location
			
			plugin.getConfig().set("worldId", newToLocation.getWorld().getName());	//Change the world node in the config to reflect the new location
			plugin.getConfig().set("X", newToLocation.getBlockX());	//Change the x node in the config to reflect the new location
			plugin.getConfig().set("Y", newToLocation.getBlockY());	//Change the y node in the config to reflect the new location
			plugin.getConfig().set("Z", newToLocation.getBlockZ());	//Change the z node in the config to reflect the new location
			
			plugin.saveConfig();	//Save config to disk
			
			return true;	//Command was a success
		}
		else {	//Command failed because of sender not being a player
			sender.sendMessage("You're not a player. Therfore you can't execute this command!");	//Send a message explaining why you failed
		}
		return false;	//Command failed
	}

}
