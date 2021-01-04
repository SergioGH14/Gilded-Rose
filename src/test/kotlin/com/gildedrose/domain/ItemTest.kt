package com.gildedrose.domain

import com.gildedrose.v3.domain.entity.Item
import com.gildedrose.v3.domain.vo.Quality

abstract class ItemTest {

    protected abstract fun generateItem(daysToExpire: Int): Item

    private fun testQuality(item: Item){
        println("Before test $item")
        val qualityValueToVerify = getQualityToTest(item)
        val qualityBeforeUpdate = Quality(item.quality.quality)
        item.update()
        println("${qualityValueToVerify.quality} == ${item.quality.quality}")
        assert(qualityValueToVerify == item.quality)
        println("After test  $item ")
        println("Quality value has changed in ${qualityValueToVerify.quality-qualityBeforeUpdate.quality}")
    }

    protected abstract fun getQualityToTest(item:Item): Quality

    fun testAll(){
        println("Initializing tests")
        var sellIn = -3
        while (sellIn < 13){
            testQuality(generateItem(sellIn))
            sellIn++
        }
        println("Finishing tests")

    }

    protected fun getRandomQuality():Int{
        var random = Math.random()
        random *= 50
        return random.toInt()
    }

    protected fun getRandomId():Int{
        var random = Math.random()
        random *= 100000
        return random.toInt()
    }
}