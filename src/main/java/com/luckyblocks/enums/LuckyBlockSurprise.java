package com.luckyblocks.enums;

import com.luckyblocks.events.*;

public enum LuckyBlockSurprise {
    CREEPER(3, new CreeperSurpriseHandler()),
    ANVIL(3, new AnvilSurpriseHandler()),
    COBWEB(3, new CobwebTrapSurpriseHandler()),
    BLAZE_TOWER(3, new BlazeTowerSurpriseHandler()),
    LEVITATE(3, new LevitateSurpriseHandler()),
    SONIC(3, new SonicSurpriseHandler());

    public int weight;
    public LuckyBlockSurpriseHandler eventHandler;

    LuckyBlockSurprise(int weight, LuckyBlockSurpriseHandler eventHandler) {
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
