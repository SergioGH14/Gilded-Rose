package com.gildedrose.domain

import com.gildedrose.v3.domain.command.CreateItemCommand
import com.gildedrose.v3.domain.entity.Sulfuras
import com.gildedrose.v3.domain.entity.Item
import com.gildedrose.v3.domain.vo.Quality

class SulfurasTest : ItemTest() {
    override fun generateItem(daysToExpire: Int): Item {
        return Sulfuras(CreateItemCommand(getRandomId(), "SulfurasMockItem", daysToExpire, Quality(getRandomQuality(), 80, 80)))

    }

    override fun getQualityToTest(item: Item): Quality {
        return Quality(item.quality.quality,80,80)
    }

}