package io.gameper.gampingmall.presentation.base.activity

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import dagger.android.support.DaggerAppCompatActivity
import io.gameper.gampingmall.presentation.base.RxLifeCycleActivityBinder

abstract class RxBaseActivity(val rxLifeCycleActivityBinder: RxLifeCycleActivityBinder): AppCompatActivity() {

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rxLifeCycleActivityBinder.executeOnCreate()
    }

    @CallSuper
    override fun onStart() {
        super.onStart()
        rxLifeCycleActivityBinder.executeOnStart()
    }

    @CallSuper
    override fun onResume() {
        super.onResume()
        rxLifeCycleActivityBinder.executeOnResume()
    }

    @CallSuper
    override fun onPause() {
        rxLifeCycleActivityBinder.executeOnPause()
        super.onPause()
    }

    @CallSuper
    override fun onStop() {
        rxLifeCycleActivityBinder.executeOnStop()
        super.onStop()
    }

    @CallSuper
    override fun onDestroy() {
        rxLifeCycleActivityBinder.executeOnDestroy()
        super.onDestroy()
    }
}