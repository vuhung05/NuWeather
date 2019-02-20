package com.nuweather.util

import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.app.AlertDialog
import com.nuweather.R

object DialogUtils {

    private fun createLoadingDialog(context: Context?, cancelable: Boolean = false,
                                    canceledOnTouchOutside: Boolean = false): AlertDialog? {
        if (context == null) return null
        return AlertDialog.Builder(context).setView(R.layout.progress_dialog).create().apply {
            setCancelable(cancelable)
            setCanceledOnTouchOutside(canceledOnTouchOutside)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }

    fun showLoadingDialog(context: Context?, cancelable: Boolean = false): AlertDialog? {
        if (context == null) return null
        val dialog = createLoadingDialog(context, cancelable)
        dialog?.show()
        return dialog
    }

    fun showMessage(context: Context?, title: String? = null, message: String? = null,
                    textPositive: String? = null, textNegative: String? = null,
                    callback: DialogCallback? = null, cancelable: Boolean = false): AlertDialog? {
        if (context == null) return null
        val dialog: AlertDialog =
            AlertDialog.Builder(context).apply {
                setTitle(title)
                setMessage(message)
                setPositiveButton(textPositive, callback?.onPositiveListener())
                setNegativeButton(textNegative, callback?.onNegativeListener())
                setCancelable(cancelable)
            }.create()
        dialog.show()
        return dialog
    }

    fun showMessage(context: Context?, title: Int? = null, message: Int? = null,
                    textPositive: Int? = null, textNegative: Int? = null, callback: DialogCallback? = null,
                    cancelable: Boolean = false): AlertDialog? {
        if (context == null) return null
        val dialog: AlertDialog = AlertDialog.Builder(context).apply {
            if (title != null) setTitle(title)
            if (message != null) setMessage(message)
            if (textPositive != null) {
                setPositiveButton(textPositive, callback?.onPositiveListener())
            }
            if (textNegative != null) {
                setNegativeButton(textNegative, callback?.onNegativeListener())
            }
            setCancelable(cancelable)
        }.create()
        dialog.show()
        return dialog
    }
}

abstract class DialogCallback {
    open fun onNegativeListener(): DialogInterface.OnClickListener? {
        return null
    }

    open fun onPositiveListener(): DialogInterface.OnClickListener? {
        return null
    }
}