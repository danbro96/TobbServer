package mrLarssonJr.areas.area;
import java.util.HashMap;

import mrLarssonJr.areas.Areas;
import mrLarssonJr.areas.utility.SerializableKoordinat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;



public class Battlefield extends SerializableArea {

	public Battlefield(String namn, SerializableKoordinat hörn1, SerializableKoordinat hörn2, Areas plugin) throws IllegalArgumentException {
		super(namn, hörn1, hörn2, plugin);
	}
	
	@Override
	public HashMap<String, Object> getAreaHashMap() {
		HashMap<String, Object> toReturn = super.getAreaHashMap();
		toReturn.put("Type", AreaType.BATTLEFIELD.name());
		return toReturn;
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		int toX = event.getBlock().getX();
		int toZ = event.getBlock().getZ();
		
		if(this.isInside(new SerializableKoordinat(toX, toZ))) {
			if(!event.getPlayer().isOp()) {
				event.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		int toX = event.getBlock().getX();
		int toZ = event.getBlock().getZ();
		
		if(this.isInside(new SerializableKoordinat(toX, toZ))) {
			if(!event.getPlayer().isOp()) {
				event.setCancelled(true);
			}
		}
	}

}
