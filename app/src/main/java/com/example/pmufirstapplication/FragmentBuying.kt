package com.example.pmufirstapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.resources.Compatibility.Api21Impl.inflate
import androidx.fragment.app.Fragment
import com.example.pmufirstapplication.databinding.ActivityHomeBinding.inflate
import com.example.pmufirstapplication.databinding.FragmentBuyingBinding

class FragmentBuying :Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentBuyingBinding.inflate(inflater, container, false)
        context ?: return binding.root

//        val adapter = PlantAdapter()
//        binding.plantList.adapter = adapter

        return binding.root
    }
}