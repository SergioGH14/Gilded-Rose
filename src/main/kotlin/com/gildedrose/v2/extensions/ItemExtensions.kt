package com.gildedrose.v2.extensions

import com.gildedrose.v2.model.Item
import com.gildedrose.v2.model.ItemType

val MAX_QUALITY_CONJURED:Int get() = 80

val MAX_QUALITY:Int get() = 50

val AGED_BRIE:String get() = "aged brie"

val SULFURA:String get() = "sulfuras"

val BACKSTAGE:String get() = "backstage"

val CONJURED:String get() = "conjured"

val Item.type: ItemType
    get() = when {
        name.toLowerCase().contains(AGED_BRIE) -> ItemType.AGED_BRIE
        name.toLowerCase().contains(SULFURA) -> ItemType.SULFURA
        name.toLowerCase().contains(BACKSTAGE) -> ItemType.BACKSTAGE
        else -> ItemType.ITEM
    }

val Item.conjured: Boolean get() = name.toLowerCase().contains("conjure")

val Item.maxQuality: Int get() = if(conjured) MAX_QUALITY_CONJURED else MAX_QUALITY

