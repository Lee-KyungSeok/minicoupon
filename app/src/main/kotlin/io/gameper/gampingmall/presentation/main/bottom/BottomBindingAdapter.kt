package io.gameper.gampingmall.presentation.main.bottom

import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.gameper.gampingmall.R

@BindingAdapter("bottom_changed")
fun setBottomChanged(view: BottomNavigationView, listener: InverseBindingListener) {
    view.setOnNavigationItemSelectedListener {
        listener.onChange()
        true
    }
}

@InverseBindingAdapter(attribute = "selected_id", event = "bottom_changed")
fun getBottomSelectedId(view: BottomNavigationView): Int {
    return view.selectedItemId
}