package io.gameper.gampingmall.presentation.main.present_box.received_present

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import io.gameper.gampingmall.R
import io.gameper.gampingmall.databinding.ItemPresentReceivedBinding
import io.gameper.gampingmall.entity.Product
import io.gameper.gampingmall.presentation.main.shop.list.ShopListItemDecoration
import kotlinx.android.synthetic.main.item_present_received.view.*
import javax.inject.Inject

class ReceivedPresentView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
)  : RecyclerView(context, attrs, defStyleAttr), ReceivedPresentInteractor.Presenter {

    @Inject
    lateinit var interactor: ReceivedPresentInteractor

    lateinit var receivedAdapter: Adapter

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        setRecyclerView()
        interactor.requestReceivedGiftAll()
    }

    private fun setRecyclerView() {
        receivedAdapter = Adapter()
        this@ReceivedPresentView.adapter = receivedAdapter
        val width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8f, resources.displayMetrics).toInt()
        val decoration = ShopListItemDecoration(spacing = width)
        this.addItemDecoration(decoration)
    }

    override fun updateReceived(productList: List<Product>) {
        receivedAdapter.setData(productList)
    }

    inner class Adapter : RecyclerView.Adapter<ViewHolder>() {
        var productList: List<Product> = mutableListOf()

        fun setData(productList: List<Product>) {
            this.productList = productList
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding: ItemPresentReceivedBinding = DataBindingUtil.inflate(inflater, R.layout.item_present_received, parent, false)
            return ViewHolder(binding)        }

        override fun getItemCount(): Int = productList.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(productList[position])        }

    }

    inner class ViewHolder(val binding: ItemPresentReceivedBinding): RecyclerView.ViewHolder(binding.root) {
        var product: Product? = null

        init {
            itemView.stageItemPresentReceived.setOnClickListener {
                interactor.showReceivedDetail(product)
            }
        }

        fun bind(product: Product) {
            this.product = product
            binding.product = product
        }
    }
}