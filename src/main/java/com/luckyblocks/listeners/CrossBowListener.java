package com.luckyblocks.listeners;

import com.luckyblocks.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CrossbowMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class CrossBowListener implements Listener {

    @EventHandler
    public void onEntityShootBow(EntityShootBowEvent e) {
        if(e.getEntity() instanceof Player) {
            if(e.getBow().getType() == Material.CROSSBOW) {
                CrossbowMeta meta = (CrossbowMeta) e.getBow().getItemMeta().clone();
                ItemStack arrow = new ItemStack(Material.ARROW, 1);
                meta.addChargedProjectile(arrow);


                new BukkitRunnable() {

                    @Override
                    public void run() {
                        Bukkit.broadcastMessage("Hello2");
                        e.getBow().setItemMeta(meta);
                    }

                }.runTaskLater(Main.getPlugin(Main.class), 10);
            }
        }
    }
}
