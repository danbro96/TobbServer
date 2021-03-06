package mrLarssonJr.areas.utility;

import java.util.ArrayList;

import mrLarssonJr.areas.Areas;
import mrLarssonJr.areas.area.Area;
import mrLarssonJr.areas.area.AreaType;
import mrLarssonJr.areas.area.Clans;
import mrLarssonJr.areas.area.SerializableArea;
import mrLarssonJr.areas.area.Trades;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor {
	private Areas plugin;

	public Commands(Areas plugin) {
		this.plugin = plugin;
		
		plugin.getCommand("createcity").setExecutor(this);
		plugin.getCommand("createbattlefield").setExecutor(this);
		plugin.getCommand("removearea").setExecutor(this);
		plugin.getCommand("listallareas").setExecutor(this);
		plugin.getCommand("createtradeground").setExecutor(this);
		plugin.getCommand("createclanground").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		if(sender.hasPermission("areas.commands.*")) {
			if(cmd.getName().equalsIgnoreCase("createcity")) {
				if(this.createCity(sender, cmd, cmdLabel, args)) {
					return true;
				}
			}
			else if(cmd.getName().equalsIgnoreCase("createbattlefield")) {
				if(this.createBattlefield(sender, cmd, cmdLabel, args)) {
					return true;
				}
			}
			else if(cmd.getName().equalsIgnoreCase("removearea")) {
				if(this.removeArea(sender, cmd, cmdLabel, args)) {
					return true;
				}
			}
			else if(cmd.getName().equalsIgnoreCase("listallareas")) {
				if(this.listAllAreas(sender, cmd, cmdLabel, args)) {
					return true;
				}
			}
			else if(cmd.getName().equalsIgnoreCase("createtradeground")) {
				if(this.createTradeGround(sender, cmd, cmdLabel, args)) {
					return true;
				}
			}
			else if(cmd.getName().equalsIgnoreCase("createclanground")) {
				if(this.createClanGround(sender, cmd, cmdLabel, args)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean createCity(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		if(args.length > 5) {
			sender.sendMessage("Too many arguments");
			return false;
		}
		else if(args.length < 5) {
			sender.sendMessage("Not enough arguments");
			return false;
		}
		
		int[] cord = new int[4];
		for(int i = 0; i < args.length-1; i++) {
			try {
				cord[i] = Integer.parseInt(args[i]);
			}
			catch(NumberFormatException e) {
				sender.sendMessage("\"" + args[i] + "\"" + " is not a number!");
				return false;
			}
			catch(NullPointerException e) {
				sender.sendMessage("\"" + args[i] + "\"" + " is not a number!");
				return false;
			}
		}
		
		try {
			plugin.getMap().createArea(AreaType.CITY, args[4], new SerializableKoordinat(cord[0], cord[1]), new SerializableKoordinat(cord[2], cord[3]), Trades.CRAFTSMEN, Clans.CREEPER);
		}
		catch(IllegalArgumentException e) {
			sender.sendMessage(e.getMessage());
			return false;
		}
		
		sender.sendMessage("City " + args[4] + " created!");
		return true;
	}
	
	private boolean createBattlefield(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		if(args.length > 5) {
			sender.sendMessage("Too many arguments");
			return false;
		}
		else if(args.length < 5) {
			sender.sendMessage("Not enough arguments");
			return false;
		}
		
		int[] cord = new int[4];
		for(int i = 0; i < args.length-1; i++) {
			try {
				cord[i] = Integer.parseInt(args[i]);
			}
			catch(NumberFormatException e) {
				sender.sendMessage("\"" + args[i] + "\"" + " is not a number!");
				return false;
			}
			catch(NullPointerException e) {
				sender.sendMessage("\"" + args[i] + "\"" + " is not a number!");
				return false;
			}
		}
		
		try {
			plugin.getMap().createArea(AreaType.BATTLEFIELD, args[4], new SerializableKoordinat(cord[0], cord[1]), new SerializableKoordinat(cord[2], cord[3]), Trades.CRAFTSMEN, Clans.CREEPER);
		}
		catch(IllegalArgumentException e) {
			sender.sendMessage(e.getMessage());
			return false;
		}
		
		sender.sendMessage("Battlefield " + args[4] + " created!");
		return true;
	}
	
	private boolean createTradeGround(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		if(args.length > 6) {
			sender.sendMessage("Too many arguments");
			return false;
		}
		else if(args.length < 6) {
			sender.sendMessage("Not enough arguments");
			return false;
		}
		
		int[] cord = new int[4];
		for(int i = 0; i < args.length-2; i++) {
			try {
				cord[i] = Integer.parseInt(args[i]);
			}
			catch(NumberFormatException e) {
				sender.sendMessage("\"" + args[i] + "\"" + " is not a number!");
				return false;
			}
			catch(NullPointerException e) {
				sender.sendMessage("\"" + args[i] + "\"" + " is not a number!");
				return false;
			}
		}
		
		Trades trade;
		int tradeID;
		try {
			tradeID = Integer.parseInt(args[5]);
		}
		catch(NumberFormatException e) {
			sender.sendMessage("\"" + args[5] + "\"" + " is not a number!");
			return false;
		}
		catch(NullPointerException e) {
			sender.sendMessage("\"" + args[5] + "\"" + " is not a number!");
			return false;
		}
		switch(tradeID) {
			case 0:
				trade = Trades.CRAFTSMEN;
				break;
			case 1:
				trade = Trades.MINER;
				break;
			case 2:
				trade = Trades.FARMER;
				break;
			case 3:
				trade = Trades.ENCHANTER;
				break;
			default:
				trade = Trades.CRAFTSMEN;
		}
		
		try {
			plugin.getMap().createArea(AreaType.TRADE_GROUND, args[4], new SerializableKoordinat(cord[0], cord[1]), new SerializableKoordinat(cord[2], cord[3]), trade, Clans.CREEPER);
		}
		catch(IllegalArgumentException e) {
			sender.sendMessage(e.getMessage());
			return false;
		}
		
		sender.sendMessage("TradeGround " + args[4] + " created!");
		return true;
	}
	
	private boolean createClanGround(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		if(args.length > 6) {
			sender.sendMessage("Too many arguments");
			return false;
		}
		else if(args.length < 6) {
			sender.sendMessage("Not enough arguments");
			return false;
		}
		
		int[] cord = new int[4];
		for(int i = 0; i < args.length-2; i++) {
			try {
				cord[i] = Integer.parseInt(args[i]);
			}
			catch(NumberFormatException e) {
				sender.sendMessage("\"" + args[i] + "\"" + " is not a number!");
				return false;
			}
			catch(NullPointerException e) {
				sender.sendMessage("\"" + args[i] + "\"" + " is not a number!");
				return false;
			}
		}
		
		Clans clan;
		int tradeID;
		try {
			tradeID = Integer.parseInt(args[5]);
		}
		catch(NumberFormatException e) {
			sender.sendMessage("\"" + args[5] + "\"" + " is not a number!");
			return false;
		}
		catch(NullPointerException e) {
			sender.sendMessage("\"" + args[5] + "\"" + " is not a number!");
			return false;
		}
		switch(tradeID) {
			case 0:
				clan = Clans.CREEPER;
				break;
			case 1:
				clan = Clans.END;
				break;
			case 2:
				clan = Clans.BORDER;
				break;
			case 3:
				clan = Clans.MANKIND;
				break;
			default:
				clan = Clans.CREEPER;
		}
		
		try {
			plugin.getMap().createArea(AreaType.CLAN_GROUND, args[4], new SerializableKoordinat(cord[0], cord[1]), new SerializableKoordinat(cord[2], cord[3]), Trades.CRAFTSMEN, clan);
		}
		catch(IllegalArgumentException e) {
			sender.sendMessage(e.getMessage());
			return false;
		}
		
		sender.sendMessage("ClanGround " + args[4] + " created!");
		return true;
	}
	
	private boolean removeArea(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		if(args.length > 1) {
			sender.sendMessage("Too many arguments");
			return false;
		}
		if(args.length < 1) {
			sender.sendMessage("Not enough arguments");
			return false;
		}
		try {
			plugin.getMap().removeArea(args[0]);
		}
		catch(IllegalArgumentException e) {
			sender.sendMessage(e.getMessage());
			return false;
		}
		
		sender.sendMessage("Removed area " + args[0] + "!");
		return true;
	}
	
	private boolean listAllAreas(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		if(args.length > 0) {
			sender.sendMessage("Too many arguments");
			return false;
		}
		else if(args.length < 0) {
			sender.sendMessage("Not enough arguments");
			return false;
		}
		
		ArrayList<SerializableArea> areas = plugin.getMap().listAllAreas();
		sender.sendMessage(ChatColor.GREEN + "Current areas is:");
		for(Area o : areas) {
			sender.sendMessage("    " + o);
		}
		return true;
		
	}

}
