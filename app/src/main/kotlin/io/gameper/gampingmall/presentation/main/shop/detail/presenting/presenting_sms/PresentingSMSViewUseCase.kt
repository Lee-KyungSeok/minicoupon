package io.gameper.gampingmall.presentation.main.shop.detail.presenting.presenting_sms


import android.widget.EditText
import com.jakewharton.rxbinding3.widget.textChanges
import io.gameper.gampingmall.R
import io.gameper.gampingmall.presentation.main.shop.detail.presenting.presenting_sms.di.PresentingSMSScope
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@PresentingSMSScope
class PresentingSMSViewUseCase @Inject constructor(view: PresentingSMSView) {

    private val editPhoneView : EditText = view.findViewById(R.id.editTextPhoneSelect)

    fun observeEditTextContent(): Observable<String> {
        return editPhoneView.textChanges()
            .subscribeOn(Schedulers.io())
            .map {
                it.toString()
            }
            .distinctUntilChanged()
            .observeOn(AndroidSchedulers.mainThread())
    }
}