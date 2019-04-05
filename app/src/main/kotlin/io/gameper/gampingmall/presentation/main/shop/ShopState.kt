package io.gameper.gampingmall.presentation.main.shop

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ShopData(val state: ShopState): Parcelable

enum class ShopState {
    NONE,
    SHOP_LIST,
    SHOP_DETAIL,
    PAYMENT
}