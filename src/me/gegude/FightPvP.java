package me.gegude;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import me.confuser.barapi.BarAPI;
import me.gegude.abilidades.Gladiator;
import me.gegude.comandos.Admin;
import me.gegude.comandos.Ban;
import me.gegude.comandos.Broadcast;
import me.gegude.comandos.ChatManager;
import me.gegude.comandos.Commands;
import me.gegude.comandos.Head;
import me.gegude.comandos.Invsee;
import me.gegude.comandos.Kick;
import me.gegude.comandos.New;
import me.gegude.comandos.Soup;
import me.gegude.comandos.Tag;
import me.gegude.comandos.Tell;
import me.gegude.events.ColorSigns;
import me.gegude.events.Nearfs;
import me.gegude.events.PlayerDrop;
import me.gegude.events.TabColor;
import me.gegude.listeners.PlayerListener;
import me.gegude.listeners.PlayerListener2;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public class FightPvP extends JavaPlugin {
	
  public int cooldownMonk = 10;
  public String monkCooldownMessage = ChatColor.RED + "Voce pode monkar denovo em %s segundos!";
  public String monkedMessage = ChatColor.BLUE + "Monkado!";
  public int cooldownPhantom = 30;
  public String phantomCooldownMessage = ChatColor.RED + "Voce pode usar denovo em %s segundos!";
  public transient HashMap<ItemStack, Long> phantomItem = new HashMap<ItemStack, Long>();
  public int cooldownThor = 5;
  public String thorCooldownMessage = ChatColor.RED + "Voce pode usar denovo em %s segundos!";

  @SuppressWarnings("deprecation")
  public int monkItemId = Material.BLAZE_ROD.getId();
  public transient HashMap<ItemStack, Long> monkStaff = new HashMap<ItemStack, Long>();
  public boolean sendThroughInventory = true;
  
 public ArrayList<String> oneKit = new ArrayList<String>();
 public ArrayList<Player> kanga = new ArrayList<Player>();
  public ArrayList<String> kangaroodj = new ArrayList<String>();
  
  public List<String> archer = new ArrayList<String>();
  public List<String> switcher = new ArrayList<String>();
  public List<String> fisherman = new ArrayList<String>();
  public List<String> anchor = new ArrayList<String>();
  public List<String> stomper = new ArrayList<String>();
  public List<String> camel = new ArrayList<String>();
  public List<String> hg = new ArrayList<String>();
  public List<String> tank = new ArrayList<String>();
  public List<String> viper = new ArrayList<String>();
  public List<String> snail = new ArrayList<String>();
  public List<String> berserker = new ArrayList<String>();
  public List<String> cookiemonster = new ArrayList<String>();
  public List<String> flash = new ArrayList<String>();
  public List<String> timelord = new ArrayList<String>();
  public List<String> turtle = new ArrayList<String>();
  public List<String> frosty = new ArrayList<String>();
  public List<String> vampire = new ArrayList<String>();
  public List<String> milkman = new ArrayList<String>();
  public List<String> neo = new ArrayList<String>();
  public List<String> rider = new ArrayList<String>();
  public List<String> hulk = new ArrayList<String>();
  public List<String> kangaroo = new ArrayList<String>();
  public List<String> specialist = new ArrayList<String>();
  public List<String> spectre = new ArrayList<String>();
  public List<String> poseidon = new ArrayList<String>();
  public List<String> monk = new ArrayList<String>();
  public List<String> lifeline = new ArrayList<String>();
  public List<String> urgal = new ArrayList<String>();
  public List<String> vacuum = new ArrayList<String>();
  public List<String> phantom = new ArrayList<String>();
  public List<String> grappler = new ArrayList<String>();
  public List<String> endermage = new ArrayList<String>();
  public List<String> thor = new ArrayList<String>();
  public List<String> salamander = new ArrayList<String>();
  public List<String> gladiator = new ArrayList<String>(); 
  public List<String> copycat = new ArrayList<String>();

  public List<String> weak = new ArrayList<String>();
  public List<Player> cantDoCommand = new ArrayList<Player>();
  public List<String> spectrecd = new ArrayList<String>();
  public List<String> thorcd = new ArrayList<String>();
  public List<String> cooldowns = new ArrayList<String>();
  public List<String> cooldownsm = new ArrayList<String>();
  public List<String> cooldownmage = new ArrayList<String>();
  public List<String> cooldownvacuum = new ArrayList<String>();
  public List<String> endermageProtec = new ArrayList<String>();

  public List<String> phantoming = new ArrayList<String>();
  public List<String> freeze = new ArrayList<String>();
  public List<String> freezing = new ArrayList<String>();

  public final void clear(Player player) {
		for(PotionEffect potion : player.getActivePotionEffects()) {
			player.removePotionEffect(potion.getType());}
		player.setLevel(0);
		player.getInventory().clear();
		player.getInventory().setArmorContents(new ItemStack[] {
			    null,
			    null,
				null,
				null,
	  });
	}
	
  public final void removeAbilitys(Player player) {
	  this.oneKit.remove(player.getName());
	  this.switcher.remove(player.getName());
	  this.fisherman.remove(player.getName());
	  this.camel.remove(player.getName());
	  this.archer.remove(player.getName());
	  this.tank.remove(player.getName());
	  this.viper.remove(player.getName());
	  this.snail.remove(player.getName());
	  this.stomper.remove(player.getName());
	  this.berserker.remove(player.getName());
      this.cookiemonster.remove(player.getName());
      this.flash.remove(player.getName());
      this.timelord.remove(player.getName());
      this.turtle.remove(player.getName());
      this.frosty.remove(player.getName());
      this.vampire.remove(player.getName());
      this.milkman.remove(player.getName());
      this.neo.remove(player.getName());
      this.rider.remove(player.getName());
      this.hulk.remove(player.getName());
      this.kangaroo.remove(player.getName());
      this.specialist.remove(player.getName());
      this.spectre.remove(player.getName());
      this.poseidon.remove(player.getName());
	  this.anchor.remove(player.getName());
      this.monk.remove(player.getName());
	  this.urgal.remove(player.getName());
	  this.lifeline.remove(player.getName());
	  this.freeze.remove(player.getName());
      this.freezing.remove(player.getName());
      this.vacuum.remove(player.getName());
      this.phantom.remove(player.getName());
      this.grappler.remove(player.getName());
      this.endermage.remove(player.getName());
      this.thor.remove(player.getName());
      this.salamander.remove(player.getName());
      this.gladiator.remove(player.getName());
      this.weak.remove(player.getName());
  }
  
  public void onEnable() {
    getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
    getServer().getPluginManager().registerEvents(new PlayerListener2(this), this);
    getServer().getPluginManager().registerEvents(new Admin(this), this);
    getServer().getPluginManager().registerEvents(new PlayerDrop(this), this);
    getServer().getPluginManager().registerEvents(new Nearfs(this), this);
    getServer().getPluginManager().registerEvents(new TabColor(this), this);
    getServer().getPluginManager().registerEvents(new ColorSigns(this), this);
    getServer().getPluginManager().registerEvents(new Gladiator(this), this);
  	getCommand("fisherman").setPermissionMessage(ChatColor.RED +getConfig().getString("noperm-message"));
	getCommand("anchor").setPermissionMessage(ChatColor.RED + getConfig().getString("noperm-message"));
	getCommand("stomper").setPermissionMessage(ChatColor.RED + getConfig().getString("noperm-message"));
	getCommand("camel").setPermissionMessage(ChatColor.RED + getConfig().getString("noperm-message"));
	getCommand("tank").setPermissionMessage(ChatColor.RED + getConfig().getString("noperm-message"));
	getCommand("viper").setPermissionMessage(ChatColor.RED + getConfig().getString("noperm-message"));
	getCommand("snail").setPermissionMessage(ChatColor.RED + getConfig().getString("noperm-message"));
	getCommand("berserker").setPermissionMessage(ChatColor.RED + getConfig().getString("noperm-message"));
	getCommand("cookiemonster").setPermissionMessage(ChatColor.RED + getConfig().getString("noperm-message"));
	getCommand("flash").setPermissionMessage(ChatColor.RED + getConfig().getString("noperm-message"));
	getCommand("timelord").setPermissionMessage(ChatColor.RED + getConfig().getString("noperm-message"));
	getCommand("viking").setPermissionMessage(ChatColor.RED + getConfig().getString("noperm-message"));
	getCommand("turtle").setPermissionMessage(ChatColor.RED + getConfig().getString("noperm-message"));
	getCommand("frosty").setPermissionMessage(ChatColor.RED + getConfig().getString("noperm-message"));
	getCommand("vampire").setPermissionMessage(ChatColor.RED + getConfig().getString("noperm-message"));
	getCommand("milkman").setPermissionMessage(ChatColor.RED + getConfig().getString("noperm-message"));
	getCommand("rider").setPermissionMessage(ChatColor.RED + getConfig().getString("noperm-message"));
	getCommand("hg").setPermissionMessage(ChatColor.RED + getConfig().getString("noperm-message"));
	getCommand("hulk").setPermissionMessage(ChatColor.RED + getConfig().getString("noperm-message"));
	getCommand("kangaroo").setPermissionMessage(ChatColor.RED + getConfig().getString("noperm-message"));
	getCommand("specialist").setPermissionMessage(ChatColor.RED + getConfig().getString("noperm-message"));
	getCommand("spectre").setPermissionMessage(ChatColor.RED + getConfig().getString("noperm-message"));
	getCommand("poseidon").setPermissionMessage(ChatColor.RED + getConfig().getString("noperm-message"));
	getCommand("monk").setPermissionMessage(ChatColor.RED + getConfig().getString("noperm-message"));
	getCommand("lifeline").setPermissionMessage(ChatColor.RED + getConfig().getString("noperm-message"));
	getCommand("urgal").setPermissionMessage(ChatColor.RED + getConfig().getString("noperm-message"));
	getCommand("vacuum").setPermissionMessage(ChatColor.RED + getConfig().getString("noperm-message"));
	getCommand("phantom").setPermissionMessage(ChatColor.RED + getConfig().getString("noperm-message"));
	getCommand("grappler").setPermissionMessage(ChatColor.RED + getConfig().getString("noperm-message"));
	getCommand("endermage").setPermissionMessage(ChatColor.RED + getConfig().getString("noperm-message"));
	getCommand("thor").setPermissionMessage(ChatColor.RED + getConfig().getString("noperm-message"));
	getCommand("salamander").setPermissionMessage(ChatColor.RED + getConfig().getString("noperm-message"));
	getCommand("gladiator").setPermissionMessage(ChatColor.RED + getConfig().getString("noperm-message"));
	getCommand("soup").setExecutor(new Soup(this));
    getCommand("suicide").setExecutor(new Commands(this));
	getCommand("day").setExecutor(new Commands(this));
    getCommand("new").setExecutor(new New(this));
	getCommand("bc").setExecutor(new Broadcast(this));
	getCommand("broadcast").setExecutor(new Broadcast(this));
	getCommand("feast").setExecutor(new Commands(this));
	getCommand("main").setExecutor(new Commands(this));
	getCommand("pots").setExecutor(new Commands(this));
	getCommand("admin").setExecutor(new Admin(this));
	getCommand("tell").setExecutor(new Tell(this));
	getCommand("msg").setExecutor(new Tell(this));
	getCommand("limparchat").setExecutor(new ChatManager(this));
	getCommand("tag").setExecutor(new Tag(this));
	getCommand("head").setExecutor(new Head(this));
	getCommand("kick").setExecutor(new Kick(this));
	getCommand("ban").setExecutor(new Ban(this));
	getCommand("invsee").setExecutor(new Invsee(this)); 
  }

  public void onDisable(){
	  HandlerList.unregisterAll((Plugin)this);
  }

  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
    ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
    ItemMeta sMeta = sopa.getItemMeta();
    sMeta.setDisplayName(ChatColor.YELLOW + "Sopa");
    sMeta.setLore(Arrays.asList(new String[] { "Use para regenerar 3.5 da sua vida!" }));
    sopa.setItemMeta(sMeta);
    Player player = (Player)sender;
    if (commandLabel.equalsIgnoreCase("kits")) {
      StringBuilder free = new StringBuilder();
      StringBuilder other = new StringBuilder();
      String[] Kits = { "HG", "Archer", "Snail", "Phantom", "Fisherman", "Endermage", "Switcher", "Gladiator", "Stomper", "Thor","Camel", "Anchor", "Tank", "Viper", "Snail", "Berserker", "Turtle", "Flash", "CookieMonster", "Frosty", "Vampire", "TimeLord", "Milkman", "Rider", "Hulk", "Specialist", "Spectre", "Poseidon", "Monk", "LifeLine", "Urgal", 
    		  "Vacuum", "Grappler", "Salamander"};
      for (String kit : Kits) {
        if (player.hasPermission("pvp." + kit.toLowerCase()))
          free.append(ChatColor.WHITE + kit + ChatColor.GREEN + ", ");
        else {
          other.append(ChatColor.WHITE + kit + ChatColor.RED + ", ");
        }
      }
      if (free.length() == 0)
        player.sendMessage(ChatColor.DARK_GREEN + "Seus Kits : " + ChatColor.WHITE + "Voce nao tem nenhum kit!");
      else {
        player.sendMessage(ChatColor.DARK_GREEN + "Seus Kits : " + free.toString());
      }

      if (other.length() == 0)
        player.sendMessage(ChatColor.DARK_RED + "Outros Kits : " + ChatColor.WHITE + "Voce tem todos os kits!");
      else
        player.sendMessage(ChatColor.DARK_RED + "Outros Kits : " + other.toString());
    }
    else if (commandLabel.equalsIgnoreCase("pvp")) {
      ItemStack espada = new ItemStack(Material.WOOD_SWORD);
      ItemMeta im = espada.getItemMeta();
      im.setDisplayName(ChatColor.DARK_RED + "PvP");
      im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
      espada.setItemMeta(im);
      player.removePotionEffect(PotionEffectType.SPEED);
      if (!this.oneKit.contains(player.getName())) {
        player.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.YELLOW + 
          "FightKits" + ChatColor.DARK_RED + "]" + ChatColor.GOLD + 
          " Voce escolheu o kit: " + ChatColor.AQUA + "PvP" + 
          ChatColor.GOLD + "!");
        this.oneKit.add(player.getName());
        player.playSound(player.getLocation(), Sound.ANVIL_LAND, 10.0F, 
          9.0F);
        clear(player);
        player.getInventory().setArmorContents(null);
        player.getInventory().addItem(new ItemStack[] { espada });
        for (int i = 0; i <= 35; i++) {
          player.getInventory().addItem(new ItemStack[] { sopa });
        }
        player.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
        player.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
        player.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
        player.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
        BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "PvP", 5);
      } else {
        player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
      }
    }
    else if (commandLabel.equalsIgnoreCase("archer")) {
      if (player.hasPermission("pvp.archer")) {
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
        if (!this.oneKit.contains(player.getName())) {
          player.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.YELLOW + "FightKits" + ChatColor.DARK_RED + "]" + ChatColor.GOLD + " Voce escolheu o kit: " + ChatColor.AQUA + "Archer" + ChatColor.GOLD + "!");
          this.oneKit.add(player.getName());
          this.archer.add(player.getName());
          player.playSound(player.getLocation(), Sound.ANVIL_LAND, 10.0F, 
            9.0F);
          clear(player);
          player.getInventory().setArmorContents(null);
          player.addPotionEffect(
            new PotionEffect(PotionEffectType.SPEED, 
            1000000000, 0));
          player.getInventory().addItem(new ItemStack[] { espada });
          player.getInventory().addItem(new ItemStack[] { arco });
          player.getInventory().addItem(
            new ItemStack[] { new ItemStack(Material.ARROW, 1) });
          for (int i = 0; i <= 33; i++) {
            player.getInventory().addItem(new ItemStack[] { sopa });
          }
          player.getInventory().setChestplate(
            new ItemStack(Material.LEATHER_CHESTPLATE));
          BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Archer", 5);
        } else {
          player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
        }
      }
    }
    else if (commandLabel.equalsIgnoreCase("switcher")) {
      if (player.hasPermission("pvp.switcher")) {
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
        if (!this.oneKit.contains(player.getName())) {
          player.sendMessage(ChatColor.DARK_RED + "[" + 
            ChatColor.YELLOW + "FightKits" + ChatColor.DARK_RED + "]" + ChatColor.GOLD + " Voce escolheu o kit: " + ChatColor.AQUA + "Switcher" + ChatColor.GOLD + "!");
          clear(player);
          player.getInventory().setArmorContents(null);
          this.oneKit.add(player.getName());
          this.switcher.add(player.getName());
          player.playSound(player.getLocation(), Sound.ANVIL_LAND, 
            10.0F, 9.0F);
          player.getInventory().addItem(new ItemStack[] { espada });
          player.getInventory().addItem(new ItemStack[] { ball });
          for (int i = 0; i <= 34; i++) {
            player.getInventory().addItem(new ItemStack[] { sopa });
          }
          player.getInventory().setChestplate(
            new ItemStack(Material.LEATHER_CHESTPLATE));
          BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Switcher", 5);
        } else {
          player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
        }
      }

    }
    else if (commandLabel.equalsIgnoreCase("fisherman")) {
      if (player.hasPermission("pvp.fisherman")) {
        ItemStack espada = new ItemStack(Material.WOOD_SWORD);
        ItemMeta im = espada.getItemMeta();
      im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
        im.setDisplayName(ChatColor.DARK_RED + "Fisherman");
        espada.setItemMeta(im);
        ItemStack fish = new ItemStack(Material.FISHING_ROD);
        ItemMeta fim = fish.getItemMeta();
        fim.setLore(
          Arrays.asList(new String[] { "Use para teleportar os outros ate voce!" }));
        fim.setDisplayName(ChatColor.GREEN + "Fisherman's Fishing Rod");
        fish.setItemMeta(fim);
        if (!this.oneKit.contains(player.getName())) {
          player.sendMessage(ChatColor.DARK_RED + "[" + 
            ChatColor.YELLOW + "FightKits" + ChatColor.DARK_RED + 
            "]" + ChatColor.GOLD + " Voce escolheu o kit: " + 
            ChatColor.AQUA + "Fisherman" + ChatColor.GOLD + 
            "!");
          clear(player);
          player.getInventory().setArmorContents(null);
          this.oneKit.add(player.getName());
          this.fisherman.add(player.getName());
          player.playSound(player.getLocation(), Sound.ANVIL_LAND, 
            10.0F, 9.0F);
          player.getInventory().addItem(new ItemStack[] { espada });
          player.getInventory().addItem(new ItemStack[] { fish });
          for (int i = 0; i <= 34; i++) {
            player.getInventory().addItem(new ItemStack[] { sopa });
          }
          player.getInventory().setChestplate(
            new ItemStack(Material.LEATHER_CHESTPLATE));
          BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Fisherman", 5);
        } else {
          player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
        }
      }

    }
    else if (commandLabel.equalsIgnoreCase("anchor")) {
      if (player.hasPermission("pvp.anchor")) {
        ItemStack espada = new ItemStack(Material.WOOD_SWORD);
        ItemMeta im = espada.getItemMeta();
      im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
        im.setDisplayName(ChatColor.DARK_RED + "Anchor");
        espada.setItemMeta(im);
        if (!this.oneKit.contains(player.getName())) {
          player.sendMessage(ChatColor.DARK_RED + "[" + 
            ChatColor.YELLOW + "FightKits" + ChatColor.DARK_RED + 
            "]" + ChatColor.GOLD + " Voce escolheu o kit: " + 
            ChatColor.AQUA + "Anchor" + ChatColor.GOLD + "!");
          clear(player);
          player.getInventory().setArmorContents(null);
          this.oneKit.add(player.getName());
          this.anchor.add(player.getName());
          player.playSound(player.getLocation(), Sound.ANVIL_LAND, 
            10.0F, 9.0F);
          player.getInventory().addItem(new ItemStack[] { espada });
          for (int i = 0; i <= 35; i++) {
            player.getInventory().addItem(new ItemStack[] { sopa });
          }
          player.getInventory().setChestplate(
            new ItemStack(Material.LEATHER_CHESTPLATE));
          BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Anchor", 5);
        } else {
          player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
        }
      }

    }
    else if (commandLabel.equalsIgnoreCase("stomper")) {
      if (player.hasPermission("pvp.stomper")) {
        ItemStack espada = new ItemStack(Material.WOOD_SWORD);
        ItemMeta im = espada.getItemMeta();
        im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
        im.setDisplayName(ChatColor.DARK_RED + "Stomper");
        espada.setItemMeta(im);
        if (!this.oneKit.contains(player.getName())) {
          player.sendMessage(ChatColor.DARK_RED + "[" + 
            ChatColor.YELLOW + "FightKits" + ChatColor.DARK_RED + 
            "]" + ChatColor.GOLD + " Voce escolheu o kit: " + 
            ChatColor.AQUA + "Stomper" + ChatColor.GOLD + "!");
          clear(player);
          player.getInventory().setArmorContents(null);
          player.removePotionEffect(PotionEffectType.SPEED);
          this.oneKit.add(player.getName());
          this.stomper.add(player.getName());
          player.playSound(player.getLocation(), Sound.ANVIL_LAND, 
            10.0F, 9.0F);
          player.getInventory().addItem(new ItemStack[] { espada });
          for (int i = 0; i <= 35; i++) {
            player.getInventory().addItem(new ItemStack[] { sopa });
          }
          player.getInventory().setChestplate(
            new ItemStack(Material.LEATHER_CHESTPLATE));
          BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Stomper", 5);
        } else {
          player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
        }
      }

    }
    else if (commandLabel.equalsIgnoreCase("camel")) {
      if (player.hasPermission("pvp.camel")) {
        ItemStack espada = new ItemStack(Material.WOOD_SWORD);
        ItemMeta im = espada.getItemMeta();
      im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
        im.setDisplayName(ChatColor.DARK_RED + "Camel");
        espada.setItemMeta(im);
        if (!this.oneKit.contains(player.getName())) {
          player.sendMessage(ChatColor.DARK_RED + "[" + 
            ChatColor.YELLOW + "FightKits" + ChatColor.DARK_RED + 
            "]" + ChatColor.GOLD + " Voce escolheu o kit: " + 
            ChatColor.AQUA + "Camel" + ChatColor.GOLD + "!");
          clear(player);
          player.getInventory().setArmorContents(null);
          player.removePotionEffect(PotionEffectType.SPEED);
          this.oneKit.add(player.getName());
          this.camel.add(player.getName());
          player.playSound(player.getLocation(), Sound.ANVIL_LAND, 
            10.0F, 9.0F);
          player.getInventory().addItem(new ItemStack[] { espada });
          for (int i = 0; i <= 35; i++) {
            player.getInventory().addItem(new ItemStack[] { sopa });
          }
          player.getInventory().setChestplate(
            new ItemStack(Material.LEATHER_CHESTPLATE));
          BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Camel", 5);
        } else {
          player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
        }
      }

    }
    else if (commandLabel.equalsIgnoreCase("tank")) {
      if (player.hasPermission("pvp.tank")) {
        ItemStack espada = new ItemStack(Material.WOOD_SWORD);
        ItemMeta im = espada.getItemMeta();
      im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
        im.setDisplayName(ChatColor.DARK_RED + "Tank");
        espada.setItemMeta(im);
        if (!this.oneKit.contains(player.getName())) {
          player.sendMessage(ChatColor.DARK_RED + "[" + 
            ChatColor.YELLOW + "FightKits" + ChatColor.DARK_RED + 
            "]" + ChatColor.GOLD + " Voce escolheu o kit: " + 
            ChatColor.AQUA + "Tank" + ChatColor.GOLD + "!");
          clear(player);
          player.getInventory().setArmorContents(null);
          player.removePotionEffect(PotionEffectType.SPEED);
          this.oneKit.add(player.getName());
          this.tank.add(player.getName());
          player.playSound(player.getLocation(), Sound.ANVIL_LAND, 
            10.0F, 9.0F);
          player.getInventory().addItem(new ItemStack[] { espada });
          for (int i = 0; i <= 35; i++) {
            player.getInventory().addItem(new ItemStack[] { sopa });
          }
          player.getInventory().setChestplate(
            new ItemStack(Material.LEATHER_CHESTPLATE));
          BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Tank", 5);
        } else {
          player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
        }
      }

    }
    else if (commandLabel.equalsIgnoreCase("viper")) {
      if (player.hasPermission("pvp.viper")) {
        ItemStack espada = new ItemStack(Material.WOOD_SWORD);
        ItemMeta im = espada.getItemMeta();
      im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
        im.setDisplayName(ChatColor.DARK_RED + "Viper");
        espada.setItemMeta(im);
        if (!this.oneKit.contains(player.getName())) {
          player.sendMessage(ChatColor.DARK_RED + "[" + 
            ChatColor.YELLOW + "FightKits" + ChatColor.DARK_RED + 
            "]" + ChatColor.GOLD + " Voce escolheu o kit: " + 
            ChatColor.AQUA + "Viper" + ChatColor.GOLD + "!");
          clear(player);
          player.getInventory().setArmorContents(null);
          player.removePotionEffect(PotionEffectType.SPEED);
          this.oneKit.add(player.getName());
          this.viper.add(player.getName());
          player.playSound(player.getLocation(), Sound.ANVIL_LAND, 
            10.0F, 9.0F);
          player.getInventory().addItem(new ItemStack[] { espada });
          for (int i = 0; i <= 35; i++) {
            player.getInventory().addItem(new ItemStack[] { sopa });
          }
          player.getInventory().setChestplate(
            new ItemStack(Material.LEATHER_CHESTPLATE));
          BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Viper", 5);
        } else {
          player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
        }
      }

    }
    else if (commandLabel.equalsIgnoreCase("snail")) {
      if (player.hasPermission("pvp.snail")) {
        ItemStack espada = new ItemStack(Material.WOOD_SWORD);
        ItemMeta im = espada.getItemMeta();
      im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
        im.setDisplayName(ChatColor.DARK_RED + "Snail");
        espada.setItemMeta(im);
        if (!this.oneKit.contains(player.getName())) {
          player.sendMessage(ChatColor.DARK_RED + "[" + 
            ChatColor.YELLOW + "FightKits" + ChatColor.DARK_RED + 
            "]" + ChatColor.GOLD + " Voce escolheu o kit: " + 
            ChatColor.AQUA + "Snail" + ChatColor.GOLD + "!");
          clear(player);
          player.getInventory().setArmorContents(null);
          player.removePotionEffect(PotionEffectType.SPEED);
          this.oneKit.add(player.getName());
          this.snail.add(player.getName());
          player.playSound(player.getLocation(), Sound.ANVIL_LAND, 
            10.0F, 9.0F);
          player.getInventory().addItem(new ItemStack[] { espada });
          for (int i = 0; i <= 35; i++) {
            player.getInventory().addItem(new ItemStack[] { sopa });
          }
          player.getInventory().setChestplate(
            new ItemStack(Material.LEATHER_CHESTPLATE));
          BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Snail", 5);
        } else {
          player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
        }
      }

    }
    else if (commandLabel.equalsIgnoreCase("berserker")) {
      if (player.hasPermission("pvp.berserker")) {
        ItemStack espada = new ItemStack(Material.WOOD_SWORD);
        ItemMeta im = espada.getItemMeta();
      im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
        im.setDisplayName(ChatColor.DARK_RED + "Berserker");
        espada.setItemMeta(im);
        if (!this.oneKit.contains(player.getName())) {
          player.sendMessage(ChatColor.DARK_RED + "[" + 
            ChatColor.YELLOW + "FightKits" + ChatColor.DARK_RED + 
            "]" + ChatColor.GOLD + " Voce escolheu o kit: " + 
            ChatColor.AQUA + "Berserker" + ChatColor.GOLD + 
            "!");
          clear(player);
          player.getInventory().setArmorContents(null);
          player.removePotionEffect(PotionEffectType.SPEED);
          this.oneKit.add(player.getName());
          this.berserker.add(player.getName());
          player.playSound(player.getLocation(), Sound.ANVIL_LAND, 
            10.0F, 9.0F);
          player.getInventory().addItem(new ItemStack[] { espada });
          for (int i = 0; i <= 35; i++) {
            player.getInventory().addItem(new ItemStack[] { sopa });
          }
          player.getInventory().setChestplate(
            new ItemStack(Material.LEATHER_CHESTPLATE));
          BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Berseker", 5);
        } else {
          player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
        }
      }

    }
    else if (commandLabel.equalsIgnoreCase("cookiemonster")) {
      if (player.hasPermission("pvp.cookiemonster")) {
        ItemStack espada = new ItemStack(Material.WOOD_SWORD);
        ItemMeta im = espada.getItemMeta();
      im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
        im.setDisplayName(ChatColor.DARK_RED + "CookieMonster");
        espada.setItemMeta(im);
        ItemStack cookie = new ItemStack(Material.COOKIE, 33);
        ItemMeta cim = cookie.getItemMeta();
        cim.setLore(
          Arrays.asList(new String[] { "Coma e ganhe Speed 2!" }));
        cim.setDisplayName(ChatColor.DARK_RED + 
          "CookieMonster's Cookie");
        cookie.setItemMeta(cim);
        if (!this.oneKit.contains(player.getName())) {
          player.sendMessage(ChatColor.DARK_RED + "[" + 
            ChatColor.YELLOW + "FightKits" + ChatColor.DARK_RED + 
            "]" + ChatColor.GOLD + " Voce escolheu o kit: " + 
            ChatColor.AQUA + "CookieMonster" + ChatColor.GOLD + 
            "!");
          clear(player);
          player.getInventory().setArmorContents(null);
          player.removePotionEffect(PotionEffectType.SPEED);
          this.oneKit.add(player.getName());
          this.cookiemonster.add(player.getName());
          player.playSound(player.getLocation(), Sound.ANVIL_LAND, 
            10.0F, 9.0F);
          player.getInventory().addItem(new ItemStack[] { espada });
          player.getInventory().addItem(new ItemStack[] { cookie });
          for (int i = 0; i <= 34; i++) {
            player.getInventory().addItem(new ItemStack[] { sopa });
          }
          player.getInventory().setChestplate(
            new ItemStack(Material.LEATHER_CHESTPLATE));
          BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "CookieMonster", 5);
        } else {
          player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
        }
      }

    }
    else if (commandLabel.equalsIgnoreCase("flash")) {
      if (player.hasPermission("pvp.flash")) {
        ItemStack espada = new ItemStack(Material.WOOD_SWORD);
        ItemMeta im = espada.getItemMeta();
      im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
        im.setDisplayName(ChatColor.DARK_RED + "Flash");
        espada.setItemMeta(im);
        ItemStack flasht = new ItemStack(Material.REDSTONE_TORCH_ON);
        ItemMeta fim = flasht.getItemMeta();
        fim.setLore(Arrays.asList(new String[] { 
          "Use para se teleportar para onde olhas!", 
          "DEIXE NO SLOT 2 SENAO NAO RECUPERA ELA!" }));
        fim.setDisplayName(ChatColor.DARK_RED + "Flash's Torch");
        flasht.setItemMeta(fim);
        if (!this.oneKit.contains(player.getName())) {
          player.sendMessage(ChatColor.DARK_RED + "[" + 
            ChatColor.YELLOW + "FightKits" + ChatColor.DARK_RED + 
            "]" + ChatColor.GOLD + " Voce escolheu o kit: " + 
            ChatColor.AQUA + "Flash" + ChatColor.GOLD + "!");
          clear(player);
          player.getInventory().setArmorContents(null);
          player.removePotionEffect(PotionEffectType.SPEED);
          this.oneKit.add(player.getName());
          this.flash.add(player.getName());
          player.playSound(player.getLocation(), Sound.ANVIL_LAND, 
            10.0F, 9.0F);
          player.getInventory().addItem(new ItemStack[] { espada });
          player.getInventory().addItem(new ItemStack[] { flasht });
          for (int i = 0; i <= 34; i++) {
            player.getInventory().addItem(new ItemStack[] { sopa });
          }
          player.getInventory().setChestplate(
            new ItemStack(Material.LEATHER_CHESTPLATE));
          BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Flash", 5);
        } else {
          player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
        }
      }
    }
    else
    {
      int i;
      if (commandLabel.equalsIgnoreCase("timelord")) {
        if (player.hasPermission("pvp.timelord")) {
          ItemStack espada = new ItemStack(Material.WOOD_SWORD);
          ItemMeta im = espada.getItemMeta();
        im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
          im.setDisplayName(ChatColor.DARK_RED + "Timelord");
          espada.setItemMeta(im);
          ItemStack clock = new ItemStack(Material.WATCH);
          ItemMeta cim = clock.getItemMeta();
          cim.setLore(
            Arrays.asList(new String[] { "Use para paralisar os jogadores à 5 blocos de distancia!" }));
          cim.setDisplayName(ChatColor.DARK_RED + "Timelord's Watch");
          clock.setItemMeta(cim);
          if (!this.oneKit.contains(player.getName())) {
            player.sendMessage(ChatColor.DARK_RED + "[" + 
              ChatColor.YELLOW + "FightKits" + ChatColor.DARK_RED + 
              "]" + ChatColor.GOLD + " Voce escolheu o kit: " + 
              ChatColor.AQUA + "Timelord" + ChatColor.GOLD + 
              "!");
            clear(player);
            player.getInventory().setArmorContents(null);
            player.removePotionEffect(PotionEffectType.SPEED);
            this.oneKit.add(player.getName());
            this.timelord.add(player.getName());
            player.playSound(player.getLocation(), Sound.ANVIL_LAND, 
              10.0F, 9.0F);
            player.getInventory().addItem(new ItemStack[] { espada });
            player.getInventory().addItem(new ItemStack[] { clock });
            for (i = 0; i <= 34; i++) {
              player.getInventory().addItem(new ItemStack[] { sopa });
            }
            player.getInventory().setChestplate(
              new ItemStack(Material.LEATHER_CHESTPLATE));
            BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "TimeLord", 5);
          } else {
            player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
          }
        }

      }
      else if (commandLabel.equalsIgnoreCase("viking")) {
        if (player.hasPermission("pvp.viking")) {
          ItemStack espada = new ItemStack(Material.STONE_AXE);
          espada.addEnchantment(Enchantment.DAMAGE_ALL, 3);
          ItemMeta im = espada.getItemMeta();
          im.setDisplayName(ChatColor.DARK_RED + "Viking");
        im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
          espada.setItemMeta(im);
          if (!this.oneKit.contains(player.getName())) {
            player.sendMessage(ChatColor.DARK_RED + "[" + 
              ChatColor.YELLOW + "FightKits" + ChatColor.DARK_RED + 
              "]" + ChatColor.GOLD + " Voce escolheu o kit: " + 
              ChatColor.AQUA + "Viking" + ChatColor.GOLD + "!");
            clear(player);
            player.getInventory().setArmorContents(null);
            player.removePotionEffect(PotionEffectType.SPEED);
            this.oneKit.add(player.getName());
            player.playSound(player.getLocation(), Sound.ANVIL_LAND, 
              10.0F, 9.0F);
            player.getInventory().addItem(new ItemStack[] { espada });
            for (int i1 = 0; i1 < 35; i1++) {
              player.getInventory().addItem(new ItemStack[] { sopa });
            }
            player.getInventory().setChestplate(
              new ItemStack(Material.LEATHER_CHESTPLATE));
            BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Viking", 5);
          } else {
            player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
          }
        }

      }
      else if (commandLabel.equalsIgnoreCase("turtle")) {
        if (player.hasPermission("pvp.turtle")) {
          ItemStack espada = new ItemStack(Material.WOOD_SWORD);
          ItemMeta im = espada.getItemMeta();
        im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
          im.setDisplayName(ChatColor.DARK_RED + "Turtle");
          espada.setItemMeta(im);
          if (!this.oneKit.contains(player.getName())) {
            player.sendMessage(ChatColor.DARK_RED + "[" + 
              ChatColor.YELLOW + "FightKits" + ChatColor.DARK_RED + 
              "]" + ChatColor.GOLD + " Voce escolheu o kit: " + 
              ChatColor.AQUA + "Turtle" + ChatColor.GOLD + "!");
            clear(player);
            player.getInventory().setArmorContents(null);
            player.removePotionEffect(PotionEffectType.SPEED);
            this.oneKit.add(player.getName());
            this.turtle.add(player.getName());
            player.playSound(player.getLocation(), Sound.ANVIL_LAND, 
              10.0F, 9.0F);
            player.getInventory().addItem(new ItemStack[] { espada });
            for (int i1 = 0; i1 <= 35; i1++) {
              player.getInventory().addItem(new ItemStack[] { sopa });
            }
            player.getInventory().setChestplate(
              new ItemStack(Material.LEATHER_CHESTPLATE));
            BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Turtle", 5);
          } else {
            player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
          }
        }

      }
      else if (commandLabel.equalsIgnoreCase("frosty")) {
        if (player.hasPermission("pvp.frosty")) {
          ItemStack espada = new ItemStack(Material.WOOD_SWORD);
          ItemMeta im = espada.getItemMeta();
        im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
          im.setDisplayName(ChatColor.DARK_RED + "Frosty");
          espada.setItemMeta(im);
          if (!this.oneKit.contains(player.getName())) {
            player.sendMessage(ChatColor.DARK_RED + "[" + 
              ChatColor.YELLOW + "FightKits" + ChatColor.DARK_RED + 
              "]" + ChatColor.GOLD + " Voce escolheu o kit: " + 
              ChatColor.AQUA + "Frosty" + ChatColor.GOLD + "!");
            clear(player);
            player.getInventory().setArmorContents(null);
            player.removePotionEffect(PotionEffectType.SPEED);
            this.oneKit.add(player.getName());
            this.frosty.add(player.getName());
            player.playSound(player.getLocation(), Sound.ANVIL_LAND, 
              10.0F, 9.0F);
            player.getInventory().addItem(new ItemStack[] { espada });
            for (int i1 = 0; i1 <= 35; i1++) {
              player.getInventory().addItem(new ItemStack[] { sopa });
            }
            player.getInventory().setChestplate(
              new ItemStack(Material.LEATHER_CHESTPLATE));
            BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Frosty", 5);
          } else {
            player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
          }
        }

      }
      else if (commandLabel.equalsIgnoreCase("vampire")) {
        if (player.hasPermission("pvp.vampire")) {
          ItemStack espada = new ItemStack(Material.WOOD_SWORD);
          ItemMeta im = espada.getItemMeta();
        im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
          im.setDisplayName(ChatColor.DARK_RED + "Vampire");
          espada.setItemMeta(im);
          if (!this.oneKit.contains(player.getName())) {
            player.sendMessage(ChatColor.DARK_RED + "[" + 
              ChatColor.YELLOW + "FightKits" + ChatColor.DARK_RED + 
              "]" + ChatColor.GOLD + " Voce escolheu o kit: " + 
              ChatColor.AQUA + "Vampire" + ChatColor.GOLD + "!");
            clear(player);
            player.getInventory().setArmorContents(null);
            player.removePotionEffect(PotionEffectType.SPEED);
            this.oneKit.add(player.getName());
            this.vampire.add(player.getName());
            player.playSound(player.getLocation(), Sound.ANVIL_LAND, 
              10.0F, 9.0F);
            player.getInventory().addItem(new ItemStack[] { espada });
            for (int i1 = 0; i1 <= 35; i1++) {
              player.getInventory().addItem(new ItemStack[] { sopa });
            }
            player.getInventory().setChestplate(
              new ItemStack(Material.LEATHER_CHESTPLATE));
            BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Vampire", 5);
          } else {
            player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
          }
        }

      }
      else if (commandLabel.equalsIgnoreCase("milkman")) {
        if (player.hasPermission("pvp.milkman")) {
          ItemStack espada = new ItemStack(Material.WOOD_SWORD);
          ItemMeta im = espada.getItemMeta();
        im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
          im.setDisplayName(ChatColor.DARK_RED + "Milkman");
          espada.setItemMeta(im);
          if (!this.oneKit.contains(player.getName())) {
            player.sendMessage(ChatColor.DARK_RED + "[" + 
              ChatColor.YELLOW + "FightKits" + ChatColor.DARK_RED + 
              "]" + ChatColor.GOLD + " Voce escolheu o kit: " + 
              ChatColor.AQUA + "Milkman" + ChatColor.GOLD + "!");
            clear(player);
            player.getInventory().setArmorContents(null);
            player.removePotionEffect(PotionEffectType.SPEED);
            this.oneKit.add(player.getName());
            this.milkman.add(player.getName());
            player.playSound(player.getLocation(), Sound.ANVIL_LAND, 
              10.0F, 9.0F);
            player.getInventory().addItem(new ItemStack[] { espada });
            player.getInventory().addItem(
              new ItemStack[] { 
              new ItemStack(Material.MILK_BUCKET, 4) });
            for (int i1 = 0; i1 <= 34; i1++) {
              player.getInventory().addItem(new ItemStack[] { sopa });
            }
            player.getInventory().setChestplate(
              new ItemStack(Material.LEATHER_CHESTPLATE));
            BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Milkman", 5);
          } else {
            player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
          }
        }

      }
      else if (commandLabel.equalsIgnoreCase("neo")) {
        if (player.hasPermission("pvp.neo")) {
          ItemStack espada = new ItemStack(Material.WOOD_SWORD);
          ItemMeta im = espada.getItemMeta();
        im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
          im.setDisplayName(ChatColor.DARK_RED + "Neo");
          espada.setItemMeta(im);
          if (!this.oneKit.contains(player.getName())) {
            player.sendMessage(ChatColor.DARK_RED + "[" + 
              ChatColor.YELLOW + "FightKits" + ChatColor.DARK_RED + 
              "]" + ChatColor.GOLD + " Voce escolheu o kit: " + 
              ChatColor.AQUA + "Neo" + ChatColor.GOLD + "!");
            clear(player);
            player.getInventory().setArmorContents(null);
            player.removePotionEffect(PotionEffectType.SPEED);
            this.oneKit.add(player.getName());
            this.neo.add(player.getName());
            player.playSound(player.getLocation(), Sound.ANVIL_LAND, 
              10.0F, 9.0F);
            player.getInventory().addItem(new ItemStack[] { espada });
            for (int i1 = 0; i1 <= 35; i1++) {
              player.getInventory().addItem(new ItemStack[] { sopa });
            }
            player.getInventory().setChestplate(
              new ItemStack(Material.LEATHER_CHESTPLATE));
            BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Neo", 5);
          } else {
            player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
          }
        }

      }
      else if (commandLabel.equalsIgnoreCase("rider")) {
        if (player.hasPermission("pvp.rider")) {
          ItemStack espada = new ItemStack(Material.WOOD_SWORD);
          ItemMeta im = espada.getItemMeta();
        im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
          im.setDisplayName(ChatColor.DARK_RED + "Rider");
          espada.setItemMeta(im);
          if (!this.oneKit.contains(player.getName())) {
            player.sendMessage(ChatColor.DARK_RED + "[" + 
              ChatColor.YELLOW + "FightKits" + ChatColor.DARK_RED + 
              "]" + ChatColor.GOLD + " Voce escolheu o kit: " + 
              ChatColor.AQUA + "Rider" + ChatColor.GOLD + "!");
            clear(player);
            player.getInventory().setArmorContents(null);
            player.removePotionEffect(PotionEffectType.SPEED);
            this.oneKit.add(player.getName());
            this.rider.add(player.getName());
            player.playSound(player.getLocation(), Sound.ANVIL_LAND, 
              10.0F, 9.0F);
            player.getInventory().addItem(new ItemStack[] { espada });
            player.getInventory().addItem(
              new ItemStack[] { new ItemStack(Material.SADDLE) });
            for (int i1 = 0; i1 <= 34; i1++) {
              player.getInventory().addItem(new ItemStack[] { sopa });
            }
            player.getInventory().setChestplate(
              new ItemStack(Material.LEATHER_CHESTPLATE));
            BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Rider", 5);
          } else {
            player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
          }
        }
      } else if (commandLabel.equalsIgnoreCase("hg")) {
        if (player.hasPermission("pvp.hg")) {
          ItemStack espada = new ItemStack(Material.WOOD_SWORD);
          ItemMeta im = espada.getItemMeta();
        im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
          im.setDisplayName(ChatColor.DARK_RED + "HG");
          espada.setItemMeta(im);
          if (!this.oneKit.contains(player.getName())) {
            player.sendMessage(ChatColor.DARK_RED + "[" + 
              ChatColor.YELLOW + "FightKits" + ChatColor.DARK_RED + 
              "]" + ChatColor.GOLD + " Voce escolheu o kit: " + 
              ChatColor.AQUA + "HG" + ChatColor.GOLD + "!");
            clear(player);
            player.getInventory().setArmorContents(null);
            player.removePotionEffect(PotionEffectType.SPEED);
            this.oneKit.add(player.getName());
            this.hg.add(player.getName());
            player.playSound(player.getLocation(), Sound.ANVIL_LAND, 
              10.0F, 9.0F);
            player.getInventory().addItem(new ItemStack[] { espada });
            player.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
            for (int i1 = 0; i1 <= 35; i1++)
              player.getInventory().addItem(new ItemStack[] { sopa });
            BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Hg", 5);
          } else {
            player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
          }
        }
      } else if (commandLabel.equalsIgnoreCase("hulk")) {
        if (player.hasPermission("pvp.hulk")) {
          ItemStack espada = new ItemStack(Material.WOOD_SWORD);
          ItemMeta im = espada.getItemMeta();
        im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
          im.setDisplayName(ChatColor.DARK_RED + "Hulk");
          espada.setItemMeta(im);
          if (!this.oneKit.contains(player.getName())) {
            player.sendMessage(ChatColor.DARK_RED + "[" + 
              ChatColor.YELLOW + "FightKits" + ChatColor.DARK_RED + 
              "]" + ChatColor.GOLD + " Voce escolheu o kit: " + 
              ChatColor.AQUA + "Hulk" + ChatColor.GOLD + "!");
            clear(player);
            player.getInventory().setArmorContents(null);
            player.removePotionEffect(PotionEffectType.SPEED);
            this.oneKit.add(player.getName());
            this.hulk.add(player.getName());
            player.playSound(player.getLocation(), Sound.ANVIL_LAND, 
              10.0F, 9.0F);
            player.getInventory().addItem(new ItemStack[] { espada });
            player.getInventory()
              .addItem(
              new ItemStack[] { 
              new ItemStack(Material.SADDLE, 1) });
            for (int i1 = 0; i1 <= 34; i1++) {
              player.getInventory().addItem(new ItemStack[] { sopa });
            }
            player.getInventory().setChestplate(
              new ItemStack(Material.LEATHER_CHESTPLATE));
            BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Hulk", 5);
          } else {
            player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
          }
        }
      }
      else if ((commandLabel.equalsIgnoreCase("kangaroo")) && 
        (player.hasPermission("pvp.kangaroo"))) {
        ItemStack espada = new ItemStack(Material.WOOD_SWORD);
        ItemStack keng = new ItemStack(Material.FIREWORK);
        ItemMeta im2 = keng.getItemMeta();
        im2.setDisplayName(ChatColor.GOLD + "Double-Jump Rocket");
        keng.setItemMeta(im2);
        ItemMeta im = espada.getItemMeta();
        im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
        im.setDisplayName(ChatColor.DARK_RED + "Kangaroo");
        espada.setItemMeta(im);
        if (!this.oneKit.contains(player.getName())) {
          player.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.YELLOW + "FightKits" + ChatColor.DARK_RED + "]" + ChatColor.GOLD + " Voce escolheu o kit: " + ChatColor.AQUA + "Kangaroo" + ChatColor.GOLD + "!");
          clear(player);
          player.getInventory().setArmorContents(null);
          player.removePotionEffect(PotionEffectType.SPEED);
          this.oneKit.add(player.getName());
          this.kangaroo.add(player.getName());
          player.playSound(player.getLocation(), Sound.ANVIL_LAND, 10.0F, 
            9.0F);
          player.getInventory().addItem(new ItemStack[] { espada });
          player.getInventory().addItem(
            new ItemStack[] { keng });
          for (int i1 = 0; i1 <= 34; i1++) {
            player.getInventory().addItem(new ItemStack[] { sopa });
          }
          player.getInventory().setChestplate(
            new ItemStack(Material.LEATHER_CHESTPLATE));
          BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Kangaroo", 5);
        } else {
          player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
        }

      }
      else if ((commandLabel.equalsIgnoreCase("specialist")) && 
        (player.hasPermission("pvp.specialist"))) {
        ItemStack espada = new ItemStack(Material.WOOD_SWORD);
        ItemMeta im = espada.getItemMeta();
      im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
        im.setDisplayName(ChatColor.DARK_RED + "Specialist");
        espada.setItemMeta(im);
        if (!this.oneKit.contains(player.getName())) {
          player.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.YELLOW + 
            "FightKits" + ChatColor.DARK_RED + "]" + ChatColor.GOLD + 
            " Voce escolheu o kit: " + ChatColor.AQUA + 
            "Specialist" + ChatColor.GOLD + "!");
          clear(player);
          player.getInventory().setArmorContents(null);
          player.removePotionEffect(PotionEffectType.SPEED);
          this.oneKit.add(player.getName());
          this.specialist.add(player.getName());
          player.playSound(player.getLocation(), Sound.ANVIL_LAND, 10.0F, 
            9.0F);
          player.getInventory().addItem(new ItemStack[] { espada });
          player.getInventory().addItem(
            new ItemStack[] { new ItemStack(Material.BOOK) });
          for (int i1 = 0; i1 <= 34; i1++) {
            player.getInventory().addItem(new ItemStack[] { sopa });
          }
          player.getInventory().setChestplate(
            new ItemStack(Material.LEATHER_CHESTPLATE));
          BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Soecialist", 5);
        } else {
          player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
        }

      }
      else if ((commandLabel.equalsIgnoreCase("spectre")) && 
        (player.hasPermission("pvp.spectre"))) {
        ItemStack espada = new ItemStack(Material.WOOD_SWORD);
        ItemMeta im = espada.getItemMeta();
      im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
        im.setDisplayName(ChatColor.DARK_RED + "Spectre");
        espada.setItemMeta(im);
        if (!this.oneKit.contains(player.getName())) {
          player.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.YELLOW + 
            "FightKits" + ChatColor.DARK_RED + "]" + ChatColor.GOLD + 
            " Voce escolheu o kit: " + ChatColor.AQUA + "Spectre" + 
            ChatColor.GOLD + "!");
          clear(player);
          player.getInventory().setArmorContents(null);
          player.removePotionEffect(PotionEffectType.SPEED);
          this.oneKit.add(player.getName());
          this.spectre.add(player.getName());
          player.playSound(player.getLocation(), Sound.ANVIL_LAND, 10.0F, 
            9.0F);
          player.getInventory().addItem(new ItemStack[] { espada });
          player.getInventory().addItem(
            new ItemStack[] { new ItemStack(Material.REDSTONE) });
          for (int i1 = 0; i1 <= 34; i1++) {
            player.getInventory().addItem(new ItemStack[] { sopa });
          }
          player.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
          player.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
          BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Spectre", 5);
        } else {
          player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
        }

      }
      else if ((commandLabel.equalsIgnoreCase("poseidon")) && 
        (player.hasPermission("pvp.poseidon"))) {
        ItemStack espada = new ItemStack(Material.WOOD_SWORD);
        ItemMeta im = espada.getItemMeta();
      im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
        im.setDisplayName(ChatColor.DARK_RED + "Poseidon");
        espada.setItemMeta(im);
        if (!this.oneKit.contains(player.getName())) {
          player.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.YELLOW + "FightKits" + ChatColor.DARK_RED + "]" + ChatColor.GOLD + " Voce escolheu o kit: " + ChatColor.AQUA + "Poseidon" + ChatColor.GOLD + "!");
          clear(player);
          player.getInventory().setArmorContents(null);
          player.removePotionEffect(PotionEffectType.SPEED);
          this.oneKit.add(player.getName());
          this.poseidon.add(player.getName());
          player.playSound(player.getLocation(), Sound.ANVIL_LAND, 10.0F, 
            9.0F);
          player.getInventory().addItem(new ItemStack[] { espada });
          for (int i1 = 0; i1 <= 35; i1++) {
            player.getInventory().addItem(new ItemStack[] { sopa });
          }
          BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Poseidon", 5);
        } else {
          player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
        }

      }
      else if ((commandLabel.equalsIgnoreCase("monk")) && 
        (player.hasPermission("pvp.monk"))) {
        ItemStack espada = new ItemStack(Material.WOOD_SWORD);
        ItemMeta im = espada.getItemMeta();
      im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
        im.setDisplayName(ChatColor.DARK_RED + "Monk");
        espada.setItemMeta(im);
        if (!this.oneKit.contains(player.getName())) {
          player.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.YELLOW + 
            "FightKits" + ChatColor.DARK_RED + "]" + ChatColor.GOLD + 
            " Voce escolheu o kit: " + ChatColor.AQUA + "Monk" + 
            ChatColor.GOLD + "!");
          clear(player);
          player.getInventory().setArmorContents(null);
          player.removePotionEffect(PotionEffectType.SPEED);
          this.oneKit.add(player.getName());
          this.monk.add(player.getName());
          player.playSound(player.getLocation(), Sound.ANVIL_LAND, 10.0F, 
            9.0F);
          player.getInventory().addItem(new ItemStack[] { espada });
          player.getInventory()
            .addItem(new ItemStack[] { 
            new ItemStack(Material.BLAZE_ROD) });
          for (int i1 = 0; i1 <= 34; i1++) {
            player.getInventory().addItem(new ItemStack[] { sopa });
          }
          player.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
          BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Monk", 5);
        } else {
          player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
        }

      }
      else if ((commandLabel.equalsIgnoreCase("lifeline")) && 
        (player.hasPermission("pvp.lifeline"))) {
        ItemStack espada = new ItemStack(Material.WOOD_SWORD);
        ItemMeta im = espada.getItemMeta();
      im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
        im.setDisplayName(ChatColor.DARK_RED + "Lifeline");
        espada.setItemMeta(im);
        if (!this.oneKit.contains(player.getName())) {
          player.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.YELLOW + 
            "FightKits" + ChatColor.DARK_RED + "]" + ChatColor.GOLD + 
            " Voce escolheu o kit: " + ChatColor.AQUA + 
            "Lifeline" + ChatColor.GOLD + "!");
          clear(player);
          player.getInventory().setArmorContents(null);
          this.oneKit.add(player.getName());
          this.lifeline.add(player.getName());
          player.playSound(player.getLocation(), Sound.ANVIL_LAND, 10.0F, 
            9.0F);
          player.getInventory().addItem(new ItemStack[] { espada });
          player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STRING) });
          for (int i1 = 0; i1 <= 34; i1++) {
            player.getInventory().addItem(new ItemStack[] { sopa });
          }
          player.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
          BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Lifeline", 5);
        } else {
          player.sendMessage(ChatColor.RED + "Voce ja esta com um kit");
        }

      }
      else if ((commandLabel.equalsIgnoreCase("urgal")) && 
        (player.hasPermission("pvp.urgal"))) {
        ItemStack espada = new ItemStack(Material.WOOD_SWORD);
        ItemMeta im = espada.getItemMeta();
      im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
          Arrays.asList(new String[] { "Espada usada para combater inimigos!" });
        im.setDisplayName(ChatColor.DARK_RED + "Urgal");
        espada.setItemMeta(im);
        if (!this.oneKit.contains(player.getName())) {
          player.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.YELLOW + "FightKits" + ChatColor.DARK_RED + "]" + ChatColor.GOLD + " Voce escolheu o kit: " + ChatColor.AQUA + "Urgal" + ChatColor.GOLD + "!");
          clear(player);
          player.getInventory().setArmorContents(null);
          this.oneKit.add(player.getName());
          this.urgal.add(player.getName());
          player.playSound(player.getLocation(), Sound.ANVIL_LAND, 10.0F, 
            9.0F);
          player.getInventory().addItem(new ItemStack[] { espada });
          player.getInventory().addItem(new ItemStack[] { 
            new Potion(PotionType.STRENGTH, 1).toItemStack(1) });
          for (int i1 = 0; i1 <= 34; i1++)
            player.getInventory().addItem(new ItemStack[] { sopa });
          BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Urgal", 5);
        }
        else {
          player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
        }

      }
      else if ((commandLabel.equalsIgnoreCase("vacuum")) && 
    	        (player.hasPermission("pvp.vacuum"))) {
    	        ItemStack espada = new ItemStack(Material.WOOD_SWORD);
    	        ItemStack vacuum = new ItemStack(Material.ENDER_PEARL);
    	        ItemMeta im2 = vacuum.getItemMeta();
    	        im2.setDisplayName(ChatColor.WHITE+ "Black Hole");
    	        vacuum.setItemMeta(im2);
    	        ItemMeta im = espada.getItemMeta();
    	        im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
    	        im.setDisplayName(ChatColor.DARK_RED + "Vacuum");
    	        espada.setItemMeta(im);
    	        if (!this.oneKit.contains(player.getName())) {
    	          player.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.YELLOW + "FightKits" + ChatColor.DARK_RED + "]" + ChatColor.GOLD + " Voce escolheu o kit: " + ChatColor.AQUA + "Vacuum" + ChatColor.GOLD + "!");
    	          clear(player);
    	          player.getInventory().setArmorContents(null);
    	          this.oneKit.add(player.getName());
    	          this.vacuum.add(player.getName());
    	          player.playSound(player.getLocation(), Sound.ANVIL_LAND, 10.0F, 9.0F);
    	          player.getInventory().addItem(new ItemStack[] { espada });
    	          player.getInventory().addItem(new ItemStack[] { vacuum });
    	          player.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
    	          BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Vacuum", 5);
    	          for (int i1 = 0; i1 <= 33; i1++)
    	            player.getInventory().addItem(new ItemStack[] { sopa });
    	        }
    	        else {
    	          player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
    	        }

    	      }
    else if ((commandLabel.equalsIgnoreCase("phantom")) && 
	        (player.hasPermission("pvp.phantom"))) {
	        ItemStack espada = new ItemStack(Material.WOOD_SWORD);
	        ItemStack phantom = new ItemStack(Material.FEATHER);
	        ItemMeta im = espada.getItemMeta();
	        im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
	        im.setDisplayName(ChatColor.DARK_RED + "Phantom");
	        espada.setItemMeta(im);
	        if (!this.oneKit.contains(player.getName())) {
	          player.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.YELLOW + "FightKits" + ChatColor.DARK_RED + "]" + ChatColor.GOLD + " Voce escolheu o kit: " + ChatColor.AQUA + "Phantom" + ChatColor.GOLD + "!");
	          clear(player);
	          player.getInventory().setArmorContents(null);
	          this.oneKit.add(player.getName());
	          this.phantom.add(player.getName());
	          player.playSound(player.getLocation(), Sound.ANVIL_LAND, 10.0F, 9.0F);
	          player.getInventory().addItem(new ItemStack[] { espada });
	          player.getInventory().addItem(new ItemStack[] { phantom });
	          player.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
	          BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Phantom", 5);
	          for (int i1 = 0; i1 <= 34; i1++)
	            player.getInventory().addItem(new ItemStack[] { sopa });
	        }
	        else {
	          player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
	        }
      }
    else if ((commandLabel.equalsIgnoreCase("grappler")) && 
	        (player.hasPermission("pvp.grappler"))) {
	        ItemStack espada = new ItemStack(Material.WOOD_SWORD);
	        ItemStack grapp = new ItemStack(Material.LEASH);
	        ItemMeta im2 = grapp.getItemMeta();
	        im2.setDisplayName("§6Grappling Hook");
	        grapp.setItemMeta(im2);
	        ItemMeta im = espada.getItemMeta();
	        im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
	        im.setDisplayName(ChatColor.DARK_RED + "Grappler");
	        espada.setItemMeta(im);
	        if (!this.oneKit.contains(player.getName())) {
	          player.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.YELLOW + "FightKits" + ChatColor.DARK_RED + "]" + ChatColor.GOLD + " Voce escolheu o kit: " + ChatColor.AQUA + "Grappler" + ChatColor.GOLD + "!");
	          clear(player);
	          player.getInventory().setArmorContents(null);
	          this.oneKit.add(player.getName());
	          this.grappler.add(player.getName());
	          player.playSound(player.getLocation(), Sound.ANVIL_LAND, 10.0F, 9.0F);
	          player.getInventory().addItem(new ItemStack[] { espada });
	          player.getInventory().addItem(new ItemStack[] { grapp });
	          player.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
	          BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Grappler", 5);
	          for (int i1 = 0; i1 <= 34; i1++)
	            player.getInventory().addItem(new ItemStack[] { sopa });
	        }
	        else {
	          player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
	        }
      }
    else if ((commandLabel.equalsIgnoreCase("endermage")) && (player.hasPermission("pvp.endermage"))) {
	        ItemStack espada = new ItemStack(Material.WOOD_SWORD);
	        ItemStack ender = new ItemStack(Material.PORTAL);
	        ItemMeta im2 = ender.getItemMeta();
	        im2.setDisplayName("§6Endermage Portal");
	        ender.setItemMeta(im2);
	        ItemMeta im = espada.getItemMeta();
	        im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
	        im.setDisplayName(ChatColor.DARK_RED + "Endermage");
	        espada.setItemMeta(im);
	        if (!this.oneKit.contains(player.getName())) {
	          player.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.YELLOW + "FightKits" + ChatColor.DARK_RED + "]" + ChatColor.GOLD + " Voce escolheu o kit: " + ChatColor.AQUA + "Endermage" + ChatColor.GOLD + "!");
	          clear(player);
	          player.getInventory().setArmorContents(null);
	          this.oneKit.add(player.getName());
	          this.endermage.add(player.getName());
	          player.playSound(player.getLocation(), Sound.ANVIL_LAND, 10.0F, 9.0F);
	          player.getInventory().addItem(new ItemStack[] { espada });
	          player.getInventory().addItem(new ItemStack[] { ender });
	          player.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
	          BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Endermage", 5);
	          for (int i1 = 0; i1 <= 34; i1++)
	            player.getInventory().addItem(new ItemStack[] { sopa });
	        }
	        else {
	          player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
	        }
      }
    else if ((commandLabel.equalsIgnoreCase("thor")) && (player.hasPermission("pvp.thor"))) {
        ItemStack espada = new ItemStack(Material.WOOD_SWORD);
        ItemStack thor = new ItemStack(Material.WOOD_AXE);
        ItemMeta im2 = thor.getItemMeta();
        im2.setDisplayName("§6Thor Axe");
        thor.setItemMeta(im2);
        ItemMeta im = espada.getItemMeta();
        im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
        im.setDisplayName(ChatColor.DARK_RED + "Thor");
        espada.setItemMeta(im);
        if (!this.oneKit.contains(player.getName())) {
          player.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.YELLOW + "FightKits" + ChatColor.DARK_RED + "]" + ChatColor.GOLD + " Voce escolheu o kit: " + ChatColor.AQUA + "Thor" + ChatColor.GOLD + "!");
          clear(player);
          player.getInventory().setArmorContents(null);
          this.oneKit.add(player.getName());
          this.thor.add(player.getName());
          player.playSound(player.getLocation(), Sound.ANVIL_LAND, 10.0F, 9.0F);
          player.getInventory().addItem(new ItemStack[] { espada });
          player.getInventory().addItem(new ItemStack[] { thor });
          player.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
          BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Thor", 5);
          for (int i1 = 0; i1 <= 34; i1++)
            player.getInventory().addItem(new ItemStack[] { sopa });
        }
        else {
          player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
        }
  }
    else if (commandLabel.equalsIgnoreCase("salamander")) {
		if (player.hasPermission("pvp.salamander")) {
			 ItemStack espada = new ItemStack(Material.WOOD_SWORD);
		     ItemMeta im = espada.getItemMeta();
		     im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
	         im.setDisplayName(ChatColor.DARK_RED + "Salamander");
	         espada.setItemMeta(im);
	         if (!this.oneKit.contains(player.getName())) {
	             player.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.YELLOW + "FightKits" + ChatColor.DARK_RED + "]" + ChatColor.GOLD + " Voce escolheu o kit: " + ChatColor.AQUA + "Salamander" + ChatColor.GOLD + "!");
	             clear(player);
	             player.getInventory().setArmorContents(null);
				player.removePotionEffect(PotionEffectType.SPEED);
				this.oneKit.add(player.getName());
				this.salamander.add(player.getName());
				player.playSound(player.getLocation(), Sound.ANVIL_LAND, 10.0F, 9.0F);
				player.getInventory().addItem(new ItemStack[] { espada });
				 for (int i1 = 0; i1 <= 34; i1++)
			            player.getInventory().addItem(new ItemStack[] { sopa });
			        }
				BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Salamander", 5);
			} else {
		          player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
	        }

		}
    else if ((commandLabel.equalsIgnoreCase("gladiator")) && (player.hasPermission("pvp.gladiator"))) {
        ItemStack espada = new ItemStack(Material.WOOD_SWORD);
        ItemStack glad = new ItemStack(Material.IRON_FENCE);
        ItemMeta fim = glad.getItemMeta();
        fim.setDisplayName(ChatColor.GOLD + "Use para ir 1v1!");
        glad.setItemMeta(fim);
        ItemMeta im = espada.getItemMeta();
        im.setLore(Arrays.asList(new String[] { "Fight-PvP 0.4" }));
        im.setDisplayName(ChatColor.DARK_RED + "Gladiator");
        espada.setItemMeta(im);
        if (!this.oneKit.contains(player.getName())) {
          player.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.YELLOW + "FightKits" + ChatColor.DARK_RED + "]" + ChatColor.GOLD + " Voce escolheu o kit: " + ChatColor.AQUA + "Gladiator" + ChatColor.GOLD + "!");
          clear(player);
          player.getInventory().setArmorContents(null);
          this.oneKit.add(player.getName());
          this.gladiator.add(player.getName());
          player.playSound(player.getLocation(), Sound.ANVIL_LAND, 10.0F, 9.0F);
          player.getInventory().addItem(new ItemStack[] { espada });
          player.getInventory().addItem(new ItemStack[] { glad });
          player.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
          BarAPI.setMessage(player, ChatColor.GOLD + "Você pegou o kit " + ChatColor.DARK_RED + "Gladiator", 5);
          for (int i1 = 0; i1 <= 34; i1++)
            player.getInventory().addItem(new ItemStack[] { sopa });
        }
        else {
          player.sendMessage(ChatColor.RED + "Voce ja esta com um kit!");
        }
  }
}
	return false;
 }
  
}