package mrLarssonJr.abilities.modules;

import java.util.ArrayList;
import java.util.HashMap;

import mrLarssonJr.abilities.Abilities;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class WallClimbing implements Listener {
	
	private Abilities plugin;
	private HashMap<String, ArrayList<Block>> playerLists;
	
	public WallClimbing(Abilities plugin) {
		this.plugin = plugin;
		playerLists = new HashMap<String, ArrayList<Block>>();
		this.register(plugin);
	}
	
	public void register(Abilities plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerMoveEvent(PlayerMoveEvent event) {
		Player player = event.getPlayer();	//Extract for ease of use in method
		
		if(player.hasPermission("abilities.trait.wallClimbing")) {	//Small check if the player has appropriate permission
			if(player.isSneaking()) {	//Controls if the player is sneaking
				if(this.besidesWall(player)) {	//Controls if the player is beside a wall
					Block block = player.getLocation().getBlock();
					if(block.getTypeId() != 106) {
						block.setTypeId(106);
						if(!playerLists.containsKey(player.getName())) {
							playerLists.put(player.getName(), new ArrayList<Block>());
						}
						ArrayList<Block> blocks = playerLists.get(player.getName());
						blocks.add(block);
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onPlayerToggleSneakEvent(PlayerToggleSneakEvent event) {
		if(event.isSneaking() == false) {
			ArrayList<Block> blocks = playerLists.get(event.getPlayer().getName());
			
			for(Block block : blocks) {
				if(block.getTypeId() == 106) {
					block.setTypeId(0);
				}
			}
		}
	}
	
	private boolean besidesWall(Player player) {	//Method to check if a player is next to a wall
		Block blockWithPlayer = player.getLocation().getBlock();	//Convenience variable
		Block[] blocksNextTo = {blockWithPlayer.getRelative(1, 0, 0), blockWithPlayer.getRelative(-1, 0, 0), blockWithPlayer.getRelative(0, 0, 1), blockWithPlayer.getRelative(0, 0, -1)};	//All the block that needs to be checked
		int[] blockIds = {1, 2, 3, 4, 5, 7, 12, 13, 14, 15, 16, 17, 18, 20, 21, 22, 23, 24, 25, 29,
						  33, 34, 35, 41, 42, 43, 44, 45, 46, 47, 48, 49, 52, 53, 54, 56, 57, 58,
						  60, 61, 62, 64, 67, 71, 73, 74, 79, 80, 81, 82, 84, 85, 86, 87, 88, 89, 91,
						  95, 96, 97, 98, 99, 100, 103, 107, 108, 109, 110, 112, 113, 114, 118, 120,
						  121, 123, 124, 125, 126, 128, 129, 130, 133, 134, 135, 136, 137, 138, 139,
						  146, 152, 153, 155, 156, 158, 159, 170, 172, 173};	//All blocks id that needs to be checked
		
		boolean nextToWall = false;	//Flag to check if next to wall, assume we are not
		
		for(Block block : blocksNextTo) {	//Iterate through all blocks next to the player to check for a wall
			if(nextToWall) {	//If wall allready found break out
				break;	//Break out
			}
			for(int id : blockIds) {	//Iterate through all ids to check against current block
				if(block.getTypeId() == id) {	//Check if block is a wall
					nextToWall = true;	//Block is a wall and therfore is the player next to a wall
					break;	//Break out
				}
			}
		}
		
		return nextToWall;	//Return the result of the serach for a wall
	}
		

}
