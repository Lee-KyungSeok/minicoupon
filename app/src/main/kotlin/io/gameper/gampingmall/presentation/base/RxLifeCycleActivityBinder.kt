package io.gameper.gampingmall.presentation.base

import androidx.annotation.CheckResult
import com.trello.rxlifecycle3.LifecycleProvider
import com.trello.rxlifecycle3.LifecycleTransformer
import com.trello.rxlifecycle3.RxLifecycle
import com.trello.rxlifecycle3.android.ActivityEvent
import com.trello.rxlifecycle3.android.RxLifecycleAndroid
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

class RxLifeCycleActivityBinder: LifecycleProvider<ActivityEvent> {

    private val lifecycleSubject = BehaviorSubject.create<ActivityEvent>()

    @CheckResult
    override fun lifecycle(): Observable<ActivityEvent> {
        return lifecycleSubject.hide()
    }

    @CheckResult
    override fun <T> bindUntilEvent(event: ActivityEvent): LifecycleTransformer<T> {
        return RxLifecycle.bindUntilEvent(lifecycleSubject, event)
    }

    @CheckResult
    override fun <T> bindToLifecycle(): LifecycleTransformer<T> {
        return RxLifecycleAndroid.bindActivity(lifecycleSubject)
    }


    fun executeOnCreate() {
        lifecycleSubject.onNext(ActivityEvent.CREATE)
    }

    fun executeOnStart() {
        lifecycleSubject.onNext(ActivityEvent.START)
    }

    fun executeOnResume() {
        lifecycleSubject.onNext(ActivityEvent.RESUME)
    }

    fun executeOnPause() {
        lifecycleSubject.onNext(ActivityEvent.PAUSE)
    }

    fun executeOnStop() {
        lifecycleSubject.onNext(ActivityEvent.STOP)
    }

    fun executeOnDestroy() {
        lifecycleSubject.onNext(ActivityEvent.DESTROY)
    }
}