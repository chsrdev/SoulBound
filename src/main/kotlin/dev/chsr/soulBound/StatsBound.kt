package dev.chsr.soulBound

import org.bukkit.Bukkit
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.EntityRegainHealthEvent
import org.bukkit.event.entity.FoodLevelChangeEvent

class StatsBound : Listener {

    @EventHandler
    fun onPlayerDamage(event: EntityDamageEvent) {
        if (event.entityType != EntityType.PLAYER) return
        val eventPlayer = event.entity as Player
        Bukkit.getScheduler().runTaskLater(SoulBound.instance, Runnable {
            Bukkit.getOnlinePlayers().forEach { player ->
                player.health = eventPlayer.health
                player.sendHealthUpdate()
            }
        }, 1L)
    }

    @EventHandler
    fun onPlayerRegainHealth(event: EntityRegainHealthEvent) {
        if (event.entityType != EntityType.PLAYER) return
        val eventPlayer = event.entity as Player
        Bukkit.getScheduler().runTaskLater(SoulBound.instance, Runnable {
            Bukkit.getOnlinePlayers().forEach { player ->
                player.health = eventPlayer.health
                player.sendHealthUpdate()
            }
        }, 1L)
    }

    @EventHandler()
    fun onFoodLevelChange(event: FoodLevelChangeEvent) {
        if (event.entity is Player) {
            doAfterTick {
                Bukkit.getOnlinePlayers().forEach {
                    it.foodLevel = event.entity.foodLevel
                }
            }
        }
    }
}