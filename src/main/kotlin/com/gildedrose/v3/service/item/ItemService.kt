package com.gildedrose.v3.service.item

import com.gildedrose.v3.domain.command.UpdateAllItemsCommand
import com.gildedrose.v3.domain.entity.Item

interface ItemService {
    fun handle(updateAllItemsCommand: UpdateAllItemsCommand)
    fun getAllItems(): List<Item>
}