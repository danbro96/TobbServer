package mrLarssonJr.areas.area;


import mrLarssonJr.areas.Areas;
import mrLarssonJr.areas.utility.SerializableKoordinat;

import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

/**
 * Representerar ett område med två hörn och ett namn.
 * @author jesper.1.larsson
 */
public class Area implements Listener {
	//Instans
		//Attribut
			/**
			 * Områdets namn.
			 */
			private String name;
			/**
			 * Områdets ena hörn, representerad av en koordinat.
			 */
			private SerializableKoordinat corner1;
			/**
			 * Områdets andra hörn, representerad av en koordinat.
			 */
			private SerializableKoordinat corner2;
			
		//Konstruktorer
			/**
			 * Skapar ett område med det specifierade namnet som är en rektangel med hörnen <code>hörn1</code> och <code>hörn</code>.<br>
			 * Hörnen jämförs med varandra och de minsta x-värdet och y-värdet sätts till ett hörn, <br>
			 * de största sätts till det andra hörnet. <br>
			 * @param namn - Det specifierade namnet.
			 * @param hörn1 - Det ena specifierade hörnet.
			 * @param hörn2 - Det andra specifierade hörnet.
			 */
			public Area(String namn, SerializableKoordinat hörn1, SerializableKoordinat hörn2, Areas plugin) throws IllegalArgumentException{
				this.name = namn;
				this.corner1 = new SerializableKoordinat(0,0);
				this.corner2 = new SerializableKoordinat(0,0);
				this.register(plugin);
				
				//Jämför x-värde-koordinat
				if(hörn1.getX() < hörn2.getX()) {
					//hörn1s x-värde är minst och sätts till this.hörn1
					//hörn2s x-värde är därför större och sätts till this.hörn2
					this.corner1.setX(hörn1.getX());
					this.corner2.setX(hörn2.getX());
				}
				else {
					//hörn1s x-värde är inte minst vilket betyder att hörn2s x är mindre eller lika.
					//hörn2s x-värde sätts till this.hörn1
					//hörn1s x-värde sätts till this.hörn2
					this.corner1.setX(hörn2.getX());
					this.corner2.setX(hörn1.getX());
				}
				
				//Jämför y-värde
				if(hörn1.getY() < hörn2.getY()) {
					//hörn1s y-värde är minst och sätts till this.hörn1
					//hörn2s y-värde är därför större och sätts till this.hörn2
					this.corner1.setY(hörn1.getY());
					this.corner2.setY(hörn2.getY());
				}
				else {
					//hörn1s y-värde är inte minst vilket betyder att hörn2s y är mindre eller lika.
					//hörn2s y-värde sätts till this.hörn1
					//hörn1s y-värde sätts till this.hörn2
					this.corner1.setY(hörn2.getY());
					this.corner2.setY(hörn1.getY());
				}
			}
			
		//Metoder
			public void register(Areas plugin) {
				plugin.getServer().getPluginManager().registerEvents(this, plugin);
			}
			public void unregister() {
				HandlerList.unregisterAll(this);
			}
			public boolean isInside(SerializableKoordinat pos) {
				boolean xInside = this.corner1.getX() <= pos.getX() && pos.getX() <= this.corner2.getX();
				boolean yInside = this.corner1.getY() <= pos.getY() && pos.getY() <= this.corner2.getY();
				if(xInside && yInside) {
					return true;
				}
				else {
					return false;
				}
			}
			
			@Override
			public String toString() {
				return "Name: " + name + " Location: " + corner1 + ", " + corner2 + " Type of Area: " + AreaType.parseClass(this).name();
			}
			//Getters och setters
				/**
				 * Retunerar en referens till namnet på det här området.
				 * @return en referens till namnet på det här objektet.
				 */
				public String getNamn() {
					return name;
				}
				/**
				 * ƒndrar namnet på det här området till det specifierade namnet.
				 * @param namn - Det specifierade namnet.
				 */
				public void setNamn(String namn) {
					this.name = namn;
				}
				/**
				 * Retunerar en referens till koordinaten för hörn1.
				 * @return en referens till koordinaten för hörn1
				 */
				public SerializableKoordinat getHörn1() {
					return corner1;
				}
				/**
				 * ƒndrar koordinaten för hörn1 till den specifierade koordinaten.
				 * @param pos - Den specifierade koordinaten
				 */
				public void setHörn1(SerializableKoordinat pos) {
					corner1 = pos;
				}
				/**
				 * Retunerar en referens till koordinaten för hörn2.
				 * @return en referens till koordinaten för hörn2
				 */
				public SerializableKoordinat getHörn2() {
					return corner2;
				}
				/**
				 * ƒndrar koordinaten för hörn2 till den specifierade koordinaten.
				 * @param pos - Den specifierade koordinaten.
				 */
				public void setHörn2(SerializableKoordinat pos) {
					corner2 = pos;
				}
				
}
