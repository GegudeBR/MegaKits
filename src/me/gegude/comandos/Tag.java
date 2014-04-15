	package me.gegude.comandos;

import java.util.ArrayList;
import java.util.List;

import me.gegude.FightPvP;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Tag implements Listener, CommandExecutor {
	
  List<String> tag = new ArrayList<String>();
  
  public static FightPvP plugin;
  public Tag(FightPvP kitPvP){
	    plugin = kitPvP;
	  }

  public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
		Player p = (Player) sender;
		if (cmd.equalsIgnoreCase("tag")) {
		      if (args.length == 0) {
		        p.sendMessage(ChatColor.RED +  "Use /" + cmd + " Normal | Vip | Vip+ | Youtuber | Trial | Mod | Admin | Dono");
		      }
		      
		      else if (args[0].equalsIgnoreCase("dono")) {
			    if (p.getName().length() < 11) {
		        if (p.hasPermission("fight.dono")) {
		          p.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.ITALIC + p.getName() + ChatColor.RESET);
		          p.setPlayerListName(ChatColor.DARK_RED + "" + ChatColor.ITALIC + p.getName());
		          p.sendMessage("§6Tag mudada para §4§oDONO");
		          tag.add(p.getName());
		        } else {
		        	 p.sendMessage(ChatColor.RED + "Voce nao tem permissao!");
		        }
			   } else {
		        	 String name = p.getName().substring(0, 11);
		        	 if (p.hasPermission("fight.dono")) {
		        	 p.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.ITALIC + p.getName() + ChatColor.RESET);
			          p.setPlayerListName(ChatColor.DARK_RED + "" + ChatColor.ITALIC + name);
			          p.sendMessage("§6Tag mudada para §5§oDONO");
			          tag.add(p.getName());
		        	 }
		        } 
		      }
		      
	      else if (args[0].equalsIgnoreCase("admin")) {
	        if (p.hasPermission("fight.admin")) {
	          p.setDisplayName(ChatColor.RED + p.getName() + ChatColor.RESET);
	          p.setPlayerListName(ChatColor.RED + p.getName());
	          p.sendMessage("§6Tag mudada para §cADMIN");
	          tag.add(p.getName());
	        } else {
	        	 p.sendMessage(ChatColor.RED + "Voce nao tem permissao!");
	        }
	      }
		      
		      else if (args[0].equalsIgnoreCase("mod")) {
		     if (p.getName().length() < 11) {
		        if (p.hasPermission("fight.mod")) {
		          p.setDisplayName(ChatColor.DARK_PURPLE + p.getName() + ChatColor.RESET);
		          p.setPlayerListName(ChatColor.DARK_PURPLE + p.getName());
		          p.sendMessage("§6Tag mudada para §5MOD");
		          tag.add(p.getName());
		        } else {
		        	 p.sendMessage(ChatColor.RED + "Voce nao tem permissao!");
		        }
		     } else {
		    	 String name = p.getName().substring(0, 11);
	        	 if (p.hasPermission("fight.mod")) {
	        		 p.setDisplayName(ChatColor.DARK_PURPLE + p.getName() + ChatColor.RESET);
	                 p.setPlayerListName(ChatColor.DARK_PURPLE + name);
		             p.sendMessage("§6Tag mudada para §5MOD");
			         tag.add(p.getName());
	        	 } 
		     }
		      } 
		      
		      else if (args[0].equalsIgnoreCase("trial")) {
			        if (p.hasPermission("fight.trial")) {
			          p.setDisplayName(ChatColor.LIGHT_PURPLE + p.getName() + ChatColor.RESET);
			          p.setPlayerListName(ChatColor.LIGHT_PURPLE + p.getName());
			          p.sendMessage("§6Tag mudada para §dTRIALMOD");
			          tag.add(p.getName());
			        } else {
			        	 p.sendMessage(ChatColor.RED + "Voce nao tem permissao!");
			        }
			        
			      }else if (args[0].equalsIgnoreCase("vip")) {
		        if (p.hasPermission("fight.vip")) {
		          p.setDisplayName(ChatColor.GOLD + p.getName() + 
		            ChatColor.RESET);
		          p.setPlayerListName(ChatColor.GOLD + p.getName());
		          p.sendMessage("§6Tag mudada para §6VIP");
		          tag.add(p.getName());
		        } else {
		        	 p.sendMessage(ChatColor.RED + "Voce nao tem permissao!");
		        }
		        
		      } else if (args[0].equalsIgnoreCase("vip+")) {
		        if (p.hasPermission("fight.vipplus")) {
		        if (p.getName().length() < 11) {
			      p.setDisplayName(ChatColor.GOLD + "" + ChatColor.ITALIC + p.getName() + ChatColor.RESET);
			      p.setPlayerListName(ChatColor.GOLD + "" + ChatColor.ITALIC + p.getName());
		          p.sendMessage("§6Tag mudada para §6§oVIP+");
		          tag.add(p.getName());
		        } else {
		       	 String name = p.getName().substring(0, 11);
		          p.setDisplayName(ChatColor.GOLD + "" + ChatColor.ITALIC + p.getName() + ChatColor.RESET);
			      p.setPlayerListName(ChatColor.GOLD + "" + ChatColor.ITALIC + name);
			      p.sendMessage("§6Tag mudada para §6§oVIP+");
			      tag.add(p.getName());
		        }
		       } else {
			          p.sendMessage(ChatColor.RED + "Voce nao tem permissao!");
			     }
		      }
		      
		        else if (args[0].equalsIgnoreCase("youtuber")) {
			    	  if(p.hasPermission("fight.youtuber")) {
			    		   if (p.getName().length() < 11) {
			    	  p.setDisplayName(ChatColor.AQUA + p.getName() + ChatColor.RESET);
			    	  p.setPlayerListName(ChatColor.AQUA + p.getName());
			    	  p.sendMessage("§6Tag mudada para §bYoutuber");
			    	  tag.add(p.getName());
			    	 } else {
			    		String name = p.getName().substring(0, 11);
			    	    p.setDisplayName(ChatColor.AQUA + name + ChatColor.RESET);
					    p.setPlayerListName(ChatColor.AQUA + p.getName());
					  	p.sendMessage("§6Tag mudada para §bYoutuber");
				        tag.add(p.getName()); 
			    	 }
			    	 }else {
				    		p.sendMessage(ChatColor.RED + "Voce nao tem permissao!");
			    	 }
			      } else if (args[0].equalsIgnoreCase("normal")) {
		        p.setDisplayName(ChatColor.GRAY + p.getName() + ChatColor.RESET);
		        p.setPlayerListName(ChatColor.GRAY + p.getName());
		        p.sendMessage("§6Tag mudada para §7Normal");
		        tag.add(p.getName());

		      } else if (args[0].equalsIgnoreCase("reset")) {
		        this.tag.remove(p);
		        p.sendMessage(ChatColor.GOLD + "§6Sua tag foi resetada!");
		      } else {
		        p.sendMessage(ChatColor.RED + "Essa tag nao existe.");
		      }
	}
		return false;
 }
}