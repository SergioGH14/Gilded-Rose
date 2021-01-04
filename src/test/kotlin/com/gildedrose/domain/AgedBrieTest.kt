package com.gildedrose.domain

import com.gildedrose.v3.domain.command.CreateItemCommand
import com.gildedrose.v3.domain.entity.AgedBrie
import com.gildedrose.v3.domain.entity.Item
import com.gildedrose.v3.domain.vo.Quality

class AgedBrieTest : ItemTest() {
    override fun generateItem(daysToExpire: Int): Item {
        return AgedBrie(CreateItemCommand(getRandomId(), "AgedBrieMockItem", daysToExpire, Quality(getRandomQuality())))
    }

    override fun getQualityToTest(item: Item): Quality {
        return if(getQualityToTestWithoutMax(item).quality > 50 ){
            Quality(50)
        }else{
            getQualityToTestWithoutMax(item)
        }
    }

    private fun getQualityToTestWithoutMax(item: Item): Quality{
        if(item.quality.quality == 50) {
            return item.quality
        }
        return if(item.expiration.expired()){
            Quality(item.quality.quality+2)
        }else {
            Quality(item.quality.quality+1)
        }
    }
}