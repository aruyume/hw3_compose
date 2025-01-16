package com.example.hw3_compose.model

object MockData {
    val characters = listOf(
        CharacterModel("Rick Sanchez", "Alive", "https://static.wikia.nocookie.net/rickandmorty/images/a/a6/Rick_Sanchez.png/revision/latest?cb=20160923150728", "Male", "Earth"),
        CharacterModel("Morty Smith", "Alive", "https://static.wikia.nocookie.net/rickandmorty/images/a/a6/Rick_Sanchez.png/revision/latest?cb=20160923150728", "Male", "Earth"),
        CharacterModel("Birdperson", "Dead", "https://static.wikia.nocookie.net/rickandmorty/images/a/a6/Rick_Sanchez.png/revision/latest?cb=20160923150728", "Male", "Bird World"),
        CharacterModel("Squanchy", "Unknown", "https://static.wikia.nocookie.net/rickandmorty/images/a/a6/Rick_Sanchez.png/revision/latest?cb=20160923150728", "Male", "Squanch Planet"),
        CharacterModel("Summer Smith", "Alive", "https://static.wikia.nocookie.net/rickandmorty/images/a/a6/Rick_Sanchez.png/revision/latest?cb=20160923150728", "Female", "Earth"),
        CharacterModel("Jerry Smith", "Alive", "https://static.wikia.nocookie.net/rickandmorty/images/a/a6/Rick_Sanchez.png/revision/latest?cb=20160923150728", "Male", "Earth"),
        CharacterModel("Beth Smith", "Alive", "https://static.wikia.nocookie.net/rickandmorty/images/a/a6/Rick_Sanchez.png/revision/latest?cb=20160923150728", "Female", "Earth"),
        CharacterModel("Mr. Meeseeks", "Unknown", "https://static.wikia.nocookie.net/rickandmorty/images/a/a6/Rick_Sanchez.png/revision/latest?cb=20160923150728", "Male", "Meeseeks Box"),
        CharacterModel("Evil Morty", "Alive", "https://static.wikia.nocookie.net/rickandmorty/images/a/a6/Rick_Sanchez.png/revision/latest?cb=20160923150728", "Male", "Citadel of Ricks"),
        CharacterModel("Noob-Noob", "Alive", "https://static.wikia.nocookie.net/rickandmorty/images/a/a6/Rick_Sanchez.png/revision/latest?cb=20160923150728", "Male", "Earth"),
        CharacterModel("Tammy Gueterman", "Dead", "https://static.wikia.nocookie.net/rickandmorty/images/a/a6/Rick_Sanchez.png/revision/latest?cb=20160923150728", "Female", "Earth"),
        CharacterModel("Abradolf Lincler", "Dead", "https://static.wikia.nocookie.net/rickandmorty/images/a/a6/Rick_Sanchez.png/revision/latest?cb=20160923150728", "Male", "Earth")
    )

    val locations = listOf(
        LocationModel(" ")
    )

    val episodes = listOf(
        EpisodeModel(" ")
    )
}

data class CharacterModel(val name: String, val status: String, val image: String, val gender: String, val location: String)
data class LocationModel(val location: String)
data class EpisodeModel(val episode: String)