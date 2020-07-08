package com.example.bytecoint

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextThemeWrapper
import android.view.View
import android.widget.*
import com.example.bytecoint.Logic.ControllerGame
import com.example.bytecoint.Logic.Item
import kotlinx.android.synthetic.main.activity_list_header.*
import kotlinx.android.synthetic.main.activity_shop_view.*

class ShopView : AppCompatActivity() {

    private lateinit var header: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_view)
        header = createHeader()
        generateListItem(header)
    }

    private fun createHeader() : View
    {
        val view = layoutInflater.inflate(R.layout.activity_list_header, null)
        val shopmenu = view.findViewById<LinearLayout>(R.id.ShopMenu)
        var index = 0
        for(section in ControllerGame.shop.sections)
        {
            val button = Button(ContextThemeWrapper(this, R.style.buttonMenu))
            shopmenu.run {
                button.text = section.name
                button.background.alpha = 0
                button.tag = index
                button.setOnClickListener {buttonMenuClick(button)}
                addView(button)
            }
            index++
        }
        return view;
    }

    fun buttonMenuClick(button: Button) {
        ControllerGame.currentIndexMenu = button.tag as Int
        generateListItem(header, false)
    }

    private fun generateListItem(header: View, isNeed: Boolean = true)
    {
        val listview = findViewById<ListView>(R.id.Listview)
        if(isNeed)
        listview.addHeaderView(header)
        val shopAdapter = ShopAdapter(this, R.layout.list_item, ControllerGame.shop.sections[ControllerGame.currentIndexMenu].items)
        listview.adapter = shopAdapter
    }

}