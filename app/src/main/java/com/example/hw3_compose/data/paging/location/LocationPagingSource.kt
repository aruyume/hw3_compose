package com.example.hw3_compose.data.paging.location

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.hw3_compose.data.api.LocationApiService
import com.example.hw3_compose.model.LocationModel
import com.example.hw3_compose.model.toLocationModel

class LocationPagingSource(
    private val apiService: LocationApiService
) : PagingSource<Int, LocationModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, LocationModel> {
        return try {
            val currentPage = params.key ?: 1
            val response = apiService.getAllLocations(currentPage)
            LoadResult.Page(
                data = response.locationsResponse.map { it.toLocationModel() },
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (response.pagingInfo.nextPage.isEmpty()) null else currentPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, LocationModel>): Int? {
        return state.anchorPosition?.let { anchor ->
            state.closestPageToPosition(anchor)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchor)?.nextKey?.minus(1)
        }
    }
}