package PluginMain;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.UUID;

public class CommandChuLi implements org.bukkit.command.CommandExecutor {

    @Override
    @ParametersAreNonnullByDefault
    public boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String string, String[] strings) {
        if (strings.length < 2) {
            commandSender.sendMessage("参数错误");
            return false;
        }
        String message = strings[1];
        for (int i = 1; i < strings.length - 1; i++) {
            message = message + " " + strings[i + 1];
        }
        Player player = Bukkit.getPlayer(strings[0]);
        if (player == null) {
            if (Bukkit.getEntity(UUID.fromString(strings[0])) != null) {
                UUIDsay(UUID.fromString(strings[0]),commandSender,message);
                return true;
            }else {
                commandSender.sendMessage("玩家不在线或不存在！");
                return true;
            }
            }
            if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
                String tmessage = PlaceholderAPI.setPlaceholders(player, message);
                player.chat(tmessage);
                return true;
            } else {
                player.chat(message);
                return true;
            }
        }
    public void UUIDsay(UUID uuid,CommandSender commandSender,String message) {
        commandSender.sendMessage(uuid,"["+Bukkit.getEntity(uuid).getName()+"]"+message);
        Bukkit.getEntity(uuid).sendMessage(message);
    }
}




