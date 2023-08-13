package com.nut.cdev.bitcoinapplication.views.main

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.nut.cdev.bitcoinapplication.R
import com.nut.cdev.bitcoinapplication.data.model.BtcModel
import com.nut.cdev.bitcoinapplication.data.realm.BtcHistoryModel
import com.nut.cdev.bitcoinapplication.databinding.ItemRvHistoryBinding
import com.nut.cdev.bitcoinapplication.ext.toShowDate
import com.nut.cdev.bitcoinapplication.ext.toShowTime
import com.nut.cdev.recyclerview.swipe.OnSwipeListener
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale
import java.util.TimeZone


@SuppressLint("NotifyDataSetChanged", "SetTextI18n")
class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.HistoryHolder>() {
    val items = mutableListOf<BtcHistoryModel>()
    var callback: ((BtcHistoryModel) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryHolder {
        val binding = DataBindingUtil.inflate<ItemRvHistoryBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_rv_history,
            parent,
            false
        )
        return HistoryHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: HistoryHolder, position: Int) {
        holder.bind(items[position])
        holder.selectMenu {
            callback?.invoke(it)
        }
    }

    fun getPosition(position: Int): BtcHistoryModel {
        return items[position]
    }

    fun deleteItem(item: BtcHistoryModel) {
        try {
            items.remove(item)
            this.notifyDataSetChanged()
        } catch (e: Exception) {

        }
    }

    fun setItems(items: MutableList<BtcHistoryModel>) {
        this.items.clear()
        this.items.addAll(items)
        this.notifyDataSetChanged()
    }

    fun addItem(items: BtcHistoryModel) {
        this.items.add(0, items)
        this.notifyDataSetChanged()
    }

    fun selectMenu(callback: ((BtcHistoryModel) -> Unit)?) {
        this.callback = callback
    }

    @SuppressLint("SimpleDateFormat")
    class HistoryHolder(val binding: ItemRvHistoryBinding) :
        RecyclerView.ViewHolder(binding.root), OnSwipeListener {
        var callback: ((BtcHistoryModel) -> Unit)? = null

        fun bind(item: BtcHistoryModel) {
            binding.apply {
                val dateTime = item.updatedISO?.replace("T", " ")?.replace("+00:00", "")
                tvTime.text =
                    "Date : " + dateTime?.toShowDate() + "\nTime : " + dateTime?.toShowTime() + " s"
                tvEUR.text = "EUR : " + item.EUR_rate
                tvGDP.text = "GBP : " + item.GBP_rate
                tvUSD.text = "USD : " + item.USD_rate

            }
            binding.btnMenu.setOnClickListener {
                callback?.invoke(item)
            }
        }

        fun selectMenu(callback: ((BtcHistoryModel) -> Unit)?) {
            this.callback = callback
        }

        override fun isSwipe(): Boolean {
            return true
        }
    }
}



