package mrLarssonJr.abilities.modules;

import java.util.HashMap;

import mrLarssonJr.abilities.Abilities;
import mrLarssonJr.abilities.utility.DamagePlayerIfInWaterTask;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class WaterDamage implements Listener {
	
	private Abilities plugin;
	
	private HashMap<String, DamagePlayerIfInWaterTask> tasks = new HashMap<String, DamagePlayerIfInWaterTask>();
	
	public WaterDamage(Abilities plugin) {
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
		
		if(player.hasPermission("abilities.trait.harmOfWater")) {
			if(to.getBlock().getTypeId() == 8 || to.getBlock().getTypeId() == 9) {
				if(!tasks.containsKey(player.getName())) {
					DamagePlayerIfInWaterTask task = new DamagePlayerIfInWaterTask(player, 1);
					tasks.put(player.getName(), task);
					task.runTaskTimer(plugin, 10, 10);
				}
			}
			else if(tasks.containsKey(player.getName())) {
				tasks.get(player.getName()).cancel();
				tasks.remove(player.getName());
			}
		}
	}
	
	@EventHandler
	public void onBlockFromToEvent(BlockFromToEvent event) {
		if(event.getBlock().getTypeId() == 8 || event.getBlock().getTypeId() == 9) {
			for(Player player : plugin.getServer().getOnlinePlayers()) {
				if(player.hasPermission("abilities.trait.harmOfWater") && !tasks.containsKey(player.getName())) {
					DamagePlayerIfInWaterTask task = new DamagePlayerIfInWaterTask(player, 1);
					tasks.put(player.getName(), task);
					task.runTaskTimer(plugin, 10, 10);
				}
			}
		}
	}
	
}
