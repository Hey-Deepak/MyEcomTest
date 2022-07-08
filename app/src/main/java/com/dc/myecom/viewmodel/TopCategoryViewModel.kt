package com.dc.myecom.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.dc.myecom.data.ApiService
import com.dc.myecom.data.api.APIService
import com.dc.myecom.model.homebanner.HomeBanner
import com.dc.myecom.model.topcategory.TopCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking


class TopCategoryViewModel: ViewModel() {
    var topCategoryResponse: TopCategory by mutableStateOf(TopCategory())

    fun getTopCategory() {
        runBlocking{

            try {
                topCategoryResponse = APIService.getInstance().getTopCategory()
                Log.d("TAG", "getAllHomeBanner: $topCategoryResponse")

            } catch (e: Exception) {
                Log.d("TAG",e.toString())
            }
        }

    }
}