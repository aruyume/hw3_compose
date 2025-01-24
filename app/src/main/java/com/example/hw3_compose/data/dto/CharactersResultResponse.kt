package com.example.hw3_compose.data.dto

import com.google.gson.annotations.SerializedName

data class CharactersResultResponse(
    @SerializedName("results")
    val charactersResponse: List<CharacterResponse>
)

data class CharacterResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("location")
    val location: Location? = null
)

data class Location(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)