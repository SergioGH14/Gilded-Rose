package com.gildedrose.v3.domain.command

import com.gildedrose.v3.domain.vo.Quality

data class CreateItemCommand (val id: Int, val name: String, val daysToExpire : Int, val quality : Quality) : Command