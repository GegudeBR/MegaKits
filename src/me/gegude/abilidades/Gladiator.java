package me.gegude.abilidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import me.gegude.FightPvP;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class Gladiator implements Listener{

   public static FightPvP plugin;
   public Gladiator(FightPvP kitpvp){
   plugin = kitpvp;
	}
	
 ArrayList<String> inPvP = new ArrayList<String>();
 public Map<String, Location> local = new HashMap<String, Location>();
 
 @SuppressWarnings("deprecation")
@EventHandler
 public void place(BlockPlaceEvent e) {
   Player p = e.getPlayer();

   ItemStack glad = new ItemStack(Material.IRON_FENCE);
   ItemMeta m = glad.getItemMeta();
   m.setDisplayName("§6Use para ir 1v1!");
   glad.setItemMeta(m);

   if ((p.getItemInHand().equals(glad)) && (plugin.gladiator.contains(p.getName()))) {
     e.setCancelled(true);
     p.updateInventory();
   }
 }
 
 @EventHandler
 public void death(PlayerDeathEvent e) {
   if ((e.getEntity() instanceof Player)) {
     Player p = e.getEntity();
     if ((p.getKiller() instanceof Player)) {
       Player killer = p.getKiller();
       if (this.inPvP.contains(p.getName())) {
         this.inPvP.remove(p.getName());
         if (this.inPvP.contains(killer.getName()))
           this.inPvP.remove(killer.getName());
       }
     }
   }
 }

 @EventHandler(priority=EventPriority.HIGHEST)
 public void block(PlayerInteractEvent e) {
   Player p = e.getPlayer();
   if ((e.getAction() == Action.LEFT_CLICK_BLOCK) && (this.inPvP.contains(p.getName())) && (e.getClickedBlock().getType() == Material.GLASS)) {
     final Block b = e.getClickedBlock();
     b.setType(Material.BEDROCK);
 	  plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
		public void run() {
		   if(b.getType() == Material.AIR) {
			 b.setType(Material.AIR);
		   } else {
		   b.setType(Material.GLASS);
		  }
		}
	}, 20L);
   }
 }
 @EventHandler
 public void quebrar(BlockBreakEvent e) {
	 if(e.getBlock().getType() == Material.GLASS && this.inPvP.contains(e.getPlayer().getName())) {
		 e.setCancelled(true);
	 }
 }
 
 @EventHandler
 public void removeOnTp(PlayerTeleportEvent e) {
   Player player = e.getPlayer();
   if (this.inPvP.contains(player.getName()))
     this.inPvP.remove(player.getName());
 }

 @EventHandler
 public void PlayerInteractEntityEvent(PlayerInteractEntityEvent event) {
   final Player pessoa1 = event.getPlayer();

   ItemStack glad = new ItemStack(Material.IRON_FENCE);
   ItemMeta fim = glad.getItemMeta();
   fim.setDisplayName(ChatColor.GOLD + "Use para ir 1v1!");
   glad.setItemMeta(fim);

   if ((plugin.gladiator.contains(pessoa1.getName())) && (pessoa1.getItemInHand().equals(glad))) {
     final Player pessoa2 = (Player)event.getRightClicked();
     Location pLoc = pessoa1.getLocation();

     if ((!this.inPvP.contains(pessoa1.getName())) && (!this.inPvP.contains(pessoa2.getName()))) {
       this.local.put(pessoa1.getName(), pLoc);
       this.local.put(pessoa2.getName(), pessoa2.getLocation());

       Location GladLoc = pessoa1.getLocation();
       final Location GladFence = new Location(pessoa1.getWorld(), GladLoc.getBlockX(), GladLoc.getWorld().getHighestBlockYAt(GladLoc) + 80, GladLoc.getBlockZ());

       generateArena(GladFence, pessoa2, pessoa1);
       pessoa1.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 120 , 1));
       pessoa2.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 120 , 1));
       new BukkitRunnable() {
         int tempo = 120;

         public void run() { this.tempo -= 1;

           if (!Gladiator.this.inPvP.contains(pessoa1.getName())) {
             Gladiator.this.inPvP.add(pessoa1.getName());
           }
           if (!Gladiator.this.inPvP.contains(pessoa2.getName())) {
             Gladiator.this.inPvP.add(pessoa2.getName());
           }
           if ((pessoa1.isDead()) || (pessoa2.isDead()) || (!pessoa1.isOnline()) || (!pessoa2.isOnline()) || 
             (!Gladiator.this.inPvP.contains(pessoa1.getName())) || (!Gladiator.this.inPvP.contains(pessoa2.getName()))) {
             Gladiator.this.inPvP.remove(pessoa1.getName());
             Gladiator.this.inPvP.remove(pessoa2.getName());

             Gladiator.this.clearArena(GladFence);

             cancel();

             if (pessoa1.isOnline()) {
               pessoa1.teleport((Location)Gladiator.this.local.get(pessoa1.getName()));
               Gladiator.this.local.remove(pessoa1.getName());
               if (pessoa1.hasPotionEffect(PotionEffectType.WITHER)) {
                 pessoa1.removePotionEffect(PotionEffectType.WITHER);
               }
             }

             if (pessoa2.isOnline()) {
               pessoa2.teleport((Location)Gladiator.this.local.get(pessoa2.getName()));
               Gladiator.this.local.remove(pessoa2.getName());
               if (pessoa2.hasPotionEffect(PotionEffectType.WITHER))
                 pessoa2.removePotionEffect(PotionEffectType.WITHER);
             }
           }
           else
           {
             if (this.tempo == 60)
             {
               if ((!pessoa1.isDead()) && (pessoa1.isOnline()) && (Gladiator.this.inPvP.contains(pessoa1.getName()))) {
                 pessoa1.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 999999, 4));
               }
               if ((!pessoa2.isDead()) && (pessoa2.isOnline()) && (Gladiator.this.inPvP.contains(pessoa2.getName()))) {
                 pessoa2.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 999999, 4));
               }
             }
             if (this.tempo == 0)
             {
               Gladiator.this.inPvP.remove(pessoa1.getName());
               Gladiator.this.inPvP.remove(pessoa2.getName());

               Gladiator.this.clearArena(GladFence);

               cancel();

               if ((!pessoa1.isDead()) && (pessoa1.isOnline())) {
                 pessoa1.teleport((Location)Gladiator.this.local.get(pessoa1.getName()));

                 if (pessoa1.hasPotionEffect(PotionEffectType.WITHER)) {
                   pessoa1.removePotionEffect(PotionEffectType.WITHER);
                 }
                 Gladiator.this.local.remove(pessoa2);
               }

               if ((!pessoa2.isDead()) && (pessoa2.isOnline())) {
                 pessoa2.teleport((Location)Gladiator.this.local.get(pessoa2.getName()));

                 if (pessoa2.hasPotionEffect(PotionEffectType.WITHER)) {
                   pessoa2.removePotionEffect(PotionEffectType.WITHER);
                 }
                 Gladiator.this.local.remove(pessoa2);
               }
             }
           }
         }
       }
       .runTaskTimer(plugin, 0L, 20L);
       } 
     } else {
     return;
   }
 }

 public void clearArena(Location loc) {
	    int x = 0;
	    int y = 0;
	    int z = 0;
	    for (x = -7; x < 7; x++){
	      for (z = -7; z < 7; z++) {
	        for (y = 0; y < 7; y++) {
	          Block b = loc.clone().add(x, 0.0D, z).getBlock();
	          Block b2 = loc.clone().add(x, 7.0D, z).getBlock();
	          Block b3 = loc.clone().add(-7.0D, y, z).getBlock();
	          Block b4 = loc.clone().add(x, y, -7.0D).getBlock();
	          Block b5 = loc.clone().add(x, y, 7.0D).getBlock();
	          Block b6 = loc.clone().add(7.0D, y, z).getBlock();

	          b.setType(Material.AIR);
	          b2.setType(Material.AIR);
	          b3.setType(Material.AIR);
	          b4.setType(Material.AIR);
	          b5.setType(Material.AIR);
	          b6.setType(Material.AIR);
	        }
	      }
	    }
	  }

 public void generateArena(Location loc, Player gladiator, Player target) {
   int x = 0;
   int y = 0;
   int z = 0;
   for (x = -7; x < 7; x++) {
	      for (z = -7; z < 7; z++) {
	        for (y = 0; y < 7; y++) {
	          Block b = loc.clone().add(x, 0.0D, z).getBlock();
	          Block b2 = loc.clone().add(x, 7.0D, z).getBlock();
	          Block b3 = loc.clone().add(-7.0D, y, z).getBlock();
	          Block b4 = loc.clone().add(x, y, -7.0D).getBlock();
	          Block b5 = loc.clone().add(x, y, 7.0D).getBlock();
	          Block b6 = loc.clone().add(7.0D, y, z).getBlock();

	          b.setType(Material.GLASS);
	          b2.setType(Material.GLASS);
	          b3.setType(Material.GLASS);
	          b4.setType(Material.GLASS);
	          b5.setType(Material.GLASS);
	          b6.setType(Material.GLASS);
	        }
	      }
	    }

   gladiator.teleport(loc.clone().add(x - 1, y - 2, -4.0D));
   target.teleport(loc.clone().add(-4.0D, y - 4, z - 1));
 }
 
}
