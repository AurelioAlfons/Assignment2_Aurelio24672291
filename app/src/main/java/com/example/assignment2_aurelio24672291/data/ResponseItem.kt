// Author: Aurelio
// Package: Data
package com.example.assignment2_aurelio24672291.data

// Import packages
import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

// Declare Parcelize
// List keypass ("art") Entities
@Parcelize
data class ResponseItem(
    @Json(name = "artist") val artist: String,
    @Json(name = "artworkTitle") val artworkTitle: String,
    @Json(name = "description") val description: String,
    @Json(name = "medium") val medium: String,
    @Json(name = "year") val year: Int
): Parcelable
