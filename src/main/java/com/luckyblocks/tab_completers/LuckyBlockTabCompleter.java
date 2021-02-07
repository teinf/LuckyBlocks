package com.luckyblocks.tab_completers;

import com.luckyblocks.enums.LuckyBlockSurprise;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class LuckyBlockTabCompleter implements TabCompleter {

    List<String> availableCompletions = new ArrayList<String>();
    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if(availableCompletions.isEmpty()) {
            for (LuckyBlockSurprise lbs : LuckyBlockSurprise.values()) {
                availableCompletions.add(lbs.toString());
            }
        }
        List<String> result = new ArrayList<String>();

        if(args.length == 1) {
            for(String completion: availableCompletions) {
                if(completion.toLowerCase().startsWith(args[0].toLowerCase())) {
                    result.add(completion);
                }
            }

            return result;
        }
        return null;
    }
}
