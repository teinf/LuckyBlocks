package com.luckyblocks.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.Random;

public class AnvilSurpriseHandler implements LuckyBlockSurpriseHandler {

    @Override
    public void run(Player player, Block block) {
        Random random = new Random();

        Location anvilLocation = block.getLocation().clone();
        int squareLength = random.nextInt(6) * 2 + 1;

        for (int x = 0; x < squareLength; x++) {
            for (int z = 0; z < squareLength; z++) {
                int y = random.nextInt(6) + 20;
                boolean dropAnvil = (Math.random() < 0.80);

                if (dropAnvil) {
                    anvilLocation.add(x - (squareLength / 2), y, z - (squareLength / 2));
                    anvilLocation.getBlock().setType(Material.ANVIL);
                    anvilLocation = block.getLocation().clone();
                }
            }
        }

        Location barsLocation = block.getLocation().clone();
        int barsSquareLength = squareLength + 2;
        int barsHeight = 2;

        for (int x = 0; x < barsSquareLength; x++) {
            for (int y = 0; y < barsHeight; y++) {
                for (int z = 0; z < barsSquareLength; z++) {
                    boolean onEdge = (x == 0 || x == squareLength + 1 || z == 0 || z == squareLength + 1);
                    if (onEdge) {
                        barsLocation.add(x - (barsSquareLength / 2), y, z - (barsSquareLength / 2));
                        barsLocation.getBlock().setType(Material.IRON_BARS);
                        barsLocation = block.getLocation().clone();
                    }
                }
            }
        }
    }
}