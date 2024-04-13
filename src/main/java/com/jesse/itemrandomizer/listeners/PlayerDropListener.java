package com.jesse.itemrandomizer.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDropListener implements Listener {
    @EventHandler
    public static void onPlayerItemDrop(PlayerDropItemEvent event) {
        event.setCancelled(true);
    }
}
