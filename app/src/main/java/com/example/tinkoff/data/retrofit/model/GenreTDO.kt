package com.example.tinkoff.data.retrofit.model

import com.google.gson.annotations.SerializedName

data class GenreTDO(
    @SerializedName("genre") val name : String? = null
)