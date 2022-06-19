package com.cafeyn.data.remote.mappers

import com.cafeyn.data.remote.entities.MyNewsResponse
import com.cafeyn.domain.models.MyNews

/**
 * Manage Mapping from [MyNewsResponse] to [MyNews]
 */
fun MyNewsResponse.toDomain(): MyNews {
    return MyNews(
        id = id ?: 0,
        title = title ?: "",
        url = url ?: "",
        thumbnailUrl = thumbnailUrl ?: ""
    )
}

/**
 * Manage Mapping from global object API [List<MyNewsResponse>] to [List<MyNews>]
 */
@JvmName("toDomainMyNewsResponse")
fun List<MyNewsResponse>.toDomain(): List<MyNews> {
    return map { it.toDomain() }
}