package com.example.tinkoff.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Country (
    val name : String? = null
) : Parcelable