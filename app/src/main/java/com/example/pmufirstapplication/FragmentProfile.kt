package com.example.pmufirstapplication

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pmufirstapplication.databinding.FragmentProfileBinding
import com.example.pmufirstapplication.databinding.FragmentSellingBinding

class FragmentProfile :Fragment() {

    private lateinit var  binding : FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        context ?: return binding.root

//        val adapter = PlantAdapter()
//        binding.plantList.adapter = adapter

        viewInitializations()

        return binding.root
    }

    fun viewInitializations() {

        // To show back button in actionbar
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    // Checking if the input in form is valid
    fun validateInput(): Boolean {
        if (binding.etFirstName.text.toString().equals("")) {
            binding.etFirstName.setError("Please Enter First Name")
            return false
        }
        if (binding.etLastName.text.toString().equals("")) {
            binding.etLastName.setError("Please Enter Last Name")
            return false
        }
        if (binding.etEmail.text.toString().equals("")) {
            binding.etEmail.setError("Please Enter Email")
            return false
        }

        if (binding.etContactNo.text.toString().equals("")) {
            binding.etContactNo.setError("Please Enter Contact No")
            return false
        }
        if (binding.etDes.text.toString().equals("")) {
            binding.etDes.setError("Please Enter Designation")
            return false
        }
        // checking the proper email format
        if (!isEmailValid(binding.etEmail.text.toString())) {
            binding.etEmail.setError("Please Enter Valid Email")
            return false
        }

        return true
    }

    fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    // Hook Click Event
    fun performUpdateUser(view: View) {
        if (validateInput()) {

            // Input is valid, here send data to your server

            val firstName =  binding.etFirstName.text.toString()
            val lastName = binding.etLastName.text.toString()
            val email = binding.etEmail.text.toString()
            val contactNo = binding.etContactNo.text.toString()
            val etDes = binding.etDes.text.toString()

            Toast.makeText(context,"Profile Update Successfully",Toast.LENGTH_SHORT).show()
            // Here you can call you API

        }
    }

}