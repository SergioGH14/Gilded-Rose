package com.gildedrose.v3.gildedrose

import com.gildedrose.v1.Item
import com.gildedrose.v3.service.acl.ACLService

class GildedRose(var items: Array<Item>) {

    private var aclService = ACLService(items)

    fun updateQuality() {
        aclService.updateAll()
        items = aclService.extractItems()
    }

}

