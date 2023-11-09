package com.example.simplemorty.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.simplemorty.R
import com.example.simplemorty.databinding.FragmentAllCharactersBinding
import com.example.simplemorty.presentation.CharactersAdapter
import com.example.simplemorty.presentation.viewModels.AllCharactersViewModel
import kotlinx.coroutines.launch

class AllCharactersFragment : Fragment() {

    private var _binding: FragmentAllCharactersBinding? = null
    private val binding get() = _binding!!

    private val viewModel by lazy {
        ViewModelProvider(this)[AllCharactersViewModel::class.java]
    }

    private val charactersAdapter = CharactersAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.rvAllCharacters
        recyclerView.adapter = charactersAdapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        charactersAdapter.onItemClickListener = {
            val bundle = bundleOf("characterId" to it.id)
            findNavController().navigate(R.id.characterFragment, bundle)
        }

        viewModel.pagerLD.observe(viewLifecycleOwner) {
            viewLifecycleOwner.lifecycleScope.launch {
                charactersAdapter.submitData(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}