package tech.astolfo.astolfobridges.Methods;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.util.Vector;
import tech.astolfo.astolfobridges.commands.Start;

public class teleport {

    private Player playerOne = new Start().playerOne;
    private Player playerTwo = new Start().playerTwo;

    public void teleportBack(Player p) {
        Location location = new Location(p.getWorld(), 0.5, 77, -25.5);
        Location location2 = new Location(p.getWorld(), 0.5, 77, 26.5);
        String name = p.getName();
        new inventory().clearArmour(p);
        p.getInventory().clear();
        if (Bukkit.getPlayer(playerOne.getName()) == p) {
            new inventory().magenta(p);
        }
        if (Bukkit.getPlayer(playerTwo.getName()) == p) {
            new inventory().orange(p);
        }
        p.setHealth(20);
        p.setFoodLevel(20);
        for (PotionEffect eff : p.getActivePotionEffects()) {
            p.removePotionEffect(eff.getType());
        }
        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 10.0F, 1.0F);
        p.setVelocity(new Vector(0, 0, 0));
        if(name.equals(playerTwo.getName())) {
            p.teleport(location2);
        } else {
            p.teleport(location);
        }
    }
}
