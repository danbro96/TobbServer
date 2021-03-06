package mrLarssonJr.areas.utility;

import java.util.Properties;



/**
 * Representerar en koordinat i ett plan.
 * @author Jesper Larsson
 */
public class Koordinat {
	
	/**
	 * X-värdet för denna koordinat.
	 */
	private int x;
	/**
	 * Y-värdet för denna koordinat.
	 */
	private int y; 
	/**
	 * Skapar en ny koordinat vid det specificerade x-värdet och y-värdet.
	 * @param x - Det specificerade x värdet.
	 * @param y - Det specificerade y värdet.
	 */
	public Koordinat(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Koordinat(Properties data, String id) {
		String x = data.getProperty(id+"X");
		String y = data.getProperty(id+"Y");
		this.x = Integer.parseInt(x);
		this.y = Integer.parseInt(y);
	}
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	/**
	 * Retunerar x-värdet för denna koordinat.
	 * @return x-värdet
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Specifierar x-värdet för denna koordinat.
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Retrunerar y-värdet för denna koordinat.
	 * @return y-värdet
	 */
	public int getY() {
		return y;
	}

	/**
	 * Specifierar y-värdet för denna koordinat.
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	} 
		
			
}
