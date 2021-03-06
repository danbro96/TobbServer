package mrLarssonJr.abilities.modules;

import mrLarssonJr.abilities.Abilities;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class MoveFasterInLiquid implements Listener {
	
	private Abilities plugin;
	
	public MoveFasterInLiquid(Abilities plugin) {
		this.plugin = plugin;
		this.register(plugin);
	}
	
	public void register(Abilities plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerMoveEvent(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		int toID = event.getTo().getBlock().getTypeId();
		
		if(player.hasPermission("abilities.trait.waterSwimmer")) {
			if(toID == 8 || toID == 9) {
				if(!player.isSneaking()) {
					
					Vector prevVel = player.getVelocity();
					prevVel.multiply(2);
					player.setVelocity(player.getLocation().getDirection());
					}
				else {
					Location newLocation = event.getFrom();
					newLocation.setPitch(event.getTo().getPitch());
					newLocation.setYaw(event.getTo().getYaw());
					event.setTo(event.getFrom());
				}
			}
			
		}
		else if(player.hasPermission("abilities.trait.lavaSwimmer")) {
			if(toID == 10 || toID == 11) {
				if(!player.isSneaking()) {
					
					Vector prevVel = player.getVelocity();
					prevVel.multiply(2);
					player.setVelocity(player.getLocation().getDirection());
					}
				else {
					Location newLocation = event.getFrom();
					newLocation.setPitch(event.getTo().getPitch());
					newLocation.setYaw(event.getTo().getYaw());
					event.setTo(event.getFrom());
				}
			}
			
		}
	}
}
