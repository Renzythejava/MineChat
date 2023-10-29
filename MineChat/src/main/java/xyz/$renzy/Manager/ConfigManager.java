package xyz.$renzy.Manager;

import net.md_5.bungee.api.ChatColor;
import xyz.$renzy.MineChat;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConfigManager {

    private List<String> words = new ArrayList<>();
    private List<String> urls = new ArrayList<>();
    private File wordsFile,urlsFile;

    public ConfigManager() {
        loadWordsFile();
        loadUrlsFile();
    }

    public void loadUrlsFile() {
        urlsFile = new File(MineChat.getPlugin().getDataFolder(), "urls.txt");
        MineChat.getPlugin().getDataFolder().mkdir();
        try {
            urlsFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(!urlsFile.exists()) {
            MineChat.getPlugin().getProxy().getConsole().sendMessage(ChatColor.RED + "Cannot find urls.txt file, creating new file.");
            return;
        }
        loadUrls();
    }


    public void loadWordsFile() {
        wordsFile= new File(MineChat.getPlugin().getDataFolder(), "words.txt");
        MineChat.getPlugin().getDataFolder().mkdir();
        try {
            wordsFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(!wordsFile.exists()) {
            MineChat.getPlugin().getProxy().getConsole().sendMessage(ChatColor.RED + "Cannot find words.txt file, creating new file.");
            return;
        }
        loadWords();
    }

    public void loadUrls() {
        urls.clear();
        try(BufferedReader reader = new BufferedReader(new FileReader(urlsFile))) {
            String url;
            while ((url = reader.readLine()) != null) {
                urls.add(url);
            }
        } catch (IOException e) {
            MineChat.getPlugin().getProxy().getConsole().sendMessage(ChatColor.RED + "Cannot load urls.");
        }
    }
    public void loadWords() {
        words.clear();
        try(BufferedReader reader = new BufferedReader(new FileReader(wordsFile))) {
            String word;
            while ((word = reader.readLine()) != null) {
                words.add(word);
            }
        } catch (IOException e) {
            MineChat.getPlugin().getProxy().getConsole().sendMessage(ChatColor.RED + "Cannot load words.");
        }
    }

    public List<String> getWords() {
        return words;
    }
    public List<String> getUrls() {
        return urls;
    }

    public File getUrlsFile() {
        return urlsFile;
    }

    public File getWordsFile() {
        return wordsFile;
    }
}
