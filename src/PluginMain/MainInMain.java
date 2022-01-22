package PluginMain;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MainInMain extends JavaPlugin {
    @Override
    public void onEnable() {
        if (Bukkit.getPluginCommand("othersay") != null) {
            Bukkit.getPluginCommand("othersay").setExecutor(new CommandChuLi());
        }
        if (Bukkit.getPluginCommand("otherlisten") != null) {
            Bukkit.getPluginCommand("otherlisten").setExecutor(new OtherListenChuLI());
        }
        getLogger().info("OtherSays载入成功");
    }
}

