package me.gegude.events;

import me.gegude.FightPvP;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffectType;

public class Nearfs implements Listener{
	
	  public static FightPvP plugin;
	  public Nearfs(FightPvP kitPvP){
		    plugin = kitPvP;
		  }
	
	@SuppressWarnings("deprecation")
	 @EventHandler(priority = EventPriority.LOWEST)
	 public void onDamageByEntity(EntityDamageByEntityEvent event) {
	  if (event.getDamager() instanceof Player) {
	   Player player = (Player) event.getDamager();
	   if (event.getDamage() > 1) {
	    event.setDamage(event.getDamage() - 1);
	   }
	   if ((event.getDamager() instanceof Player)) {
	    if (player.getFallDistance() > 0 && !player.isOnGround()
	      && !player.hasPotionEffect(PotionEffectType.BLINDNESS)) {
	     int NewDamage;
	     NewDamage = (int) (event.getDamage() * 1.5)
	       - (int) event.getDamage();
	     if (event.getDamage() > 1)
	      event.setDamage(event.getDamage() - NewDamage);

	    }
	    if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
	     event.setDamage(3);
	    }
	    if (player.getItemInHand().getType() == Material.STONE_SWORD) {
	     event.setDamage(4);
	    }
	    if (player.getItemInHand().getType() == Material.IRON_SWORD) {
	     event.setDamage(5);
	    }
	    if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
	     event.setDamage(6);
	    }
	    if(player.getItemInHand().containsEnchantment(Enchantment.DAMAGE_ALL)){
	     event.setDamage(event.getDamage() + 1);
	    }
	    if (player.getFallDistance() > 0 && !player.isOnGround()
	      && !player.hasPotionEffect(PotionEffectType.BLINDNESS)) {
	     if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
	      event.setDamage(event.getDamage() + 1);
	     }
	     if (player.getItemInHand().getType() == Material.STONE_SWORD) {
	      event.setDamage(event.getDamage() + 1);
	     }
	     if (player.getItemInHand().getType() == Material.IRON_SWORD) {
	      event.setDamage(event.getDamage() + 1);
	     }
	     if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
	      event.setDamage(event.getDamage() + 1);
	     }

	    }
	   }
	  }
	 }
}
