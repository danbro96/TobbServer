package mrLarssonJr.abilities.modules;

import java.util.ArrayList;

import mrLarssonJr.abilities.Abilities;
import mrLarssonJr.abilities.utility.DamagePlayersTask;

import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class DamageWhileInStorm implements Listener {
	private Abilities plugin;
	private DamagePlayersTask task;
	
	public DamageWhileInStorm(Abilities plugin) {
		this.plugin = plugin;
		this.register(plugin);
		
		if(plugin.getServer().getWorld("world").hasStorm()) {
			task = new DamagePlayersTask();
			task.runTaskTimer(plugin, 100, 25);
		}
	}
	
	public void register(Abilities plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onWeatherChangeEvent(WeatherChangeEvent event) {
		if(event.toWeatherState()) {
			task = new DamagePlayersTask();
			task.runTaskTimer(plugin, 100, 25);
			
			ArrayList<Player> playersInWorld = (ArrayList<Player>) event.getWorld().getPlayers();
			Player[] onlinePlayers = plugin.getServer().getOnlinePlayers();
			ArrayList<Player> validForCheckPlayers = new ArrayList<Player>();
			
			for(Player player : onlinePlayers) {
				if(playersInWorld.contains(player)) {
					validForCheckPlayers.add(player);
				}
			}
			
			for(Player player : validForCheckPlayers) {
				if(player.hasPermission("abilities.trait.harmOfStorm")) {
					if(event.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation().getBlockZ()) != Biome.DESERT) {
						task.addPlayer(player);
					}
				}
			}
		}
		else {
			task.cancel();
		}
		
	}
	
	@EventHandler
	public void onPlayerMoveEvent(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		
		if(event.getTo().getWorld().hasStorm()) {
			if(player.hasPermission("abilities.trait.harmOfStorm")) {
				if(plugin.getServer().getWorld("world").getBiome(player.getLocation().getBlockX(), player.getLocation().getBlockZ()) != Biome.DESERT) {
					task.addPlayer(player);
				}
			}
		}
		
	}

}
