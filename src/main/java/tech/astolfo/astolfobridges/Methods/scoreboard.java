package tech.astolfo.astolfobridges.Methods;

import org.bson.Document;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class scoreboard {
    public Scoreboard waitBoard1() {
        Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = sb.registerNewObjective("Waitingboard1", "HIDE");

        obj.setDisplayName(ChatColor.translateAlternateColorCodes('§', "§5§lPORTALS"));
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score line1 = obj.getScore(ChatColor.GRAY+"Server | "+ChatColor.DARK_GRAY+"test1A");
        Score line2 = obj.getScore("");
        Score line3 = obj.getScore("Players: "+ChatColor.LIGHT_PURPLE+Bukkit.getOnlinePlayers().toArray().length+"/2");
        Score line4 = obj.getScore("Map: "+ChatColor.LIGHT_PURPLE+"Islands");
        Score line5 = obj.getScore(" ");
        Score line6;
        if (Bukkit.getOnlinePlayers().toArray().length < 2) {
            line6 = obj.getScore(ChatColor.YELLOW + "Waiting for players...");
        } else {
            line6 = obj.getScore(ChatColor.GREEN+"Ready to play!");
        }
        Score line7 = obj.getScore("  ");
        Score line8 = obj.getScore(ChatColor.LIGHT_PURPLE+"Astolfo"+ChatColor.WHITE+"Games");

        line1.setScore(7);
        line2.setScore(6);
        line3.setScore(5);
        line4.setScore(4);
        line5.setScore(3);
        line6.setScore(2);
        line7.setScore(1);
        line8.setScore(0);

        return sb;
    }

    public Scoreboard gameBoard(Document data) {
        Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = sb.registerNewObjective("Waitingboard1", "HIDE");

        obj.setDisplayName(ChatColor.translateAlternateColorCodes('§', "§5§lPORTALS"));
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score line1 = obj.getScore(ChatColor.GRAY+"Server | "+ChatColor.DARK_GRAY+"test1A");
        Score line2 = obj.getScore("");
        Score line3 = obj.getScore("Score");
        Score line4 = obj.getScore(ChatColor.DARK_PURPLE+"Purple: "+ChatColor.GREEN+data.get("score1")+"/5");
        Score line5 = obj.getScore(ChatColor.GOLD+"Orange: "+ChatColor.GREEN+data.get("score2")+"/5");
        Score line6 = obj.getScore(" ");
        Score line7 = obj.getScore("Map: "+ChatColor.LIGHT_PURPLE+"Islands");
        Score line8 = obj.getScore("  ");
        Score line9 = obj.getScore(ChatColor.LIGHT_PURPLE+"Astolfo"+ChatColor.WHITE+"Games");

        line1.setScore(8);
        line2.setScore(7);
        line3.setScore(6);
        line4.setScore(5);
        line5.setScore(4);
        line6.setScore(3);
        line7.setScore(2);
        line8.setScore(1);
        line8.setScore(0);

        return sb;
    }
}
