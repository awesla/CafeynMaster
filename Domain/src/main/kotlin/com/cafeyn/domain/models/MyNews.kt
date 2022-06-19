package com.cafeyn.domain.models

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class MyNews(
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
) : Parcelable