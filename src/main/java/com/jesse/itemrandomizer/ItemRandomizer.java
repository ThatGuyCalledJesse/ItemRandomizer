package com.jesse.itemrandomizer;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ItemRandomizer extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getServer().broadcastMessage("[IR] ItemRandomizer is now enabled!");
    }
}
