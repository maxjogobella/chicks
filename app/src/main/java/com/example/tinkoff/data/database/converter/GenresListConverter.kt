package com.example.tinkoff.data.database.converter

import androidx.room.TypeConverter
import com.example.tinkoff.data.database.model.GenreStorage
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GenresListConverter {

    @TypeConverter
    fun fromString(value : String?) : List<GenreStorage>? {
        val listType = object : TypeToken<List<GenreStorage>>() {}.type
            return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun listToString(list : List<GenreStorage>?) : String {
        return Gson().toJson(list)
    }

}