package xyz.$renzy.Commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import xyz.$renzy.MineChat;

public class CommandMineChat extends Command {
    public CommandMineChat() {
        super("mc");
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if (strings[0].equalsIgnoreCase("reload")) {
            MineChat.getPlugin().getConfigManager().loadWords();
            MineChat.getPlugin().getConfigManager().loadUrls();
            commandSender.sendMessage(ChatColor.GREEN + "Eklenti başarıyla yeniden yüklendi!");
        } else if (strings[0].equalsIgnoreCase("words") && strings.length > 1 && strings[1].equalsIgnoreCase("list")) {
            for (String word : MineChat.getPlugin().getConfigManager().getWords()) {
                commandSender.sendMessage(word);
            }
        }else if (strings[0].equalsIgnoreCase("urls") && strings.length > 1 && strings[1].equalsIgnoreCase("list")) {
            for (String url : MineChat.getPlugin().getConfigManager().getUrls()) {
                commandSender.sendMessage(url);
            }
        } else {
            commandSender.sendMessage(ChatColor.RED + "Geçersiz komut. Kullanım: /mc [reload | words list | urls list]");
        }
    }
}
