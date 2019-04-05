package io.gameper.gampingmall.presentation.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import io.gameper.gampingmall.R
import io.gameper.gampingmall.appDependencies
import io.gameper.gampingmall.presentation.base.RxLifeCycleActivityBinder
import io.gameper.gampingmall.presentation.base.state.ActivityState
import io.gameper.gampingmall.presentation.main.di.DaggerMainComponent
import io.gameper.gampingmall.presentation.main.di.MainModule
import io.gameper.gampingmall.presentation.model.OrderWrapper
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainView: MainView

    @Inject
    lateinit var rxLifeCycleActivityBinder: RxLifeCycleActivityBinder

    @Inject
    lateinit var interactor: MainInteractor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var activityState: ActivityState? = null
        savedInstanceState?.let {
            activityState = savedInstanceState.getParcelable(MAIN_ACTIVITY_STATE)
        }
        injectComponent(activityState)
        setContentView(mainView)


        rxLifeCycleActivityBinder.executeOnCreate()

        interactor.restoreState()

        // temp
        tempSetListener()
    }

    private fun injectComponent(activityState: ActivityState?) {

        DaggerMainComponent.builder()
            .activity(this)
            .mainModule(MainModule(activityState ?: ActivityState()))
            .appDependencies(applicationContext.appDependencies())
            .build()
            .inject(this)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(MAIN_ACTIVITY_STATE, interactor.getActivityState())
    }

    override fun onBackPressed() {
        if(!interactor.onBackPressed()) {
            super.onBackPressed()
        }
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

    companion object {
        private const val MAIN_ACTIVITY_STATE = "MAIN_ACTIVITY_STATE"
    }



    // ====== temp email 처리를 일단 여기서 전부 처리함

    @Inject
    lateinit var orderWrapper: OrderWrapper

    private fun tempSetListener() {

        orderWrapper.tempEmail = resources.getString(R.string.name_yun)

        tempIdSelect.setOnCheckedChangeListener { _, checkedId ->
            when(checkedId) {
                R.id.yun -> orderWrapper.tempEmail = resources.getString(R.string.name_yun)
                R.id.lee -> orderWrapper.tempEmail = resources.getString(R.string.name_lee)
                R.id.ko -> orderWrapper.tempEmail = resources.getString(R.string.name_ko)
            }
        }

        btnTemp.setOnClickListener {
            tempEmailContainer.visibility = View.GONE
            Toast.makeText(this, "${orderWrapper.tempEmail} 이 선택되었습니다,", Toast.LENGTH_SHORT).show()
        }
    }

}
