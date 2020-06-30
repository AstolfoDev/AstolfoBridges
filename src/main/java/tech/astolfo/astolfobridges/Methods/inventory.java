package tech.astolfo.astolfobridges.Methods;

import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.material.Wool;

public class inventory {

    public void clearArmour(Player p){
        p.getInventory().setHelmet(null);
        p.getInventory().setChestplate(null);
        p.getInventory().setLeggings(null);
        p.getInventory().setBoots(null);
    }

    public void magenta(Player p) {
        ItemStack lchest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        LeatherArmorMeta lch = (LeatherArmorMeta) lchest.getItemMeta();
        lch.setColor(Color.fromRGB(176, 12, 201));
        lchest.setItemMeta(lch);

        ItemStack lleg = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta lgn = (LeatherArmorMeta) lleg.getItemMeta();
        lgn.setColor(Color.fromRGB(176, 12, 201));
        lleg.setItemMeta(lgn);

        ItemStack lboot = new ItemStack(Material.LEATHER_BOOTS, 1);
        LeatherArmorMeta lbt = (LeatherArmorMeta) lleg.getItemMeta();
        lbt.setColor(Color.fromRGB(176, 12, 201));
        lboot.setItemMeta(lbt);

        p.getEquipment().setChestplate(lchest);
        p.getEquipment().setLeggings(lleg);
        p.getEquipment().setBoots(lboot);

        p.getInventory().setItem(0, new ItemStack(Material.IRON_SWORD, 1));
        p.getInventory().setItem(1, new Wool(DyeColor.MAGENTA).toItemStack(64));
        p.getInventory().setItem(2, new Wool(DyeColor.MAGENTA).toItemStack(64));
        p.getInventory().setItem(3, new ItemStack(Material.GOLDEN_APPLE, 8));
        p.getInventory().setHeldItemSlot(0);
    }

    public void orange(Player p) {
        ItemStack lchest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        LeatherArmorMeta lch = (LeatherArmorMeta) lchest.getItemMeta();
        lch.setColor(Color.fromRGB(212, 77, 19));
        lchest.setItemMeta(lch);

        ItemStack lleg = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta lgn = (LeatherArmorMeta) lleg.getItemMeta();
        lgn.setColor(Color.fromRGB(212, 77, 19));
        lleg.setItemMeta(lgn);

        ItemStack lboot = new ItemStack(Material.LEATHER_BOOTS, 1);
        LeatherArmorMeta lbt = (LeatherArmorMeta) lleg.getItemMeta();
        lbt.setColor(Color.fromRGB(212, 77, 19));
        lboot.setItemMeta(lbt);

        p.getEquipment().setChestplate(lchest);
        p.getEquipment().setLeggings(lleg);
        p.getEquipment().setBoots(lboot);

        p.getInventory().setItem(0, new ItemStack(Material.IRON_SWORD, 1));
        p.getInventory().setItem(1, new Wool(DyeColor.ORANGE).toItemStack(64));
        p.getInventory().setItem(2, new Wool(DyeColor.ORANGE).toItemStack(64));
        p.getInventory().setItem(3, new ItemStack(Material.GOLDEN_APPLE, 8));
        p.getInventory().setHeldItemSlot(0);
    }
}
