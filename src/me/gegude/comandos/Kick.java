	package me.gegude.comandos;

import me.gegude.FightPvP;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kick implements CommandExecutor {
	
	  public static FightPvP plugin;
	  public Kick(FightPvP kitPvP){
		    plugin = kitPvP;
		  }
	  
	  public boolean onCommand(CommandSender sender, Command command,
				String cmd, String[] args) {
			Player p = (Player) sender;
			if (cmd.equalsIgnoreCase("kick")) {
			      if (p.hasPermission("fight.staff"))
			        if (args.length >= 2) {
			          Player target = p.getServer().getPlayer(args[0]);
			          if (target != null) {
			            if (!target.hasPermission("fight.staff")) {
			              target.kickPlayer(args[1]);
			              Bukkit.broadcastMessage("�6Admin �c" + p.getName() + "�6 kickou �c" + target.getName() + " �6por: �c" + args[1]+args[2]+args[3]);
			            } else {
			              p.sendMessage(ChatColor.DARK_RED + "Erro: " + ChatColor.RED + "Esse jogador nao pode ser kickado.");
			            }
			          }
			          else {
			            p.sendMessage(ChatColor.DARK_RED + "Erro: " + ChatColor.RED + "Jogador inexistente.");
			          }
			        }
			        else {
			          p.sendMessage(ChatColor.DARK_RED + "Erro: " + ChatColor.RED + 
			            "Use /" + cmd + " <jogador> <motivo>");
			        }
			    }
			return false;
		}
}