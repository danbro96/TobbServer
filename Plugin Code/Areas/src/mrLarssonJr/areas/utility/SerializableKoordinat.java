package mrLarssonJr.areas.utility;

import java.util.HashMap;




public class SerializableKoordinat extends Koordinat {
	
	

	public SerializableKoordinat(int x, int y) {
		super(x, y);
	}
	
	public SerializableKoordinat(HashMap<String, Integer> koordinat) {
		super(koordinat.get("X"), koordinat.get("Y"));
	}
	
	public HashMap<String, Integer> getKoordinatHashMap() {
		HashMap<String, Integer> koordinatHashMap = new HashMap<String, Integer>();
		
		koordinatHashMap.put("X", this.getX());
		koordinatHashMap.put("Y", this.getY());
		
		return koordinatHashMap;
	}

}
