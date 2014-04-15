package me.gegude.listeners;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import me.confuser.barapi.BarAPI;
import me.gegude.FightPvP;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
import org.bukkit.util.Vector;

public class PlayerListener implements Listener {
	
  public static FightPvP plugin;
  public static ItemStack[] armorContents;
  public static ItemStack[] inventoryContents;
  public boolean changeStomperFallDamage = true;
  public boolean reduceStompDamageByDistance = true;
  public boolean stomperBlocksFall = false;
  public int stomperFallDamage = 8;

  public PlayerListener(FightPvP kitPvP){
    plugin = kitPvP;
  }

  @EventHandler
  public void creature(CreatureSpawnEvent event) {
    event.setCancelled(true);
  }
  
  @EventHandler
  public void lifeline(EntityDamageByEntityEvent event) {
    if (!(event.getEntity() instanceof Player))
      return;
    if (!(event.getDamager() instanceof Player))
      return;
    Player p = (Player)event.getEntity();
    Player d = (Player)event.getDamager();
    if ((plugin.lifeline.contains(d.getName())) && 
      (d.getItemInHand().getType() == Material.STRING)) {
      event.setCancelled(true);
      p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 60, 0));
      d.addPotionEffect(
        new PotionEffect(PotionEffectType.REGENERATION, 60, 0));
    }
  }
	@SuppressWarnings("deprecation")
	@EventHandler
    public void onPlayerPhantom(PlayerInteractEvent event) {
		   final Player p = event.getPlayer();
		   final PlayerInventory pi = p.getInventory();
		   final ItemStack[] armorContents = p.getInventory().getArmorContents();
		   ItemStack item = event.getPlayer().getItemInHand();
		   if ((plugin.phantom.contains(event.getPlayer().getName())) && (item.getTypeId() == Material.FEATHER.getId())) {
			      long lastUsed = 0L;
			      if (plugin.phantomItem.containsKey(item)) {
			        lastUsed = ((Long)plugin.phantomItem.get(item)).longValue();
			      }
			      if (lastUsed + 1000 * plugin.cooldownPhantom > System.currentTimeMillis()) {
			        event.getPlayer().sendMessage(String.format(plugin.phantomCooldownMessage, 
			          new Object[] { Long.valueOf(-((System.currentTimeMillis() - (lastUsed + 1000 * plugin.cooldownPhantom)) / 1000L)) }));
			      } 
			      else {
			    	       BarAPI.setMessage(p, ChatColor.RED + "Você pode voar por 5 segundos!", 5);
			   	           plugin.phantomItem.put(item, Long.valueOf(System.currentTimeMillis()));
        				   p.setAllowFlight(true);
        				   p.setFlying(true);
        				   pi.setArmorContents(null);
        				   pi.setHelmet(new ItemStack(Material.LEATHER_HELMET));
        				   pi.setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
        				   pi.setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
        				   pi.setBoots(new ItemStack(Material.LEATHER_BOOTS));
        				   p.playSound(p.getLocation(), Sound.WITHER_DEATH, 5.0F, 1.0F);
        				   plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
        					   public void run(){
        						   PlayerInventory pi = p.getInventory();
        						   p.setAllowFlight(false);
        						   p.setFlying(false);
        						   pi.setArmorContents(null);
        						   pi.setArmorContents(armorContents);
        						   BarAPI.setMessage(p, ChatColor.RED + "Você nao pode mais voar", 3);
                				   p.playSound(p.getLocation(), Sound.WITHER_SPAWN, 5.0F, 1.0F);
        					   }
        				   }
        				   , 20 * 5);
           }
    }
}
  @SuppressWarnings("deprecation")
@EventHandler
  public void monk(PlayerInteractEntityEvent event)
  {
    ItemStack item = event.getPlayer().getItemInHand();
    if ((plugin.monk.contains(event.getPlayer().getName())) && ((event.getRightClicked() instanceof Player)) && (item.getTypeId() == plugin.monkItemId)) {
      long lastUsed = 0L;
      if (plugin.monkStaff.containsKey(item)) {
        lastUsed = ((Long)plugin.monkStaff.get(item)).longValue();
      }
      if (lastUsed + 1000 * plugin.cooldownMonk > System.currentTimeMillis()) {
        event.getPlayer().sendMessage(String.format(plugin.monkCooldownMessage, 
          new Object[] { 
         Long.valueOf(-((System.currentTimeMillis() - (lastUsed + 1000 * plugin.cooldownMonk)) / 1000L)) }));
      } else {
        PlayerInventory inv = ((Player)event.getRightClicked()).getInventory();
        int slot = new Random().nextInt(plugin.sendThroughInventory ? 36 : 9);
        ItemStack replaced = inv.getItemInHand();
        if (replaced == null)
          replaced = new ItemStack(0);
        ItemStack replacer = inv.getItem(slot);
        if (replacer == null)
          replacer = new ItemStack(0);
        inv.setItemInHand(replacer);
        inv.setItem(slot, replaced);
        plugin.monkStaff.put(item, Long.valueOf(System.currentTimeMillis()));
        event.getPlayer().sendMessage(plugin.monkedMessage);
      }
    }
  }

  @SuppressWarnings("deprecation")
@EventHandler
  public void onPush(final PlayerInteractEvent event){
	ItemStack vacuum = new ItemStack(Material.ENDER_PEARL);
    ItemMeta im2 = vacuum.getItemMeta();
    im2.setDisplayName(ChatColor.WHITE+ "Black Hole");
    vacuum.setItemMeta(im2);
	if (plugin.vacuum.contains(event.getPlayer().getName()) && event.getPlayer().getItemInHand().equals(vacuum)) {
		if(plugin.cooldownvacuum.contains(event.getPlayer().getName())) {  
		        event.setCancelled(true);
		        event.getPlayer().updateInventory();
	 	     } else {
		      event.setCancelled(true);
		      event.getPlayer().updateInventory();
		      List<Entity> ent = event.getPlayer().getNearbyEntities(10.0D, 20.0D, 10.0D);
		      plugin.cooldownvacuum.add(event.getPlayer().getName());
		      plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
		  		public void run() {
		  		  plugin.cooldownvacuum.remove(event.getPlayer().getName());
		  		}
		  	}, 40L);
		      for (Entity en : ent)
		        pullEntityToLocation(en, event.getPlayer().getLocation());
		    }
		  }
      }
  public static void pullEntityToLocation(Entity e, Location loc) {
	    Location entityLoc = e.getLocation();

	    entityLoc.setY(entityLoc.getY() + 0.5D);
	    e.teleport(entityLoc);

	    double g = -0.08D;
	    double d = loc.distance(entityLoc);
	    double t = d;
	    double v_x = (1.0D + 0.07000000000000001D * t) * (loc.getX() - entityLoc.getX()) / t;
	    double v_y = (1.0D + 0.03D * t) * (loc.getY() - entityLoc.getY()) / t - 0.5D * g * t;
	    double v_z = (1.0D + 0.07000000000000001D * t) * (loc.getZ() - entityLoc.getZ()) / t;

	    Vector v = e.getVelocity();
	    v.setX(v_x);
	    v.setY(v_y);
	    v.setZ(v_z);
	    e.setVelocity(v);
	  }
  @EventHandler
  public void anchor_continue(EntityDamageByEntityEvent event){
    if (event.getCause() != EntityDamageEvent.DamageCause.ENTITY_ATTACK)
      return;
    if (!(event.getEntity() instanceof Player))
      return;
    if (!(event.getDamager() instanceof Player))
      return;
    double damage = event.getDamage();
    Player p = (Player)event.getDamager();
    if (!plugin.anchor.contains(p.getName()))
      return;
    event.setCancelled(true);
    ((Player)event.getEntity()).damage(damage);
    p.getWorld().playSound(p.getLocation(), Sound.ANVIL_LAND, 1.0F, 1.0F);
  }

  @EventHandler
  public void anchor(EntityDamageByEntityEvent event) {
    if (event.getCause() != EntityDamageEvent.DamageCause.ENTITY_ATTACK)
      return;
    if (!(event.getEntity() instanceof Player))
      return;
    if (!(event.getDamager() instanceof Player))
      return;
    double damage = event.getDamage();
    Player p = (Player)event.getEntity();
    if (!plugin.anchor.contains(p.getName()))
      return;
    event.setCancelled(true);
    p.damage(damage);
    p.getWorld().playSound(p.getLocation(), Sound.ANVIL_LAND, 10.0F, 1.0F);
  }
  @EventHandler
  public void commandPreProcess(PlayerCommandPreprocessEvent event) {
    String message = event.getMessage();
    if (message.equalsIgnoreCase("/rdm"))
      if (!plugin.oneKit.contains(event.getPlayer().getName()))
        event.getPlayer().performCommand("pvp");
      else
        event.getPlayer().sendMessage(ChatColor.RED + "Voce ja escolheu um kit. Digite /suicide para ir ao RDM.");
  }

  @EventHandler
  public void specialistDeath(PlayerDeathEvent event)
  {
    if (event.getEntity().getKiller() == null)
      return;
    if (!(event.getEntity() instanceof Player))
      return;
    if (!(event.getEntity().getKiller() instanceof Player))
      return;
    Player k = event.getEntity().getKiller();
    if (plugin.specialist.contains(k.getName()))
      k.getInventory().addItem(new ItemStack[] { new ItemStack(Material.EXP_BOTTLE, 1) });
  }
  @SuppressWarnings("deprecation")
  @EventHandler
    public void onPlayerKangaroo(PlayerInteractEvent event) {
      final Player p = event.getPlayer();
      if (((event.getAction() == Action.LEFT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK) || (event.getAction() == Action.LEFT_CLICK_AIR) || (event.getAction() != Action.RIGHT_CLICK_BLOCK)) && (plugin.kangaroo.contains(p.getName())) && (p.getItemInHand().getType() == Material.FIREWORK)) {
        event.setCancelled(true);
        if (p.isOnGround()) {
          if (!p.isSneaking()) {
            Vector vector = p.getEyeLocation().getDirection();
            vector.multiply(0.28F);
            vector.setY(0.9F);
            p.setVelocity(vector);
            if (plugin.kangaroodj.contains(p.getName()))
              Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, 
                new Runnable() {
                public void run() {
                  plugin.kangaroodj.remove(p.getName());
                } } );
          }
          else if (p.isSneaking()) {
            Vector vector = p.getEyeLocation().getDirection();
            vector.multiply(0.28F);
            vector.setY(0.65F);
            p.setVelocity(vector);
            if (plugin.kangaroodj.contains(p.getName()))
              Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, 
                new Runnable() {
                public void run() {
                 plugin.kangaroodj.remove(p.getName());
                }
              });
          }
        }
        else if (!plugin.kangaroodj.contains(p.getName()))
          if (!p.isSneaking()) {
            Vector vector = p.getEyeLocation().getDirection();
            vector.multiply(0.28F);
            vector.setY(0.85F);
            p.setVelocity(vector);
            plugin.kangaroodj.add(p.getName());
          } else if (p.isSneaking()) {
            Vector vector = p.getEyeLocation().getDirection();
            vector.multiply(1.5F);
            vector.setY(0.65F);
            p.setVelocity(vector);
            plugin.kangaroodj.add(p.getName());
          }
      }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event){
      Player p = event.getPlayer();
      if (plugin.kanga.contains(p)) {
        Block b = p.getLocation().getBlock();
        if ((b.getType() != Material.AIR) || (b.getRelative(BlockFace.DOWN).getType() != Material.AIR))
        	plugin.kanga.remove(p);
      }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event){
      Entity e = event.getEntity();
      if ((e instanceof Player)) {
        Player player = (Player)e;
        if (((event.getEntity() instanceof Player)) && (event.getCause() == EntityDamageEvent.DamageCause.FALL) && (plugin.kangaroo.contains(player.getName())) && (event.getDamage() >= 8.0D))
          event.setDamage(8.0D);
      }
    }

    @EventHandler(priority=EventPriority.NORMAL)
    public void onPlayerKangarooMove(PlayerMoveEvent event) {
      Player p = event.getPlayer();
      Block b = p.getLocation().getBlock();
      if (((b.getType() != Material.AIR) || 
        (b.getRelative(BlockFace.DOWN).getType() != Material.AIR)) && 
        (plugin.kangaroodj.contains(p.getName())))
    	  plugin.kangaroodj.remove(p.getName());
    }

    @EventHandler
	  public void onPlayerPoseidon(PlayerMoveEvent e) {  
		Player p = (Player)e.getPlayer();
		if(plugin.poseidon.contains(p.getName())){
			if(p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.WATER || p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.STATIONARY_WATER || p.getLocation().getBlock().getRelative(BlockFace.WEST).getType() == Material.STATIONARY_WATER || p.getLocation().getBlock().getRelative(BlockFace.WEST).getType() == Material.WATER || p.getLocation().getBlock().getRelative(BlockFace.EAST).getType() == Material.STATIONARY_WATER || p.getLocation().getBlock().getRelative(BlockFace.EAST).getType() == Material.WATER) {
				p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
				p.removePotionEffect(PotionEffectType.SPEED);
				p.removePotionEffect(PotionEffectType.WEAKNESS);
				p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
				p.removePotionEffect(PotionEffectType.SLOW);
				
				p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 120, 0));
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 120, 1));
			}
			if(p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.ICE) {
				p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
				p.removePotionEffect(PotionEffectType.SPEED);
				p.removePotionEffect(PotionEffectType.WEAKNESS);
				p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
				p.removePotionEffect(PotionEffectType.SLOW);
				
				p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 120, 0));
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 120, 1));
			}
			if(p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.LAVA || p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.STATIONARY_LAVA || p.getLocation().getBlock().getRelative(BlockFace.WEST).getType() == Material.STATIONARY_LAVA || p.getLocation().getBlock().getRelative(BlockFace.WEST).getType() == Material.WATER || p.getLocation().getBlock().getRelative(BlockFace.EAST).getType() == Material.LAVA || p.getLocation().getBlock().getRelative(BlockFace.EAST).getType() == Material.STATIONARY_LAVA) {
				p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
				p.removePotionEffect(PotionEffectType.SPEED);
				p.removePotionEffect(PotionEffectType.WATER_BREATHING);
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
	public void onPoseidon(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (plugin.poseidon.contains(p.getName())) {
			    if (e.getCause() == DamageCause.DROWNING) {
				    e.setCancelled(true);
			} 
			}
		}
}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void spectre(PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		final ItemStack sugar = new ItemStack(Material.SUGAR);
		if(plugin.cooldowns.contains(p.getName())) {
			p.sendMessage(ChatColor.RED + "Voce esta em cooldown");
			return;
		}
		if (plugin.spectre.contains(p.getName())) {
			if (p.getItemInHand().getType() == Material.REDSTONE) {
				event.setCancelled(true);
				p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 400, 1));
				final ItemStack[] armorContents = p.getInventory().getArmorContents();
				p.getInventory().setArmorContents(null);
				p.updateInventory();
				p.setItemInHand(new ItemStack(sugar));
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
							public void run() {
								plugin.cooldowns.remove(p.getName());
								p.getInventory().remove(sugar);
								p.getInventory().addItem(new ItemStack(Material.REDSTONE));
								p.getInventory().setArmorContents(armorContents);
							}
						}, 800L);
			}
		}
	}
  @EventHandler
  public void enchant(PlayerInteractEvent event) {
    Player p = event.getPlayer();
    if ((plugin.specialist.contains(p.getName())) && (p.getItemInHand().getType() == Material.BOOK))
      p.openEnchanting(p.getLocation(), true);
  }

  @EventHandler
  public void resistanceRemove(EntityDamageEvent event)
  {
    if (!(event.getEntity() instanceof Player))
      return;
    if (event.getCause() != EntityDamageEvent.DamageCause.FALL)
      return;
    final Player p = (Player)event.getEntity();
    plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
      public void run() {
        p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
      }
    }
    , 20L);
  }

  @EventHandler
  public void hulkSmash(EntityDamageByEntityEvent event) {
    if (!(event.getDamager() instanceof Player))
      return;
    if (!(event.getEntity() instanceof Player))
      return;
    final Player player = (Player)event.getEntity();
    Player damager = (Player)event.getDamager();
    if (damager.getPassenger() != null) {
      if (!plugin.hulk.contains(damager.getName()))
        return;
      event.setCancelled(true);
      player.setSneaking(true);
      Vector vec = player.getLocation().getDirection().multiply(2.0F);
      vec.setY(2.0D);
      player.setVelocity(vec);
      plugin.getServer().getScheduler()
        .scheduleSyncDelayedTask(plugin, new Runnable() {
        public void run() {
          player.setSneaking(false);
        }
      }
      , 10L);
    }
  }

  @EventHandler
  public void hulk(PlayerInteractEntityEvent event) {
    if (!(event.getRightClicked() instanceof Player))
      return;
    Player player = event.getPlayer();
    Player clicked = (Player)event.getRightClicked();
    if (!plugin.hulk.contains(player.getName()))
      return;
    if (player.getItemInHand().getType() != Material.SADDLE)
      return;
    if ((player.getPassenger() == null) && (clicked.getPassenger() == null))
      player.setPassenger(clicked); 
  }

  @EventHandler
  public void rider(PlayerInteractEntityEvent event) {
    if (!(event.getRightClicked() instanceof Player))
      return;
    Player player = event.getPlayer();
    Player clicked = (Player)event.getRightClicked();
    if (player.getItemInHand().getType() != Material.SADDLE)
      return;
    if (clicked.getPassenger() != null)
      return;
    if (player.getPassenger() != null)
      return;
    if (!plugin.rider.contains(player.getName()))
      return;
    clicked.setPassenger(player);
  }
  @SuppressWarnings("deprecation")
@EventHandler
  public void milkmanEvent(PlayerInteractEvent event) {
    final Player player = event.getPlayer();
    if (!plugin.milkman.contains(player.getName()) || plugin.cooldownsm.contains(player.getName()))
		return;
	if (player.getItemInHand().getType() != Material.MILK_BUCKET)
		return;
    if ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
      player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 900, 0));
      player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 900, 0));
      player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 900, 0));
      player.getItemInHand().setAmount(player.getItemInHand().getAmount() - 1);
      player.updateInventory();
      Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {		
			public void run() {
				plugin.cooldownsm.remove(player.getName());
				}
			}
	, 400L);
	}else{
		player.sendMessage(ChatColor.RED + "Voce esta em cooldown!");
	}
   }
  @EventHandler
  public void vampireDeath(PlayerDeathEvent event) {
    if (!(event.getEntity().getKiller() instanceof Player))
      return;
    if (event.getEntity().getKiller() == null)
      return;
    if (plugin.vampire.contains(event.getEntity().getKiller().getName())) {
      event.getEntity().getKiller().setHealth(20.0D);
      @SuppressWarnings("deprecation")
	Potion potion = new Potion(PotionType.INSTANT_DAMAGE, 1, true);
      event.getEntity().getKiller().getInventory().addItem(new ItemStack[] { potion.toItemStack(1) });
    }
  }

  @EventHandler
  public void frostyEvent(PlayerMoveEvent event) {
    Player player = event.getPlayer();
    if (!event.getFrom().getBlock().getLocation()
      .equals(event.getTo().getBlock().getLocation()))
      return;
    Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);
    if ((block.getType() == Material.SNOW_BLOCK) && (plugin.frosty.contains(player.getName())))
      player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1)); 
  }

  @EventHandler
  public void turtleEntityDamageToOtherEvent(EntityDamageByEntityEvent event) {
    if (!(event.getDamager() instanceof Player))
      return;
    if (!(event.getEntity() instanceof Player))
      return;
    Player player = (Player) event.getDamager();
    if ((plugin.turtle.contains(player.getName())) && (player.isSneaking()))
      event.setCancelled(true); 
  }

  @EventHandler
  public void turtleEvent(EntityDamageEvent e) {
    if (!(e.getEntity() instanceof Player))
      return;
    if (!plugin.turtle.contains(((Player)e.getEntity()).getName()))
      return;
    Player p = (Player)e.getEntity();
    if ((p.isSneaking()) && ((e.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) || (e.getCause() == EntityDamageEvent.DamageCause.CONTACT) || (e.getCause() == EntityDamageEvent.DamageCause.CUSTOM) || (e.getCause() == EntityDamageEvent.DamageCause.DROWNING) || (e.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK) || (e.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) || (e.getCause() == EntityDamageEvent.DamageCause.FALL) || (e.getCause() == EntityDamageEvent.DamageCause.FALLING_BLOCK) || (e.getCause() == EntityDamageEvent.DamageCause.FIRE) || (e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK) || (e.getCause() == EntityDamageEvent.DamageCause.LAVA) || (e.getCause() == EntityDamageEvent.DamageCause.LIGHTNING) || (e.getCause() == EntityDamageEvent.DamageCause.MAGIC) || (e.getCause() == EntityDamageEvent.DamageCause.MELTING) || (e.getCause() == EntityDamageEvent.DamageCause.POISON) || (e.getCause() == EntityDamageEvent.DamageCause.PROJECTILE) || (e.getCause() == EntityDamageEvent.DamageCause.STARVATION) || (e.getCause() == EntityDamageEvent.DamageCause.SUFFOCATION) || (e.getCause() == EntityDamageEvent.DamageCause.THORNS) || (e.getCause() == EntityDamageEvent.DamageCause.VOID) || (e.getCause() == EntityDamageEvent.DamageCause.WITHER)))
      e.setDamage(2.0D);
  }

  @EventHandler
  public void tankDamage(EntityDamageEvent event) {
    if (!(event.getEntity() instanceof Player))
      return;
    Player player = (Player)event.getEntity();
    if (!plugin.tank.contains(player.getName()))
      return;
    if (event.getCause() != EntityDamageEvent.DamageCause.BLOCK_EXPLOSION)
      return;
    event.setCancelled(true);
  }
  @EventHandler
  public void timelordkit(PlayerInteractEvent event) {
    final Player player = event.getPlayer();
    if (((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) && (player.getItemInHand().getType() == Material.WATCH) && (plugin.timelord.contains(player.getName())))
      for (Entity frozen : player.getNearbyEntities(5.0D, 0.0D, 5.0D))
        if ((frozen != null) && ((frozen instanceof Player))) {
          plugin.freeze.add(((Player)frozen).getName());
          if (!plugin.freezing.contains(player.getName())) {
            player.getWorld().playEffect(player.getLocation(), Effect.MOBSPAWNER_FLAMES, 10);
            player.getWorld().playSound(player.getLocation(), Sound.WITHER_SHOOT, 10.0F, 1.0F);
            plugin.freezing.add(player.getName());
            plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, 
              new Runnable() {
              public void run() {
                PlayerListener.plugin.freezing.remove(player.getName());
              }
            }
            , 600L);
          } else {
            player.sendMessage(ChatColor.RED + "Voce ainda está no cooldown!");
          }
        }
  }

  @EventHandler
  public void onPlayerMove(PlayerMoveEvent event) {
    final Player player = event.getPlayer();
    if ((plugin.freeze.contains(player.getName())) && 
      (!plugin.freezing.contains(player.getName()))) {
      event.setTo(player.getLocation());
      plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
        public void run() {
          PlayerListener.plugin.freeze.remove(player.getName());
        }
      }
      , 100L);
    }
  }

  @EventHandler
  public void place(BlockPlaceEvent event) {
    if ((event.getBlock().getType() == Material.REDSTONE_TORCH_ON) || ((event.getBlock().getType() == Material.REDSTONE_TORCH_OFF) && (plugin.flash.contains(event.getPlayer().getName()))))
      event.setCancelled(true);
  }

@SuppressWarnings("deprecation")
@EventHandler
  public void flashEvent(PlayerInteractEvent event) {
    final Player player = event.getPlayer();
    final ItemStack flashcol = new ItemStack(Material.REDSTONE_TORCH_OFF);
    if (!plugin.flash.contains(player.getName()))
      return;
    if (player.getItemInHand().getType() == Material.REDSTONE_TORCH_ON) {
    if (event.getAction() == Action.RIGHT_CLICK_AIR) {
      event.setCancelled(true);
      Block tb = player.getTargetBlock(null, 100);
      Location bloc = tb.getLocation();
      Location block = player.getWorld().getHighestBlockAt(bloc).getLocation();
      int x = block.getBlockX();
      int y = block.getBlockY();
      int z = block.getBlockZ();
      player.teleport(new Location(player.getWorld(), x, y, z));
      player.getWorld().strikeLightningEffect(block);
      player.getInventory().remove(Material.REDSTONE_TORCH_ON);
      player.getInventory().addItem(flashcol);
      player.updateInventory();
      plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
        public void run() {
          ItemStack flasht = new ItemStack(Material.REDSTONE_TORCH_ON);
          ItemMeta fim = flasht.getItemMeta();
          fim.setLore(Arrays.asList(new String[] { "Use para se teleportar para onde voce esta olhando!" }));
          fim.setDisplayName(ChatColor.DARK_RED + "Flash's Torch");
          flasht.setItemMeta(fim);
          player.getInventory().remove(flashcol);
          player.getInventory().addItem(flasht);
          player.updateInventory();
        }
      }
      , 700L);
    }
   }
  }

  @SuppressWarnings("deprecation")
@EventHandler
  public void cookiemonsterEvent(PlayerInteractEvent event) {
    Player player = event.getPlayer();
    if (!plugin.cookiemonster.contains(player.getName()))
      return;
    if (player.getItemInHand().getType() != Material.COOKIE)
      return;
    if ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
      player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1));
      player.getItemInHand().setAmount(player.getItemInHand().getAmount() - 1);
      player.updateInventory();
    }
  }

  @EventHandler
  public void berserkerEvent(PlayerDeathEvent event) {
    if (!(event.getEntity().getKiller() instanceof Player))
      return;
    if (event.getEntity().getKiller() == null)
      return;
    Player player = event.getEntity().getKiller();
    if (plugin.berserker.contains(player.getName())) {
      player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 1));
      player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 200, 0));
    }
  }

  @EventHandler
  public void onPlayerSnail(EntityDamageByEntityEvent event) {
    if (((event.getEntity() instanceof Player)) && ((event.getDamager() instanceof Player))) {
      Player victim = (Player)event.getEntity();
      Player damager = (Player)event.getDamager();
      Random rnd = new Random();
      if ((plugin.snail.contains(damager.getName())) && (rnd.nextInt(3) == 1))
        victim.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 150, 1));
    }
  }
  @EventHandler
  public void onPlayerViper(EntityDamageByEntityEvent event) {
    if (((event.getEntity() instanceof Player)) && ((event.getDamager() instanceof Player))) {
      Player victim = (Player)event.getEntity();
      Player damager = (Player)event.getDamager();
      Random rnd = new Random();
      if ((plugin.viper.contains(damager.getName())) && (rnd.nextInt(3) == 1))
        victim.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 150, 0));
    }
  }
  @EventHandler
  public void tankEvent(PlayerDeathEvent event) {
    if (!(event.getEntity().getKiller() instanceof Player))
      return;
    if (event.getEntity().getKiller() == null)
      return;
    if ((plugin.tank.contains(event.getEntity().getKiller().getName())) && ((event.getEntity() instanceof Player)) && ((event.getEntity().getKiller() instanceof Player)))
      event.getEntity().getWorld().createExplosion(event.getEntity().getLocation(), 5.0F); 
  }

  @EventHandler
  public void camelEvent(PlayerMoveEvent event) {
    Player player = event.getPlayer();

    if (!event.getFrom().getBlock().getLocation().equals(event.getTo().getBlock().getLocation()))
      return;
    Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);
    if ((block.getType() == Material.SAND) && (plugin.camel.contains(player.getName()))) {
      player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1));
      player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 0));
    }
  }
  
@EventHandler
  public void onEntityDamage(EntityDamageEvent event) { if (event.isCancelled())
      return;
    if ((event.getCause() == EntityDamageEvent.DamageCause.FALL) && ((event.getEntity() instanceof Player))) {
      Player p = (Player)event.getEntity();
      if (plugin.stomper.contains(p.getName())) {
        double dmg = event.getDamage() + stomperFallDamage;
        int area = (int)(dmg / 3.0D);
        if (area > 3)
          area = 3;
        event.setCancelled(true);
        if ((this.changeStomperFallDamage) && (this.stomperFallDamage > 0))
          p.damage(4);
        Location center = p.getLocation();
        double velocity = dmg * 0.01D;
        for (Entity entity : p.getNearbyEntities(area * 2, area, area * 2))
          if ((entity instanceof LivingEntity)) {
            double hisDmg = dmg;
            if (this.reduceStompDamageByDistance)
              hisDmg = dmg * 3 / (entity.getLocation().distance(center) + 1.0D);
            if (entity.getLocation().getBlockY() - 1 > center.getBlockY())
              continue;
            if ((entity instanceof Player)) {
              if ((((Player)entity).isSneaking()) && 
                (hisDmg > 4.0D)) {
                hisDmg = 4.0D;
              }
              Player gamer = (Player) entity;
              if (gamer.isDead())
                continue;
            }
            Vector unitVector = entity.getLocation().toVector().subtract(center.toVector()).normalize();
            if (this.stomperBlocksFall)
              entity.setVelocity(unitVector.multiply(0.4D).add(new Vector(0.0D, 0.4D + velocity, 0.0D)));
            if ((hisDmg >= ((LivingEntity)entity).getHealth()) && ((entity instanceof Player))) {
              Player gamer = (Player)entity;
              if (!gamer.isDead())
               ((Damageable) gamer).damage(hisDmg , p);
               gamer.playSound(gamer.getLocation(), Sound.IRONGOLEM_HIT, 10.0F, 1.0F);
            } else {
              ((Damageable)(LivingEntity)entity).damage(hisDmg, p);
            }
          }
        if (this.stomperBlocksFall)
          p.setVelocity(p.getVelocity().add(new Vector(0.0D, 0.3D, 0.0D)));
      }
    }
  }

  @EventHandler
  public void onFoodLevelChange(FoodLevelChangeEvent event) {
    event.setFoodLevel(20);
  }
  @EventHandler
  public void onPlayerFish(PlayerFishEvent event) {
  	Entity caught = event.getCaught();
  	Block block = event.getHook().getLocation().getBlock();
  	if ((caught != null) && (caught != block) && (plugin.fisherman.contains(event.getPlayer().getName())))
  		caught.teleport(event.getPlayer().getLocation());
  }

  @EventHandler
  public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
    if (!(event.getEntity() instanceof Player))
      return;
    if (!(event.getDamager() instanceof Player))
      return;
    if (event.getCause() != EntityDamageEvent.DamageCause.ENTITY_ATTACK)
      return;
    if (!plugin.weak.contains(((Player)event.getEntity()).getName()))
      return;
    event.setDamage(20.0D);
  }

  @EventHandler
  public void onPlayerPickup(PlayerPickupItemEvent e){
   if(e.getItem().getItemStack().getType() != Material.MUSHROOM_SOUP) {
     e.setCancelled(true);
    }
   }
  @EventHandler
  public void onItemDrop(final ItemSpawnEvent e) {
    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
       public void run() {
        e.getEntity().remove();
        e.getLocation().getWorld().playEffect(e.getEntity().getLocation(),Effect.SMOKE, 10);
        e.getLocation().getWorld().playSound(e.getEntity().getLocation(),Sound.LAVA_POP, 1.0F, 1.0F);
        }
       }
        , 50L);
    }
  @EventHandler
  public void onPlayerDeath(PlayerDeathEvent event) { 
	event.setDeathMessage(null);
	plugin.removeAbilitys(event.getEntity().getPlayer());
  }
  
  ItemStack s; 
	public void openSopa(Player p) {
		ItemStack s = new ItemStack(Material.MUSHROOM_SOUP);
	    ItemMeta meta2 = s.getItemMeta();
		meta2.setDisplayName("§eSopa");
		s.setItemMeta(meta2);
		
		Inventory sopa = Bukkit.createInventory(null, 54,"§6Sopas:");
	   
		sopa.setItem(0, s);
		sopa.setItem(1, s);
		sopa.setItem(2, s);
		sopa.setItem(3, s);
		sopa.setItem(4, s);
		sopa.setItem(5, s);
		sopa.setItem(6, s);
		sopa.setItem(7, s);
		sopa.setItem(8, s);
		sopa.setItem(9, s);
		sopa.setItem(10, s);
		sopa.setItem(11, s);
		sopa.setItem(12, s);
		sopa.setItem(13, s);
		sopa.setItem(14, s);
		sopa.setItem(15, s);
		sopa.setItem(16, s);
		sopa.setItem(17, s);
		sopa.setItem(18, s);
		sopa.setItem(19, s);
		sopa.setItem(20, s);
		sopa.setItem(21, s);
		sopa.setItem(22, s);
		sopa.setItem(23, s);
		sopa.setItem(24, s);
		sopa.setItem(25, s);
		sopa.setItem(26, s);
		sopa.setItem(27, s);
		sopa.setItem(28, s);
		sopa.setItem(29, s);
		sopa.setItem(30, s);
		sopa.setItem(31, s);
		sopa.setItem(32, s);
		sopa.setItem(33, s);
		sopa.setItem(34, s);
		sopa.setItem(35, s);
		sopa.setItem(36, s);
		sopa.setItem(37, s);
		sopa.setItem(38, s);
		sopa.setItem(39, s);
		sopa.setItem(40, s);
		sopa.setItem(41, s);
		sopa.setItem(42, s);
		sopa.setItem(43, s);
		sopa.setItem(44, s);
		sopa.setItem(45, s);
		sopa.setItem(45, s);
		sopa.setItem(46, s);
		sopa.setItem(47, s);
		sopa.setItem(48, s);
		sopa.setItem(49, s);
		sopa.setItem(50, s);
		sopa.setItem(51, s);
		sopa.setItem(52, s);
		sopa.setItem(53, s);
		p.openInventory(sopa);
		
	}
	
	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		if(e.getLine(0).equalsIgnoreCase("[Gratis]")) {
			e.setLine(0, "§c§lFight");
			e.setLine(1, "§e§lSopas");
		}
	}
	@EventHandler
	public void onSignClick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
		if(e.getClickedBlock().getState() instanceof Sign) {
			Sign s = (Sign) e.getClickedBlock().getState();
			if (s.getLine(0).equalsIgnoreCase("§c§lFight") && s.getLine(1).equalsIgnoreCase("§e§lSopas")) {
				openSopa(p);
			}
		}
	}
	@EventHandler
	  public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage("§6[§2+§6]§7"+p.getName()+ " entrou no servidor!");
		e.getPlayer().performCommand("spawn");
		BarAPI.setMessage(e.getPlayer(), ChatColor.GOLD + "Bem vindo " + ChatColor.GREEN + e.getPlayer().getName() + ChatColor.GOLD+" ,ao " + ChatColor.RED + "FightPvP.", 10);
		plugin.removeAbilitys(p);
	}
	@EventHandler
	  private void onPlayerLeave(PlayerQuitEvent e) {
		e.setQuitMessage("§6[§4-§6]§7 "+e.getPlayer().getName()+" saiu do servidor!'");
		e.getPlayer().performCommand("spawn");
	}
	 @EventHandler
	 public void onHit(EntityDamageByEntityEvent event) {
	   if (((event.getEntity() instanceof Player)) && ((event.getDamager() instanceof Player))) {
	     Player p = (Player)event.getDamager();
		 ItemStack[] armor = p.getInventory().getArmorContents();
	       p.getItemInHand().setDurability((short)(-p.getItemInHand().getType().getMaxDurability()));
	       if (armor.length > 0){
	         for (int i = 0; i < armor.length; i++){
	        	 armor[i].setDurability((short)(-armor[i].getType().getMaxDurability()));
	         }
	         }
	       }
	   }
	  @EventHandler
	  public void onPlayerInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Material mat = p.getItemInHand().getType();
		ItemStack pote = new ItemStack(Material.BOWL, 1);
		ItemMeta meta = pote.getItemMeta();
		meta.setDisplayName("§eTigela");
		pote.setItemMeta(meta);		
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(mat == Material.MUSHROOM_SOUP) {
				double health = p.getHealth();
				if(health == 20){
					int food = p.getFoodLevel();
					if(food == 20){
						return;
					}
					int nfood = food + 7;
					if(nfood > 20) {
						p.setFoodLevel(20);
					} else {
						p.setFoodLevel(nfood);
					}
					e.setCancelled(true);
					p.getInventory().setItem(p.getInventory().getHeldItemSlot(), pote);
					return;
				} else {
					double nhealth = health + 7;
					if(nhealth > 20) {
						p.setHealth(20);
					} else {
						p.setHealth(nhealth);
					}
					e.setCancelled(true);
					p.getInventory().setItem(p.getInventory().getHeldItemSlot(), pote);
					return;
				}
			}
		}
	  }
}