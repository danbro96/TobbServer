package mrLarssonJr.abilities;

import java.io.Serializable;

import mrLarssonJr.abilities.modules.*;

import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public class Abilities extends JavaPlugin implements Serializable{
	//private Commands cmds;
	private NoHarmByMonster damageListener;
	private NoTargetByMonster targetListener;
	private BlockDropItemControl dropControl;
	private InventoryControl inventoryControl;
	private DamageWhileInStorm stormDamage;
	private WaterDamage waterDamage;
	private PoisonOnWater waterPoison;
	private SunDamage sunDamage;
	private ReplaceArrow enderpearlArrow;
	private TemporarliyNightvision tempNightvision;
	private MoveFasterInLiquid swimmer;
	private SpawnCube spawner;
	private InfinitePotion infinitePotion;
	private ShortFlying shortFlying;
	private WallClimbing wallClimbing;
	
	public Abilities() {
	}
	
	@Override
	public void onEnable() {
		//cmds = new Commands(this);
		damageListener = new NoHarmByMonster(this);
		targetListener = new NoTargetByMonster(this);
		dropControl = new BlockDropItemControl(this);
		inventoryControl = new InventoryControl(this);
		stormDamage = new DamageWhileInStorm(this);
		waterDamage = new WaterDamage(this);
		waterPoison = new PoisonOnWater(this);
		sunDamage = new SunDamage(this);
		enderpearlArrow = new ReplaceArrow(this);
		tempNightvision = new TemporarliyNightvision(this);
		swimmer = new MoveFasterInLiquid(this);
		spawner = new SpawnCube(this);
		infinitePotion = new InfinitePotion(this);
		shortFlying = new ShortFlying(this);
		wallClimbing = new WallClimbing(this);
		this.getLogger().info("Abilities " + this.getDescription().getVersion() + " has been enabled.");
	}
	
	@Override
	public void onDisable() {
		HandlerList.unregisterAll(this);
		damageListener = null;
		targetListener = null;
		dropControl = null;
		inventoryControl = null;
		stormDamage = null;
		waterDamage = null;
		waterPoison = null;
		sunDamage = null;
		enderpearlArrow = null;
		tempNightvision = null;
		swimmer = null;
		spawner = null;
		infinitePotion = null;
		shortFlying = null;
		wallClimbing = null;
		
		this.getServer().getScheduler().cancelTasks(this);	//Cancel all timers for this plugin
		this.getLogger().info("Abilities " + this.getDescription().getVersion() + " has been disabled.");
	}

}
