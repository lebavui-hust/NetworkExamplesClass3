package vn.edu.hust.networkexamples.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Post (
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String
)
