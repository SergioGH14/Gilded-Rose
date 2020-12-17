package com.gildedrose.v1

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            //NO QUESO Y NO ENTRADA
            if (items[i].name != "Aged Brie" && items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                //NO QMINIMO
                if (items[i].quality > 0) {
                    //NO SULFURA
                    if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                        items[i].quality = items[i].quality - 1
                    }
                }
                //O QUESO O ENTRADA
            } else {
                //AUMENTA CALIDAD SI NO ES MÁXIMA
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1
                    //ES ENTRADA
                    if (items[i].name == "Backstage passes to a TAFKAL80ETC concert") {
                        //AUMENTA OTRO PUNTO DE CALIDAD SI ES ENTRADA ANTES DE 10 DIAS
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1
                            }
                        }
                        //AUMENTA OTRO PUNTO DE CALIDAD SI ES ENTRADA ANTES DE 10 DIAS
                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1
                            }
                        }
                    }
                }
            }
            //DISMINUYE EL DIA SI NO SULFURA
            if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                items[i].sellIn = items[i].sellIn - 1
            }
            //SI FECHA DE VENTA
            if (items[i].sellIn < 0) {
                //SI NO QUESO
                if (items[i].name != "Aged Brie") {
                    //SI NO ENTRADA
                    if (items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                        //SI CALIDAD > 0
                        if (items[i].quality > 0) {
                            //SI NO SULFURA BAJAR CALIDAD
                            if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                                items[i].quality = items[i].quality - 1
                            }
                        }
                        //SI ENTRADA
                    } else {
                        //CALIDAD IGUAL A 0
                        items[i].quality = items[i].quality - items[i].quality
                    }
                //SI QUESO
                } else {
                    //AUMENTA CALIDAD SI NO ES 50 (TENIENDO EN CUENTA QUE ANTES LE HABIAMOS SUMADO YA)
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1
                    }
                }
            }
        }
    }

}

