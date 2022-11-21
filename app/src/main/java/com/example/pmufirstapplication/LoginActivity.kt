package com.example.pmufirstapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.ui.AppBarConfiguration
import com.example.pmufirstapplication.databinding.ActivityLoginBinding
import com.example.pmufirstapplication.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity()
{
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window,false)
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

//        GitHub Generated Token : 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
    }

    fun login(view: View) {
       val intt :  Intent  = Intent(this,HomeActivity::class.java)
        startActivity(intt)

    }
}