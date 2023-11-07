package com.example.simplemorty.presentation.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.simplemorty.R
import com.example.simplemorty.network.RickAndMortyService
import com.example.simplemorty.model.GetCharacterByIdResponse
import com.example.simplemorty.presentation.SharedViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class CharacterFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProvider(this)[SharedViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_character, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val characterImage = view.findViewById<ImageView>(R.id.character_img)
        val name = view.findViewById<TextView>(R.id.characters_name)
        val status = view.findViewById<TextView>(R.id.character_status)
        val genderImage = view.findViewById<ImageView>(R.id.gender_icon)
        val originName = view.findViewById<TextView>(R.id.origin_status)
        val speciesStatus = view.findViewById<TextView>(R.id.species_status)

        viewModel.refreshCharacter(23)
        viewModel.characterByIdLD.observe(viewLifecycleOwner) { response ->
            if (response == null) {
                Log.d("MainActivity", "response not Successful")
                return@observe
            }
            name.text = response.name
            status.text = response.status
            originName.text = response.origin.name
            speciesStatus.text = response.species
            Glide.with(view).load(response.image).into(characterImage)
            if (response.gender == "Male") {
                genderImage.setImageResource(R.drawable.ic_male)
            } else {
                genderImage.setImageResource(R.drawable.ic_female)
            }
        }
    }

    companion object {

    }
}