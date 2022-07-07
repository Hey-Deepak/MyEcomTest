package com.dc.myecom.model.topcategory

data class Sub(
    val fk_parent: String,
    val int_glcode: String,
    val sub: List<SubX>,
    val var_icon: String,
    val var_title: String
)