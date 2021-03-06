package mrLarssonJr.abilities.utility;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class InfinitePotionTask extends BukkitRunnable {
	
	private ArrayList<Player> players;	//Players that shall receive infinite potion
	private int ticksToUpdate;	//Game ticks until the next refill of potions is done
	private int tickDifference;	//The difference of ticks the ticksToUpdate and the actual remaing ticks of the potioneffect
	
	private PotionEffectType type;	//Type of potion the players shall receive
	private int potionEffectTicks;	//Ticks the potion shall be active
	private int potionAmplifier;	//Amplifier used to determine strength of potion
	
	public InfinitePotionTask(PotionEffectType type, int potionEffectTicks, int potionAmplifier, int tickDifference) {	//Gathers & stores info needed for the execution of the instance
		this.type = type;	//Stores value in instance
		this.potionEffectTicks = potionEffectTicks;	//Stores value in instance
		this.potionAmplifier = potionAmplifier;	//Stores value in instance
		this.tickDifference = tickDifference;	//Stores value in instance
		
		ticksToUpdate = this.potionEffectTicks - this.tickDifference;	//Calculate and set ticksToUpdate
		players = new ArrayList<Player>();	//Initiate the players variable
	}
	
	public void addPlayer(Player player) {	//Add player that shall receive infinite potion
		players.add(player);	//Add player to players list
		ticksToUpdate = 100;	//Make sure all players get an update in five seconds
	}
	
	public void removePlayer(Player player) {	//Remove the specified player from the list
		while(players.contains(player)) {	//For as long as the specified player occurs in the list, remove the reference
			players.remove(player);	//Remove reference of the specified player from the list
		}
	}
	
	public void redosePotion(Player player) {	//Supposed to be called when a redose is needed, for example when the player respawns or drank milk
		this.updatePotion(player, this.remaingTicksOfPotionEffect());	//Make sure the player has the potion for the remaining time until next update
	}
	
	private void updatePotion(Player player, int ticks) {	//Give the player a new dose of potion
		player.removePotionEffect(type);	//If a potioneffect of this type is present it removes it to ensure the success of the update of the potion effect
		player.addPotionEffect(new PotionEffect(type, ticks, potionAmplifier));	//Readd the potioneffect
	}
	
	private int remaingTicksOfPotionEffect() {	//Returns remaing ticks of the potioneffect
		return tickDifference + ticksToUpdate;	//Does what the method does...
	}
	
	private void tick() {	//Decrement the ticksToUpdate, if it's time to update the does, then does it
		ticksToUpdate--;	//Decrement the ticksToUpdate by one
		if(ticksToUpdate <= 0) {	//If time to update, then update
			for(Player player : players) {	//Iterate through all players and update them
				this.updatePotion(player, potionEffectTicks);	//Update the players potion to last potionEffectTicks ticks
			}
			ticksToUpdate = potionEffectTicks - tickDifference;	//Reset ticksToUpdate
		}
	}
	

	@Override
	public void run() {	//Called once every tick to update the tick count
		tick();	//Runs all necessary code to update the count
	}

}
