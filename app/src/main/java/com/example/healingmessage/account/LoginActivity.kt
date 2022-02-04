package com.example.healingmessage.account

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.healingmessage.R
import com.example.healingmessage.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setButtonClickEventListener() {
        binding.buttonLogin.setOnClickListener {
           //login check
        }

        binding.textviewFindEmail.setOnClickListener {
            //find email
        }

        binding.textviewFindPassword.setOnClickListener {
            //find password
        }

        binding.textviewRegister.setOnClickListener {
            //intent register activity
        }
    }
}