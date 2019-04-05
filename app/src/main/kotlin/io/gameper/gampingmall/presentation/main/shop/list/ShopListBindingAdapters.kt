package io.gameper.gampingmall.presentation.main.shop.list

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import io.gameper.gampingmall.entity.Product


@BindingAdapter("bind_gifts")
fun bindGifts(view : RecyclerView, items : List<Product>) {
    val adapter = view.adapter as? ShopListAdapter
    adapter?.productList = items
    adapter?.notifyDataSetChanged()
}