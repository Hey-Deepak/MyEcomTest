package com.dc.myecom.model.topcategory

data class SubX(
    val fk_parent: String,
    val int_glcode: String,
    val sub: List<Any>,
    val var_icon: String,
    val var_title: String
)