package com.cafeyn.data.local.mappers

import com.cafeyn.data.local.entities.MyNewsEntity
import com.cafeyn.domain.models.MyNews

/**
 * Manage Mapping from [MyNewsEntity] to [MyNews]
 */
fun MyNewsEntity.toDomain(): MyNews {
    return MyNews(
        id = id,
        title = title ?: "",
        url = url ?: "",
        thumbnailUrl = thumbnailUrl ?: ""
    )
}

/**
 * Manage Mapping from local [List<MyNewsEntity>] to [List<MyNews>]
 */
@JvmName("toDomainMyNewsEntity")
fun List<MyNewsEntity>.toDomain(): List<MyNews> {
    return map { it.toDomain() }
}

/**
 * Manage Mapping from [MyNews] to [MyNewsEntity]
 */
fun MyNews.fromDomain(): MyNewsEntity {
    return MyNewsEntity(
        id = id,
        albumId = 0,
        title = title ?: "",
        url = url ?: "",
        thumbnailUrl = thumbnailUrl ?: ""
    )
}

/**
 * Manage Mapping from local [List<MyNews>] to [List<MyNewsEntity>]
 */
@JvmName("fromDomainMyNews")
fun List<MyNews>.fromDomain(): List<MyNewsEntity> {
    return map { it.fromDomain() }
}