package mrLarssonJr.abilities.modules;

import mrLarssonJr.abilities.Abilities;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.LargeFireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.SmallFireball;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.util.Vector;

public class ReplaceArrow implements Listener {
	
	private Abilities plugin;
	
	public ReplaceArrow(Abilities plugin) {
		this.plugin = plugin;
		this.register(plugin);
	}
	
	public void register(Abilities plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onProjectileLaunchEvent(ProjectileLaunchEvent event) {
		if(event.getEntity().getShooter() instanceof Player && event.getEntity() instanceof Arrow) {
			Player shooter = (Player) event.getEntity().getShooter();
			Projectile projectile = event.getEntity();
			
			if(shooter.hasPermission("abilities.trait.shootEnderpearl")) {
				
				Vector velocity = projectile.getVelocity();
				Location location = projectile.getLocation();
				World world = projectile.getWorld();
				projectile.remove();
				
				projectile = shooter.launchProjectile(EnderPearl.class);
				projectile.setVelocity(velocity);
			}
			else if(shooter.hasPermission("abilities.trait.shootFireball")) {
				Vector velocity = projectile.getVelocity();
				Location location = projectile.getLocation();
				World world = projectile.getWorld();
				projectile.remove();
				
				if(velocity.length() >= 2.9) {
					projectile = shooter.launchProjectile(LargeFireball.class);
				}
				else {
					projectile = shooter.launchProjectile(SmallFireball.class);
				}
				
				projectile.setVelocity(velocity);
			}
			else if(shooter.hasPermission("abilities.trait.shootWitherSkull")) {
				Vector velocity = projectile.getVelocity();
				Location location = projectile.getLocation();
				World world = projectile.getWorld();
				projectile.remove();
				
				projectile = shooter.launchProjectile(WitherSkull.class);
				projectile.setVelocity(velocity);
			}
		}
	}

}
