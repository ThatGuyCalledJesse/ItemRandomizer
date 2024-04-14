package com.jesse.itemrandomizer;

import com.jesse.itemrandomizer.listeners.InventoryOpenListener;
import com.jesse.itemrandomizer.listeners.PlayerDropListener;
import com.jesse.itemrandomizer.listeners.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class ItemRandomizer extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getServer().broadcastMessage("[IR] ItemRandomizer is now enabled!");
        this.getServer().getPluginManager().registerEvents(new InventoryOpenListener(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerDropListener(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    Inventory player_inv = player.getInventory();
                    ItemStack[] items = player_inv.getContents();
                    List<Material> itemlist = new ArrayList<>(Arrays.asList(Material.values()));
                    itemlist.remove(Material.AIR);
                    itemlist.remove(Material.COMMAND_BLOCK);
                    itemlist.remove(Material.COMMAND_BLOCK_MINECART);
                    itemlist.remove(Material.FIRE);
                    itemlist.remove(Material.END_PORTAL);
                    itemlist.remove(Material.NETHER_PORTAL);
                    Random random = new Random(player.getWorld().getTime());
                    Collections.shuffle(itemlist, new Random(player.getWorld().getTime()));
                    for (int i = 0; i < items.length && i < itemlist.size(); i++) {
                        if (items[i] != null) {
                            items[i] = new ItemStack(itemlist.get(i), (random.nextInt(itemlist.get(i).getMaxStackSize()) + 1));
                        }
                    }
                    player_inv.setContents(items);
                    player.playSound(player.getLocation(), Sound.BLOCK_TRIAL_SPAWNER_DETECT_PLAYER, 250, 29);
                }
            }
        }, 0, 2400L); // 2400L

    }
}
