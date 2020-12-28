package com.gildedrose.v3.domain.entity

import com.gildedrose.v3.domain.command.CreateItemCommand
import com.gildedrose.v3.domain.vo.Expiration
import com.gildedrose.v3.domain.vo.Name
import com.gildedrose.v3.domain.vo.Quality
import java.time.LocalDate

abstract class Item(command: CreateItemCommand) : DomainEntity<Int>(command.id) {

    var name: Name = Name(command.name)
        protected set(value) {
            field = value
        }
    var expiration: Expiration = Expiration(command.daysToExpire)
        protected set(value) {
            field = value
        }
    var quality: Quality = command.quality
        protected set(value) {
            field = value
        }
    var lastUpdate: LocalDate? = null
        protected set(value) {
            field = value
        }

    fun update() {
        if (hasToBeUpdated()) {
            if (expiration.expired()) {
                expireQuality()
            } else {
                updateQuality()
            }
        }
        updated()
    }

    protected open fun updateQuality() {
        quality.decrease()
    }

    protected open fun expireQuality() {
        quality.decrease().decrease()
    }

    protected open fun hasToBeUpdated(): Boolean {
        return if (lastUpdate != null) {
            lastUpdate!!.isBefore(LocalDate.now())
        } else {
            true
        }

    }

    private fun updated() {
        lastUpdate = LocalDate.now()
    }

    override fun toString(): String {
        return "Item $name, $expiration, $quality"
    }

}