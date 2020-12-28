package com.gildedrose.v3.domain.entity

import com.gildedrose.v3.domain.command.CreateItemCommand

class BackStage(command: CreateItemCommand) : Item(command) {
    override fun updateQuality() {
        quality.increase()
        if (expiration.daysToExpire() <= 10) quality.increase()
        if (expiration.daysToExpire() <= 5) quality.increase()
    }

    override fun expireQuality() {
        quality.min()
    }
}