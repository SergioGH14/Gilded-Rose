package com.gildedrose.v3.service.acl

import com.gildedrose.v3.domain.command.CreateItemCommand
import com.gildedrose.v3.domain.command.UpdateAllItemsCommand
import com.gildedrose.v3.domain.entity.*
import com.gildedrose.v3.domain.repository.ItemRepositoryImpl
import com.gildedrose.v3.domain.vo.Quality
import com.gildedrose.v3.service.item.ItemService
import com.gildedrose.v3.service.item.ItemServiceImpl

class ACLService(items: Array<com.gildedrose.v1.Item>) {

    private val itemService: ItemService

    private val AGED_BRIE = "aged brie"

    private val SULFURA = "sulfuras"

    private val BACKSTAGE = "backstage"

    private val CONJURED = "conjured"

    init {
        itemService = ItemServiceImpl(ItemRepositoryImpl(items.toList().map(this::mapItem)))
    }

    fun updateAll() {
        itemService.handle(UpdateAllItemsCommand())
    }

    fun extractItems(): Array<com.gildedrose.v1.Item> {
        return itemService.getAllItems().map(this::mapItem).toTypedArray()
    }

    private fun mapItem(item: com.gildedrose.v1.Item): Item {
        val command = CreateItemCommand(item.name.hashCode(), item.name, item.sellIn, getQuality(item))
        return when {
            item.name.toLowerCase().contains(AGED_BRIE) -> AgedBrie(command)
            item.name.toLowerCase().contains(SULFURA) -> Sulfuras(command)
            item.name.toLowerCase().contains(BACKSTAGE) -> BackStage(command)
            item.name.toLowerCase().contains(CONJURED) -> Conjured(command)
            else -> BasicItem(command)
        }
    }

    private fun mapItem(item: Item): com.gildedrose.v1.Item {
        return com.gildedrose.v1.Item(item.name.name, item.expiration.daysToExpire()-1, item.quality.quality)
    }

    private fun getQuality(item: com.gildedrose.v1.Item): Quality {
        return when {
            item.name.toLowerCase().contains(SULFURA) -> Quality(80, 80, 80)
            else -> Quality(item.quality)
        }
    }
}