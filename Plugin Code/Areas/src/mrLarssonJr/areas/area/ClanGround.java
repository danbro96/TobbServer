package mrLarssonJr.areas.area;

import java.util.HashMap;

import mrLarssonJr.areas.Areas;
import mrLarssonJr.areas.utility.SerializableKoordinat;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class ClanGround extends SerializableArea {
	
	private Clans belongsTo;

	public ClanGround(String namn, SerializableKoordinat hörn1, SerializableKoordinat hörn2, Areas plugin, Clans clan) throws IllegalArgumentException {
		super(namn, hörn1, hörn2, plugin);
		belongsTo = clan;
	}
	
	@Override
	public HashMap<String, Object> getAreaHashMap() {
		HashMap<String, Object> toReturn = super.getAreaHashMap();
		toReturn.put("Type", AreaType.CLAN_GROUND.name());
		toReturn.put("Clan", belongsTo.name());
		return toReturn;
	}
	
	@EventHandler
	public void onPlayerDamage(EntityDamageByEntityEvent event) {
		SerializableKoordinat attackedSpot = new SerializableKoordinat(event.getEntity().getLocation().getBlockX(), event.getEntity().getLocation().getBlockZ());
		
		if(this.isInside(attackedSpot)) {
			if(event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
				event.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		SerializableKoordinat placedSpot = new SerializableKoordinat(event.getBlockPlaced().getX(), event.getBlockPlaced().getZ());
		
		if(this.isInside(placedSpot)) {
			String clanPermissionTag;
			switch(belongsTo) {
				case CREEPER:
					clanPermissionTag = "Creeper";
					break;
				case END:
					clanPermissionTag = "End";
					break;
				case BORDER:
					clanPermissionTag = "Nether";
					break;
				case MANKIND:
					clanPermissionTag = "Mankind";
					break;
				default:
					clanPermissionTag = "Creeper";
					break;
			}
			if(!event.getPlayer().hasPermission("areas.clans." + clanPermissionTag)) {
				event.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onBlockBreakEvent(BlockBreakEvent event) {
		SerializableKoordinat placedSpot = new SerializableKoordinat(event.getBlock().getX(), event.getBlock().getZ());
		
		if(this.isInside(placedSpot)) {
			String clanPermissionTag;
			switch(belongsTo) {
				case CREEPER:
					clanPermissionTag = "Creeper";
					break;
				case END:
					clanPermissionTag = "End";
					break;
				case BORDER:
					clanPermissionTag = "Nether";
					break;
				case MANKIND:
					clanPermissionTag = "Mankind";
					break;
				default:
					clanPermissionTag = "Creeper";
					break;
			}
			if(!event.getPlayer().hasPermission("areas.clans." + clanPermissionTag)) {
				event.setCancelled(true);
			}
		}
	}

}
