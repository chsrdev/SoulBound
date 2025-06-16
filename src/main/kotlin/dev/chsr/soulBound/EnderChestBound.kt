package dev.chsr.soulBound

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryDragEvent

class EnderChestBound : Listener {
    @EventHandler
    fun onInventoryClick(event: InventoryClickEvent) {
        if (event.whoClicked is Player) {
            doAfterTick {
                Bukkit.getOnlinePlayers().forEach {
                    it.enderChest.contents = (event.whoClicked as Player).enderChest.contents
                }
            }
        }
    }

    @EventHandler
    fun onInventoryDrag(event: InventoryDragEvent) {
        if (event.whoClicked is Player) {
            doAfterTick {
                Bukkit.getOnlinePlayers().forEach {
                    it.enderChest.contents = (event.whoClicked as Player).enderChest.contents
                }
            }
        }
    }
}