package com.example.recycle

import java.io.Serializable

class Crime(var title: String, var isSolved: Boolean, var bigtitle: String, var date: String?) :
    Serializable {
    var id: Long? = null

}