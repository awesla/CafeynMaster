package com.cafeyn.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cafeyn.data.local.entities.MyNewsEntity

@Dao
interface MyNewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllNews(sitesList: List<MyNewsEntity>)

    @Query(value = "SELECT * FROM my_news")
    suspend fun getAllNews(): List<MyNewsEntity>
}