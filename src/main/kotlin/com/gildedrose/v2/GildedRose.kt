package com.gildedrose.v2

import com.gildedrose.v2.model.Item
import com.gildedrose.v2.service.UpdateService
import com.gildedrose.v2.service.impl.UpdateServiceDispatcher


class GildedRose(var items: Array<Item>) {

    val updateService: UpdateService = UpdateServiceDispatcher()

    fun updateQuality() {
        items.toList().forEach(updateService::updateItem)
    }
}