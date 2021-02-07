package com.luckyblocks.events;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public interface LuckyBlockSurpriseHandler {
    void run(Player player, Block block);
}
