package com.luckyblocks.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.Random;

public class CobwebTrapSurpriseHandler implements LuckyBlockSurpriseHandler {
    @Override
    public void run(Player player, Block block) {
        Random random = new Random();

        Location airLocation = block.getLocation().clone();
        int squareLength = random.nextInt(6) * 2 + 1;
        int height = 7;

        for (int x = 0; x < squareLength; x++) {
            for (int y = 0; y < height; y++) {
                for (int z = 0; z < squareLength; z++) {
                    airLocation.add(x - (squareLength / 2), -y, z - (squareLength / 2));
                    airLocation.getBlock().setType(Material.AIR);
                    airLocation = block.getLocation().clone();
                }
            }
        }

        Location sandLocation = block.getLocation().clone();
        Location webLocation = block.getLocation().clone();
        Location lavaLocation = block.getLocation().clone();
        Location netherrackLocation = block.getLocation().clone();

        int netherrackSquareLength = squareLength + 2;
        int netherrackHeight = 2;

        for (int x = 0; x < squareLength; x++) {
            for (int z = 0; z < squareLength; z++) {
                sandLocation.add(x - (squareLength / 2), -1, z - (squareLength / 2));
                sandLocation.getBlock().setType(Material.SAND);
                sandLocation = block.getLocation().clone();

                webLocation.add(x - (squareLength / 2), -3, z - (squareLength / 2));
                webLocation.getBlock().setType(Material.COBWEB);
                webLocation = block.getLocation().clone();

                // Floor
                netherrackLocation.add(x - (squareLength / 2), -height, z - (squareLength / 2));
                netherrackLocation.getBlock().setType(Material.NETHERRACK);
                netherrackLocation = block.getLocation().clone();

                for (int y = 1; y <= 2; y++) {
                    lavaLocation.add(x - (squareLength / 2), -height + y, z - (squareLength / 2));
                    lavaLocation.getBlock().setType(Material.LAVA);
                    lavaLocation = block.getLocation().clone();
                }
            }
        }

        // Walls
        for (int x = 0; x < netherrackSquareLength; x++) {
            for (int y = 0; y < netherrackHeight; y++) {
                for (int z = 0; z < netherrackSquareLength; z++) {
                    boolean onEdge = (x == 0 || x == squareLength + 1 || z == 0 || z == squareLength + 1);
                    if (onEdge) {
                        netherrackLocation.add(x - (netherrackSquareLength / 2), -height + y, z - (netherrackSquareLength / 2));
                        netherrackLocation.getBlock().setType(Material.NETHERRACK);
                        netherrackLocation = block.getLocation().clone();
                    }
                }
            }
        }
    }
}
