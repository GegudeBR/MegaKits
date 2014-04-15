	package me.gegude.comandos;

import java.util.ArrayList;

import me.gegude.FightPvP;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Admin implements Listener, CommandExecutor {
	
  public ArrayList<String> admin = new ArrayList<String>();
  
  public static FightPvP plugin;
  public Admin(FightPvP kitPvP){
	    plugin = kitPvP;
	  }

public boolean onCommand(CommandSender sender, Command cmd, String tag, String[] args) {
    Player p = (Player) sender;
    if (!(sender instanceof Player)) {
        sender.sendMessage(ChatColor.RED + "Voce nao e um jogador!");
        return false;
      }
	ItemStack inv = new ItemStack(Material.WOOD_HOE);
	ItemMeta inv2 = inv.getItemMeta();
	inv2.setDisplayName("§6Olhar Inventario");
	inv.setItemMeta(inv2);
    if (cmd.getName().equalsIgnoreCase("admin") && (p.hasPermission("fight.staff"))) {
      if (admin.contains(p.getName())) {
        p.sendMessage(ChatColor.AQUA + "Você saio do Modo ADMIN!");
      	p.setGameMode(GameMode.SURVIVAL);
      	plugin.clear(p);
        admin.remove(p.getName());
        for (Player s : Bukkit.getOnlinePlayers()) {
              s.showPlayer(p);
          }
      }
      else if (!admin.contains(p.getName())) {  
    	plugin.clear(p);
    	p.setGameMode(GameMode.CREATIVE);
        p.sendMessage(ChatColor.AQUA + "Você entrou no Modo ADMIN!");
        admin.add(p.getName());
    	p.getInventory().addItem(new ItemStack[] { inv });
        for (Player s : Bukkit.getOnlinePlayers()) {
            if (!s.hasPermission("pvp.admin")) {
              s.hidePlayer(p);
            }
           }
      }
    }
	return false;
   }
  @EventHandler
  public void join(PlayerJoinEvent event) {
	  Player p = event.getPlayer();
	  admin.remove(p.getName()); 
	   for (Player s : Bukkit.getOnlinePlayers()) {
		   s.showPlayer(p);
	   }
	  }
}