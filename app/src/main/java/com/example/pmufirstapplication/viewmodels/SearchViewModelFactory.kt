package com.example.pmufirstapplication.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SearchViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(SearchViewModel::class.java))
        {
            return SearchViewModel() as T
        }

        throw IllegalArgumentException("UnknownViewModel")

    }
}