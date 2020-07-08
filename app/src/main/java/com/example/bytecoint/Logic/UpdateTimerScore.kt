package com.example.bytecoint.Logic

import java.util.*

class UpdateTimerScore(val bitcoinLogic: BitcoinLogic) : TimerTask() {
    override fun run() {
        bitcoinLogic.scoreSecond()
    }
}