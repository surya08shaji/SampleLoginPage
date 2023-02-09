package com.example.exampleapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleapp.databinding.RvBannerListBinding
import com.example.exampleapp.model.Value
import com.squareup.picasso.Picasso

class BannerAdapter(private val bannerList: List<Value>) :
    RecyclerView.Adapter<BannerAdapter.BannerViewHolder>() {
    class BannerViewHolder(val binding: RvBannerListBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val binding =
            RvBannerListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BannerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        with(holder) {
            with(bannerList[position]) {
                Picasso.with(binding.bannerImage.context).load(this.banner_url)
                    .into(binding.bannerImage)
            }
        }
    }

    override fun getItemCount(): Int {
        return bannerList.size
    }
}