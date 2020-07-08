package com.example.bytecoint.Logic

import kotlin.math.pow

class Shop
{
    lateinit var sections: MutableList<Section>

    init {
        //Видеокарты
        sections = arrayListOf()
        sections.add( generateItems(0.000000016f, 0.000000001f, "Видеокарта ", "Видеокарты ", Bonus.SpeedInGame))
        sections.add( generateItems(0.000000032f, 0.000000001f, "Процессор ","Процессоры ", Bonus.SpeedOutGame))
        sections.add( generateItems(0.000000064f, 0.000000001f, "Мышка ", "Мышки ", Bonus.CLICK))
    }

    private fun generateItems(startPrice: Float, startPlus : Float, nameItem: String, nameSection: String, bonus: Bonus) : Section
    {
        val section = Section(bonus, nameSection, "fggd")
        var lastPrice =startPrice
        var lastPlus =startPlus
        for (i in (1..8))
        {
            val item = Item("$nameItem $i", lastPrice, lastPlus, 10)
            lastPrice *= 16
            lastPlus *= 8
            section.items.add(item)
        }
        return section
    }
}