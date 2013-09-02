package mrLarssonJr.teleportOnJoin.utillty;


import mrLarssonJr.teleportOnJoin.TeleportOnJoin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor {
	private TeleportOnJoin plugin;	//Declare a variable for easy access to the plugin

	public Commands(TeleportOnJoin plugin) {	//Setup a new Commands instance
		this.plugin = plugin;	//Stores given plugin in the easy access variable
		
		plugin.getCommand("tpOnJoin_setTpLocation").setExecutor(this);	//Register set location command
		plugin.getCommand("tpOnJoin_getTpLocation").setExecutor(this);	//Register get location command
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {	//The on command which gets executed when a player executes a command
		if(cmd.getName().equalsIgnoreCase("tpOinJoin_setTpLocation")) {	//Checks if the command is the set location command
			
		}
		else if(cmd.getName().equalsIgnoreCase("tpOnJoin_getTpLocation")) {	//Checks if the command is the get location command
			
		}
		return false;	//Command failed for some reason
	}

}
