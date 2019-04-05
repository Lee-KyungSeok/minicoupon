package io.gameper.gampingmall.utils

import android.content.Context
import android.widget.Toast

interface ToastProvider {
    fun makeToast(charSequence: CharSequence)
    fun makeToast(resId: Int)
}

class ToastProviderImpl(private val context: Context) : ToastProvider {
    override fun makeToast(charSequence: CharSequence)  = Toast.makeText(context, charSequence, Toast.LENGTH_SHORT).show()

    override fun makeToast(resId: Int) = Toast.makeText(context, resId, Toast.LENGTH_SHORT).show()

}