package com.luckyblocks.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CrossbowMeta;

public class CrossBowListener implements Listener {

    @EventHandler
    public void onEntityShootBow(EntityShootBowEvent e) {
        if(e.getEntity() instanceof Player) {
            if(e.getBow().getType() == Material.CROSSBOW) {
                CrossbowMeta meta = (CrossbowMeta) e.getBow().getItemMeta();
                ItemStack arrow = new ItemStack(Material.ARROW, 1);
                meta.addChargedProjectile(arrow);
                e.getBow().setItemMeta(meta);
            }
        }
    }

}
