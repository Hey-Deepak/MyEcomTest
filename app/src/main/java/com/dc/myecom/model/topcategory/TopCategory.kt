package com.dc.myecom.model.topcategory

data class TopCategory(
    val data: List<Data> = emptyList(),
    val message: String = "",
    val status: Int = 0
)