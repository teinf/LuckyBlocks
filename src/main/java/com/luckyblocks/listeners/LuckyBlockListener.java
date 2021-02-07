package com.luckyblocks.listeners;

import com.luckyblocks.enums.LuckyBlockSurprise;
import com.luckyblocks.items.ItemManager;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

import java.util.ArrayList;
import java.util.HashMap;

public class LuckyBlockListener implements Listener {

    HashMap<Location, Boolean> luckyBlockLocations = new HashMap<Location, Boolean>();

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        if (e.getItemInHand().getItemMeta().equals(ItemManager.LUCKY_BLOCK.getItemMeta())) {
            luckyBlockLocations.put(e.getBlock().getLocation(), true);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Location breakLocation = e.getBlock().getLocation();

        if (luckyBlockLocations.get(breakLocation) != null && luckyBlockLocations.get(breakLocation) == true) {
            LuckyBlockSurprise event = LuckyBlockSurprise.getRandomSurprise();
            event.eventHandler.run(e.getPlayer(), e.getBlock());
            luckyBlockLocations.put(breakLocation, false);
        }

    }

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent e) {
        ArrayList<Block> blocksToDestroy = new ArrayList<Block>(e.blockList());

        for (Block b : blocksToDestroy) {
            Location explodeBlockLocation = b.getLocation();
            if (luckyBlockLocations.get(explodeBlockLocation) != null && luckyBlockLocations.get(explodeBlockLocation) == true) {
                e.blockList().remove(b);
            }
        }
    }
}
