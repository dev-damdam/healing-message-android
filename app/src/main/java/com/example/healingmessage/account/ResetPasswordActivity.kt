package com.example.healingmessage.account

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.healingmessage.MainActivity
import com.example.healingmessage.databinding.ActivityResetPasswordBinding
import com.example.healingmessage.firebase.FirebaseBaseSingleton

class ResetPasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResetPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonResetPassword.setOnClickListener {
            val res = FirebaseBaseSingleton.getInstance().resetPassword("dev.sodam@gmail.com")
            res?.addOnCompleteListener { task ->
                if(task.isSuccessful) {
                    val intent = Intent(this, LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY
                    startActivity(intent)
                }
            }
        }
    }

}