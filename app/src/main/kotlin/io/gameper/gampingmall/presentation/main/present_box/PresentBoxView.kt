package io.gameper.gampingmall.presentation.main.present_box

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import io.gameper.gampingmall.R
import kotlinx.android.synthetic.main.view_present_box.view.*
import javax.inject.Inject

class PresentBoxView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    @Inject
    lateinit var interactor: PresentBoxInteractor

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        setViewPager()
    }

    private fun setViewPager() {
        tabLayoutPresentBox.addTab( tabLayoutPresentBox.newTab().setText("받은 선물함"))
        tabLayoutPresentBox.addTab( tabLayoutPresentBox.newTab().setText("보낸 선물함"))

        viewPagePresentBox.adapter = ReceivedPagerAdapter()

        tabLayoutPresentBox.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(viewPagePresentBox))
        viewPagePresentBox.addOnPageChangeListener( TabLayout.TabLayoutOnPageChangeListener(tabLayoutPresentBox))

    }

    inner class ReceivedPagerAdapter: PagerAdapter() {

        override fun getCount(): Int = 2

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            var view: View
            if(position == 0) {
                view = interactor.onReceivedViewShow()
            } else {
                view = interactor.onSentViewShow()
            }
            container.addView(view)
            return view
        }

        override fun isViewFromObject(view: View, any: Any): Boolean {
            return any == view
        }

        override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
            (container as ViewPager).removeView(view as View)
        }
    }
}