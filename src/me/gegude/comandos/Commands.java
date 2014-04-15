package me.gegude.comandos;

import java.util.Arrays;

import me.gegude.FightPvP;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Commands implements CommandExecutor {
	
  public static FightPvP plugin;
  public Commands(FightPvP kitPvP){
    plugin = kitPvP;
  }


  public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args){
	    if (!(sender instanceof Player)) {
	        sender.sendMessage(ChatColor.RED + "Voce nao e um jogador!");
	        return false;
	      }
	  
    final Player player = (Player)sender;
    PlayerInventory pi = player.getInventory(); 
    ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
    ItemMeta sMeta = sopa.getItemMeta();
    sMeta.setDisplayName(ChatColor.YELLOW + "Sopa");
    sMeta.setLore(Arrays.asList(new String[] { "Use para regenerar 3.5 da sua vida!" }));
    sopa.setItemMeta(sMeta);
    if (commandLabel.equalsIgnoreCase("suicide")) {
    	player.setHealth(0);
    }
    if (commandLabel.equalsIgnoreCase("day") && player.hasPermission("fight.staff")) {
    	player.getWorld().setTime(0L);
    }
    if (commandLabel.equalsIgnoreCase("feast")) {
    	plugin.removeAbilitys(player);
    	plugin.oneKit.add(player.getName());
    	ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
    	espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
    	player.performCommand("warp feast");
    	plugin.clear(player);
    	pi.addItem(espada);
    	pi.setHelmet(new ItemStack(Material.IRON_HELMET));
		pi.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
		pi.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
		pi.setBoots(new ItemStack(Material.IRON_BOOTS));	
    	 for(int i = 0; i < 35; i++){
		      pi.addItem(sopa);
		  }
    }
    if (commandLabel.equalsIgnoreCase("main")) {
    	plugin.removeAbilitys(player);
    	plugin.oneKit.add(player.getName());
    	ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
    	espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
    	player.performCommand("warp main");
    	plugin.clear(player);
    	pi.addItem(espada);
    	pi.setHelmet(new ItemStack(Material.IRON_HELMET));
		pi.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
		pi.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
		pi.setBoots(new ItemStack(Material.IRON_BOOTS));	
		player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0));
		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0));
    	 for(int i = 0; i < 35; i++){
		      pi.addItem(sopa);
		  }
    }
    if (commandLabel.equalsIgnoreCase("pots")) {
    	plugin.removeAbilitys(player);
    	plugin.oneKit.add(player.getName());
    	ItemStack pot = new ItemStack(Material.POTION, 1,(short)16421);
    	ItemMeta potm = pot.getItemMeta();
    	potm.setDisplayName("§ePotion");
    	pot.setItemMeta(potm);
    	ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
    	ItemStack helm = new ItemStack(Material.DIAMOND_HELMET);
    	ItemStack chest = new ItemStack(Material.DIAMOND_CHESTPLATE);
    	ItemStack leg = new ItemStack(Material.DIAMOND_LEGGINGS);
    	ItemStack bot = new ItemStack(Material.DIAMOND_BOOTS);
    	helm.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
    	chest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
    	leg.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
    	bot.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
    	espada.addEnchantment(Enchantment.DAMAGE_ALL, 5);
    	espada.addEnchantment(Enchantment.FIRE_ASPECT, 2);
    	player.performCommand("warp pots");
    	plugin.clear(player);
    	pi.addItem(espada);
    	pi.setHelmet(helm);
		pi.setChestplate(chest);
		pi.setLeggings(leg);
		pi.setBoots(bot);	
		player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0));
		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0));
    	 for(int i = 0; i < 35; i++){
		      pi.addItem(pot);
		  }
    }
    return false;
  }
  
 }