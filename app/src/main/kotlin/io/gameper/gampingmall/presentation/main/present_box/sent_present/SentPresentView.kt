package io.gameper.gampingmall.presentation.main.present_box.sent_present

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import io.gameper.gampingmall.R
import io.gameper.gampingmall.databinding.ItemPresentSentBinding
import io.gameper.gampingmall.entity.Product
import io.gameper.gampingmall.presentation.main.shop.list.ShopListItemDecoration
import javax.inject.Inject

class SentPresentView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
)  : RecyclerView(context, attrs, defStyleAttr), SentPresentInteractor.Presenter {

    @Inject
    lateinit var interactor: SentPresentInteractor

    lateinit var sentAdapter: Adapter

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        setRecyclerView()
        interactor.requestSentGiftAll()
    }

    private fun setRecyclerView() {
        sentAdapter = Adapter()
        this@SentPresentView.adapter = sentAdapter
        val width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8f, resources.displayMetrics).toInt()
        val decoration = ShopListItemDecoration(spacing = width)
        this.addItemDecoration(decoration)
    }

    override fun updateSent(productList: List<Product>) {
        sentAdapter.setData(productList)
    }

    inner class Adapter : RecyclerView.Adapter<ViewHolder>() {
        var productList: List<Product> = mutableListOf()

        fun setData(productList: List<Product>) {
            this.productList = productList
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding: ItemPresentSentBinding = DataBindingUtil.inflate(inflater, R.layout.item_present_sent, parent, false)
            return ViewHolder(binding)        }

        override fun getItemCount(): Int = productList.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(productList[position])        }

    }

    inner class ViewHolder(val binding: ItemPresentSentBinding): RecyclerView.ViewHolder(binding.root) {
        var product: Product? = null

        init {
//            itemView.stageItemShopList.setOnClickListener {
//                interactor.changeToDetail(product!!)
//            }
        }

        fun bind(product: Product) {
            this.product = product
            binding.product = product
        }
    }
}