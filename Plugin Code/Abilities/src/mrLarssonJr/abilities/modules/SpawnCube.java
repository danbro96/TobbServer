package mrLarssonJr.abilities.modules;

import mrLarssonJr.abilities.Abilities;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class SpawnCube implements Listener {
	
	private Abilities plugin;
	
	public SpawnCube(Abilities plugin) {
		this.plugin = plugin;
		this.register(plugin);
	}
	
	public void register(Abilities plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerInteractEvent(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		
		if(player.hasPermission("abilities.trait.spawnSlime")) {
			if(event.getItem() != null) {
				if(event.getItem().getTypeId() == 341) {
					if(event.hasBlock()) {
						Entity slime = player.getWorld().spawnEntity(event.getClickedBlock().getRelative(0, 1, 0).getLocation(), EntityType.SLIME);
						
						if(slime != null) {
							player.getInventory().removeItem(new ItemStack(341, 1));
						}
					}
				}
			}
		}
		else if(player.hasPermission("abilities.trait.spawnMagma")) {
			if(event.getItem() != null) {
				if(event.getItem().getTypeId() == 378) {
					if(event.hasBlock()) {
						Entity slime = player.getWorld().spawnEntity(event.getClickedBlock().getRelative(0, 1, 0).getLocation(), EntityType.MAGMA_CUBE);
						
						if(slime != null) {
							player.getInventory().removeItem(new ItemStack(378, 1));
						}
					}
				}
			}
		}
	}

}
