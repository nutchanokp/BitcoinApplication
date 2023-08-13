package com.nut.cdev.bitcoinapplication.ext

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.nut.cdev.bitcoinapplication.R
import com.nut.cdev.bitcoinapplication.data.realm.BtcHistoryModel
import com.nut.cdev.bitcoinapplication.views.main.HistoryAdapter
import com.nut.cdev.recyclerview.swipe.SwipeHelper

fun RecyclerView.enableSwipeRecyclerView(
    context: Context,
    historyAdapter: HistoryAdapter,
    deleteCallback: (BtcHistoryModel) -> Unit,
) {
    val swipeHelper = object : SwipeHelper(context) {
        override fun instantiateUnderlayButton(
            viewHolder: RecyclerView.ViewHolder,
            underlayButtons: MutableList<UnderlayButton>
        ) {
            underlayButtons.add(UnderlayButton("Delete",
                0,
                ContextCompat.getColor(context, R.color.btn_red),
                object : UnderlayButtonClickListener {
                    override fun onClick(view: UnderlayButton, position: Int) {
                        val menu = historyAdapter.getPosition(position)
                        menu?.let { deleteCallback.invoke(it) }
                    }
                }
            ))
        }
    }
    swipeHelper.attachToRecyclerView(this)
}

