package com.jesse.itemrandomizer.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener {
    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage("Welcome, " + event.getPlayer().getDisplayName() + ". Use /rules to see the rules for this challenge.");
    }
}
