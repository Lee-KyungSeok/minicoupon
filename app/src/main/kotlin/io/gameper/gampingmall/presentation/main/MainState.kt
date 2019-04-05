package io.gameper.gampingmall.presentation.main

import android.os.Parcelable
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.parcel.Parcelize
import javax.inject.Inject

@Parcelize
data class MainData(val state: MainState): Parcelable

enum class MainState {
    SHOP,
    PRESENT_BOX
}

//class MainStateStreamProvider @Inject
//constructor() {
//
//    private val appStateSubject = BehaviorSubject.createDefault(MainState.SHOP)
//    fun provideMainStateStream(): Observable<MainState> {
//        return appStateSubject.distinctUntilChanged() //TODO stub
//    }
//}