package com.example.pmufirstapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pmufirstapplication.databinding.FragmentProfileBinding
import com.example.pmufirstapplication.databinding.FragmentSellingBinding

class FragmentProfile :Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentProfileBinding.inflate(inflater, container, false)
        context ?: return binding.root

//        val adapter = PlantAdapter()
//        binding.plantList.adapter = adapter

        return binding.root    }
}