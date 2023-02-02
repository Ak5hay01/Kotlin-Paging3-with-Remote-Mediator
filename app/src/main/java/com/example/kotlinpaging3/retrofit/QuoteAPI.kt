package com.example.kotlinpaging3.retrofit

import com.example.kotlinpaging3.models.QuoteList
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteAPI {

    @GET("/quotes")
    suspend fun getQuotes(@Query("page")page:Int):QuoteList
}