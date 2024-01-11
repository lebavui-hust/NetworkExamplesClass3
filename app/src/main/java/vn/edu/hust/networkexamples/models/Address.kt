package vn.edu.hust.networkexamples.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Address (
    val street: String,
    val city: String,
    val geo: Geo
)
