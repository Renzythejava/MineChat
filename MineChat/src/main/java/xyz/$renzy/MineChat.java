package xyz.$renzy;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.plugin.Plugin;
import xyz.$renzy.Commands.CommandMineChat;
import xyz.$renzy.Events.ChatEvent;
import xyz.$renzy.Manager.ConfigManager;

public final class MineChat extends Plugin {

    private static MineChat instance;
    private ConfigManager configManager;

    @Override
    public void onEnable() {
        instance=this;
        configManager = new ConfigManager();
        getProxy().getPluginManager().registerListener(this,new ChatEvent());
        getProxy().getPluginManager().registerCommand(this, new CommandMineChat());
        getProxy().getConsole().sendMessage(ChatColor.GREEN + "Plugin enabled!");
        getProxy().getConsole().sendMessage(ChatColor.BLUE + "Name: " + getDescription().getName());
        getProxy().getConsole().sendMessage(ChatColor.BLUE + "Author: " + getDescription().getAuthor());
        getProxy().getConsole().sendMessage(ChatColor.BLUE + "Version: " + getDescription().getVersion());
        getProxy().getConsole().sendMessage(ChatColor.BLUE + "Description: " + getDescription().getDescription());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static MineChat getPlugin() {
        return instance;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }
}
