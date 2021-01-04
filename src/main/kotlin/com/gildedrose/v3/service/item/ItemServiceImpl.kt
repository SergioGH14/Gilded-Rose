package com.gildedrose.v3.service.item

import com.gildedrose.v3.domain.command.UpdateAllItemsCommand
import com.gildedrose.v3.domain.entity.Item
import com.gildedrose.v3.repository.ItemRepositoryImpl

class ItemServiceImpl(private val itemRepository: ItemRepositoryImpl) : ItemService {


    override fun handle(updateAllItemsCommand: UpdateAllItemsCommand) {
        itemRepository.findAll().forEach { item -> item.update() }
    }

    override fun getAllItems(): List<Item> {
        return itemRepository.findAll()
    }
}