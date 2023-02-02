package com.example.kotlinpaging3.di

import com.example.kotlinpaging3.retrofit.QuoteAPI
import com.example.kotlinpaging3.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkSetup {

    @Singleton
    @Provides
   fun getRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getQuotes(retrofit: Retrofit):QuoteAPI{
        return retrofit.create(QuoteAPI::class.java)
    }
}