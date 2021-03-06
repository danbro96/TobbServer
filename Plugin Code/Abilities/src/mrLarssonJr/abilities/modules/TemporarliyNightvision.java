package mrLarssonJr.abilities.modules;

import mrLarssonJr.abilities.Abilities;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class TemporarliyNightvision implements Listener {
	
	private Abilities plugin;
	
	public TemporarliyNightvision(Abilities plugin) {
		this.plugin = plugin;
		this.register(plugin);
	}
	
	public void register(Abilities plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerToggleSneakEvent(PlayerToggleSneakEvent event) {
		if(event.getPlayer().hasPermission("abilities.trait.tempNightvision")) {
			event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 600, 1));
		}
	}

}
