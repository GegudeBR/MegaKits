package me.gegude.comandos;

import java.util.Arrays;

import me.confuser.barapi.BarAPI;
import me.gegude.FightPvP;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Soup
  implements CommandExecutor
{
  public static FightPvP plugin;

  public Soup(FightPvP kitPvP)
  {
    plugin = kitPvP;
  }

public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
    final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
    ItemMeta sMeta = sopa.getItemMeta();
    sMeta.setDisplayName(ChatColor.YELLOW + "Sopa");
    sMeta.setLore(Arrays.asList(new String[] { "Use para regenerar 3.5 da sua vida!" }));
    sopa.setItemMeta(sMeta);
    final Player player = (Player)sender;

    if (commandLabel.equalsIgnoreCase("soup")) {
      final ItemStack[] inventoryContents = player.getInventory().getContents();
      final ItemStack[] armorContents = player.getInventory().getArmorContents();
      player.getInventory().clear();
      player.getInventory().setArmorContents(null);
      player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 9));
      player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 100, 9));
      plugin.weak.add(player.getName());
      player.playSound(player.getLocation(), Sound.ZOMBIE_WOOD, 10.0F, 1.0F);
      BarAPI.setMessage(player, ChatColor.GOLD + "Resoup em 5 segundos!", 5);
      player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 9));
      player.getInventory().setHelmet(new ItemStack(Material.WOOL, 1 ,(byte) 14));
      player.getInventory().setChestplate(new ItemStack(Material.WOOL, 1 ,(byte) 14));
      player.getInventory().setLeggings(new ItemStack(Material.WOOL, 1 ,(byte) 14));
      player.getInventory().setBoots(new ItemStack(Material.WOOL, 1 ,(byte) 14));
      plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
        public void run() {
          player.getInventory().setArmorContents(armorContents);
          player.getInventory().setContents(inventoryContents);
          plugin.weak.remove(player.getName());
          BarAPI.setMessage(player, ChatColor.GOLD + "Resoup concluido", 1);
          player.playSound(player.getLocation(), Sound.ZOMBIE_WOODBREAK, 10.0F, 1.0F);
          for (int i = 0; i <= 35; i++)
            player.getInventory().addItem(new ItemStack[] { sopa });
        }
      }
      , 100L);
    }
    return false;
  }
}