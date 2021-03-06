package mrLarssonJr.areas.area;
import java.util.HashMap;
import java.util.Map;

import mrLarssonJr.areas.Areas;
import mrLarssonJr.areas.utility.SerializableKoordinat;

public enum AreaType {
	BASIC,
	BATTLEFIELD,
	CITY,
	CLAN_GROUND,
	TRADE_GROUND;
	
	public SerializableArea createNewAreaOfThisType(String namn, SerializableKoordinat corner1, SerializableKoordinat corner2, Areas plugin, Trades trade, Clans clan) {
		SerializableArea createdArea = null;
		switch (this) {
			case BASIC:
				createdArea = new SerializableArea(namn, corner1, corner2, plugin);
				break;
			case BATTLEFIELD:
				createdArea = new Battlefield(namn, corner1, corner2, plugin);
				break;
			case CITY:
				createdArea = new City(namn, corner1, corner2, plugin);
				break;
			case CLAN_GROUND:
				createdArea = new ClanGround(namn, corner1, corner2, plugin, clan);
				break;
			case TRADE_GROUND:
				createdArea = new TradeGround(namn, corner1, corner2, plugin, trade);
				break;
		}
		return createdArea;
	}
	
	public SerializableArea createNewAreaOfThisType(Map<?,?> areaHashMap, Areas plugin) {
		SerializableArea createdArea = null;
		String namn = (String) areaHashMap.get("Name");
		SerializableKoordinat corner1 = new SerializableKoordinat((HashMap<String, Integer>)areaHashMap.get("Corner1"));
		SerializableKoordinat corner2 = new SerializableKoordinat((HashMap<String, Integer>)areaHashMap.get("Corner2"));
		switch (this) {
			case BASIC:
				createdArea = new SerializableArea(namn, corner1, corner2, plugin);
				break;
			case BATTLEFIELD:
				createdArea = new Battlefield(namn, corner1, corner2, plugin);
				break;
			case CITY:
				createdArea = new City(namn, corner1, corner2, plugin);
				break;
			case CLAN_GROUND:
				createdArea = new ClanGround(namn, corner1, corner2, plugin, Clans.parseString((String) areaHashMap.get("Clan")));
				break;
			case TRADE_GROUND:
				createdArea = new TradeGround(namn, corner1, corner2, plugin, Trades.parseString((String) areaHashMap.get("Trade")));
				break;
		}
		return createdArea;
	}
	
	public static AreaType parseClass(Area type) {
		if(type instanceof Battlefield) {
			return BATTLEFIELD;
		}
		else if(type instanceof City) {
			return CITY;
		}
		else if(type instanceof ClanGround) {
			return CLAN_GROUND;
		}
		else if(type instanceof TradeGround) {
			return TRADE_GROUND;
		}
		
		return null;
		
	}
	
	public static AreaType parseString(String type) {
		if(type.equals("BASIC")) {
			return BASIC;
		}
		else if(type.equals("BATTLEFIELD")) {
			return BATTLEFIELD;
		}
		else if(type.equals("CITY")) {
			return CITY;
		}
		else if(type.equals("CLAN_GROUND")) {
			return CLAN_GROUND;
		}
		else if(type.equals("TRADE_GROUND")) {
			return TRADE_GROUND;
		}
		return null;
	}

}
