package com.example.pmufirstapplication

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.ui.AppBarConfiguration
import com.example.pmufirstapplication.databinding.ActivityBottomBarBinding
import layout.FragmentSearch

class BottomBarActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityBottomBarBinding
    private var fragmentName : String = "Home Menu"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.title = fragmentName
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        loadFragment(FragmentMore())

        binding.bottomNav.setOnItemSelectedListener { it ->

            when (it.itemId)
            {
                R.id.menu_home -> {
                    Toast.makeText(
                        applicationContext,
                        "Menu Home ",
                        Toast.LENGTH_SHORT
                    ).show()
                    loadFragment(FragmentMore())
                    fragmentName = "Home Menu"
                    binding.toolbar.title = fragmentName
                    return@setOnItemSelectedListener true
                }

                R.id.menu_notification-> {
                    Toast.makeText(
                        applicationContext,
                        "Notifications ",
                        Toast.LENGTH_SHORT
                    ).show()
                    loadFragment(FragmentNotification())
                    fragmentName = "Notifications "
                    binding.toolbar.title = fragmentName
                    return@setOnItemSelectedListener true
                }

                R.id.menu_search -> {
                    Toast.makeText(
                        applicationContext,
                        "Search ",
                        Toast.LENGTH_SHORT
                    ).show()
                    loadFragment(FragmentSearch())
                    fragmentName = "Search "
                    binding.toolbar.title = fragmentName
                    return@setOnItemSelectedListener true
                }

                R.id.menu_profile -> {
                    Toast.makeText(
                        applicationContext,
                        "Profile ",
                        Toast.LENGTH_SHORT
                    ).show()
                    loadFragment(FragmentProfile())
                    fragmentName = "Profile "
                    binding.toolbar.title = fragmentName
                    return@setOnItemSelectedListener true
                }
                else -> {

                }
            }

            false

        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                // todo: goto back activity from here
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.container.id, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}

