package mrLarssonJr.abilities.modules;

import mrLarssonJr.abilities.Abilities;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PoisonOnWater implements Listener {

	private Abilities plugin;
	
	public PoisonOnWater(Abilities plugin) {
		this.plugin = plugin;
		this.register(plugin);
	}
	
	public void register(Abilities plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerMoveEvent(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		Location to = event.getTo();
		if(player.hasPermission("abilities.trait.poisonOfWater")) {
			if(to.getBlock().getTypeId() == 8 || to.getBlock().getTypeId() == 9) {
				plugin.getLogger().info("3");
				this.doPoison(player);
			}
		}
	}
	
	@EventHandler
	public void onBlockFromToEvent(BlockFromToEvent event) {
		if(event.getBlock().getTypeId() == 8 || event.getBlock().getTypeId() == 9) {
			for(Player player : plugin.getServer().getOnlinePlayers()) {
				if(player.hasPermission("abilities.trait.poisonOfWater")) {
					this.doPoison(player);
				}
			}
		}
	}
	
	private void doPoison(Player player) {
		player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 1000, 1));
	}

}
