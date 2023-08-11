package com.nut.cdev.bitcoinapplication.views.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.nut.cdev.bitcoinapplication.R
import com.nut.cdev.bitcoinapplication.data.realm.HistoryModel
import com.nut.cdev.bitcoinapplication.databinding.ItemRvHistoryBinding

@SuppressLint("NotifyDataSetChanged")
class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.HistoryHolder>() {
    val items = mutableListOf<HistoryModel>()
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

    fun getPosition(position: Int): HistoryModel {
        return items[position]
    }

    fun deleteItem(item: HistoryModel) {
        try {
//           items.indexOf(item)
//           items.find { it.id == item.id }
//           items.removeAt(items.indexOf(items.find { it.id == item.id }))
            items.remove(item)
            this.notifyDataSetChanged()
        } catch (e: Exception) {

        }
    }

    fun setItems(items: MutableList<HistoryModel>) {
        this.items.clear()
        this.items.addAll(items)
        this.notifyDataSetChanged()
    }

    class HistoryHolder(val binding: ItemRvHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: HistoryModel) {
//            binding.apply {
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
    }
}


