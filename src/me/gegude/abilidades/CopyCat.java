package me.gegude.abilidades;

import java.util.Arrays;

import me.confuser.barapi.BarAPI;
import me.gegude.FightPvP;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CopyCat implements Listener{

   public static FightPvP plugin;
   public CopyCat(FightPvP kitPvP){
   plugin = kitPvP;
	}
	
   @EventHandler
	public void Copycats(PlayerDeathEvent event) {
		Player p = event.getEntity();
		if (p.getKiller() instanceof Player) {
			Player d = p.getKiller();
			if (plugin.copycat.contains(d.getName())) {
				if (plugin.hg.contains(p.getName())) {
			        ItemStack esdada = new ItemStack(Material.WOOD_SWORD);
			          ItemMeta im = esdada.getItemMeta();
			         im.setLore(Arrays.asList(new String[] { "Fight-dvd 0.4" }));
			          im.setDisplayName(ChatColor.DARK_RED + "HG");
			          esdada.setItemMeta(im);
			            d.playSound(d.getLocation(), Sound.ANVIL_LAND, 
			              10.0F, 9.0F);
			            d.getInventory().addItem(new ItemStack[] { esdada });
			            BarAPI.setMessage(d, ChatColor.GOLD + "Você degou o kit " + ChatColor.DARK_RED + "Hg", 5);
					}
				if (plugin.archer.contains(p.getName())) {
					  ItemStack espada = new ItemStack(Material.WOOD_SWORD);
				        ItemMeta im = espada.getItemMeta();
				      im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
				        im.setDisplayName(ChatColor.DARK_RED + "Archer");
				        espada.setItemMeta(im);
				        ItemStack arco = new ItemStack(Material.BOW);
				        arco.addEnchantment(Enchantment.ARROW_INFINITE, 1);
				        ItemMeta aMeta = arco.getItemMeta();
				        aMeta.setLore(
				          Arrays.asList(new String[] { "Arco usado para distanciar os jogadores!" }));
				        aMeta.setDisplayName(ChatColor.DARK_RED + "Archbow");
				        arco.setItemMeta(aMeta);
				          d.addPotionEffect(
				            new PotionEffect(PotionEffectType.SPEED, 
				            1000000000, 0));
				          d.getInventory().addItem(new ItemStack[] { espada });
				          d.getInventory().addItem(new ItemStack[] { arco });
				          d.getInventory().addItem(
				            new ItemStack[] { new ItemStack(Material.ARROW, 1) });
				          d.getInventory().setChestplate(
				            new ItemStack(Material.LEATHER_CHESTPLATE));
				          BarAPI.setMessage(d, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Archer", 5);
					}
				if (plugin.switcher.contains(p.getName())) {
					 ItemStack espada = new ItemStack(Material.WOOD_SWORD);
				        ItemMeta im = espada.getItemMeta();
				      im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
				        im.setDisplayName(ChatColor.DARK_RED + "Switcher");
				        espada.setItemMeta(im);
				        ItemStack ball = new ItemStack(Material.SNOW_BALL, 64);
				        ItemMeta bMeta = ball.getItemMeta();
				        bMeta.setLore(
				          Arrays.asList(new String[] { "Use para trocar de lugar com os outros!" }));
				        bMeta.setDisplayName(ChatColor.GREEN + "Bolas de Neve do Switcher");
				        ball.setItemMeta(bMeta);
				          d.getInventory().addItem(new ItemStack[] { espada });
				          d.getInventory().addItem(new ItemStack[] { ball });
				          d.getInventory().setChestplate(
				            new ItemStack(Material.LEATHER_CHESTPLATE));
				          BarAPI.setMessage(d, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Switcher", 5);
				        }

					plugin.removeAbilitys(d);
					plugin.copycat.add(d.getName());
				}
			}
		}
}
