package io.gameper.gampingmall.utils

import android.content.Context
import android.util.TypedValue
import androidx.annotation.DimenRes
import androidx.annotation.StringRes

interface ResourcesProvider {
    fun string(@StringRes id: Int): String
    fun string(@StringRes id: Int, vararg args: String): String
    fun dimen(@DimenRes id: Int): Float
    fun getDp(dps: Float): Int
}

class ResourcesProviderImpl(context: Context) : ResourcesProvider {
    private val resources = context.resources
    override fun string(@StringRes id: Int) = resources.getString(id)
    override fun string(@StringRes id: Int, vararg args: String) = resources.getString(id, args)
    override fun dimen(@DimenRes id: Int) = resources.getDimension(id)
    override fun getDp(dps: Float): Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dps, resources.displayMetrics).toInt()
}