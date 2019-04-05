package io.gameper.gampingmall.presentation.main.bottom

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import javax.inject.Inject

class BottomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BottomNavigationView(context, attrs, defStyleAttr) {


    @Inject
    lateinit var interactor: BottomInteractor

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        checkItemSelected()
        setListener()
    }

    private fun setListener() {
        this.setOnNavigationItemSelectedListener {
            interactor.onBottomChange(it.itemId)
            true
        }
    }

    private fun checkItemSelected() {
        this.selectedItemId = interactor.checkSelectedItemId()
    }
}