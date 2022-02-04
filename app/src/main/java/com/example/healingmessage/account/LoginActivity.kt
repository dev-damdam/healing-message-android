package com.example.healingmessage.account

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.healingmessage.MainActivity
import com.example.healingmessage.R
import com.example.healingmessage.databinding.ActivityLoginBinding
import com.example.healingmessage.firebase.FirebaseBaseSingleton

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setButtonClickEventListener()
    }

    private fun setButtonClickEventListener() {
        binding.buttonLogin.setOnClickListener {
            //login
            login()
        }

        binding.textviewFindEmail.setOnClickListener {
            //find email
        }

        binding.textviewFindPassword.setOnClickListener {
            //find password
        }

        binding.textviewRegister.setOnClickListener {
            //intent register activity
            register()
        }
    }

    private fun login() {
        val res = FirebaseBaseSingleton.getInstance().login(this, "dev.sodam@gmail.com", "test123!")

        res?.addOnCompleteListener { task ->
            if(task.isSuccessful) {
                if(FirebaseBaseSingleton.getInstance().checkEmailVerified() == true) {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "이메일 인증을 해주세요.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun register() {
        val intent = Intent(this, RegisterActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY
        startActivity(intent)
    }
}