package com.example.pmufirstapplication

import android.R
import android.os.Bundle
import android.view.MenuItem
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
    private var fragmentName : String = "Android"

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMultiSelectorRadioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.title = fragmentName
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

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
                    fragmentName = "Android"
                    loadFragment(FragmentForm())
                }
                binding.radioiPhone -> {
                    Toast.makeText(
                        applicationContext,
                        "iPhone RadioButton checked",
                        Toast.LENGTH_SHORT
                    ).show()
                    fragmentName = "iPhone"
                    loadFragment(FragmentBuying())
                }
                binding.radioWindows -> {
                    Toast.makeText(
                        applicationContext,
                        "windows RadioButton checked",
                        Toast.LENGTH_SHORT
                    ).show()
                    fragmentName = "Windows"
                    loadFragment(FragmentSelling())
                }
                else -> {

                }
            }

            binding.toolbar.title = fragmentName
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