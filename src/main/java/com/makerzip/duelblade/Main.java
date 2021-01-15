package com.makerzip.duelblade;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("PLUGIN IS ACTIVATED");
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void rightClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Action a = e.getAction();

        if (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK) {
            p.swingOffHand();
            if (p.getItemInHand().getType() == Material.BLAZE_ROD) {
                Fireball fb = p.launchProjectile(Fireball.class);
                fb.setVelocity(p.getLocation().getDirection().multiply(5));
            }
        }
    }
}