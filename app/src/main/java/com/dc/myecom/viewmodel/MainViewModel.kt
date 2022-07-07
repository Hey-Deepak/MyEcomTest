package com.dc.myecom.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.dc.myecom.data.ApiService
import com.dc.myecom.model.homebanner.HomeBanner
import kotlinx.coroutines.runBlocking

class MainViewModel: ViewModel() {

    var homeBannerResponse: HomeBanner by mutableStateOf(HomeBanner())

    fun getAllHomeBanner() {
        runBlocking{

            try {
                homeBannerResponse = ApiService.getInstance().getAllHomeBanner()
                Log.d("TAG", "getAllHomeBanner: $homeBannerResponse")

            } catch (e: Exception) {
                Log.d("TAG",e.toString())
            }
        }

    }

}