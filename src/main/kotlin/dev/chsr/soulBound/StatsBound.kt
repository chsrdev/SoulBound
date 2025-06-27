package dev.chsr.soulBound

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.EntityRegainHealthEvent
import org.bukkit.event.entity.FoodLevelChangeEvent
import kotlin.math.roundToInt

class StatsBound : Listener {

    @EventHandler(ignoreCancelled = true)
    fun onPlayerDamage(event: EntityDamageEvent) {
        if (event.entityType != EntityType.PLAYER) return
        val eventPlayer = event.entity as Player
        doAfterTick {
            if (event.finalDamage != .0) {
                if (event.damageSource.causingEntity != null)
                    Bukkit.broadcastMessage("${ChatColor.DARK_RED}${eventPlayer.name} ${ChatColor.RED}-${event.finalDamage} | ${ChatColor.LIGHT_PURPLE}${event.cause} (${event.damageSource.causingEntity!!.name})")
                else
                    Bukkit.broadcastMessage("${ChatColor.DARK_RED}${eventPlayer.name} ${ChatColor.RED}-${event.finalDamage} | ${ChatColor.LIGHT_PURPLE}${event.cause}")
                syncAll(eventPlayer)
            }
        }
    }

    @EventHandler(ignoreCancelled = true)
    fun onPlayerRegainHealth(event: EntityRegainHealthEvent) {
        if (event.entityType != EntityType.PLAYER) return
        val eventPlayer = event.entity as Player
        doAfterTick {
            syncAll(eventPlayer)
        }
    }

    @EventHandler(ignoreCancelled = true)
    fun onFoodLevelChange(event: FoodLevelChangeEvent) {
        if (event.entity is Player) {
            doAfterTick {
                syncAll(event.entity as Player)
            }
        }
    }
}