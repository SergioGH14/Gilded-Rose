package com.gildedrose


import com.gildedrose.v1.Item
import com.gildedrose.v3.gildedrose.GildedRose
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun exampleTest() {
        val items = arrayOf(
                Item("+5 Dexterity Vest", 10, 20), //
                Item("Aged Brie", -1, 0), //
                Item("Elixir of the Mongoose", 5, 7), //
                Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                Item("Sulfuras, Hand of Ragnaros", -1, 80),
                Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                Item("Backstage passes to a TAFKAL80ETC concert", -1, 49),
                // this conjured item does not work properly yet
                Item("Conjured Mana Cake", 3, 6))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].sellIn)
        assertEquals(-2, app.items[1].sellIn)
        assertEquals(4, app.items[2].sellIn)
        assertEquals(-1, app.items[3].sellIn)
        assertEquals(-2, app.items[4].sellIn)
        assertEquals(14, app.items[5].sellIn)
        assertEquals(9, app.items[6].sellIn)
        assertEquals(4, app.items[7].sellIn)
        assertEquals(-2, app.items[8].sellIn)
        assertEquals(2, app.items[9].sellIn)

        assertEquals(19, app.items[0].quality)
        assertEquals(2, app.items[1].quality)
        assertEquals(6, app.items[2].quality)
        assertEquals(80, app.items[3].quality)
        assertEquals(80, app.items[4].quality)
        assertEquals(21, app.items[5].quality)
        assertEquals(50, app.items[6].quality)
        assertEquals(50, app.items[7].quality)
        assertEquals(0, app.items[8].quality)
        assertEquals(4, app.items[9].quality)
    }

}


