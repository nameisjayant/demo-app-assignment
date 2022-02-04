package com.db8.demoapp.data.network

import com.db8.demoapp.data.model.Home
import retrofit2.http.GET

interface ApiService {

    companion object {
        const val BASE_URL = "https://take-home-test.herokuapp.com/bff/workDetails/"
    }

    @GET("326210.json")
    suspend fun getHome(): Home
}