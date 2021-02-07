package com.luckyblocks.events;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class LevitateSurpriseHandler implements LuckyBlockSurpriseHandler{
    @Override
    public void run(Player player, Block block) {
        int levitateDuration = (int) (Math.random() * 10) + 3;
        int levitateAmplifier = (int) (Math.random() * 5) + 1;
        player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 20*levitateDuration, levitateAmplifier));
    }
}
