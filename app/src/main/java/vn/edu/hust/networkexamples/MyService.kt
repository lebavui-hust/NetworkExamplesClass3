package vn.edu.hust.networkexamples

import retrofit2.http.GET
import retrofit2.http.Path
import vn.edu.hust.networkexamples.models.Post
import vn.edu.hust.networkexamples.models.User

interface MyService {
//    @GET("posts")
//    suspend fun listAllPosts(): List<Post>
//
//    @GET("posts/{postId}")
//    suspend fun findPost(@Path("postId") postId: Int): Post

    @GET("users.json")
    suspend fun getAllUsers(): List<User>
}