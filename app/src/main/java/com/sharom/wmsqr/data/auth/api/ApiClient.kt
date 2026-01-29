package com.sharom.wmsqr.data.auth.api

import android.util.Log
import com.sharom.wmsqr.data.auth.SessionManager
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "http://10.0.2.2:8080/"

    private val authInterceptor = Interceptor { chain ->
        val original = chain.request()
        val builder = original.newBuilder()


        val token = SessionManager.accessToken
        Log.d("AuthInterceptor", "Token = $token")

        SessionManager.accessToken?.let { token ->
            builder.addHeader("Authorization", "Bearer $token")
        }

        chain.proceed(builder.build())
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()


    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val authApi: AuthApi = retrofit.create(AuthApi::class.java)

    val boxApi: BoxApi = retrofit.create(BoxApi::class.java)

    val userApi: UserApi = retrofit.create(UserApi::class.java)
}