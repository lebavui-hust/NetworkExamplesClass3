package vn.edu.hust.networkexamples.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Avatar (
    val thumbnail: String,
    val photo: String
)
