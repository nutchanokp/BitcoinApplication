package com.nut.cdev.bitcoinapplication.views.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.nut.cdev.bitcoinapplication.R
import com.nut.cdev.bitcoinapplication.data.model.BtcModel
import com.nut.cdev.bitcoinapplication.data.realm.BtcHistoryModel
import com.nut.cdev.bitcoinapplication.databinding.ItemRvHistoryBinding
import com.nut.cdev.recyclerview.swipe.OnSwipeListener


@SuppressLint("NotifyDataSetChanged")
class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.HistoryHolder>() {
    val items = mutableListOf<BtcHistoryModel>()
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
    }

    fun getPosition(position: Int): BtcHistoryModel {
        return items[position]
    }

    fun deleteItem(item: BtcHistoryModel) {
        try {
//           items.indexOf(item)
//           items.find { it.id == item.id }
//           items.removeAt(items.indexOf(items.find { it.id == item.id }))
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
        this.items.add(0,items)
        this.notifyDataSetChanged()
    }

    class HistoryHolder(val binding: ItemRvHistoryBinding) :
        RecyclerView.ViewHolder(binding.root), OnSwipeListener {

        fun bind(item: BtcHistoryModel) {
            binding.apply {
                tvChartName.text = item.chartName
                tvUpdated.text = item.updated
                tvUpdatedISO.text = item.updatedISO
                tvUpdateduk.text = item.updateduk
            }
//                tvSummary.text = item?.healthType
//                tvBmi.text = item?.bmi.toString()
//                tvBmr.text = item?.bmr.toString()
//                tvBodyFat.text = item?.body_fat.toString() + item?.body_fatTxt
//                tvIbw.text = item?.ibw.toString() + item?.ibwTxt
//                tvTdee.text = item?.rdee.toString()
//                tvMindTitle.text = item?.mindType
//                tvDate.text = "วันที่ " + item?.dateTimestamp
////                tvSummary.text = "ค่า BMI : " + item?.BMI.toString()
////                tvResult.text = "คุณ " + item?.result
//            }
//            binding.btnHistory.setOnClickListener {
//
//            }
        }
        override fun isSwipe(): Boolean {
            return true
        }
    }
}


