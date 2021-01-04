package com.gildedrose.v3.repository

import com.gildedrose.v3.domain.entity.Item
import com.gildedrose.v3.domain.vo.Name

class ItemRepositoryImpl(private val items: List<Item>) : ItemRepository {
    override fun find(id: Long): Item {
        TODO("Not yet implemented")
    }

    override fun find(name: Name): Item {
        TODO("Not yet implemented")
    }

    override fun find(name: String): Item {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<Item> {
        return items
    }
}