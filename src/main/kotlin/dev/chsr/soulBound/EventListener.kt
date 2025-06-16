package dev.chsr.soulBound

import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class EventListener : Listener {
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val players = Bukkit.getOnlinePlayers()
        if (players.size == 1) return
        val playerToCopy = players.first()
        event.player.health = playerToCopy.health
        event.player.saturation = playerToCopy.saturation
        event.player.inventory.contents = playerToCopy.inventory.contents
        event.player.enderChest.contents = playerToCopy.enderChest.contents
    }
}
