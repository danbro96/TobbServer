package mrLarssonJr.areas.area;


public enum Clans {
	CREEPER,
	END,
	BORDER,
	MANKIND;

	public static Clans parseString(String trade) {
		if(trade.equals("CREEPER")) {
			return CREEPER;
		}
		else if(trade.equals("END")) {
			return END;
		}
		else if(trade.equals("BORDER")) {
			return BORDER;
		}
		else if(trade.equals("MANKIND")) {
			return MANKIND;
		}
		return null;
	}

}
