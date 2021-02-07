package com.luckyblocks.events;

import org.bukkit.block.Block;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class BlazeTowerSurpriseHandler implements LuckyBlockSurpriseHandler {
    @Override
    public void run(Player player, Block block) {
        Blaze blaze = (Blaze) player.getWorld().spawnEntity(block.getLocation(), EntityType.BLAZE);
        blaze.setHealth(2);

        for (int i = 0; i < 10; i++) {
            Blaze child = (Blaze) player.getWorld().spawnEntity(block.getLocation(), EntityType.BLAZE);
            child.setHealth(2);
            blaze.addPassenger(child);
            blaze = child;
        }
    }
}
