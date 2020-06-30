package tech.astolfo.astolfobridges.Methods;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class chunks {
    public void clearWool(Player p) {
        for(Chunk c : p.getWorld().getLoadedChunks())
        {
            int X = c.getX() * 16;
            int Z = c.getZ() * 16;

            for (int x = 0; x < 16; x++)
            {
                for (int z = 0; z < 16; z++)
                {
                    for (int y = 53; y < 75; y++)
                    {
                        if (c.getWorld().getBlockTypeIdAt(X+x, y, Z+z) == Material.WOOL.getId())
                        {
                            c.getWorld().getBlockAt(X+x, y, Z+z).setType(Material.AIR);
                        }
                    }
                }
            }
        }
    }
}
