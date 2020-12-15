package com.example.randstadsearchanimapplication.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

sealed class AnimeObject

@Parcelize
data class AnimeResponse(
    val results: List<AnimeItem>
) : Parcelable, AnimeObject()

@Parcelize
data class AnimeItem(
    val url: String?,
    val image_url: String?,
    val title: String?,
    val synopsis: String?
) : Parcelable, AnimeObject()