package com.example.hw3_compose.data.paging

import com.google.gson.annotations.SerializedName

data class PagingInfo(
    @SerializedName("count")
    val count: Int,
    @SerializedName("page")
    val page: Int,
    @SerializedName("next")
    val nextPage: String = String(),
    @SerializedName("prev")
    val prevPage: String = String()
)
