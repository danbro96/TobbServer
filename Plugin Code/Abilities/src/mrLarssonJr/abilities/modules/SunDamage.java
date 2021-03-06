package mrLarssonJr.abilities.modules;

import mrLarssonJr.abilities.Abilities;
import mrLarssonJr.abilities.utility.BlindnessIfInSun;
import mrLarssonJr.abilities.utility.FireIfInSun;
import mrLarssonJr.abilities.utility.NauseaIfInSun;

import org.bukkit.event.Listener;

public class SunDamage implements Listener {

	private Abilities plugin;
	
	private FireIfInSun taskFire;
	private BlindnessIfInSun taskBlind;
	private NauseaIfInSun taskNausea;
	
	
	public SunDamage(Abilities plugin) {
		this.plugin = plugin;
		this.register(plugin);
		taskFire = new FireIfInSun(plugin);
		taskFire.runTaskTimer(plugin, 100, 20);
		taskBlind = new BlindnessIfInSun(plugin);
		taskBlind.runTaskTimer(plugin, 100, 20);
		taskNausea = new NauseaIfInSun(plugin);
		taskNausea.runTaskTimer(plugin, 100, 20);
		
	}

	public void register(Abilities plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	
}
