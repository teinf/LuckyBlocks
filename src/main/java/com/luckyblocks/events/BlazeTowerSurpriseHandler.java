package com.luckyblocks.events;

import org.bukkit.block.Block;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.Random;

public class BlazeTowerSurpriseHandler implements LuckyBlockSurpriseHandler {
    @Override
    public void run(Player player, Block block) {
        Random random = new Random();

        int towerSize = random.nextInt(4) + 3;
        double blazeHealth = 0.1;

        Blaze blaze = (Blaze) player.getWorld().spawnEntity(block.getLocation(), EntityType.BLAZE);
        blaze.setHealth(blazeHealth);

        for (int i = 0; i < towerSize; i++) {
            Blaze child = (Blaze) player.getWorld().spawnEntity(block.getLocation(), EntityType.BLAZE);
            child.setHealth(blazeHealth);
            blaze.addPassenger(child);
            blaze = child;
        }
    }
}
