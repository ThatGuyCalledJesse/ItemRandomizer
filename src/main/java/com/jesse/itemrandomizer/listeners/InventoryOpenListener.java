package com.jesse.itemrandomizer.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.AbstractHorseInventory;

public class InventoryOpenListener implements Listener {
    @EventHandler
    public static void onInventoryOpen(InventoryOpenEvent event) {
        if (event.getInventory().getType().equals(InventoryType.CHEST) || event.getInventory().getType().equals(InventoryType.ENDER_CHEST) || event.getInventory().getType().equals(InventoryType.BARREL) || event.getInventory().getType().equals(InventoryType.DISPENSER) || event.getInventory().getType().equals(InventoryType.DROPPER) || event.getInventory().getType().equals(InventoryType.SHULKER_BOX) || event.getInventory().getType().equals(InventoryType.HOPPER)) {
            if (!(event.getInventory() instanceof AbstractHorseInventory)) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(ChatColor.RED + "No chests or other storage items! It says so in the rules...");
            }
        }
    }
}