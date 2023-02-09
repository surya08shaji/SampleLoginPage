package com.example.exampleapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleapp.adapter.BannerAdapter
import com.example.exampleapp.adapter.CategoryAdapter
import com.example.exampleapp.adapter.ProductAdapter
import com.example.exampleapp.api.ApiInterface
import com.example.exampleapp.databinding.ActivityHomeBinding
import com.example.exampleapp.model.DataModel
import retrofit2.Call
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var bannerAdapter: BannerAdapter
    private lateinit var productAdapter: ProductAdapter

    private val apiCall = ApiInterface.create()

    private var _binding: ActivityHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_home)

        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val layoutManagerCategory: RecyclerView.LayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL, false
        )
        binding.recyclerViewCategory.layoutManager = layoutManagerCategory

        val layoutManagerBanner: RecyclerView.LayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL, false
        )
        binding.recyclerViewBanners.layoutManager = layoutManagerBanner

        val layoutManagerProduct: RecyclerView.LayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL, false
        )
        binding.recyclerViewProducts.layoutManager = layoutManagerProduct


        apiCall.getList()
            .enqueue(object : retrofit2.Callback<DataModel> {
                override fun onFailure(call: Call<DataModel>?, t: Throwable?) {
                    t?.printStackTrace()
                    Log.e("scroll", "exception", t)
                }

                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(
                    call: Call<DataModel>,
                    response: Response<DataModel>
                ) {
                    if (response.isSuccessful) {
                        val dataList = response.body()
                        if (dataList != null) {
                            val categoryValue = dataList.homeData[0].values
                            categoryAdapter = CategoryAdapter(categoryValue)
                            binding.recyclerViewCategory.adapter = categoryAdapter

                            val bannerValue = dataList.homeData[1].values
                            bannerAdapter = BannerAdapter(bannerValue)
                            binding.recyclerViewBanners.adapter = bannerAdapter

                            val productValue = dataList.homeData[2].values
                            productAdapter = ProductAdapter(productValue)
                            binding.recyclerViewProducts.adapter = productAdapter

                        }
                    }
                }

            })
        fun onDestroy() {
            super.onDestroy()
            _binding = null

        }
    }
}