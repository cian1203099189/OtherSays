package PluginMain;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Objects;

public class EventCL implements Listener {
    @EventHandler
    public void getUuid(com.destroystokyo.paper.event.player.PlayerAttackEntityCooldownResetEvent e) {
        TextComponent name = Component.text("uuid获取工具");
        try {
            if (Objects.equals(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().displayName(), name)) {
                e.getPlayer().sendMessage(e.getAttackedEntity().getUniqueId().toString());
                e.setCancelled(true);
            }
        } catch (NullPointerException ignored) {}
    }
}

