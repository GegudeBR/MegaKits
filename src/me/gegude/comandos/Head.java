	package me.gegude.comandos;

import me.gegude.FightPvP;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class Head implements Listener, CommandExecutor {
  
  public static FightPvP plugin;
  public Head(FightPvP kitPvP){
	    plugin = kitPvP;
	  }

  @SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command,String cmd, String[] args) {
		Player p = (Player) sender;
		if(cmd.equalsIgnoreCase("head") && p.isOp()){
			if(args.length == 0){
				p.sendMessage(ChatColor.RED + "/head <jogador>");
				return true;
			}
				ItemStack s = new ItemStack(Material.SKULL_ITEM,1,(byte)3);
				SkullMeta smeta = (SkullMeta) s.getItemMeta();
				smeta.setOwner(args[0]);
				s.setItemMeta(smeta);
				p.getInventory().addItem(s);
				p.updateInventory();

		}
		return false;
	}
}