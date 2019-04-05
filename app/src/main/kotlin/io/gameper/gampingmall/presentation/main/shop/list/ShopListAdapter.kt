package io.gameper.gampingmall.presentation.main.shop.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import io.gameper.gampingmall.R
import io.gameper.gampingmall.databinding.ItemShopListBinding
import io.gameper.gampingmall.entity.Product
import kotlinx.android.synthetic.main.item_shop_list.view.*

class ShopListAdapter(
    val interactor: ShopListInteractor
) : RecyclerView.Adapter<ShopListAdapter.ViewHolder>() {

    var productList: List<Product> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemShopListBinding = DataBindingUtil.inflate(inflater, R.layout.item_shop_list, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int  = productList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    inner class ViewHolder(val binding: ItemShopListBinding) : RecyclerView.ViewHolder(binding.root) {

        var product: Product? = null

        init {
            itemView.stageItemShopList.setOnClickListener {
                interactor.changeToDetail(product!!)
            }
        }

        fun bind(product: Product) {
            this.product = product
            binding.product = product
        }
    }
}