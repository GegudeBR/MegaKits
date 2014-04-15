package me.gegude.comandos;

import me.confuser.barapi.BarAPI;
import me.gegude.FightPvP;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class New implements CommandExecutor {
	
  public static FightPvP plugin;
  public New(FightPvP kitPvP){
    plugin = kitPvP;
  }


  public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args){
    final Player player = (Player)sender;
    if (commandLabel.equalsIgnoreCase("new") || player.hasPermission("pvp.new")) {
    	BarAPI.setMessage(player, ChatColor.GOLD + "Agora você pode escolher outro kit.", 4);
    	plugin.removeAbilitys(player);
    }
    return false;
  }
  
 }