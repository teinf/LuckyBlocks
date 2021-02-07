package com.luckyblocks.items;

import com.luckyblocks.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class LuckyBlock extends ItemStack {
    public LuckyBlock() {
        super(Material.SPONGE);

        ItemMeta meta = getItemMeta();

        if (meta != null) {
            String displayName = "&6&lLucky Block";
            meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayName));

            meta.setCustomModelData(1234567);

            this.setItemMeta(meta);
        }
    }

    public ShapedRecipe getRecipe() {
        NamespacedKey key = new NamespacedKey(Main.getPlugin(Main.class), "Lucky_Block");
        ShapedRecipe recipe = new ShapedRecipe(key, this);

        recipe.shape("AAA", "AAA", "AAA");
        recipe.setIngredient('A', Material.GOLD_BLOCK);

        return recipe;
    }
}
