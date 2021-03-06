package mrLarssonJr.areas;

import org.bukkit.plugin.java.JavaPlugin;

import mrLarssonJr.areas.utility.Commands;

public class Areas extends JavaPlugin {
	public static Areas plugin;
	
	private Map map;
	private Commands cmds;
	
	public Areas() {
	}
	
	public Map getMap() {
		return map;
	}
	
	@Override
	public void onEnable() {
		plugin = this;
		this.saveDefaultConfig();
		this.getConfig();
		map = new Map(this, "Map");
		this.getLogger().info("Loaded " + map.listAllAreas().size() + " areas!");
		cmds = new Commands(this);
		this.getLogger().info("Areas " + this.getDescription().getVersion() + " has been enabled.");
	}
	
	@Override
	public void onDisable() {
		map.save();
		this.saveConfig();
		this.getLogger().info("Areas " + this.getDescription().getVersion() + " has been disabled.");
	}

}
