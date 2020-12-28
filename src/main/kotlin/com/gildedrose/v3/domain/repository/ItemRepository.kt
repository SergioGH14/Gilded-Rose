package com.gildedrose.v3.domain.repository

import com.gildedrose.v3.domain.entity.Item
import com.gildedrose.v3.domain.vo.Name

interface ItemRepository {

    fun find(id: Long): Item

    fun find(name: Name): Item

    fun find(name: String): Item

    fun findAll(): List<Item>

}