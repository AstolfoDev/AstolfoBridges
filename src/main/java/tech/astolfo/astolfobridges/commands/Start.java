package tech.astolfo.astolfobridges.commands;

import com.mongodb.ConnectionString;
import com.mongodb.Mongo;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import net.md_5.bungee.api.ChatColor;
import org.bson.Document;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tech.astolfo.astolfobridges.Methods.chunks;
import tech.astolfo.astolfobridges.Methods.inventory;
import tech.astolfo.astolfobridges.Methods.scoreboard;

public class Start implements CommandExecutor {

    private String player2 = "yankewithoutbrim";

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        new chunks().clearWool(p);

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
        Document doc = new Document("player1", p.getUniqueId().toString())
                .append("player2", Bukkit.getPlayer(player2).getUniqueId().toString())
                .append("score1", 0)
                .append("score2", 0);
        collection.insertOne(doc);


        Location loc = new Location(p.getWorld(), 0.5, 77, -25.5);
        Location loc2 = new Location(p.getWorld(), 0.5, 77, 26.5);

        Location spawn1 = new Location(p.getWorld(), 57.5, 69, -9.5);
        Location spawn2 = new Location(p.getWorld(), 57.5, 69, 9.5);

        if (Bukkit.getPlayer("LieutenantLolli") != null) {
            Player plyr = Bukkit.getPlayer("LieutenantLolli");
            plyr.setGameMode(GameMode.SURVIVAL);
            plyr.teleport(spawn1);
        }
        if (Bukkit.getPlayer(player2) != null) {
            Player plyr2 = Bukkit.getPlayer(player2);
            plyr2.setGameMode(GameMode.SURVIVAL);
            plyr2.teleport(spawn2);
        }

        for (Player pl : Bukkit.getOnlinePlayers()) {
            pl.setScoreboard(new scoreboard().gameBoard(doc));
            pl.setAllowFlight(true);

            pl.getInventory().clear();
            new inventory().clearArmour(pl);
            pl.updateInventory();

            pl.sendTitle(ChatColor.RED+"3", "");
            pl.playNote(pl.getLocation(), Instrument.PIANO, Note.natural(0, Note.Tone.E));
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Player pl : Bukkit.getOnlinePlayers()) {
            pl.sendTitle(ChatColor.GOLD+"2", "");
            pl.playNote(pl.getLocation(), Instrument.PIANO, Note.natural(0, Note.Tone.D));
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Player pl : Bukkit.getOnlinePlayers()) {
            pl.sendTitle(ChatColor.YELLOW+"1", "");
            pl.playNote(pl.getLocation(), Instrument.PIANO, Note.natural(0, Note.Tone.C));
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Player pl : Bukkit.getOnlinePlayers()) {
            pl.sendTitle(ChatColor.GREEN+"GO!", "");
            pl.setAllowFlight(false);
            pl.playSound(pl.getLocation(), Sound.ORB_PICKUP, 10.0F, 1.0F);
        }

        if (Bukkit.getPlayer("LieutenantLolli") != null) {
            Player p1 = Bukkit.getPlayer("LieutenantLolli");
            new inventory().magenta(p1);
            p1.teleport(loc);
        }
        if (Bukkit.getPlayer(player2) != null) {
            Player p2 = Bukkit.getPlayer(player2);
            new inventory().orange(p2);
            p2.teleport(loc2);
        }
        return true;
    }
}
