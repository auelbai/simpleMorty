package com.example.simplemorty.presentation

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.simplemorty.data.network.model.GetCharacterByIdResponse
import com.example.simplemorty.repository.SharedRepository
import okio.IOException
import retrofit2.HttpException

class CharactersPagingSource(
    private val repository: SharedRepository
): PagingSource<Int, GetCharacterByIdResponse>() {
    override fun getRefreshKey(state: PagingState<Int, GetCharacterByIdResponse>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GetCharacterByIdResponse> {
        return try {
            val pageNumber = params.key ?: 0
            val page = repository.getCharacterPage(pageNumber)
            val characterList = page?.results ?: emptyList()
            val prevKey = if (pageNumber > 0) pageNumber - 1 else null
            val nextKey = getPageIndexFromNext(page?.info?.next)
            LoadResult.Page(
                data = characterList,
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    private fun getPageIndexFromNext(next: String?): Int? {
        return next?.split("?page=")?.get(1)?.toInt()
    }
}