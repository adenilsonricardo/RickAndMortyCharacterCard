package com.example.rickandmortycharactercard.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortycharactercard.model.CharactersResponse
import com.example.rickandmortycharactercard.model.api.RetrofitService
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit


class CharacterViewModel: ViewModel() {

    val disposable = CompositeDisposable()
    val characterResult: MutableLiveData<CharactersResponse> = MutableLiveData()
    private val error: MutableLiveData<String> = MutableLiveData()

    fun getCharacters() {
        disposable.add(
            RetrofitService.service.getCharacters()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    characterResult.value = it
                }, { e ->
                    error.value = e.message
            })
        )
    }
}