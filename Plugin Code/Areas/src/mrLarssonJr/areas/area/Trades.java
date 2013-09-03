package mrLarssonJr.areas.area;


public enum Trades {
	CRAFTSMEN,
	MINER,
	FARMER,
	ENCHANTER;
	
	public static Trades parseString(String trade) {
		if(trade.equals("CRAFTSMEN")) {
			return CRAFTSMEN;
		}
		else if(trade.equals("MINER")) {
			return MINER;
		}
		else if(trade.equals("FARMER")) {
			return FARMER;
		}
		else if(trade.equals("ENCHANTER")) {
			return ENCHANTER;
		}
		return null;
	}
}
