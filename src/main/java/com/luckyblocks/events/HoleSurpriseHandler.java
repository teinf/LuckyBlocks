package com.luckyblocks.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.Random;

public class HoleSurpriseHandler  implements SurpriseHandler {
    @Override
    public void run(Player player, Block block) {
        Random random = new Random();

        Location airLocation = block.getLocation().clone();
        int squareLength = random.nextInt(6) * 2 + 1;
        int height = 50;

        for (int x = 0; x < squareLength; x++) {
            for (int y = 0; y < height; y++) {
                for (int z = 0; z < squareLength; z++) {
                    airLocation.add(x - (squareLength / 2), -y, z - (squareLength / 2));
                    airLocation.getBlock().setType(Material.AIR);
                    airLocation = block.getLocation().clone();
                }
            }
        }
    }
}
