package dev.chsr.soulBound

import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class EventListener : Listener {
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val players = Bukkit.getOnlinePlayers()
        if (players.size == 1) {
            event.player.health = SoulBound.lastHp ?: event.player.health
            event.player.saturation = SoulBound.lastSaturation ?: event.player.saturation
            event.player.absorptionAmount = SoulBound.lastAbsorption ?: event.player.absorptionAmount
            event.player.foodLevel = SoulBound.lastFoodLevel ?: event.player.foodLevel
            return
        }
        val playerToCopy = players.first()
        event.player.health = playerToCopy.health
        event.player.saturation = playerToCopy.saturation
        event.player.foodLevel = playerToCopy.foodLevel
        event.player.absorptionAmount = playerToCopy.absorptionAmount
    }

    @EventHandler
    fun onPlayerQuit(event: PlayerQuitEvent) {
        val players = Bukkit.getOnlinePlayers()
        if (players.size == 1) {
            SoulBound.lastHp = event.player.health
            SoulBound.lastSaturation = event.player.saturation
            SoulBound.lastFoodLevel = event.player.foodLevel
            SoulBound.lastAbsorption = event.player.absorptionAmount
        }
    }
}
