package com.gildedrose.v3.domain.vo

class Quality(var quality: Int) {

    private var maxQuality: Int = 50
    private var minQuality: Int = 0

    constructor(quality: Int, maxQuality: Int, minQuality: Int) : this(quality) {
        this.quality = quality
        this.maxQuality = maxQuality
        this.minQuality = minQuality
    }

    fun increase(): Quality {
        if (quality < maxQuality) {
            quality = quality.inc()
        }
        return this
    }

    fun decrease(): Quality {
        if (quality > minQuality) {
            quality = quality.dec()
        }
        return this
    }

    fun min(): Quality {
        quality = minQuality
        return this
    }

    override fun toString(): String {
        return "Quality : quality=$quality, maxQuality=$maxQuality, minQuality=$minQuality"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Quality

        if (quality != other.quality) return false
        if (maxQuality != other.maxQuality) return false
        if (minQuality != other.minQuality) return false

        return true
    }

    override fun hashCode(): Int {
        var result = quality
        result = 31 * result + maxQuality
        result = 31 * result + minQuality
        return result
    }
}