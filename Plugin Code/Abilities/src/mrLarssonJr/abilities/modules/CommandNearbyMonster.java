package mrLarssonJr.abilities.modules;

import mrLarssonJr.abilities.Abilities;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class CommandNearbyMonster implements Listener {
	
	private Abilities plugin;
	
	public CommandNearbyMonster(Abilities plugin) {
		this.plugin = plugin;
		this.register(plugin);
	}
	
	public void register(Abilities plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		Entity damager = event.getDamager();
		
		if(damager instanceof Arrow) {
			Arrow damagingArrow = (Arrow) damager;
			
			if(damagingArrow.getShooter() instanceof Player) {
				
			}
		}
	}

}
