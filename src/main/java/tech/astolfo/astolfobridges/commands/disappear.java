package tech.astolfo.astolfobridges.commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class disappear {
    public void spawn(Player p) {
        Location location18 = new Location(p.getWorld(), 0, 76, -27);
        Location location19 = new Location(p.getWorld(), 1, 76, -27);
        Location location20 = new Location(p.getWorld(), -1, 76, -27);

        Location location21 = new Location(p.getWorld(), 0, 76, -26);
        Location location22 = new Location(p.getWorld(), 1, 76, -26);
        Location location23 = new Location(p.getWorld(), -1, 76, -26);

        Location location24 = new Location(p.getWorld(), 0, 76, -25);
        Location location25 = new Location(p.getWorld(), 1, 76, -25);
        Location location26 = new Location(p.getWorld(), -1, 76, -25);

        Location location27 = new Location(p.getWorld(), 0, 76, 27);
        Location location28 = new Location(p.getWorld(), 1, 76, 27);
        Location location29 = new Location(p.getWorld(), -1, 76, 27);

        Location location30 = new Location(p.getWorld(), 0, 76, 26);
        Location location31 = new Location(p.getWorld(), 1, 76, 26);
        Location location32 = new Location(p.getWorld(), -1, 76, 26);

        Location location33 = new Location(p.getWorld(), 0, 76, 25);
        Location location34 = new Location(p.getWorld(), 1, 76, 25);
        Location location35 = new Location(p.getWorld(), -1, 76, 25);

        location18.getBlock().setType(Material.AIR);
        location19.getBlock().setType(Material.AIR);
        location20.getBlock().setType(Material.AIR);

        location21.getBlock().setType(Material.AIR);
        location22.getBlock().setType(Material.AIR);
        location23.getBlock().setType(Material.AIR);

        location24.getBlock().setType(Material.AIR);
        location25.getBlock().setType(Material.AIR);
        location26.getBlock().setType(Material.AIR);

        location27.getBlock().setType(Material.AIR);
        location28.getBlock().setType(Material.AIR);
        location29.getBlock().setType(Material.AIR);

        location30.getBlock().setType(Material.AIR);
        location31.getBlock().setType(Material.AIR);
        location32.getBlock().setType(Material.AIR);

        location33.getBlock().setType(Material.AIR);
        location34.getBlock().setType(Material.AIR);
        location35.getBlock().setType(Material.AIR);
    }
}
