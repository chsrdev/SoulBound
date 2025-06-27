package dev.chsr.soulBound
//
//import org.bukkit.Bukkit
//import org.bukkit.entity.EntityType
//import org.bukkit.entity.Player
//import org.bukkit.event.*
//import org.bukkit.event.block.BlockPlaceEvent
//import org.bukkit.event.enchantment.EnchantItemEvent
//import org.bukkit.event.entity.*
//import org.bukkit.event.inventory.InventoryClickEvent
//import org.bukkit.event.inventory.InventoryDragEvent
//import org.bukkit.event.inventory.TradeSelectEvent
//import org.bukkit.event.player.*
//import org.bukkit.event.vehicle.VehicleDestroyEvent
//import org.bukkit.event.vehicle.VehicleEvent
//import org.bukkit.event.world.PortalCreateEvent
//import org.bukkit.inventory.ItemStack
//
//class InventoryBound : Listener {
//    @EventHandler
//    fun onInventoryDrag(event: InventoryDragEvent) {
//        if (event.whoClicked is Player)
//            syncInventory(event.whoClicked as Player, event)
//    }
//
//    @EventHandler
//    fun onInventoryClick(event: InventoryClickEvent) {
//        if (event.whoClicked is Player) {
//            syncInventory(event.whoClicked as Player, event)
//        }
//    }
//
//    @EventHandler
//    fun onTradeSelect(event: TradeSelectEvent) {
//        if (event.whoClicked is Player)
//            syncInventory(event.whoClicked as Player, event)
//    }
//
//    @EventHandler
//    fun onBlockPlace(event: BlockPlaceEvent) {
//        syncInventory(event.player, event)
//    }
//
//    @EventHandler
//    fun onPlayerEditBook(event: PlayerEditBookEvent) {
//        syncInventory(event.player, event)
//    }
//
//    @EventHandler
//    fun onPlayerEggThrow(event: PlayerEggThrowEvent) {
//        syncInventory(event.player, null)
//    }
//
//    @EventHandler
//    fun onPlayerFish(event: PlayerFishEvent) {
//        syncInventory(event.player, event)
//    }
//
//    @EventHandler
//    fun onPlayerHarvestBlock(event: PlayerHarvestBlockEvent) {
//        syncInventory(event.player, event)
//    }
//
//    @EventHandler
//    fun onPlayerPickupArrow(event: PlayerPickupArrowEvent) {
//        syncInventory(event.player, event)
//    }
////
////    @EventHandler
////    fun onPlayerInteract(event: PlayerInteractEvent) {
////        syncInventory(event.player, event)
////    }
//
//    @EventHandler
//    fun onPlayerInteractEntity(event: PlayerInteractEntityEvent) {
//        syncInventory(event.player, event)
//    }
//
//    @EventHandler
//    fun onPlayerItemBreak(event: PlayerItemBreakEvent) {
//        syncInventory(event.player, null)
//    }
//
//    @EventHandler
//    fun onPlayerItemConsume(event: PlayerItemConsumeEvent) {
//        syncInventory(event.player, event)
//    }
//
//    @EventHandler
//    fun onPlayerItemDamage(event: PlayerItemDamageEvent) {
//        syncInventory(event.player, event)
//    }
//
//    @EventHandler
//    fun onPlayerItemMend(event: PlayerItemMendEvent) {
//        syncInventory(event.player, event)
//    }
//
//    @EventHandler
//    fun onPlayerShearEntity(event: PlayerShearEntityEvent) {
//        syncInventory(event.player, event)
//    }
//
//    @EventHandler
//    fun onPlayerTakeLecternBook(event: PlayerTakeLecternBookEvent) {
//        syncInventory(event.player, event)
//    }
//
//    @EventHandler
//    fun onEnchant(event: EnchantItemEvent) {
//        syncInventory(event.enchanter, event)
//    }
//
//    @EventHandler
//    fun onPlayerUnleashEntity(event: PlayerUnleashEntityEvent) {
//        syncInventory(event.player, event)
//    }
//
//    @EventHandler
//    fun onPlayerBucketEntity(event: PlayerBucketEntityEvent) {
//        syncInventory(event.player, event)
//    }
//
//    @EventHandler
//    fun onPlayerBucketEmpty(event: PlayerBucketEmptyEvent) {
//        syncInventory(event.player, event)
//    }
//
//    @EventHandler
//    fun onPlayerBucketFill(event: PlayerBucketFillEvent) {
//        syncInventory(event.player, event)
//    }
//
//    @EventHandler
//    fun onPlayerDrop(event: PlayerDropItemEvent) {
//        syncInventory(event.player, event)
//    }
//
//    @EventHandler
//    fun onItemPickup(event: EntityPickupItemEvent) {
//        if (event.entityType == EntityType.PLAYER) {
//            syncInventory(event.entity as Player, event)
//        }
//    }
//
//    @EventHandler
//    fun onShootBow(event: EntityShootBowEvent) {
//        if (event.entityType == EntityType.PLAYER) {
//            syncInventory(event.entity as Player, event)
//        }
//    }
//
//    @EventHandler
//    fun onEntityChangeBlock(event: EntityChangeBlockEvent) {
//        if (event.entityType == EntityType.PLAYER) {
//            syncInventory(event.entity as Player, event)
//        }
//    }
//
//    @EventHandler
//    fun onPortalCreate(event: PortalCreateEvent) {
//        if (event.entity is Player) {
//            syncInventory(event.entity as Player, event)
//        }
//    }
//
//    @EventHandler
//    fun onEntityInteract(event: EntityInteractEvent) {
//        if (event.entity is Player) {
//            syncInventory(event.entity as Player, event)
//        }
//    }
//
//    @EventHandler
//    fun onEntityPlace(event: EntityPlaceEvent) {
//        if (event.entity is Player) {
//            syncInventory(event.entity as Player, event)
//        }
//    }
//
//    @EventHandler
//    fun onEntityTame(event: EntityTameEvent) {
//        if (event.entity is Player) {
//            syncInventory(event.entity as Player, event)
//        }
//    }
//
//    @EventHandler
//    fun onFireworkExplode(event: FireworkExplodeEvent) {
//        if (event.entity is Player) {
//            syncInventory(event.entity as Player, event)
//        }
//    }
//
//    @EventHandler
//    fun onSheepDyeWool(event: SheepDyeWoolEvent) {
//        if (event.entity is Player) {
//            syncInventory(event.entity as Player, event)
//        }
//    }
//
//    @EventHandler
//    fun onVillagerAcquireTrade(event: VillagerAcquireTradeEvent) {
//        if (event.entity is Player) {
//            syncInventory(event.entity as Player, event)
//        }
//    }
//
//    private fun syncInventory(player: Player, event: Cancellable?) {
//        doAfterTick {
//            val sourceContents = player.inventory.contents
//            Bukkit.getOnlinePlayers().forEach {
//                for (i in sourceContents.indices) {
//                    if (!itemsEqual(it.inventory.contents[i], sourceContents[i]))
//                        it.inventory.setItem(i, sourceContents[i])
//                }
//            }
//        }
//    }
//
//    private fun itemsEqual(a: ItemStack?, b: ItemStack?): Boolean {
//        return when {
//            a == null && b == null -> true
//            a == null || b == null -> false
//            else -> a.isSimilar(b) && a.amount == b.amount
//        }
//    }
//}
