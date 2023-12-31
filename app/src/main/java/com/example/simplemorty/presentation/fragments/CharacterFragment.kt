package com.example.simplemorty.presentation.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.simplemorty.R
import com.example.simplemorty.databinding.FragmentCharacterBinding
import com.example.simplemorty.presentation.viewModels.CharacterFragmentViewModel


class CharacterFragment : Fragment() {

    private var _binding: FragmentCharacterBinding? = null
    private val binding get() = _binding!!

    private val viewModel by lazy {
        ViewModelProvider(this)[CharacterFragmentViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val characterId = arguments?.getInt("characterId") ?: -1
        viewModel.refreshCharacter(characterId)
        viewModel.characterByIdLD.observe(viewLifecycleOwner) { response ->
            if (response == null) {
                Log.d("MainActivity", "response not Successful")
                return@observe
            }
            with(binding) {
                charactersName.text = response.name
                characterStatus.text = response.status
                originStatus.text = response.origin.name
                speciesStatus.text = response.species
                Glide.with(view).load(response.image).into(characterImg)
                if (response.gender == "Male") {
                    genderIcon.setImageResource(R.drawable.ic_male)
                } else {
                    genderIcon.setImageResource(R.drawable.ic_female)
                }
                fab.setOnClickListener {
                    viewModel.addCharacter(response)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

    }
}