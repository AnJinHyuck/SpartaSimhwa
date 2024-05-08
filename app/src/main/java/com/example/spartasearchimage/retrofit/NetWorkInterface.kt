package com.example.spartasearchimage.retrofit

import com.example.spartasearchimage.Constants
import com.example.spartasearchimage.data.DocumentResponse
import com.example.spartasearchimage.data.ImageResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface NetWorkInterface {
    @Headers("Authorization: KakaoAK ${Constants.AUTH_HEADER}")
    @GET("v2/search/image")

    suspend fun getImage(
        @QueryMap param: HashMap<String,Any>
//        @Query("query") query: String,
//        @Query("sort") sort: String,
//        @Query("page") page: Int,
//        @Query("size") size: Int
    ): ImageResponse
    //카카오 이미지 검색 API 호출하는 인터페이스 정의
}

//제이슨이 뭔지