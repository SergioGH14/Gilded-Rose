package com.gildedrose.domain

import com.gildedrose.v3.domain.command.CreateItemCommand
import com.gildedrose.v3.domain.entity.BackStage
import com.gildedrose.v3.domain.entity.Item
import com.gildedrose.v3.domain.vo.Quality

class BackStageTest : ItemTest() {
    override fun generateItem(daysToExpire: Int): Item {
        return BackStage(CreateItemCommand(getRandomId(), "BackStageMockItem", daysToExpire, Quality(getRandomQuality())))
    }

    override fun getQualityToTest(item: Item): Quality {
        return if(getQualityToTestWithoutMax(item).quality > 50 ){
            Quality(50)
        }else{
            getQualityToTestWithoutMax(item)
        }
    }

    private fun getQualityToTestWithoutMax(item: Item): Quality{
        if (item.quality.quality == 50) {
            return item.quality
        }
        if (item.expiration.daysToExpire() > 10) {
            return Quality(item.quality.quality + 1)
        }
        if (item.expiration.daysToExpire() in 10 downTo 6) {
            return Quality(item.quality.quality + 2)

        }
        if (item.expiration.daysToExpire() in 5 downTo 0) {
            return Quality(item.quality.quality + 3)
        }
        return Quality(0)
    }

}