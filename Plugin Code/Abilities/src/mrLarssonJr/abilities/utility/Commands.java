package mrLarssonJr.abilities.utility;

import java.io.Serializable;

import mrLarssonJr.abilities.Abilities;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor, Serializable {
	private Abilities plugin;

	public Commands(Abilities plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		if(sender.hasPermission("abilities.commands.*")) {
			/*if(cmd.getName().equalsIgnoreCase("createcity")) {
			if(this.createCity(sender, cmd, cmdLabel, args)) {
				plugin.getMap().saveMap();
				return true;
			}
		}
		else if(cmd.getName().equalsIgnoreCase("createbattlefield")) {
			if(this.createBattlefield(sender, cmd, cmdLabel, args)) {
				plugin.getMap().saveMap();
				return true;
			}
		}
		else if(cmd.getName().equalsIgnoreCase("removearea")) {
			if(this.removeArea(sender, cmd, cmdLabel, args)) {
				plugin.getMap().saveMap();
				return true;
			}
		}
		else if(cmd.getName().equalsIgnoreCase("listallareas")) {
			if(this.listAllAreas(sender, cmd, cmdLabel, args)) {
				return true;
			}
		}
		else if(cmd.getName().equalsIgnoreCase("createtradeground")) {
			if(this.createTradeGrounde(sender, cmd, cmdLabel, args)) {
				return true;
			}
		}*/
		}
		
		return false;
	}

}
