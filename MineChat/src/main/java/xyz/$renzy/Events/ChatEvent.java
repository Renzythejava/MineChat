package xyz.$renzy.Events;

import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import xyz.$renzy.MineChat;

import java.util.List;

public class ChatEvent implements Listener {

    @EventHandler
    public void onChat(net.md_5.bungee.api.event.ChatEvent event) {
        String message = event.getMessage();

        if(event.getSender() != null) {
            for(String word : MineChat.getPlugin().getConfigManager().getWords()) {
                if(message.contains(word)){
                    message.replace(word, "****");
                }
            }
            for(String url : MineChat.getPlugin().getConfigManager().getUrls()) {
                if(message.contains(url)) {
                    message.replace(url,"*******");
                }
            }

            event.setMessage(message);
        }
    }
}
