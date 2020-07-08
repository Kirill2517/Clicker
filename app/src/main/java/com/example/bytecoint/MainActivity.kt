package com.example.bytecoint

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.bytecoint.Logic.ControllerGame
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val controllerGame = ControllerGame()
    private val bitcoinLogic = ControllerGame.bitcoinLogic
    private val shop = ControllerGame.shop

    private val timer = Timer()

    private fun updatePrint()
    {
        perSecond.text = bitcoinLogic.perSecond.toBigDecimal().toPlainString()
        perClick.text = bitcoinLogic.perClick.toBigDecimal().toPlainString()
        Score.text = bitcoinLogic.Score.toBigDecimal().toPlainString()
        Log.d("print", bitcoinLogic.Score.toBigDecimal().toPlainString())
    }

    private fun initValues()
    {
        updatePrint()
        val task = UpdateView(this)
        timer.scheduleAtFixedRate(task, 0, 500)
    }

    fun print()
    {
        runOnUiThread {
            updatePrint()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //считывание из файла, создание объекта логики

        //вывод изначальных значений
        initValues()
    }

    fun mainButtonClick(view: View) {
        bitcoinLogic.scoreClick()
        updatePrint()
    }

    fun getShop(view: View) {
        val shopActivity = Intent(this, ShopView::class.java)
        startActivity(shopActivity)
    }
}