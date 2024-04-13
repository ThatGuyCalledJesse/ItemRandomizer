package com.jesse.itemrandomizer;

import com.jesse.itemrandomizer.listeners.InventoryOpenListener;
import com.jesse.itemrandomizer.listeners.PlayerDropListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ItemRandomizer extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getServer().broadcastMessage("[IR] ItemRandomizer is now enabled!");
        this.getServer().getPluginManager().registerEvents(new InventoryOpenListener(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerDropListener(), this);
    }
}
