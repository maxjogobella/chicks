package com.example.tinkoff.data.database.converter

import androidx.room.TypeConverter
import com.example.tinkoff.data.database.model.CountryStorage
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CountriesListConverter {
    @TypeConverter
    fun fromString(value : String?) : List<CountryStorage>? {
        val listType = object : TypeToken<List<CountryStorage>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun listToString(list : List<CountryStorage>?) : String {
        return Gson().toJson(list)
    }
}