package mrLarssonJr.abilities.utility;

import mrLarssonJr.abilities.Abilities;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class FireIfInSun extends BukkitRunnable {
	private Abilities plugin;
	
	public FireIfInSun(Abilities plugin) {
		this.plugin = plugin;
	}

	@Override
	public void run() {
		for(Player player : plugin.getServer().getOnlinePlayers()) {
			if((player.getWorld().getTime() > 23000 || player.getWorld().getTime() > 0) && (player.getWorld().getTime() < 13000)) {
				if(player.getLocation().getBlock().getLightFromSky() == 15 && player.hasPermission("abilities.trait.fireOfSun")) {
					player.setFireTicks(500);
				}
			}
		}
	}

}
