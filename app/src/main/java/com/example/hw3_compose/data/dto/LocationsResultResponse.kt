package com.example.hw3_compose.data.dto

import com.example.hw3_compose.data.paging.PagingInfo
import com.google.gson.annotations.SerializedName

data class LocationsResultResponse(
    @SerializedName("info")
    val pagingInfo: PagingInfo,
    @SerializedName("results")
    val locationsResponse: List<LocationResponse>
)

data class LocationResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("dimension")
    val dimension: String
)