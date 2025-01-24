package com.example.hw3_compose.model

import com.example.hw3_compose.data.dto.CharacterResponse

data class CharacterModel(
    val id: Int,
    val name: String,
    val status: String,
    val gender: String,
    val location: String,
    val image: String,
    val species: String
)

fun CharacterResponse.toCharacterModel(): CharacterModel {
    return CharacterModel(
        id = this.id,
        name = this.name,
        status = this.status,
        gender = this.gender,
        location = this.location?.name ?: "Unknown",
        image = this.image,
        species = this.species
    )
}
