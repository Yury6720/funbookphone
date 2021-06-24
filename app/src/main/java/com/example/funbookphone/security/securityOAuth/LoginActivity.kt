package com.example.funbookphone.security.securityOAuth

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.funbookphone.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity(){
    private lateinit var sessionManager: SessionManager
    private lateinit var apiClient: ApiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        apiClient = ApiClient()
        sessionManager = SessionManager(this)

        apiClient.getApiService().login(LoginRequest(email = "s@sample.com", password = "mypassword"))
            .enqueue(object : Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    // Error logging in
                }

                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    val loginResponse = response.body()

                    if (loginResponse?.statusCode == 200 && loginResponse.user != null) {
                        sessionManager.saveAuthToken(loginResponse.authToken)
                    } else {
                        // Error logging in
                    }
                }
            })

    }
}