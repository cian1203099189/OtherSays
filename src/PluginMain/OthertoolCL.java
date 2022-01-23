package PluginMain;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;

public class OthertoolCL implements org.bukkit.command.CommandExecutor{
    @Override
    @ParametersAreNonnullByDefault
    public boolean onCommand(CommandSender commandSender,Command command,String string,String[] strings) {
        ItemStack is = new ItemStack(Material.BLAZE_ROD);
        is.setAmount(1);
        ItemMeta im = is.getItemMeta();
        TextComponent name = Component.text("uuid获取工具");
        im.displayName(name);
        ArrayList<Component> arrays = new ArrayList<Component>();
        TextComponent textComponent2 = Component.text(ChatColor.BLUE + "左键生物获取uuid");
        arrays.add(textComponent2);
        im.lore(arrays);
        is.setItemMeta(im);
        Player player = Bukkit.getPlayer(commandSender.getName());
        if (player == null) {
            System.out.println("只能由玩家执行指令！");
        } else {
            player.getInventory().addItem(is);
        }
        return true;
    }
}
