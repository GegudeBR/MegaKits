package me.gegude.listeners;

import java.util.ArrayList;
import java.util.List;

import me.confuser.barapi.BarAPI;
import me.gegude.FightPvP;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class PlayerListener2 implements Listener {
	
  public static FightPvP plugin;
  public PlayerListener2(FightPvP kitPvP){
	    plugin = kitPvP;
	  }
  protected ArrayList<String> nofalldamage = new ArrayList<String>();
  
  @EventHandler
  public void onPlayerEndermage(PlayerInteractEvent e){
    final Player p = e.getPlayer();
    if (plugin.endermage.contains(p.getName())) {
      if((e.getPlayer().getItemInHand().getType().equals(Material.PORTAL) && (e.getAction() == Action.RIGHT_CLICK_BLOCK) && (e.getClickedBlock() != null))) {
      e.setCancelled(true);
      Material item = e.getItem().getType();
      Location placed = e.getClickedBlock().getLocation().add(0.0D, 1.0D, 0.0D);
      if (plugin.cooldownmage.contains(p.getName())) {
        p.sendMessage(ChatColor.RED + "Você esta em cooldown!");
      }
      else if (item == Material.PORTAL) {
        List<Entity> nearby = p.getNearbyEntities(1.0D, 256.0D, 1.0D);
        for (final Entity ent : nearby) {
          if ((ent instanceof Player)) {
            ((Player)ent).teleport(placed);
        if (nearby.size() >= 1) {
          plugin.cooldownmage.add(p.getName());
          plugin.endermageProtec.add(p.getName());
          plugin.endermageProtec.add(((Player) ent).getName());
          p.teleport(placed);
          BarAPI.setMessage((Player) ent, "§aPUXADO!", 5);
          BarAPI.setMessage(p, "§aVocê puxou alguem!", 5);
          p.sendMessage("§cVoce tem 5 segundos de invencibilidade!");
          ((Player) ent).sendMessage("§cVoce tem 5 segundos de invencibilidade!");
          plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {  	  
              public void run() {
             plugin.endermageProtec.remove(p.getName());
             plugin.endermageProtec.remove(((Player) ent).getName());
             plugin.cooldownmage.remove(p.getName());
              }}, 20 * 5);
             }  	
           }
          }
        }
       }
     }
    }
  @EventHandler
  public void onEndermageProtec(EntityDamageByEntityEvent e) {
	  Player p = (Player) e.getEntity();
	  if(plugin.endermageProtec.contains(p.getName())) {
		  e.setCancelled(true);
	   }
	  }
  
	@EventHandler
	  public void onEntityDamage(EntityDamageEvent event) {
	    if ((event.getEntity() instanceof Player)) {
	      Player player = (Player)event.getEntity();

	      if ((nofalldamage.contains(player.getName())) && 
	        (event.getCause().equals(EntityDamageEvent.DamageCause.FALL))) {
	        event.setCancelled(true);
	        nofalldamage.remove(player.getName());
	      }
	    }
	  }
	@SuppressWarnings("deprecation")
	@EventHandler(priority=EventPriority.NORMAL)
	  public void onPlayerThor(PlayerInteractEvent e){
		if (e.getPlayer() instanceof Player) {
		final Player p = (Player) e.getPlayer();
	    if (plugin.thor.contains(p.getName())) {
	      if((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) &&
	        (p.getItemInHand().getType() == Material.WOOD_AXE)) { 
	        if (plugin.thorcd.contains(p.getName())){
	          p.sendMessage(ChatColor.RED + "Você esta em cooldown");
	        } else {
	        	
			  Location loc = p.getTargetBlock(null, 20).getLocation();
	          p.getWorld().strikeLightning(loc);
	          plugin.thorcd.add(p.getName());
	          plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
	            public void run() {
	            	plugin.thorcd.remove(p.getName());
	            }
	         }, 20 * 5);
	        }
	      }
	     }
	   }
	  }
		@EventHandler
		public void onThor(EntityDamageEvent e) {
			if (e.getEntity() instanceof Player) {
				Player p = (Player) e.getEntity();
				if (plugin.thor.contains(p.getName())) {
				    if (e.getCause() == DamageCause.LIGHTNING) {
					    e.setCancelled(true);
				} 
				}
			}
		}
	@EventHandler
	  public void onPlayerMove(PlayerMoveEvent event){
	    Player player = event.getPlayer();
	    Location standBlock = player.getWorld().getBlockAt(player.getLocation().add(0.0D, -0.01D, 0.0D)).getLocation();
	    if (standBlock.getBlock().getType() == Material.SPONGE) {
	      int xblock = 0;
	      double xvel = 0.0D;
	      int yblock = -1;
	      double yvel = 0.0D;
	      int zblock = 0;
	      double zvel = 0.0D;
	      while (standBlock.getBlock().getLocation()
	        .add(xblock - 1, -1.0D, 0.0D).getBlock().getType() == Material.SPONGE) {
	        xblock--;
	        xvel += 1.0D;
	      }
	      while (standBlock.getBlock().getLocation().add(0.0D, yblock, 0.0D).getBlock().getType() == Material.SPONGE) {
	        yblock--;
	        yvel += 0.7D;
	      }
	      while (standBlock.getBlock().getLocation()
	        .add(0.0D, -1.0D, zblock - 1).getBlock().getType() == Material.SPONGE) {
	        zblock--;
	        zvel += 1.0D;
	      }
	      xblock = 0;
	      zblock = 0;
	      while (standBlock.getBlock().getLocation()
	        .add(xblock + 1, -1.0D, 0.0D).getBlock().getType() == Material.SPONGE) {
	        xblock++;
	        xvel -= 1.0D;
	      }
	      while (standBlock.getBlock().getLocation()
	        .add(0.0D, -1.0D, zblock + 1).getBlock().getType() == Material.SPONGE) {
	        zblock++;
	        zvel -= 1.0D;
	      }
	      if ((xvel != 0.0D) || (yvel != 0.0D) || (zvel != 0.0D)) {
	        player.setVelocity(new Vector(xvel, yvel, zvel));
	        player.playSound(player.getLocation(), Sound.ENDERDRAGON_HIT, 5.0F, -5.0F);
	        if (!nofalldamage.contains(player.getName())) {
	            nofalldamage.add(player.getName());
	        }
	      }
	    }
	  } 
	@EventHandler
    public void onEntityExplode(EntityExplodeEvent e){
        if(e.blockList().size() > 0){
            e.blockList().clear();
        }
    }
	 @EventHandler
	   public void onDeath(PlayerDeathEvent event) {
	     Player p = event.getEntity();
	          if ((p.getKiller() instanceof Player)) {
	             Player k = p.getKiller();
	     Location l = k.getLocation();
	     Location lp = p.getLocation();
	     p.sendMessage(ChatColor.RED + "Voce foi morto por: " + ChatColor.DARK_RED + ChatColor.BOLD + k.getName());
	     k.sendMessage(ChatColor.GREEN + "Voce matou: " + ChatColor.DARK_GREEN + ChatColor.BOLD + p.getName());
	     k.playSound(l, Sound.ANVIL_LAND, 10.0F, 1.0F);
	     p.playSound(lp, Sound.IRONGOLEM_DEATH, 10.0F, 1.0F);     
	     }
	   }
	  @EventHandler(priority=EventPriority.HIGHEST)
	  public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
		  if(!event.getPlayer().hasPermission("noplugins.view")) {
	    if ((event.getMessage().toLowerCase().startsWith("/plugins")) || (event.getMessage().toLowerCase().startsWith("/pl ")) || (event.getMessage().toLowerCase().equals("/pl")) || (event.getMessage().toLowerCase().startsWith("/ver")) || (event.getMessage().toLowerCase().startsWith("/gc")) || (event.getMessage().toLowerCase().startsWith("/version") || (event.getMessage().toLowerCase().startsWith("/?")) || (event.getMessage().toLowerCase().equals("/help")))) {
	    event.setCancelled(true);
	    event.getPlayer().sendMessage("§fPlugins (6): §aBuyCraft§f, §aFight-Kits§f, §aFight-1v1§f, §aFight-Score§f, §aFight-Libs§f, §aPermissionsEx");
	     }
	    }
		  if ((event.getMessage().toLowerCase().startsWith("/me ") || event.getMessage().toLowerCase().startsWith("/me"))) {
			  event.setCancelled(true);
	  }
	 }
	  @EventHandler
	  public void onPlayerPoseidon(PlayerMoveEvent e) {  
		Player p = (Player)e.getPlayer();
		if(plugin.salamander.contains(p.getName())){
			if(p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.LAVA || p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.STATIONARY_LAVA || p.getLocation().getBlock().getRelative(BlockFace.WEST).getType() == Material.STATIONARY_LAVA || p.getLocation().getBlock().getRelative(BlockFace.WEST).getType() == Material.LAVA || p.getLocation().getBlock().getRelative(BlockFace.EAST).getType() == Material.STATIONARY_LAVA || p.getLocation().getBlock().getRelative(BlockFace.EAST).getType() == Material.LAVA || p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.FIRE) {
				p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
				p.removePotionEffect(PotionEffectType.SPEED);
				p.removePotionEffect(PotionEffectType.WEAKNESS);
				p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
				p.removePotionEffect(PotionEffectType.SLOW);
				
				p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 120, 0));
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 120, 1));
			}
			if(p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.WATER || p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.STATIONARY_WATER || p.getLocation().getBlock().getRelative(BlockFace.WEST).getType() == Material.STATIONARY_WATER || p.getLocation().getBlock().getRelative(BlockFace.WEST).getType() == Material.WATER || p.getLocation().getBlock().getRelative(BlockFace.EAST).getType() == Material.WATER || p.getLocation().getBlock().getRelative(BlockFace.EAST).getType() == Material.STATIONARY_WATER) {
				p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
				p.removePotionEffect(PotionEffectType.SPEED);
				p.removePotionEffect(PotionEffectType.WEAKNESS);
				p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
				p.removePotionEffect(PotionEffectType.SLOW);
				
				p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 120, 1));
				p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 120, 0));
				p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 120, 0));
			}
		}
	}
	@EventHandler
	public void onSalamander(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (plugin.salamander.contains(p.getName())) {
			    if (e.getCause() == DamageCause.LAVA || e.getCause() == DamageCause.FIRE || e.getCause() == DamageCause.FIRE_TICK) {
				    e.setCancelled(true);
			} 
			}
		}
 }
	 @EventHandler
		public void onLogin(PlayerLoginEvent event){
			if(event.getResult().equals(PlayerLoginEvent.Result.KICK_FULL)){
				if(event.getPlayer().isOp() || event.getPlayer().hasPermission("fight.vip") || event.getPlayer().hasPermission("fight.staff")){
					event.allow();
				}else{
					event.setKickMessage(ChatColor.RED + "Server cheio! " + ChatColor.GOLD + "Compre vip para entrar com o servidor cheio!");
				}
			}
			if(event.getResult().equals(PlayerLoginEvent.Result.KICK_WHITELIST)) {
				event.getPlayer().sendMessage("§cServidor em Manutençao!");
			}

		}
	 
	 @EventHandler
	 public void onPlayerBreack(BlockBreakEvent e) {
		 Player player = e.getPlayer();
		 if(!player.hasPermission("mod.construct")) {
			 e.setCancelled(true);
		 }
	 }
	 @EventHandler
	 public void onPlayerPutBlock(BlockPlaceEvent e) {
		 Player player = e.getPlayer();
		 if(!player.hasPermission("mod.construct")) {
			 e.setCancelled(true);
		 }
	 }
	 @EventHandler
		public void onInvsee(PlayerInteractEntityEvent event){
			if(event.getRightClicked() instanceof Player){
				if(event.getPlayer().getItemInHand().getType().equals(Material.WOOD_HOE) && event.getPlayer().hasPermission("fight.staff")){
				Player d = (Player)event.getRightClicked();
				event.getPlayer().openInventory(d.getInventory());
				event.getPlayer().sendMessage("§6Voce esta vendo o inventario de: " + ChatColor.RED + d.getName());
			}
			}
		}

	 
}