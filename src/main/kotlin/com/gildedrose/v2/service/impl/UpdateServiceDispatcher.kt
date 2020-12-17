package com.gildedrose.v2.service.impl

import com.gildedrose.v2.extensions.type
import com.gildedrose.v2.model.Item
import com.gildedrose.v2.model.ItemType
import com.gildedrose.v2.service.UpdateService

class UpdateServiceDispatcher : UpdateService {

    private val updateServiceAgedBrie = UpdateServiceAgedBrie()
    private val updateServiceItem = UpdateServiceItem()
    private val updateServiceBackstage = UpdateServiceBackstage()
    private val updateServiceSulfuras = UpdateServiceSulfuras()

    override fun updateItem(item: Item) =
            when (item.type) {
                ItemType.AGED_BRIE -> updateServiceAgedBrie.updateItem(item)
                ItemType.BACKSTAGE -> updateServiceBackstage.updateItem(item)
                ItemType.SULFURA -> updateServiceSulfuras.updateItem(item)
                ItemType.ITEM -> updateServiceItem.updateItem(item)
            }

}