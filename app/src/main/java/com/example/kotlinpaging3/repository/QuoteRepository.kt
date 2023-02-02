package com.example.kotlinpaging3.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.kotlinpaging3.QuoteDatabase
import com.example.kotlinpaging3.paging.QuoteRemoteMediator
import com.example.kotlinpaging3.paging.QuoteSource
import com.example.kotlinpaging3.retrofit.QuoteAPI
import javax.inject.Inject

@ExperimentalPagingApi
class QuoteRepository @Inject constructor(
    private val quoteAPI: QuoteAPI,
    private val quoteDatabase: QuoteDatabase
) {

    fun getQuotes() = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        remoteMediator = QuoteRemoteMediator(quoteAPI,quoteDatabase),
        pagingSourceFactory = {quoteDatabase.quoteDao().getQuotes()}
    ).liveData
}