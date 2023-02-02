package com.example.kotlinpaging3.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kotlinpaging3.retrofit.QuoteAPI
import retrofit2.Retrofit
import com.example.kotlinpaging3.models.Result

class QuoteSource(val quoteAPI: QuoteAPI):PagingSource<Int, Result>() {
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? { // for identifying which page to load
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {
            val position = params.key ?: 1
            val response = quoteAPI.getQuotes(position)

            return LoadResult.Page(
                data = response.results,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (position == response.totalPages) null else position + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}