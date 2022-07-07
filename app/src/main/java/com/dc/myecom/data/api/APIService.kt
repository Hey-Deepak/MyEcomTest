package com.dc.myecom.data.api

import com.dc.myecom.model.homebanner.HomeBanner
import com.dc.myecom.model.topcategory.TopCategory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface APIService {

    @GET("ESC/single_vendor/api/category/getCategory/")
    suspend fun getTopCategory(): TopCategory


    companion object {
        var apiservice: APIService? = null
        fun getInstance(): APIService {
            if (apiservice == null) {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BASIC
                apiservice = Retrofit.Builder()
                    .baseUrl("https://ecommercesourcecode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(OkHttpClient.Builder().addInterceptor(logging).build())
                    .build().create(APIService::class.java)
            }
            return apiservice!!
        }
    }

}