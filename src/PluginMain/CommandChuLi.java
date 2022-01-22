package PluginMain;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Locale;

public class CommandChuLi implements org.bukkit.command.CommandExecutor {

    @Override
    @ParametersAreNonnullByDefault
    public boolean onCommand(CommandSender commandSender,org.bukkit.command.Command command,String string,String[] strings) {
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
        for (int i = 2;i<strings.length-1;i++){
            message = message +" "+ strings[i];
        }
        player.chat(message);
        return true;
    }
}


