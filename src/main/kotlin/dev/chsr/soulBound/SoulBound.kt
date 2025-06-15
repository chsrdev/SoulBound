package dev.chsr.soulBound

import org.bukkit.Bukkit
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin

class SoulBound : JavaPlugin() {

    companion object {
        lateinit var instance: SoulBound
    }

    override fun onEnable() {
        instance = this
        server.pluginManager.registerEvents(EventListener(), this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
