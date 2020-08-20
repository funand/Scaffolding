package com.example.scaffoldiing.service

import com.example.scaffoldiing.model.Teams
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("searchteams.php")
    fun getTeams(@Query("t") teamName: String): Single<Teams>

    companion object {
        val BASE_URL = "https://www.thesportsdb.com/api/v1/json/1/"
    }
}

