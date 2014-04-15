package me.gegude.comandos;

import me.gegude.FightPvP;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Broadcast implements CommandExecutor {
	
  public static FightPvP plugin;
  public Broadcast(FightPvP kitPvP){
    plugin = kitPvP;
  }

  public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args){
	  Player player = (Player)sender;
	  if (commandLabel.equalsIgnoreCase("bc") || commandLabel.equalsIgnoreCase("broadcast")) {
		  if(player.hasPermission("pvp.bc")) {
	        if (args.length >= 1){
	          String bcast = "";
	          for (int x = 0; x < args.length; x++){
	            bcast = bcast + args[x] + " ";
	          }
	          bcast = ChatColor.translateAlternateColorCodes('&', bcast);
	            Bukkit.broadcastMessage("§7[§bFight-PvP§7]§7 " + bcast);
	        }else {
	          sender.sendMessage(ChatColor.GRAY + "/bc <mensagem>");
	        }
		  }
	    }
	return false;
  }
 }