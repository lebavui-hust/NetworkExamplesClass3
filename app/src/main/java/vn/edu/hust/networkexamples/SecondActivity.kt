package vn.edu.hust.networkexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import vn.edu.hust.networkexamples.models.User

class SecondActivity : AppCompatActivity() {

    val users = arrayListOf<User>()
    val adapter = ItemAdapter(users, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("https://lebavui.github.io/jsons/")
            .build()

        val myService = retrofit.create(MyService::class.java)

        lifecycleScope.launch(Dispatchers.IO) {
            try {
                users.addAll(myService.getAllUsers())
                withContext(Dispatchers.Main) {
                    adapter.notifyDataSetChanged()
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
    }
}