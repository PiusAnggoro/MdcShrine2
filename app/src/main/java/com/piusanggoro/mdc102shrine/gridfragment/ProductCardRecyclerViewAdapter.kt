package com.piusanggoro.mdc102shrine.gridfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.piusanggoro.mdc102shrine.R
import com.piusanggoro.mdc102shrine.network.ProductEntry

class ProductCardRecyclerViewAdapter(
    private val context: ProductGridFragment,
    private val productList: List<ProductEntry>
) :
    RecyclerView.Adapter<ProductCardRecyclerViewAdapter.ProductCardViewHolder>() {

    class ProductCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var productImage: ImageView = itemView.findViewById(R.id.product_image)
        var productTitle: TextView = itemView.findViewById(R.id.product_title)
        var productPrice: TextView = itemView.findViewById(R.id.product_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCardViewHolder {
        val layoutView =
            LayoutInflater.from(parent.context).inflate(R.layout.shr_product_card, parent, false)
        return ProductCardViewHolder(layoutView)
    }

    override fun onBindViewHolder(
        holder: ProductCardViewHolder,
        position: Int
    ) {
        if (position < productList.size) {
            val product = productList[position]
            holder.productTitle.text = product.title
            holder.productPrice.text = product.price
            Glide.with(context).load(product.url).override(300,300).into(holder.productImage)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}