package com.example.pmufirstapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun  setIntent(destination : Class<*>)
    {
        val intent = Intent(this,destination)
        startActivity(intent)
    }
}