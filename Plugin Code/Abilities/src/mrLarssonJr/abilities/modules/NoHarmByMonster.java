package mrLarssonJr.abilities.modules;

import mrLarssonJr.abilities.Abilities;

import org.bukkit.entity.Blaze;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Giant;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wither;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class NoHarmByMonster implements Listener {
	
	private Abilities plugin;
	
	public NoHarmByMonster(Abilities plugin) {
		this.plugin = plugin;
		this.register(plugin);
	}
	
	public void register(Abilities plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.getEntity() instanceof Player) {
			Entity attacker;
			Player defender = (Player) event.getEntity();
			if(event.getDamager() instanceof Projectile) {
				attacker = ((Projectile) event.getDamager()).getShooter();
			}
			else {
				attacker = event.getDamager();
			}
			
			if(attacker instanceof Zombie && defender.hasPermission("abilities.noHarm.Zombie")) {
				event.setCancelled(true);
			}
			else if(attacker instanceof Creeper && defender.hasPermission("abilities.noHarm.Creeper")) {
				event.setCancelled(true);
			}
			else if(attacker instanceof Skeleton && defender.hasPermission("abilities.noHarm.Skeleton")) {
				event.setCancelled(true);
			}
			else if(attacker instanceof Blaze && defender.hasPermission("abilities.noHarm.Blaze")) {
				event.setCancelled(true);
			}
			else if(attacker instanceof CaveSpider && defender.hasPermission("abilities.noHarm.CaveSpider")) {
				event.setCancelled(true);
			}
			else if(attacker instanceof EnderDragon && defender.hasPermission("abilities.noHarm.EnderDragon")) {
				event.setCancelled(true);
			}
			else if(attacker instanceof Enderman && defender.hasPermission("abilities.noHarm.Enderman")) {
				event.setCancelled(true);
			}
			else if(attacker instanceof Ghast && defender.hasPermission("abilities.noHarm.Ghast")) {
				event.setCancelled(true);
			}
			else if(attacker instanceof Giant && defender.hasPermission("abilities.noHarm.Giant")) {
				event.setCancelled(true);
			}
			else if(attacker instanceof MagmaCube && defender.hasPermission("abilities.noHarm.MagmaCube")) {
				event.setCancelled(true);
			}
			else if(attacker instanceof PigZombie && defender.hasPermission("abilities.noHarm.PigZombie")) {
				event.setCancelled(true);
			}
			else if(attacker instanceof Silverfish && defender.hasPermission("abilities.noHarm.Silverfish")) {
				event.setCancelled(true);
			}
			else if(attacker instanceof Slime && defender.hasPermission("abilities.noHarm.Slime")) {
				event.setCancelled(true);
			}
			else if(attacker instanceof Spider && defender.hasPermission("abilities.noHarm.Spider")) {
				event.setCancelled(true);
			}
			else if(attacker instanceof Witch && defender.hasPermission("abilities.noHarm.Witch")) {
				event.setCancelled(true);
			}
			else if(attacker instanceof Wither && defender.hasPermission("abilities.noHarm.Wither")) {
				event.setCancelled(true);
			}
		}
	}
	

}
