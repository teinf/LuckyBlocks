package com.luckyblocks.listeners;

import com.luckyblocks.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CrossbowMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class CrossBowListener implements Listener {

    @EventHandler
    public void onEntityShootBow(EntityShootBowEvent e) {
        if(e.getEntity() instanceof Player) {
            if(e.getBow().getType() == Material.CROSSBOW) {
                new BukkitRunnable() {

                    @Override
                    public void run() {
                        CrossbowMeta meta = (CrossbowMeta) e.getBow().getItemMeta().clone();
                        ItemStack arrow = new ItemStack(Material.ARROW, 1);
                        List<ItemStack> projectiles = new ArrayList<ItemStack>();
                        projectiles.add(arrow);
                        meta.setChargedProjectiles(projectiles);
                        e.getBow().setItemMeta(meta);
                    }

                }.runTaskLater(Main.getPlugin(Main.class), 5);
            }
        }
    }
}
