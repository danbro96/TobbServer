package mrLarssonJr.abilities.utility;

import mrLarssonJr.abilities.Abilities;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class NauseaIfInSun extends BukkitRunnable {
	private Abilities plugin;
	
	public NauseaIfInSun(Abilities plugin) {
		this.plugin = plugin;
	}

	@Override
	public void run() {
		for(Player player : plugin.getServer().getOnlinePlayers()) {
			if((player.getWorld().getTime() > 23000 || player.getWorld().getTime() > 0) && (player.getWorld().getTime() < 13000)) {
				if(player.getLocation().getBlock().getLightFromSky() == 15 && player.hasPermission("abilities.trait.NauseaOfSun")) {
					player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 500, 1));
				}
			}
		}
	}

}
