package com.example.funbookphone

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.funbookphone.databinding.ActivityMainBinding
import com.example.funbookphone.security.securityOAuth.ApiClient
import com.example.funbookphone.security.securityOAuth.PostsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var apiClient: ApiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //binding.btnBooks.setOnClickListener()
    }


    /**
     * Function to fetch posts
     */
    private fun fetchPosts() {
        apiClient.getApiService(this).fetchPosts()
            .enqueue(object : Callback<PostsResponse> {
                override fun onFailure(call: Call<PostsResponse>, t: Throwable) {
                    // Error fetching posts
                }

                override fun onResponse(call: Call<PostsResponse>, response: Response<PostsResponse>) {
                    // Handle function to display posts
                }
            })
    }
    //Something new
}