package com.example.pmufirstapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pmufirstapplication.adapters.RecyclerAdapter
import com.example.pmufirstapplication.databinding.ActivityHomeBinding
import com.example.pmufirstapplication.models.MainModel
import com.example.pmufirstapplication.viewmodels.MainViewModel
import com.example.pmufirstapplication.viewmodels.MainViewModelFactory

class HomeActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHomeBinding

    private var viewManager = LinearLayoutManager(this)
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAnchorView(R.id.fab)
                .setAction("Action", null).show()
        }

        init()
    }

    private fun init()
    {
        val application = requireNotNull(this).application
        val factory = MainViewModelFactory()
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        initialiseAdapter()
    }

    private fun initialiseAdapter(){
        binding.recycler.layoutManager = viewManager
        observeData()
    }

    private fun observeData() {
        viewModel.list.observe(this, Observer {
            Log.i("data",it.toString())
            binding.recycler.adapter = RecyclerAdapter(viewModel,it,this)
        })

    }

    fun addData()
    {
        var title = binding.titletxt.text.toString()
        if(title.isNullOrBlank())
        {
            Toast.makeText(this,"Enter value!",Toast.LENGTH_LONG).show()
        }
        else
        {
           var model =  MainModel(title,"")
            viewModel.add(model)
            binding.titletxt.text.clear()
            binding.recycler.adapter?.notifyDataSetChanged()

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_home)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    fun saveData(view: View) {
        addData()
    }
}