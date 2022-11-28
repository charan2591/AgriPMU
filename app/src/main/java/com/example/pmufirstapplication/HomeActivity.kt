package com.example.pmufirstapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pmufirstapplication.adapters.RecyclerAdapter
import com.example.pmufirstapplication.databinding.ActivityHomeBinding
import com.example.pmufirstapplication.models.MainModel
import com.example.pmufirstapplication.viewmodels.MainViewModel
import com.example.pmufirstapplication.viewmodels.MainViewModelFactory
import com.google.android.material.snackbar.Snackbar

class HomeActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHomeBinding

    private var viewManager = LinearLayoutManager(this)
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
//        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAnchorView(R.id.fab)
                .setAction("Action", null).show()

            val intent = Intent(this,BottomBarActivity::class.java)
            startActivity(intent)
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

    private fun addData()
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.getItemId()) {
            android.R.id.home -> {
                // todo: goto back activity from here
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun saveData(view: View) {
        addData()
    }
}