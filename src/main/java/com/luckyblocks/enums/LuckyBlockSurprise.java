package com.luckyblocks.enums;

import com.luckyblocks.events.*;

public enum LuckyBlockSurprise {
    ANVIL(3, new AnvilSurpriseHandler()),
    BLAZE_TOWER(3, new BlazeTowerSurpriseHandler()),
    COBWEB(3, new CobwebTrapSurpriseHandler()),
    CREEPER(3, new CreeperSurpriseHandler()),
    FIREWORK(3, new FireworkSurpriseHandler()),
    HOLE(3, new HoleSurpriseHandler()),
    LEVITATE(3, new LevitateSurpriseHandler()),
    SONIC(3, new SonicSurpriseHandler());

    public int weight;
    public SurpriseHandler eventHandler;

    LuckyBlockSurprise(int weight, SurpriseHandler eventHandler) {
        this.weight = weight;
        this.eventHandler = eventHandler;
    }

    public static LuckyBlockSurprise getRandomSurprise() {
        LuckyBlockSurprise[] surprises = LuckyBlockSurprise.values();

        double totalWeight = 0;

        for (LuckyBlockSurprise e : surprises) {
            totalWeight += e.weight;
        }

        double r = Math.random() * totalWeight;

        int idx = 0;
        for (idx = 0; idx < surprises.length; idx++) {
            r -= surprises[idx].weight;
            if (r <= 0.0) break;
        }

        return surprises[idx];
    }
}
