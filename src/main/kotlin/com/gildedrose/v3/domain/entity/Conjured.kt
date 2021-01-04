package com.gildedrose.v3.domain.entity

import com.gildedrose.v3.domain.command.CreateItemCommand

class Conjured(command: CreateItemCommand) : Item(command) {
    override fun updateQuality() {
        super.updateQuality()
        super.updateQuality()
    }

    override fun expireQuality() {
        super.expireQuality()
        super.expireQuality()
    }
}