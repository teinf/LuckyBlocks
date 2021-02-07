package com.luckyblocks.events;

import com.luckyblocks.Main;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class SonicSurpriseHandler implements SurpriseHandler {
    @Override
    public void run(Player player, Block block) {
        new BukkitRunnable() {

            int counter = 10;
            final float initialSpeed = 0.2f;

            final float speedIncreaseRate = 1.2f;
            final float playerMaxWalkSpeed = 1.0f;

            void resetPlayerSpeed() {
                player.setWalkSpeed(initialSpeed);
                this.cancel();
            }

            @Override
            public void run() {
                if(player.getWalkSpeed() * speedIncreaseRate < playerMaxWalkSpeed) {
                    player.setWalkSpeed((player.getWalkSpeed() * speedIncreaseRate));
                } else {
                    resetPlayerSpeed();
                    return;
                }

                if(counter == 0) {
                    resetPlayerSpeed();
                    return;
                }

                counter--;
            }

        }.runTaskTimer(Main.getPlugin(Main.class), 0, 20);
    }
}
