package mrLarssonJr.abilities.utility;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class DamagePlayersTask extends BukkitRunnable {

	private ArrayList<Player> playersToDamage = new ArrayList<Player>();
	
	public DamagePlayersTask() {
	}
	
	public void addPlayer(Player player) {
		if(!playersToDamage.contains(player)) {
			playersToDamage.add(player);
		}
	}

	@Override
	public void run() {
		for(Player player : playersToDamage) {
			if(player.getLocation().getBlock().getLightFromSky() == 15) {
				player.damage(1.0);
			}
		}
	}

}
