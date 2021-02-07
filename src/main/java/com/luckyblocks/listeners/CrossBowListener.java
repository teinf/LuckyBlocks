package com.luckyblocks.listeners;

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

public class CrossBowListener implements Listener {

    @EventHandler
    public void onEntityShootBow(EntityShootBowEvent e) {
        Bukkit.broadcastMessage("Hello");
        if(e.getEntity() instanceof Player) {
            Bukkit.broadcastMessage("Hello1");
            if(e.getBow().getType() == Material.CROSSBOW) {
                Bukkit.broadcastMessage("Hello2");
                CrossbowMeta meta = (CrossbowMeta) e.getBow().getItemMeta();
                ItemStack arrow = new ItemStack(Material.ARROW, 1);
                meta.addChargedProjectile(arrow);
                e.getBow().setItemMeta(meta);
            }
        }
    }

}
