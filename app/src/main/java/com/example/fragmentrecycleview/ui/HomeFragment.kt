package com.example.fragmentrecycleview.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragmentrecycleview.adapter.ContactAdapter
import com.example.fragmentrecycleview.databinding.FragmentHomeBinding
import com.example.fragmentrecycleview.model.Contact

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listContact = arrayListOf(
            Contact("Fauzan", 12313123),
            Contact("zan", 12313123),
            Contact("ssazx", 12313123),
            Contact("daw", 12313123),
            Contact("Mochamad", 12313123),
            Contact("ww", 12313123),
            Contact("ojan", 12313123),
            Contact("ozan", 12313123),
            Contact("Osama", 12313123),
        )

        val adapter = ContactAdapter(listContact)
        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        binding.recyclerViewContainer.layoutManager = layoutManager

        binding.recyclerViewContainer.adapter = adapter
    }

}