package com.dc.myecom.model.homebanner

data class HomeBanner(
    val data: List<Data> = emptyList(),
    val message: String = "",
    val status: Int = 0
)