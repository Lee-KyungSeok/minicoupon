package io.gameper.gampingmall.presentation.base

import android.os.Parcelable

interface StateDateProvider {
    fun onSaveData(): Parcelable?
}