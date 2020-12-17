package com.gildedrose.v2.service

import com.gildedrose.v2.extensions.conjured
import com.gildedrose.v2.model.Item

interface UpdateService {

    fun updateItem(item: Item) {
        var qualityVariation = getQualityVariation(item)
        qualityVariation = if (item.conjured) qualityVariation * 2 else qualityVariation
        item.quality = item.quality + qualityVariation
        item.sellIn = item.sellIn + getSellInDecrease(item)
    }

    fun getQualityVariation(item: Item): Int =  if (item.quality > 0) -1 else 0


    fun getSellInDecrease(item: Item): Int = -1
}