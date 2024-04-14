package com.jesse.itemrandomizer.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RulesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player sender = (Player) commandSender;
            sender.sendMessage("You used /rules! Here are the rules:");
            sender.sendMessage("1. Every minute your inventory randomizes.");
            sender.sendMessage("2. No dropping items or saving them in storage containers.");
            return true;
        }
        return false;
    }
}
