package mrLarssonJr.areas.area;

import java.util.HashMap;

import mrLarssonJr.areas.Areas;
import mrLarssonJr.areas.utility.SerializableKoordinat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class TradeGround extends SerializableArea {
	
	private Trades belongsTo;

	public TradeGround(String namn, SerializableKoordinat hörn1, SerializableKoordinat hörn2, Areas plugin, Trades trade) throws IllegalArgumentException {
		super(namn, hörn1, hörn2, plugin);
		belongsTo = trade;
	}
	
	@Override
	public HashMap<String, Object> getAreaHashMap() {
		HashMap<String, Object> toReturn = super.getAreaHashMap();
		toReturn.put("Type", AreaType.TRADE_GROUND.name());
		toReturn.put("Trade", belongsTo.name());
		return toReturn;
	}
	
	@EventHandler
	public void onPlayerTeleportEvent(PlayerTeleportEvent event) {
		int toX = event.getTo().getBlockX();
		int toZ = event.getTo().getBlockZ();
		
		if(this.isInside(new SerializableKoordinat(toX,toZ))) {
			switch(belongsTo) {
				case CRAFTSMEN:
					if(!event.getPlayer().hasPermission("areas.trade.Craftsmen")) {
						event.setTo(event.getFrom());
					}
					break;
				case MINER:
					if(!event.getPlayer().hasPermission("areas.trade.Miner")) {
						event.setTo(event.getFrom());
					}
					break;
				case FARMER:
					if(!event.getPlayer().hasPermission("areas.trade.Farmer")) {
						event.setTo(event.getFrom());
					}
					break;
				case ENCHANTER:
					if(!event.getPlayer().hasPermission("areas.trade.Enchanter")) {
						event.setTo(event.getFrom());
					}
					break;
			}
		}
	}
	
	@EventHandler
	public void onPlayerMoveEvent(PlayerMoveEvent event) {
		int toX = event.getTo().getBlockX();
		int toZ = event.getTo().getBlockZ();
		
		if(this.isInside(new SerializableKoordinat(toX,toZ))) {
			switch(belongsTo) {
				case CRAFTSMEN:
					if(!event.getPlayer().hasPermission("areas.trade.Craftsmen")) {
						event.setTo(event.getFrom());
					}
					break;
				case MINER:
					if(!event.getPlayer().hasPermission("areas.trade.Miner")) {
						event.setTo(event.getFrom());
					}
					break;
				case FARMER:
					if(!event.getPlayer().hasPermission("areas.trade.Farmer")) {
						event.setTo(event.getFrom());
					}
					break;
				case ENCHANTER:
					if(!event.getPlayer().hasPermission("areas.trade.Enchanter")) {
						event.setTo(event.getFrom());
					}
					break;
			}
		}
	}

}
