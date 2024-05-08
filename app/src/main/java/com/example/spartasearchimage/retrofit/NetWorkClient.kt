package com.example.spartasearchimage.retrofit

import com.example.spartasearchimage.Constants
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetWorkClient {
     private fun createOkHttpClient(): OkHttpClient {
         val interceptor = HttpLoggingInterceptor()
         interceptor.level = HttpLoggingInterceptor.Level.BODY


         return OkHttpClient.Builder()
             .connectTimeout(20, TimeUnit.SECONDS)
             .readTimeout(20, TimeUnit.SECONDS)
             .writeTimeout(20, TimeUnit.SECONDS)
             .addNetworkInterceptor(interceptor)
             .build()
     }

     private val kakaoRetrofit = Retrofit.Builder()
         .baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(
             createOkHttpClient()
         ).build()

    private fun getDateFormatGsonBuilder() = GsonBuilder()
        .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        .create()

    val kakaoSearch: NetWorkInterface = kakaoRetrofit.create(NetWorkInterface::class.java)

 }