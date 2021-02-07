package com.luckyblocks.commands;

import com.luckyblocks.enums.LuckyBlockSurprise;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LuckyBlockCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (label.equalsIgnoreCase("lb") || label.equalsIgnoreCase("luckyblock")) {
                LuckyBlockSurprise lbs;
                if (args.length > 0) {
                    lbs = LuckyBlockSurprise.valueOf(args[0]);
                } else {
                    lbs = LuckyBlockSurprise.getRandomSurprise();
                }

                lbs.eventHandler.run(p, p.getLocation().getBlock());
            }
        }
        return false;
    }
}
