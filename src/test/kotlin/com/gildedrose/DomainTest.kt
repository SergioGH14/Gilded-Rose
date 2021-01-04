package com.gildedrose

import com.gildedrose.domain.*
import org.junit.jupiter.api.Test

class DomainTest {

    private val agedBrieTest = AgedBrieTest()
    private val backStageTest = BackStageTest()
    private val basicItemTest = BasicItemTest()
    private val conjuredTest = ConjuredTest()
    private val sulfurasTest = SulfurasTest()

    @Test
    fun test() {
        agedBrieTest.testAll()
        backStageTest.testAll()
        basicItemTest.testAll()
        conjuredTest.testAll()
        sulfurasTest.testAll()
    }
}