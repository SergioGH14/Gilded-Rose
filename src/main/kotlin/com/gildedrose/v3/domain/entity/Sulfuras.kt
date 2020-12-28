package com.gildedrose.v3.domain.entity

import com.gildedrose.v3.domain.command.CreateItemCommand

class Sulfuras(command: CreateItemCommand) : Item(command) {
    override fun updateQuality() {}

    override fun expireQuality() {}
}