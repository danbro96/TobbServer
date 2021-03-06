package mrLarssonJr.abilities.modules;

import mrLarssonJr.abilities.Abilities;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;

public class InventoryControl implements Listener {
	
	private Abilities plugin;
	
	public InventoryControl(Abilities plugin) {
		this.plugin = plugin;
		this.register(plugin);
	}
	
	public void register(Abilities plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onInventoryOpenEvent(InventoryOpenEvent event) {
		InventoryType type = event.getInventory().getType();
		if(type == InventoryType.ANVIL || type == InventoryType.ENCHANTING) {
			if(!event.getPlayer().hasPermission("areas.trade.Enchanter")) {
				event.setCancelled(true);
			}
		}
	}

}
