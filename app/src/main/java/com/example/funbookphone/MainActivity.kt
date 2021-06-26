package com.example.funbookphone

import android.R
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.View
import androidx.navigation.Navigation
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

       val ft: FragmentTransaction
       ft.remove(R.layout.)
        val binding: ViewDataBinding? = DataBindingUtil.inflate(
            layoutInflater ,R.layout.fragment_recommendations,conteiner, false)
//        setContentView(R.layout.activity_main)
        //binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.button3.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(R.id.action_recommendations_to_myBooks)
        }
        //binding.btnBooks.setOnClickListener()
    }


    /**
     * Function to fetch posts
     */
    private fun fetchPosts() {
        apiClient.getApiService().fetchPosts()
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