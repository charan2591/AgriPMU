package com.example.pmufirstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.ui.AppBarConfiguration
import com.example.pmufirstapplication.databinding.ActivityBottomBarBinding
import com.example.pmufirstapplication.databinding.ActivityHomeBinding

class BottomBarActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityBottomBarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNav.setOnNavigationItemReselectedListener {
            when(it.itemId)
            {
                R.id.menu_home ->
                {

                }

                R.id.menu_notification ->
                {

                }

                R.id.menu_search->
                {

                }

                R.id.menu_profile ->
                {

                }
            }
        }

    }
}

