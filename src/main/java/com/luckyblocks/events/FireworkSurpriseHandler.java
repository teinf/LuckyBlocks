package com.luckyblocks.events;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.Random;

public class FireworkSurpriseHandler  implements SurpriseHandler {
    @Override
    public void run(Player player, Block block) {
        Random random = new Random();

        Location shotLocation = block.getLocation().clone().add(0, 1, 0);

        for (int i = 0; i <= 25; i++) {

            Firework firework = (Firework) shotLocation.getWorld().spawnEntity(shotLocation, EntityType.FIREWORK);
            FireworkMeta properties = firework.getFireworkMeta();

            properties.setPower(10);

            int r = random.nextInt(256);
            int g = random.nextInt(256);
            int b = random.nextInt(256);

            Color color = Color.fromRGB(r, g, b);
            FireworkEffect effect = FireworkEffect.builder().withColor(color).build();

            properties.addEffect(effect);

            firework.setFireworkMeta(properties);
            firework.detonate();
        }
    }
}
