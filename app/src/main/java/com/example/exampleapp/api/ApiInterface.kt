package com.example.exampleapp.api

import com.example.exampleapp.api.Urls.baseUrl
import com.example.exampleapp.model.DataModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    @GET("v3/69ad3ec2-f663-453c-868b-513402e515f0")
    fun getList(): Call<DataModel>

    companion object Factory {

        fun create(): ApiInterface {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

            val retrofit = Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).baseUrl(baseUrl)
                .client(client)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}