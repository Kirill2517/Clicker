package com.example.bytecoint.Logic

data class Item(
    val name: String,
    var price : Float,
    val plusCoins : Float,
    val markUp : Int,
    var count : Int = 0
)

enum class Bonus
{
    SpeedInGame, SpeedOutGame, CLICK
}

class Section(val bonus: Bonus, val name: String, val image : String)
{
    val items = mutableListOf<Item>()
}