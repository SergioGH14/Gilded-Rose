package com.gildedrose.v2.service.impl

import com.gildedrose.v2.extensions.maxQuality
import com.gildedrose.v2.model.Item
import com.gildedrose.v2.service.UpdateService

class UpdateServiceBackstage : UpdateService {
    override fun getQualityVariation(item: Item): Int {
        return when {
            item.quality >= item.maxQuality -> 0
            item.sellIn >= 10 -> 2
            item.sellIn >= 5 -> 3
            else -> item.quality * -1
        }
    }
}