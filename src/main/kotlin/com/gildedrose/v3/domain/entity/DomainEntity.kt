package com.gildedrose.v3.domain.entity
import org.apache.commons.lang3.builder.EqualsBuilder
import org.apache.commons.lang3.builder.HashCodeBuilder
import org.slf4j.Logger
import org.slf4j.LoggerFactory

abstract class DomainEntity<T : Any>(val id: T) {

    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    override fun equals(other: Any?): Boolean {
        if (other!!.javaClass != this.javaClass) {
            return false
        }
        return EqualsBuilder()
                .append(this.id, (other as DomainEntity<*>).id) // Only on the ID!
                .isEquals
    }

    override fun hashCode(): Int {
        return HashCodeBuilder()
                .append(id) // Only on the ID!
                .toHashCode()
    }
}