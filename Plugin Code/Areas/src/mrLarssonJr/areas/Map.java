package mrLarssonJr.areas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mrLarssonJr.areas.area.Area;
import mrLarssonJr.areas.area.AreaType;
import mrLarssonJr.areas.area.Clans;
import mrLarssonJr.areas.area.SerializableArea;
import mrLarssonJr.areas.area.Trades;
import mrLarssonJr.areas.utility.SerializableKoordinat;

/**
 * 
 */

/**
 * @author jesperlarsson
 *
 */
public class Map {
	//Klass
	//Instans
		//Variabler
			private ArrayList<SerializableArea> areas = new ArrayList<SerializableArea>();
			private Areas plugin;
		//Konstruktrorer
			public Map(Areas plugin, String parentPath) {
				this.plugin = plugin;
				
				List<java.util.Map<?, ?>> areaInfoToLoad = plugin.getConfig().getMapList("Map.Areas");
				
				for(java.util.Map<?, ?> m : areaInfoToLoad) {
					String typeID = (String) m.get("Type");
					plugin.getLogger().info("1: " + typeID);
					AreaType type = AreaType.parseString(typeID);
					plugin.getLogger().info("2: " + type.name());
					SerializableArea loadedArea = type.createNewAreaOfThisType(m, plugin);
					areas.add(loadedArea);
				}
				
				this.reRegisterAreas();
				
			}
		//Metoder
			public void reRegisterAreas() {
				for(Area o : areas) {
					o.register(plugin);
				}
			}
			
			public boolean areaExist(String namn) {
				if(getArea(namn) != null) {
					return true;
				}
				else {
					return false;
				}
			}
			public Area getArea(String namn) {
				for(Area o : areas) {
					if(o.getNamn().equalsIgnoreCase(namn)) {
						return o;
					}
				}
				
				return null;
			}
			
			public void createArea(AreaType type, String namn, SerializableKoordinat corner1, SerializableKoordinat corner2, Trades trade, Clans clan) throws IllegalArgumentException{
				if(!this.areaExist(namn)) {
					for(AreaType at : AreaType.values()) {
						if(type == at) {
							areas.add(type.createNewAreaOfThisType(namn, corner1, corner2, plugin, trade, clan));
						}
					}
				}
				else {
					throw new IllegalArgumentException("An area with the name " + namn + " already exist!");
				}
			}
			public void removeArea(String namn) throws IllegalArgumentException{
				if(areaExist(namn)) {
					Area o = getArea(namn);
					areas.remove(o);
					o.unregister();
				}
				else {
					throw new IllegalArgumentException("An area with the name " + namn + " don't exist!");
				}
			}
			public ArrayList<SerializableArea> listAllAreas() {
				return areas;
			}
			
			public void save() {
				ArrayList<HashMap> areaInfoToSave = new ArrayList<HashMap>();
				
				for(SerializableArea a : areas) {
					areaInfoToSave.add(a.getAreaHashMap());
				}
				
				plugin.getConfig().set("Map.Areas", areaInfoToSave);
			}
			
}