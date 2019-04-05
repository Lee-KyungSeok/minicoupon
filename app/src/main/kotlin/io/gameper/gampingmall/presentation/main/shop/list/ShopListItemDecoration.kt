package io.gameper.gampingmall.presentation.main.shop.list

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ShopListItemDecoration(
    private val spanCount: Int = 2,
    private val spacing: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        
        val position = parent.getChildAdapterPosition(view) // item position
        val column = position % spanCount // item column

        outRect.left = column * spacing / spanCount
        outRect.right = spacing - (column + 1) * spacing / spanCount
    }
}