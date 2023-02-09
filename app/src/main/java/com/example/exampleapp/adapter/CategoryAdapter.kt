package com.example.exampleapp.adapter

import android.annotation.SuppressLint
import android.os.Build
import android.text.Html
import android.text.Spanned
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleapp.databinding.RvCategoryListBinding
import com.example.exampleapp.model.Value
import com.squareup.picasso.Picasso

class CategoryAdapter(private val categoryList: List<Value>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    class CategoryViewHolder(val binding: RvCategoryListBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding =
            RvCategoryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        with(holder) {
            with(categoryList[position]) {
                Picasso.with(binding.categoryImage.context).load(this.image_url)
                    .into(binding.categoryImage)
//                binding.categoryName.text = this.name


                val value = this.name
                val data = "<u> $value </u>"

                val categoryNameString: Spanned = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    Html.fromHtml(data, Html.FROM_HTML_MODE_LEGACY)
                } else {
                    @Suppress("DEPRECATION")
                    Html.fromHtml(data)
                }
                binding.categoryName.text = categoryNameString
            }
        }
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
}