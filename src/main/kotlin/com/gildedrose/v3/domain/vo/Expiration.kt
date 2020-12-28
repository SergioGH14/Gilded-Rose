package com.gildedrose.v3.domain.vo

import java.time.Duration
import java.time.LocalDate

class Expiration(sellIn: Int) {

    private var expiration: LocalDate = LocalDate.now()

    init {
        expiration = expiration.plusDays(sellIn.toLong())
    }

    fun expired(): Boolean {
        return LocalDate.now().isAfter(expiration)
    }

    fun daysToExpire(): Int {
        return Duration.between(LocalDate.now().atStartOfDay(), expiration.atStartOfDay()).toDays().toInt()
    }

    override fun toString(): String {
        return "Expiration : expire in ${daysToExpire()} days"
    }
}