package com.gildedrose.v3.domain.entity

import com.gildedrose.v3.domain.command.CreateItemCommand

class AgedBrie(command: CreateItemCommand) : Item(command) {

    override fun updateQuality() {
        quality.increase()
    }

    override fun expireQuality() {
        quality.increase().increase()
    }
}