package com.example.funbookphone.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    var id: String,

    @SerializedName("login")
    var login: String,

    @SerializedName("email")
    var email: String
)
