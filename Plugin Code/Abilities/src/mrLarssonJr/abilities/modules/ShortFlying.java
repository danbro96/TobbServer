package mrLarssonJr.abilities.modules;

import mrLarssonJr.abilities.Abilities;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;

public class ShortFlying implements Listener {
	
	private Abilities plugin;
	
	public ShortFlying(Abilities plugin) {
		this.plugin = plugin;
		this.register(plugin);
	}
	
	public void register(Abilities plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event) {	//Called when player tries to login
		if(event.getPlayer().hasPermission("abilities.trait.shortFly")) {	//Checks if the player has permission for flying
			event.getPlayer().setAllowFlight(true);	//Allow the player to fly
			event.getPlayer().setMetadata("flyAllowed", new FixedMetadataValue(plugin, true));	//Stores metadata in the player saying if the player can fly or not
		}
	}
	
	@EventHandler
	public void onPlayerToggleFlightEvent(PlayerToggleFlightEvent event) {	//Called when player is trying to fly
		if(event.isFlying()) {	//Because we don't want to affect if the player tries to end flight we check for what state the player tries to toggle to
			if(event.getPlayer().getMetadata("flyAllowed").get(0).asBoolean()) {	//if player is allowed to fly
				event.getPlayer().setMetadata("flyAllowed", new FixedMetadataValue(plugin, false));	//Stores metadata in the player saying if the player can fly or not
				final Player player = event.getPlayer();	//For the anonymous class
				plugin.getServer().getScheduler().runTaskLater(plugin, new BukkitRunnable() {

					@Override
					public void run() {
						player.setFlying(false);
					}
					
				}, 20);
			}
			else {
				event.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onPlayerMoveEvent(PlayerMoveEvent event) {	//Search for when player touch ground
		if(event.getPlayer().hasPermission("abilities.trait.shortFly")) {	//Checks if the player has permission for flying
			Entity entityPlayer = (Entity) event.getPlayer();	//Converts the player to an local entity for use of isOnGround()
			if(entityPlayer.isOnGround()) {	//Checks if player is on ground
				event.getPlayer().setMetadata("flyAllowed", new FixedMetadataValue(plugin, true));	//Stores metadata in the player saying if the player can fly or not
			}
		}
	}

}
