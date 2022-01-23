package PluginMain;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MainInMain extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new EventCL(), this);
        getLogger().info("事件系统插入成功");
        if (Bukkit.getPluginCommand("othersay") != null) {
            Bukkit.getPluginCommand("othersay").setExecutor(new CommandChuLi());
        }
        if (Bukkit.getPluginCommand("otherlisten") != null) {
            Bukkit.getPluginCommand("otherlisten").setExecutor(new OtherListenChuLI());
        }
        if (Bukkit.getPluginCommand("othertool") != null) {
            Bukkit.getPluginCommand("othertool").setExecutor(new OthertoolCL());
        }
        getLogger().info("OtherSays载入成功");
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null) {
            getLogger().info("未找到PlaceholderAPI插件,papi解析功能已关闭！");
        } else if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null){
            getLogger().info("挂钩PlaceholderAPI插件成功");
        }
    }
}

