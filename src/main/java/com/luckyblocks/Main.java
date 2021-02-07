package com.luckyblocks;

import com.luckyblocks.commands.LuckyBlockCommandExecutor;
import com.luckyblocks.items.ItemManager;
import com.luckyblocks.listeners.LuckyBlockListener;
import com.luckyblocks.tab_completers.LuckyBlockTabCompleter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        // Static inits

        ItemManager.init();

        // Recipes

        Bukkit.addRecipe(ItemManager.LUCKY_BLOCK.getRecipe());

        // Listeners

        getServer().getPluginManager().registerEvents(new LuckyBlockListener(), this);

        // Commands

        getCommand("lb").setExecutor(new LuckyBlockCommandExecutor());
        getCommand("lb").setTabCompleter(new LuckyBlockTabCompleter());
    }

    @Override
    public void onDisable() {

    }
}
