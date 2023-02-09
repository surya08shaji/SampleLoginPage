package com.example.exampleapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleapp.databinding.RvProductListBinding
import com.example.exampleapp.model.Value
import com.squareup.picasso.Picasso

class ProductAdapter(private val productList: List<Value>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    class ProductViewHolder(val binding: RvProductListBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding =
            RvProductListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        with(holder) {
            with(productList[position]) {

//                binding.offerValue.text = this.offer.toString()+"%OFF"
                Picasso.with(binding.productImage.context).load(this.image)
                    .into(binding.productImage)
                binding.actualPrice.text = this.actual_price
                binding.offerPrice.text = this.offer_price
                binding.productName.text = this.name
                if (this.offer > 0) {
                    binding.offerValue.text = this.offer.toString() + "%OFF"
                } else {
                    binding.offerLayout.visibility = View.GONE
                }

                if (this.is_express) {
                    binding.isExpress.visibility = View.VISIBLE
                } else {
                    binding.isExpress.visibility = View.GONE
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}