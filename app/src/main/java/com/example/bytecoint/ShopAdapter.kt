package com.example.bytecoint

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import com.example.bytecoint.Logic.ControllerGame
import com.example.bytecoint.Logic.Item
import kotlinx.android.synthetic.main.list_item.view.*


class ShopAdapter(var mCtx: Context, var resources: Int, var items: List<Item>) :
    ArrayAdapter<Item>(
        mCtx, resources, items
    ) {
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater : LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(resources, null)

        val item : Item = items[position];


        val countView: TextView = view.count
        val addButton : Button = view.BuyButton
        addButton.setOnClickListener{
            Selling(addButton, item)
            countView.text = item.count.toString()
        }
        val nameView: TextView = view.name
        val priceView: TextView = view.price
        val plusSpeedView: TextView = view.plusSpeed


        nameView.text = item.name
        priceView.text = item.price.toString()
        countView.text = item.count.toString()
        plusSpeedView.text  = item.plusCoins.toString()


        return view
    }

    fun Selling(it: View, item: Item) {
        item.count++
        ControllerGame.bitcoinLogic.improveSecond(item.plusCoins)
    }
}