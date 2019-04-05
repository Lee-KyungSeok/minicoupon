package io.gameper.gampingmall.presentation.main.di

import android.content.Context
import android.view.LayoutInflater
import dagger.Module
import dagger.Provides
import io.gameper.gampingmall.R
import io.gameper.gampingmall.presentation.base.RxLifeCycleActivityBinder
import io.gameper.gampingmall.presentation.base.state.ActivityState
import io.gameper.gampingmall.presentation.main.*
import io.gameper.gampingmall.presentation.main.bottom.BottomInteractor
import io.gameper.gampingmall.presentation.main.bottom.BottomNodeHolder
import io.gameper.gampingmall.presentation.main.present_box.PresentBoxNodeHolder
import io.gameper.gampingmall.presentation.main.shop.ShopInteractor
import io.gameper.gampingmall.presentation.main.shop.ShopNodeHolder
import io.gameper.gampingmall.presentation.main.shop.detail.ShopDetailInteractor
import io.gameper.gampingmall.presentation.main.shop.payment.pay_sucess.PaySuccessInteractor
import io.gameper.gampingmall.presentation.model.GiftWrapper
import io.gameper.gampingmall.presentation.model.OrderWrapper
import io.gameper.gampingmall.utils.ToastProvider
import io.gameper.gampingmall.utils.ToastProviderImpl
import io.reactivex.Observable
import javax.inject.Named

@Module
class MainModule(private val activityState: ActivityState) {

    @MainScope
    @Provides
    @Named("mainContext")
    fun provideMainContext(activity: MainActivity) : Context = activity

    @MainScope
    @Provides
    fun provideInflater(@Named("mainContext") context: Context) : LayoutInflater = LayoutInflater.from(context)

    @MainScope
    @Provides
    fun provideMainRxLifeCycleBinder(): RxLifeCycleActivityBinder = RxLifeCycleActivityBinder()

    @MainScope
    @Provides
    fun provideActivityState() : ActivityState {
        return activityState
    }

//    @MainScope
//    @Provides
//    fun provideMainStateStream(provider: AppStateStreamProvider): Observable<MainState> {
//        return provider.provideMainStateStream()
//    }

    @MainScope
    @Provides
    fun providesMainView(inflater: LayoutInflater) : MainView =
        inflater.inflate(R.layout.activity_main, null, true) as MainView

    @MainScope
    @Provides
    fun provideShopNodeHolder(component: MainComponent): ShopNodeHolder = ShopNodeHolder(component)

    @MainScope
    @Provides
    fun providePresentBoxNodeHolder(
        inflater: LayoutInflater,
        mainView: MainView,
        component: MainComponent
    ) : PresentBoxNodeHolder =
        PresentBoxNodeHolder(inflater, mainView, component)

    @MainScope
    @Provides
    fun provideBottomNodeHolder(
        inflater: LayoutInflater,
        mainView: MainView,
        component: MainComponent
    ): BottomNodeHolder =
        BottomNodeHolder(inflater, mainView, component)

    @MainScope
    @Provides
    fun providePaySuccessListener(interactor: MainInteractor): PaySuccessInteractor.Listener = interactor

    @MainScope
    @Provides
    fun provideBottomListener(interactor: MainInteractor): BottomInteractor.Listener = interactor

    @MainScope
    @Provides
    fun provideShopListener(interactor: MainInteractor): ShopInteractor.Listener = interactor

    @MainScope
    @Provides
    fun provideGiftWrapper(): GiftWrapper = GiftWrapper(null)

    @MainScope
    @Provides
    fun provideOrderWrapper(): OrderWrapper = OrderWrapper()

    @MainScope
    @Provides
    @Named("activityToast")
    fun provideToastProvider(@Named("mainContext") context: Context): ToastProvider = ToastProviderImpl(context)

}