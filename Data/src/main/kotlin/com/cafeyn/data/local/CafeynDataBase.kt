package com.cafeyn.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cafeyn.data.local.dao.MyNewsDao
import com.cafeyn.data.local.entities.MyNewsEntity

@Database(
    entities = [MyNewsEntity::class], version = 1
)
abstract class CafeynDataBase : RoomDatabase() {
    abstract fun mynewsDao(): MyNewsDao
}