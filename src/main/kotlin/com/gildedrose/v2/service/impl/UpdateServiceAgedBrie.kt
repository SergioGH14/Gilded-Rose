package com.gildedrose.v2.service.impl

import com.gildedrose.v2.extensions.maxQuality
import com.gildedrose.v2.model.Item
import com.gildedrose.v2.service.UpdateService

class UpdateServiceAgedBrie : UpdateService {
    override fun getQualityVariation(item: Item): Int {
        return when {
            item.quality == item.maxQuality -> 0
            item.quality < item.maxQuality && item.sellIn > 0 -> 1
            else -> 2
        }
    }
}
