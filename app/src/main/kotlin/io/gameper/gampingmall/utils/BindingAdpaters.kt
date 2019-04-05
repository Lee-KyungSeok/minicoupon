package io.gameper.gampingmall.utils

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import io.gameper.gampingmall.presentation.GlideApp
import java.util.*

@BindingAdapter("imageFromUrl")
fun ImageView.bindImageFromUrl(imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        GlideApp.with(this.context)
            .load(imageUrl)
            .placeholder(ColorDrawable(Color.GRAY))
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(this)
    }
}

@BindingAdapter("barcodeFromText")
fun ImageView.bindBarcodeFromText(barcode: String) {
    try {
       val bitmap = barcode.encodeBarcodeAsBitmap(BarcodeFormat.CODE_128,600 , 300)
        this.setImageBitmap(bitmap)
    } catch (e: WriterException) {
        return
    }
}

@BindingAdapter("convertExpiredDateToString")
fun TextView.bindConvertExpiredDateToString(date:Date) {
    val dateText: String = date.convertToString("yyyy.MM.dd")
    this.text = dateText
}

@BindingAdapter("checkVisibleByStatus")
fun View.bindVisibleByStatus(status: String) {
    if(status == "used") {
        this.visibility = View.VISIBLE
    } else {
        this.visibility = View.GONE
    }
}