package com.gildedrose.domain

import com.gildedrose.v3.domain.command.CreateItemCommand
import com.gildedrose.v3.domain.entity.BasicItem
import com.gildedrose.v3.domain.entity.Item
import com.gildedrose.v3.domain.vo.Quality

class BasicItemTest : ItemTest() {
    override fun generateItem(daysToExpire: Int): Item {
        return BasicItem(CreateItemCommand(getRandomId(), "BasicItemMockItem", daysToExpire, Quality(getRandomQuality())))
    }

    override fun getQualityToTest(item: Item): Quality {
        return if (getQualityToTestWithoutMaxMin(item).quality > 50) {
            Quality(50)
        } else if(getQualityToTestWithoutMaxMin(item).quality < 0){
            Quality(0)
        }else{
            getQualityToTestWithoutMaxMin(item)
        }
    }

    private fun getQualityToTestWithoutMaxMin(item: Item): Quality {
        if (item.quality.quality == 50) {
            return item.quality
        }
        return if(item.expiration.expired()){
            Quality(item.quality.quality-2)
        }else {
            Quality(item.quality.quality-1)
        }
    }

}