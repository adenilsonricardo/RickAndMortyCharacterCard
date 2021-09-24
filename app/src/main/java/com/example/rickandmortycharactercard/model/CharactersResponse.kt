package com.example.rickandmortycharactercard.model

data class CharactersResponse(
    val info: Info,
    val results: List<Characters>
)