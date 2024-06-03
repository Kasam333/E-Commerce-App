package com.example.craft.adapters

import android.annotation.SuppressLint
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.craft.data.Product
import com.example.craft.databinding.ProductRvItemBinding
import com.example.craft.helper.getProductPrice

class BestProductsAdapter: RecyclerView.Adapter<BestProductsAdapter.BestProductsViewHolder>() {


    inner class BestProductsViewHolder(private val binding: ProductRvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(product: Product) {
            binding.apply {

                    val priceAfterOffer = product.offerPercentage?.minus((product.price))
                    tvSavePrice.text = "Save ₹ ${String.format("%.1f",priceAfterOffer)}"
                    tvOrignalPrice.text = "₹ ${product.offerPercentage}"
                    tvOrignalPrice.paintFlags = tvOrignalPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG


                if (product.offerPercentage == null)
                    tvOrignalPrice.visibility = View.INVISIBLE
                if (product.offerPercentage == null)
                    tvSavePrice.visibility = View.INVISIBLE


                Glide.with(itemView).load(product.images[0]).into(imgProduct)
                tvPrice.text = "₹ ${product.price}"
                tvName.text = product.name
            }

        }
    }

    private val diffCallback = object : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id

        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestProductsViewHolder {
        return BestProductsViewHolder(
            ProductRvItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: BestProductsViewHolder, position: Int) {
        val product = differ.currentList[position]
        holder.bind(product)

        holder.itemView.setOnClickListener {
            onClick?.invoke(product)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    var onClick: ((Product) -> Unit)? = null

}