package dev.chsr.soulBound

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class SoulBound : JavaPlugin() {

    companion object {
        var lastHp: Double? = null
        var lastSaturation: Float? = null
        var lastAbsorption: Double? = null
        var lastFoodLevel: Int? = null
        lateinit var instance: SoulBound
    }

    override fun onEnable() {
        instance = this
        server.pluginManager.registerEvents(StatsBound(), this)
        server.pluginManager.registerEvents(EventListener(), this)
    }
}

public fun doAfterTick(runnable: Runnable) {
    Bukkit.getScheduler().runTaskLater(SoulBound.instance, runnable, 1L)
}

public fun syncAll(player: Player) {
    Bukkit.getOnlinePlayers().forEach {
        it.health = player.health
        it.foodLevel = player.foodLevel
        it.absorptionAmount = player.absorptionAmount
        it.sendHealthUpdate()
    }
}