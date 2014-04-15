package me.gegude.comandos;

import me.gegude.FightPvP;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatManager implements CommandExecutor {
	
  public static FightPvP plugin;
  public ChatManager(FightPvP kitPvP){
    plugin = kitPvP;
  }
  
  public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
    if (!(sender instanceof Player)) {
      sender.sendMessage(ChatColor.RED + "Voce nao e um jogador!");
      return false;
    }
    Player p = (Player)sender;
    if (commandLabel.equalsIgnoreCase("limparchat")) {
      if (p.isOp()) {
        for (int i = 1; i <= 100; i++)
          Bukkit.broadcastMessage(" ");
      }
    }
	return false;
 }
}