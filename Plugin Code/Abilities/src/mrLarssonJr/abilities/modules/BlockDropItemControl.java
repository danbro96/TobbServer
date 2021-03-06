package mrLarssonJr.abilities.modules;

import mrLarssonJr.abilities.Abilities;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockDropItemControl implements Listener {
	
	private Abilities plugin;
	
	public BlockDropItemControl(Abilities plugin) {
		this.plugin = plugin;
		this.register(plugin);
	}
	
	public void register(Abilities plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onBlockBreakEvent(BlockBreakEvent event) {
		int[] blocksBreakableByMiners = {14, 15, 16, 21, 56, 81, 153, 73, 74},
			  blocksBreakableByFarmers = {59, 83, 86, 103, 104, 105, 115, 141, 142, 127, 39, 40, 99, 100},
			  blocksBreakableByEnchanters = {},
			  blocksBreakableByCraftsmen = {17};
		
		if(!event.getPlayer().hasPermission("areas.trade.Miner")) {
			for(int blockID : blocksBreakableByMiners) {
				if(blockID == event.getBlock().getTypeId()) {
					event.setCancelled(true);
					event.getBlock().setTypeId(0);
					return;
				}
				
			}
		}
		else if(!event.getPlayer().hasPermission("areas.trade.Farmer")) {
			for(int blockID : blocksBreakableByFarmers) {
				if(blockID == event.getBlock().getTypeId()) {
					event.setCancelled(true);
					event.getBlock().setTypeId(0);
					return;
				}
				
			}
		}
		if(!event.getPlayer().hasPermission("areas.trade.Enchanter")) {
			for(int blockID : blocksBreakableByEnchanters) {
				if(blockID == event.getBlock().getTypeId()) {
					event.setCancelled(true);
					event.getBlock().setTypeId(0);
					return;
				}
				
			}
		}
		if(!event.getPlayer().hasPermission("areas.trade.Craftsmen")) {
			for(int blockID : blocksBreakableByCraftsmen) {
				if(blockID == event.getBlock().getTypeId()) {
					event.setCancelled(true);
					event.getBlock().setTypeId(0);
					return;
				}
				
			}
		}
		
		
		
	}

}
