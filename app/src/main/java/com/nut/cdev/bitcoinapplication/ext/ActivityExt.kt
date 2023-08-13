package com.nut.cdev.bitcoinapplication.ext

import android.app.Activity
import androidx.fragment.app.FragmentManager
import com.nut.cdev.bitcoinapplication.views.dialog.DialogAlertMessage


fun Activity.showAlertDialog(
    fragmentManager: FragmentManager,
    message: String?,
    clickCallback: ((Unit) -> Unit)
) {
    message?.let {
        if (it.isEmpty()) return
        runOnUiThread {
            val dialog = DialogAlertMessage.newInstance(it)
            dialog.show(fragmentManager)
            dialog.setOnButtonLeftClick {
                clickCallback.invoke(Unit)
            }
        }
    }
}


fun Activity.showAlertDialog(
    fragmentManager: FragmentManager,
    message: String?,
    textLeft: String,
    textRight: String,
    clickCallback: ((Boolean) -> Unit)
) {
    message?.let {
        if (it.isEmpty()) return
        runOnUiThread {
            val dialog = DialogAlertMessage.newInstance(it, textLeft, textRight)
            dialog.setOnButtonLeftClick {
                clickCallback.invoke(false)
            }
            dialog.setOnButtonRightClick {
                clickCallback.invoke(true)
            }
            dialog.show(fragmentManager)
        }
    }
}