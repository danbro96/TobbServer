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
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wither;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;

public class NoTargetByMonster implements Listener {
	
	private Abilities plugin;
	
	public NoTargetByMonster(Abilities plugin) {
		this.plugin = plugin;
		this.register(plugin);
	}
	
	public void register(Abilities plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onEntityTargetLivingEntityEvent(EntityTargetLivingEntityEvent event) {
		if(event.getTarget() instanceof Player) {
			Entity targeter = event.getEntity();
			Player target = (Player) event.getTarget();
			
			int itemIdThatMakesMonsterTarget = 261; //BOW
			
			if(target.getItemInHand().getTypeId() != itemIdThatMakesMonsterTarget) {
				if(targeter instanceof Zombie && target.hasPermission("abilities.noTarget.Zombie")) {
					event.setCancelled(true);
				}
				else if(targeter instanceof Creeper && target.hasPermission("abilities.noTarget.Creeper")) {
					event.setCancelled(true);
				}
				else if(targeter instanceof Skeleton && target.hasPermission("abilities.noTarget.Skeleton")) {
					event.setCancelled(true);
				}
				else if(targeter instanceof Blaze && target.hasPermission("abilities.noTarget.Blaze")) {
					event.setCancelled(true);
				}
				else if(targeter instanceof CaveSpider && target.hasPermission("abilities.noTarget.CaveSpider")) {
					event.setCancelled(true);
				}
				else if(targeter instanceof EnderDragon && target.hasPermission("abilities.noTarget.EnderDragon")) {
					event.setCancelled(true);
				}
				else if(targeter instanceof Enderman && target.hasPermission("abilities.noTarget.Enderman")) {
					event.setCancelled(true);
				}
				else if(targeter instanceof Ghast && target.hasPermission("abilities.noTarget.Ghast")) {
					event.setCancelled(true);
				}
				else if(targeter instanceof Giant && target.hasPermission("abilities.noTarget.Giant")) {
					event.setCancelled(true);
				}
				else if(targeter instanceof MagmaCube && target.hasPermission("abilities.noTarget.MagmaCube")) {
					event.setCancelled(true);
				}
				else if(targeter instanceof PigZombie && target.hasPermission("abilities.noTarget.PigZombie")) {
					event.setCancelled(true);
				}
				else if(targeter instanceof Silverfish && target.hasPermission("abilities.noTarget.Silverfish")) {
					event.setCancelled(true);
				}
				else if(targeter instanceof Slime && target.hasPermission("abilities.noTarget.Slime")) {
					event.setCancelled(true);
				}
				else if(targeter instanceof Spider && target.hasPermission("abilities.noTarget.Spider")) {
					event.setCancelled(true);
				}
				else if(targeter instanceof Witch && target.hasPermission("abilities.noTarget.Witch")) {
					event.setCancelled(true);
				}
				else if(targeter instanceof Wither && target.hasPermission("abilities.noTarget.Wither")) {
					event.setCancelled(true);
				}
			}
			
		}
		
	}
}
