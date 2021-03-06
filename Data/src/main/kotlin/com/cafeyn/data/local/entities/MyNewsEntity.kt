package com.cafeyn.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_news")
class MyNewsEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "albumId") val albumId: Int?,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "url") val url: String?,
    @ColumnInfo(name = "thumbnailUrl") val thumbnailUrl: String?
)