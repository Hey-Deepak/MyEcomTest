package com.dc.myecom.model.topcategory

data class Data(
    val fk_parent: String,
    val int_glcode: String,
    val sub: List<Sub>,
    val var_icon: String,
    val var_title: String
)