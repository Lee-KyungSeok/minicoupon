package io.gameper.gampingmall.utils

import android.graphics.Bitmap
import android.graphics.Color.BLACK
import android.graphics.Color.WHITE
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.MultiFormatWriter
import com.google.zxing.common.BitMatrix
import java.util.*

//const val WHITE: Int = 0xFFFFFFFF
//const val BLACK: Int = 0xFF000000

fun String.encodeBarcodeAsBitmap(format: BarcodeFormat, img_width: Int, img_height: Int): Bitmap {
    val contentsToEncode = this

    val hints: MutableMap<EncodeHintType, Any> = EnumMap<EncodeHintType, Any>(EncodeHintType::class.java)
    hints[EncodeHintType.CHARACTER_SET] = "utf-8"

    var result: BitMatrix
    MultiFormatWriter().apply {
        result = this.encode(contentsToEncode, format, img_width, img_height, hints)
    }

    val width = result.width
    val height = result.height
    val pixelSize = width * height
    val pixels = IntArray(pixelSize)
    for (y in 0 until height) {
        val offset = y * width
        for (x in 0 until width) {
            pixels[offset + x] = if (result!!.get(x, y)) BLACK else WHITE
        }
    }

    val bitmap: Bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    bitmap.setPixels(pixels, 0, width, 0, 0, width, height)

    return bitmap
}

