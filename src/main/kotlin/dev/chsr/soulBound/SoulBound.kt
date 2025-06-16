package dev.chsr.soulBound

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class SoulBound : JavaPlugin() {

    companion object {
        lateinit var instance: SoulBound
    }

    override fun onEnable() {
        instance = this
        server.pluginManager.registerEvents(InventoryBound(), this)
        server.pluginManager.registerEvents(EnderChestBound(), this)
        server.pluginManager.registerEvents(StatsBound(), this)
        server.pluginManager.registerEvents(EventListener(), this)
    }
}

public fun doAfterTick(runnable: Runnable) {
    Bukkit.getScheduler().runTaskLater(SoulBound.instance, runnable, 1L)
}
