package me.gegude.events;

import me.gegude.FightPvP;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class TabColor implements Listener {

	  public static FightPvP plugin;
	  public TabColor(FightPvP kitPvP){
		    plugin = kitPvP;
		  }
	
		@EventHandler
		public void tabcolornormal(PlayerJoinEvent event){
		    if (event.getPlayer().getName().length() < 11) {
			if(event.getPlayer().hasPermission("fight.normal")) {
				event.getPlayer().setPlayerListName(ChatColor.GRAY + event.getPlayer().getName() + ChatColor.RESET);
				event.getPlayer().setCustomName(ChatColor.GRAY + event.getPlayer().getName() + ChatColor.RESET);	
			    event.getPlayer().setDisplayName(ChatColor.GRAY + event.getPlayer().getName() + ChatColor.RESET);  	 
		     }
			} else {
		    	String name = event.getPlayer().getName().substring(0, 11);
				if(event.getPlayer().hasPermission("fight.normal")) {
				event.getPlayer().setPlayerListName(ChatColor.GRAY + name + ChatColor.RESET);
				event.getPlayer().setCustomName(ChatColor.GRAY + event.getPlayer().getName() + ChatColor.RESET);	
			    event.getPlayer().setDisplayName(ChatColor.GRAY + event.getPlayer().getName() + ChatColor.RESET);  	 
			    }	     
			}
		}
	@EventHandler
	public void tabcolorvip(PlayerJoinEvent event){
		if(event.getPlayer().hasPermission("fight.vip")) {
			event.getPlayer().setPlayerListName(ChatColor.GOLD + event.getPlayer().getName() + ChatColor.RESET);
			event.getPlayer().setCustomName(ChatColor.GOLD + event.getPlayer().getName() + ChatColor.RESET);
			event.getPlayer().setDisplayName(ChatColor.GOLD + event.getPlayer().getName() + ChatColor.RESET);
		}
	}
	@EventHandler
	public void tabcolorvip2(PlayerJoinEvent event){
	    if (event.getPlayer().getName().length() < 11) {
		if(event.getPlayer().hasPermission("fight.vipplus")) {
			event.getPlayer().setPlayerListName(ChatColor.GOLD + "" + ChatColor.ITALIC + event.getPlayer().getName() + ChatColor.RESET);
			event.getPlayer().setCustomName(ChatColor.GOLD + "" + ChatColor.ITALIC + event.getPlayer().getName() + ChatColor.RESET);
			event.getPlayer().setDisplayName(ChatColor.GOLD + "" + ChatColor.ITALIC + event.getPlayer().getName() + ChatColor.RESET);
	     }
		} else {
	    	String name = event.getPlayer().getName().substring(0, 11);
			if(event.getPlayer().hasPermission("fight.vipplus")) {
			event.getPlayer().setPlayerListName(ChatColor.GOLD + "" + ChatColor.ITALIC + name + ChatColor.RESET);
			event.getPlayer().setCustomName(ChatColor.GOLD + "" + ChatColor.ITALIC + event.getPlayer().getName() + ChatColor.RESET);	
		    event.getPlayer().setDisplayName(ChatColor.GOLD + "" + ChatColor.ITALIC + event.getPlayer().getName() + ChatColor.RESET);  	 
		    }	     
		}
	}
	@EventHandler
	public void tabcoloryoutuber(PlayerJoinEvent event){
	    if (event.getPlayer().getName().length() < 11) {
		if(event.getPlayer().hasPermission("fight.youtuber")) {
			event.getPlayer().setPlayerListName(ChatColor.AQUA + event.getPlayer().getName() + ChatColor.RESET);
			event.getPlayer().setCustomName(ChatColor.AQUA + event.getPlayer().getName() + ChatColor.RESET);	
		    event.getPlayer().setDisplayName(ChatColor.AQUA + event.getPlayer().getName() + ChatColor.RESET);  	 
	     }
		} else {
	    	String name = event.getPlayer().getName().substring(0, 11);
			if(event.getPlayer().hasPermission("fight.youtuber")) {
			event.getPlayer().setPlayerListName(ChatColor.AQUA + name + ChatColor.RESET);
			event.getPlayer().setCustomName(ChatColor.AQUA + event.getPlayer().getName() + ChatColor.RESET);	
		    event.getPlayer().setDisplayName(ChatColor.AQUA + event.getPlayer().getName() + ChatColor.RESET);  	 
		    }	     
		}
	}
	@EventHandler
	public void tabcolortrial(PlayerJoinEvent event){
		if(event.getPlayer().hasPermission("fight.trial")) {
			event.getPlayer().setPlayerListName(ChatColor.LIGHT_PURPLE + event.getPlayer().getName() + ChatColor.RESET);
			event.getPlayer().setCustomName(ChatColor.LIGHT_PURPLE + event.getPlayer().getName() + ChatColor.RESET);
			event.getPlayer().setDisplayName(ChatColor.LIGHT_PURPLE + event.getPlayer().getName() + ChatColor.RESET);
		}
	}
	@EventHandler
	public void tabcolormod(PlayerJoinEvent event){
	    if (event.getPlayer().getName().length() < 11) {
		if(event.getPlayer().hasPermission("fight.mod")) {
			event.getPlayer().setPlayerListName(ChatColor.DARK_PURPLE + event.getPlayer().getName() + ChatColor.RESET);
			event.getPlayer().setCustomName(ChatColor.DARK_PURPLE + event.getPlayer().getName() + ChatColor.RESET);	
		    event.getPlayer().setDisplayName(ChatColor.DARK_PURPLE + event.getPlayer().getName() + ChatColor.RESET);  	 
	     }
		} else {
	    	String name = event.getPlayer().getName().substring(0, 11);
			if(event.getPlayer().hasPermission("fight.mod")) {
			event.getPlayer().setPlayerListName(ChatColor.DARK_PURPLE + name + ChatColor.RESET);
			event.getPlayer().setCustomName(ChatColor.DARK_PURPLE + event.getPlayer().getName() + ChatColor.RESET);	
		    event.getPlayer().setDisplayName(ChatColor.DARK_PURPLE + event.getPlayer().getName() + ChatColor.RESET);  	 
		    }	     
		}
	}
	@EventHandler
	public void tabcoloradmin(PlayerJoinEvent event){
		if(event.getPlayer().hasPermission("fight.admin")) {
			event.getPlayer().setPlayerListName(ChatColor.RED + event.getPlayer().getName() + ChatColor.RESET);
			event.getPlayer().setCustomName(ChatColor.RED + event.getPlayer().getName() + ChatColor.RESET);
			event.getPlayer().setDisplayName(ChatColor.RED + event.getPlayer().getName() + ChatColor.RESET);
		}
	}
	@EventHandler
	public void tabcolordono(PlayerJoinEvent event){
	    if (event.getPlayer().getName().length() < 11) {
		if(event.getPlayer().hasPermission("fight.dono")) {
			event.getPlayer().setPlayerListName(ChatColor.DARK_RED + "" + ChatColor.ITALIC + event.getPlayer().getName() + ChatColor.RESET);
			event.getPlayer().setCustomName(ChatColor.DARK_RED + "" + ChatColor.ITALIC + event.getPlayer().getName() + ChatColor.RESET);
			event.getPlayer().setDisplayName(ChatColor.DARK_RED + "" + ChatColor.ITALIC + event.getPlayer().getName() + ChatColor.RESET);
		    } 
		} else {
		   	String name = event.getPlayer().getName().substring(0, 11);
			if(event.getPlayer().hasPermission("fight.dono")) {
			event.getPlayer().setPlayerListName(ChatColor.DARK_RED + "" + ChatColor.ITALIC + name + ChatColor.RESET);
			event.getPlayer().setCustomName(ChatColor.DARK_RED + "" + ChatColor.ITALIC + event.getPlayer().getName() + ChatColor.RESET);
			event.getPlayer().setDisplayName(ChatColor.DARK_RED + "" + ChatColor.ITALIC + event.getPlayer().getName() + ChatColor.RESET);   
			}
		  }
	}
}
