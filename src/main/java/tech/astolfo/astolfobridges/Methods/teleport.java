package tech.astolfo.astolfobridges.Methods;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.util.Vector;

public class teleport {
    private String player2 = "yankewithoutbrim";

    public void teleportBack(Player p) {
        Location location = new Location(p.getWorld(), 0.5, 77, -25.5);
        Location location2 = new Location(p.getWorld(), 0.5, 77, 26.5);
        String name = p.getName();
        new inventory().clearArmour(p);
        p.getInventory().clear();
        if (Bukkit.getPlayer("LieutenantLolli") == p) {
            new inventory().magenta(p);
        }
        if (Bukkit.getPlayer(player2) == p) {
            new inventory().orange(p);
        }
        p.setHealth(20);
        p.setFoodLevel(20);
        for (PotionEffect eff : p.getActivePotionEffects()) {
            p.removePotionEffect(eff.getType());
        }
        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 10.0F, 1.0F);
        p.setVelocity(new Vector(0, 0, 0));
        if(name.equals(player2)) {
            p.teleport(location2);
            p.getLocation().setYaw(-180);
        } else {
            p.teleport(location);
        }
    }
}
