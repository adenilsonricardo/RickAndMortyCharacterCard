package com.example.rickandmortycharactercard.model.api

import com.example.rickandmortycharactercard.model.CharactersResponse
import io.reactivex.Single
import retrofit2.http.GET

interface CharacterApi {
    @GET("character")
    fun getCharacters(): Single<CharactersResponse>
}