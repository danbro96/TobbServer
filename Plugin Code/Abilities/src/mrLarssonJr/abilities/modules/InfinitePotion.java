package mrLarssonJr.abilities.modules;

import java.util.ArrayList;

import mrLarssonJr.abilities.Abilities;
import mrLarssonJr.abilities.utility.InfinitePotionTask;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class InfinitePotion implements Listener {
	
	private Abilities plugin;
	
	private InfinitePotionTask speed1, speed2, speed3,	//Declare six infinitePotionTasks, three for use for the speed potion
							   jump1, jump2, jump3;		//And three for use for jump potion
	
	public InfinitePotion(Abilities plugin) {
		this.plugin = plugin;
		this.register(plugin);
		
		speed1 = new InfinitePotionTask(PotionEffectType.SPEED, 18000, 0, 10000);	//Initiate speed1. Set type of effect to speed 1, duration of effect to three hours and set time to update before effect wear off to ten minutes
		speed2 = new InfinitePotionTask(PotionEffectType.SPEED, 18000, 1, 10000);	//Initiate speed2. Set type of effect to speed 2, duration of effect to three hours and set time to update before effect wear off to ten minutes
		speed3 = new InfinitePotionTask(PotionEffectType.SPEED, 18000, 2, 10000);	//Initiate speed3. Set type of effect to speed 3, duration of effect to three hours and set time to update before effect wear off to ten minutes
		
		jump1 = new InfinitePotionTask(PotionEffectType.JUMP, 18000, 0, 10000);	//Initiate jump1. Set type of effect to jump 1, duration of effect to three hours and set time to update before effect wear off to ten minutes
		jump2 = new InfinitePotionTask(PotionEffectType.JUMP, 18000, 1, 10000);	//Initiate jump2. Set type of effect to jump 2, duration of effect to three hours and set time to update before effect wear off to ten minutes
		jump3 = new InfinitePotionTask(PotionEffectType.JUMP, 18000, 2, 10000);	//Initiate jump3. Set type of effect to jump 3, duration of effect to three hours and set time to update before effect wear off to ten minutes
		
		speed1.runTaskTimer(plugin, 0, 1);	//Start timer
		speed2.runTaskTimer(plugin, 0, 1);	//Start timer
		speed3.runTaskTimer(plugin, 0, 1);	//Start timer
		
		jump1.runTaskTimer(plugin, 0, 1);	//Start timer
		jump2.runTaskTimer(plugin, 0, 1);	//Start timer
		jump3.runTaskTimer(plugin, 0, 1);	//Start timer
		
	}
	
	public void register(Abilities plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	//RespawnEvent
	//ConsumeEvent (Milk)
	@EventHandler
	public void onPlayerItemConsumeEvent(PlayerItemConsumeEvent event) {	//When a player drinks milk, check if that player should have infinite potion, and if so, redose it
		if(event.getItem().getTypeId() == 335) {	//Check if consumed item is milk
			final Player player = event.getPlayer();	//Get associated player with this event
			
			plugin.getServer().getScheduler().runTaskLater(plugin, new BukkitRunnable(){
				@Override
				public void run() {
					ArrayList<InfinitePotionTask> tasks = checkPlayer(player);	//Get appropriate tasks for this player
					for(InfinitePotionTask task : tasks) {	//Iterate through all of the tasks and add the player to them
						task.redosePotion(player);	//Add player to the task
					}
				}
			}, 20);
		}
	}
	
	@EventHandler
	public void onPlayerLoginEvent(PlayerLoginEvent event) {	//Creates timer to execute checkPlayer when the login is complete
		final Player player = event.getPlayer();	//Extract player from event for ease of use
		
		plugin.getServer().getScheduler().runTaskLater(plugin, new BukkitRunnable(){
			@Override
			public void run() {
				ArrayList<InfinitePotionTask> tasks = checkPlayer(player);	//Get appropriate tasks for this player
				for(InfinitePotionTask task : tasks) {	//Iterate through all of the tasks and add the player to them
					task.addPlayer(player);	//Add player to the task
				}
			}
		}, 20);
	}
	
	@EventHandler
	public void onPlayerRespawnEvent(PlayerRespawnEvent event) {
		final Player player = event.getPlayer();	//Get associated player with this event
		
		plugin.getServer().getScheduler().runTaskLater(plugin, new BukkitRunnable(){
			@Override
			public void run() {
				ArrayList<InfinitePotionTask> tasks = checkPlayer(player);	//Get appropriate tasks for this player
				for(InfinitePotionTask task : tasks) {	//Iterate through all of the tasks and add the player to them
					task.redosePotion(player);	//Add player to the task
				}
			}
		}, 20);
		
		
	}
	
	private ArrayList<InfinitePotionTask> checkPlayer(Player player) {	//Check if player is supposed to have infinite potion, if so, return a list with the appropriate InfinitePotionTasks
		ArrayList<InfinitePotionTask> taskList = new ArrayList<InfinitePotionTask>();
		
		if(player.hasPermission("abilities.trait.speed1")) {	//If player has permission, then add speed1 to the list
			taskList.add(speed1);	//Add speed1 to taskList
		}
		else if(player.hasPermission("abilities.trait.speed2")) {	//If player has permission, then add speed2 to the list
			taskList.add(speed2);	//Add speed1 to taskList
		}
		else if(player.hasPermission("abilities.trait.speed3")) {	//If player has permission, then add speed3 to the list
			taskList.add(speed3);	//Add speed1 to task list
		}
		
		if(player.hasPermission("abilities.trait.jump1")) {	//If player has permission, then add jump1 to the list
			taskList.add(jump1);	//Add jump1 to task list
		}
		else if(player.hasPermission("abilities.trait.jump2")) {	//If player has permission, then add jump2 to the list
			taskList.add(jump1);	//Add jump1 to task list
		}
		else if(player.hasPermission("abilities.trait.jump3")) {	//If player has permission, then add jump3  to the list
			taskList.add(jump1);	//Add jump1 to task list
		}
		
		return taskList;
	}

}
