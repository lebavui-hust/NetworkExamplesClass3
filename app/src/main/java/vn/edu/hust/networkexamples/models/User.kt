package vn.edu.hust.networkexamples.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User (
    val name: String,
    val email: String,
    val address: Address,
    val avatar: Avatar
)
