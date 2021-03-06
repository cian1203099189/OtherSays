package PluginMain;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.ParametersAreNonnullByDefault;

public class OtherListenChuLI implements org.bukkit.command.CommandExecutor{
    @Override
    @ParametersAreNonnullByDefault
    public boolean onCommand(CommandSender commandSender,Command command,String string,String[] strings) {
        if (strings.length < 2) {
            commandSender.sendMessage("参数错误");
            return false;
        }
        Player player = Bukkit.getPlayer(strings[0]);
        if (player == null) {
            commandSender.sendMessage("玩家不在线或不存在！");
            return true;
        }
        String message = strings[1];
        for (int i = 1;i< strings.length-1;i++) {
            message = message + " "+ strings[i+1];
        }
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            String tmessage = PlaceholderAPI.setPlaceholders(player, message);
            player.sendMessage(tmessage);
            return true;
        } else {
            player.sendMessage(message);
            return true;
        }
    }
}

