package tech.astolfo.astolfobridges.Listener;

import com.mongodb.BasicDBObject;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import jdk.nashorn.internal.parser.JSONParser;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.*;
import org.bukkit.potion.PotionEffectType;
import org.json.simple.JSONObject;
import tech.astolfo.astolfobridges.Methods.scoreboard;
import tech.astolfo.astolfobridges.Methods.teleport;

import java.util.UUID;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.*;

public class ABridgesListener implements Listener {
    ConnectionString conStr = new ConnectionString(
            "INSERT YOUR URL HERE"
    );
    MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(conStr)
            .retryWrites(true)
            .build();
    MongoClient mongoClient = MongoClients.create(settings);
    MongoDatabase database = mongoClient.getDatabase("Minigames");
    MongoCollection<Document> collection = database.getCollection("Portals");


    @EventHandler
    public void onFallDamage(EntityDamageEvent e) {
        if (e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void noDrop(PlayerDropItemEvent e) {
        e.getPlayer().sendMessage(ChatColor.RED+"(!) You cannot drop items!");
        e.setCancelled(true);
    }

    @EventHandler
    public void onDeathRespawn(EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        Player player = (Player) e.getEntity();

        if (e.getCause().equals((EntityDamageEvent.DamageCause.FALL))) return;

        if (player.getHealth() - e.getFinalDamage() > 0) {
            return;
        }
        new teleport().teleportBack(player);
        e.setCancelled(true);
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if (e.getPlayer().getLocation().getY() < 53) {
            new teleport().teleportBack(e.getPlayer());
        }
    }

    @EventHandler
    public void denyBreak(BlockBreakEvent e) {
        Player Lolli = Bukkit.getPlayer("LieutenantLolli");
        if (e.getBlock().getType() != Material.WOOL && e.getPlayer() != Lolli) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void noHunger(FoodLevelChangeEvent e) {
        if (e.getEntityType() != EntityType.PLAYER) return;
        if (e.getEntity().getItemInHand().getType() == Material.GOLDEN_APPLE) {
            e.getEntity().setHealth(20);
            e.getEntity().removePotionEffect(PotionEffectType.REGENERATION);
        }
        e.setCancelled(true);
    }

    @EventHandler
    public void onGoal(PlayerPortalEvent e) {
        if (e.getPlayer().getLocation().getBlock().getType().equals(Material.ENDER_PORTAL)) {
            Player Lolli = Bukkit.getPlayer("LieutenantLolli");
            if (e.getPlayer().getLocation().getZ() > 25) {
                if (e.getPlayer() != Lolli) {
                    e.getPlayer().sendMessage(ChatColor.RED + "(!) You can't score in your own portal!");
                    new teleport().teleportBack(e.getPlayer());
                } else {
                    Bson filter = eq("player1", e.getPlayer().getUniqueId().toString());
                    Document json = collection.find(filter).first();
                    if (json == null) return;
                    int score = (Integer) json.get("score1");
                    UUID uuid = UUID.fromString((String) json.get("player2"));
                    if (score >= 4) {
                        Bson update = set("score1", score+1);
                        collection.updateOne(filter, update);
                        json = collection.find(filter).first();
                        Bukkit.getPlayer(uuid).setGameMode(GameMode.SPECTATOR);
                        collection.deleteMany(filter);
                        for (Player pl : Bukkit.getOnlinePlayers()) {
                            pl.setScoreboard(new scoreboard().gameBoard(json));
                            pl.playSound(pl.getLocation(), Sound.ENDERDRAGON_DEATH, 10.0F, 1.0F);
                            pl.sendTitle(e.getPlayer().getName()+" wins!", "");
                        }
                    } else {
                        Bson update = set("score1", score+1);
                        collection.updateOne(filter, update);
                        json = collection.find(filter).first();
                        for (Player pl : Bukkit.getOnlinePlayers()) {
                            pl.setScoreboard(new scoreboard().gameBoard(json));
                            pl.sendTitle(ChatColor.LIGHT_PURPLE + e.getPlayer().getName() + " scored", null);
                            pl.playSound(pl.getLocation(), Sound.ENDERDRAGON_GROWL, 10.0F, 1.0F);
                            new teleport().teleportBack(pl);
                        }
                    }
                }
            } else if (e.getPlayer().getLocation().getZ() < 10) {
                if (e.getPlayer() == Lolli) {
                    e.getPlayer().sendMessage(ChatColor.RED + "(!) You can't score in your own portal!");
                    new teleport().teleportBack(e.getPlayer());
                } else {
                    Bson filter = eq("player2", e.getPlayer().getUniqueId().toString());
                    Document json = collection.find(filter).first();
                    if (json == null) return;
                    int score = (Integer) json.get("score2");
                    UUID uuid = UUID.fromString((String) json.get("player1"));
                    if (score == 4) {
                        Bson update = set("score2", score+1);
                        collection.updateOne(filter, update);
                        json = collection.find(filter).first();
                        Bukkit.getPlayer(uuid).setGameMode(GameMode.SPECTATOR);
                        collection.deleteMany(filter);
                        for (Player pl : Bukkit.getOnlinePlayers()) {
                            pl.setScoreboard(new scoreboard().gameBoard(json));
                            pl.playSound(pl.getLocation(), Sound.ENDERDRAGON_DEATH, 10.0F, 1.0F);
                            pl.sendTitle(e.getPlayer().getName()+" wins!", "");
                        }
                    } else {
                        Bson update = set("score2", score+1);
                        collection.updateOne(filter, update);
                        json = collection.find(filter).first();
                        for (Player pl : Bukkit.getOnlinePlayers()) {
                            pl.setScoreboard(new scoreboard().gameBoard(json));
                            pl.sendTitle(ChatColor.LIGHT_PURPLE + e.getPlayer().getName() + " scored", null);
                            pl.playSound(pl.getLocation(), Sound.ENDERDRAGON_GROWL, 10.0F, 1.0F);
                            new teleport().teleportBack(pl);
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        if (e.getBlockAgainst().getLocation().getZ() > 23 || e.getBlockAgainst().getLocation().getZ() < -23 || e.getBlockAgainst().getY() > 72 || e.getBlockAgainst().getY() < 53 || e.getBlockAgainst().getX() > 20 || e.getBlockAgainst().getX() < -20) {
            e.getPlayer().sendMessage(ChatColor.RED+"(!) You can't place blocks here!");
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onEndPortal(PlayerTeleportEvent e) {
        if (e.getCause().equals(PlayerTeleportEvent.TeleportCause.END_PORTAL)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        for (Player pl : Bukkit.getOnlinePlayers()) {
            pl.setScoreboard(new scoreboard().waitBoard1());
        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        for (Player pl : Bukkit.getOnlinePlayers()) {
            pl.setScoreboard(new scoreboard().waitBoard1());
        }
    }
}
