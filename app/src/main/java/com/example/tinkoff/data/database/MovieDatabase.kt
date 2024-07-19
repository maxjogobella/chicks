package com.example.tinkoff.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.tinkoff.data.database.converter.CountriesListConverter
import com.example.tinkoff.data.database.converter.GenresListConverter
import com.example.tinkoff.data.database.dao.MovieDao
import com.example.tinkoff.data.database.model.MovieDetailStorage
import com.example.tinkoff.data.database.model.MovieStorage

@Database(
    entities = [MovieStorage::class, MovieDetailStorage::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(GenresListConverter::class, CountriesListConverter::class)

abstract class MovieDatabase : RoomDatabase() {

    companion object {
        private const val DATABASE_NAME = "movies.db"
        private var INSTANCE: MovieDatabase? = null
        fun getInstance(context: Context): MovieDatabase {
            INSTANCE?.let { return it }
            synchronized(this) {
                INSTANCE?.let {
                    return it
                }
            }
            val instance = Room.databaseBuilder(
                context = context,
                klass = MovieDatabase::class.java,
                name = DATABASE_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
            INSTANCE = instance
            return instance
        }
    }

    abstract fun movieDao(): MovieDao

}