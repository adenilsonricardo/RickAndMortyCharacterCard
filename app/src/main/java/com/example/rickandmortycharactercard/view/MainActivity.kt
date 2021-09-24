package com.example.rickandmortycharactercard.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortycharactercard.R
import com.example.rickandmortycharactercard.databinding.ActivityMainBinding
import com.example.rickandmortycharactercard.model.Characters
import com.example.rickandmortycharactercard.model.CharactersResponse
import com.example.rickandmortycharactercard.viewmodel.CharacterViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CharacterViewModel

    private val list = mutableListOf<Characters>()
    private val adapter = CharacterAdapter(list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)

        binding.rvMain.adapter = adapter
        binding.rvMain.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        viewModel.getCharacters()

        viewModel.characterResult.observe(this, Observer {
            adapter.updateList(it.results as MutableList<Characters>)
        })
    }
}