package com.example.healingmessage.account

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.healingmessage.MainActivity
import com.example.healingmessage.R
import com.example.healingmessage.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setButtonClickEventListener()
    }

    private fun setButtonClickEventListener() {
        binding.buttonRegister.setOnClickListener {
            startMainActivity()
        }
    }

    private fun startMainActivity() {
        //FirebaseDataBaseSingleton.getInstance().register(this, "dev.sodam@gmail.com", "test123!")
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}