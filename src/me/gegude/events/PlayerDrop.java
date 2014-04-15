package me.gegude.events;

import me.gegude.FightPvP;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDrop implements Listener{
 
	  public static FightPvP plugin;
	  public PlayerDrop(FightPvP kitPvP){
		    plugin = kitPvP;
		  }
	
	@EventHandler
	public void onPlayerDropSword(PlayerDropItemEvent e){
		if(e.getItemDrop().getItemStack().getType() == Material.DIAMOND_SWORD || e.getItemDrop().getItemStack().getType() == Material.IRON_SWORD || e.getItemDrop().getItemStack().getType() == Material.GOLD_SWORD || e.getItemDrop().getItemStack().getType() == Material.STONE_SWORD || e.getItemDrop().getItemStack().getType() == Material.WOOD_SWORD ||  e.getItemDrop().getItemStack().getType() == Material.BOW ||
				e.getItemDrop().getItemStack().getType() == Material.ARROW || e.getItemDrop().getItemStack().getType() == Material.FIREWORK || e.getItemDrop().getItemStack().getType() == Material.FEATHER || e.getItemDrop().getItemStack().getType() == Material.REDSTONE_TORCH_ON || e.getItemDrop().getItemStack().getType() == Material.PORTAL || e.getItemDrop().getItemStack().getType() == Material.FISHING_ROD ||
				e.getItemDrop().getItemStack().getType() == Material.WOOD_AXE || e.getItemDrop().getItemStack().getType() == Material.SNOW_BALL || e.getItemDrop().getItemStack().getType() == Material.INK_SACK || e.getItemDrop().getItemStack().getType() == Material.SADDLE || e.getItemDrop().getItemStack().getType() == Material.ENDER_PEARL || e.getItemDrop().getItemStack().getType() == Material.BLAZE_ROD ||
				e.getItemDrop().getItemStack().getType() == Material.SUGAR || e.getItemDrop().getItemStack().getType() == Material.REDSTONE || e.getItemDrop().getItemStack().getType() == Material.IRON_FENCE) {
			e.setCancelled(true);
		}
	}
}
