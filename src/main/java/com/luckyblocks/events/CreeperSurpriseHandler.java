package com.luckyblocks.events;

import org.bukkit.block.Block;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class CreeperSurpriseHandler implements LuckyBlockSurpriseHandler {
    @Override
    public void run(Player player, Block block) {
        Creeper creeper = (Creeper) player.getWorld().spawnEntity(block.getLocation(), EntityType.CREEPER);
        creeper.setExplosionRadius(15);
        creeper.setPowered(true);
        creeper.setGlowing(true);
        creeper.setInvisible(true);
    }
}
