package com.example.urbandrive.data

import com.example.urbandrive.data.LoginRequest
import com.example.urbandrive.data.User

import retrofit2.Response
import retrofit2.Retrofit

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("api/users/register")
    suspend fun registerUser(@Body user: User): Response<User>

    @POST("api/users/login")
    suspend fun loginUser(@Body loginRequest: LoginRequest): Response<User>
}

object RetrofitClient {
    private const val BASE_URL = "http://10.0.2.2:3000/"

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
