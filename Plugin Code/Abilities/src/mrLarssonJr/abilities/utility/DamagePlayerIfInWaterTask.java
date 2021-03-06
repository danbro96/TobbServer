package mrLarssonJr.abilities.utility;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class DamagePlayerIfInWaterTask extends BukkitRunnable {
	
	private Player player;
	private int damageAmount;
	
	public DamagePlayerIfInWaterTask(Player player, int damageAmount) {
		this.player = player;
		this.damageAmount = damageAmount;
	}

	@Override
	public void run() {
		if(player.getLocation().getBlock().getTypeId() == 8 || player.getLocation().getBlock().getTypeId() == 9) {
			player.damage((double) damageAmount);
		}
		else {
			this.cancel();
		}
	}
}