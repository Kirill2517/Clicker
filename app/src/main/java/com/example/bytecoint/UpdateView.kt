package com.example.bytecoint

import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class UpdateView(val view: MainActivity) : TimerTask() {
    override fun run() {
        view.print()
    }
}