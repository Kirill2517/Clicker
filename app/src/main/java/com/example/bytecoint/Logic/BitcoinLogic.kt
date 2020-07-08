package com.example.bytecoint.Logic

import java.util.*

class BitcoinLogic{
    var perSecond = 0.000000001f;
    var perClick = 0.000000001f;
    var Score = 0f;
    val timer = Timer()

    init {
        val timerTask = UpdateTimerScore(this);
        timer.scheduleAtFixedRate(timerTask, 0, 1000)
    }

    fun scoreSecond()
    {
        Score += perSecond
    }

    fun scoreClick()
    {
        Score += perClick
    }

    fun improveClick(float: Float)
    {
        perClick += float
    }

    fun improveSecond(float: Float)
    {
        perSecond += float
    }

}