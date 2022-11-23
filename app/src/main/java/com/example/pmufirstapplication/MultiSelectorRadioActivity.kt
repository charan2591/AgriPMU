package com.example.pmufirstapplication

import android.R
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.navigation.ui.AppBarConfiguration
import com.example.pmufirstapplication.databinding.ActivityMultiSelectorRadioBinding


class MultiSelectorRadioActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMultiSelectorRadioBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMultiSelectorRadioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        // Checked change Listener for RadioGroup 1
        // Checked change Listener for RadioGroup 1
        loadFragment(FragmentForm())

        binding.radioGroup1.setOnCheckedChangeListener { group, checkedId ->

            val radio: RadioButton = findViewById(checkedId)
            when (radio) {
                binding.radioAndroid -> {
                    Toast.makeText(
                        applicationContext,
                        "Android RadioButton checked",
                        Toast.LENGTH_SHORT
                    ).show()

                    loadFragment(FragmentForm())
                }
                binding.radioiPhone -> {
                    Toast.makeText(
                        applicationContext,
                        "iPhone RadioButton checked",
                        Toast.LENGTH_SHORT
                    ).show()
                    loadFragment(FragmentBuying())
                }
                binding.radioWindows -> {
                    Toast.makeText(
                        applicationContext,
                        "windows RadioButton checked",
                        Toast.LENGTH_SHORT
                    ).show()
                    loadFragment(FragmentSelling())
                }
                else -> {

                }
            }
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