package mrLarssonJr.areas.area;

import java.util.HashMap;
import java.util.Map;

import mrLarssonJr.areas.Areas;
import mrLarssonJr.areas.utility.SerializableKoordinat;

public class SerializableArea extends Area {

	public SerializableArea(String namn, SerializableKoordinat hörn1, SerializableKoordinat hörn2, Areas plugin) throws IllegalArgumentException {
		super(namn, hörn1, hörn2, plugin);
	}
	
	public SerializableArea(Map<?, ?> areaHashMap, Areas plugin) throws IllegalArgumentException {
		super((String) areaHashMap.get("Name"), new SerializableKoordinat((HashMap) areaHashMap.get("Corner1")), new SerializableKoordinat((HashMap) areaHashMap.get("Corner2")), plugin);
	}

	public HashMap<String, Object> getAreaHashMap() {
		HashMap<String, Object> areaHashMap = new HashMap<String, Object>();
		
		areaHashMap.put("Name", getNamn());
		areaHashMap.put("Corner1", this.getHörn1().getKoordinatHashMap());
		areaHashMap.put("Corner2", this.getHörn2().getKoordinatHashMap());
		areaHashMap.put("Type", AreaType.BASIC.name());
		
		return areaHashMap;
	}

}
