package com.example.healingmessage.firebase

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*

class FirebaseBaseSingleton {
    companion object {
        private var instance: FirebaseBaseSingleton? = null
        //database
        private var database: FirebaseDatabase? = null
        private var databaseReference: DatabaseReference? = null

        //auth
        private var auth: FirebaseAuth? = null

        init {
            init()
        }

        fun getInstance(): FirebaseBaseSingleton {
            if (instance == null) {
                instance = FirebaseBaseSingleton()
            }

            return instance!!
        }

        private fun init() {
            if (database == null) {
                database = FirebaseDatabase.getInstance()
            }

            if (databaseReference == null) {
                databaseReference = database!!.reference
            }

            if(auth == null) {
                auth = FirebaseAuth.getInstance()
            }
        }

        fun getDatabase(): FirebaseDatabase {
            if (database == null) {
                database = FirebaseDatabase.getInstance()
            }

            return database!!
        }

        fun getDatabaseReference(): DatabaseReference {
            if (databaseReference == null) {
                databaseReference = database!!.reference
            }

            return databaseReference!!
        }
    }

    fun register(context: Context, email: String, password: String) {
        auth?.createUserWithEmailAndPassword(email, password)
            ?.addOnCompleteListener { task ->
                if(task.isSuccessful) {
                    auth?.currentUser
                        ?.sendEmailVerification()
                        ?.addOnCompleteListener { task ->
                            if(task.isSuccessful) {
                                Toast.makeText(context, "회원가입 인증 성공", Toast.LENGTH_SHORT).show()
                            }
                            else {
                                Toast.makeText(context, "회원가입 인증 실패", Toast.LENGTH_SHORT).show()
                            }
                        }
                } else {
                    Toast.makeText(context, "회원가입 실패", Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun login(email: String, password: String): Task<AuthResult>? {
        return auth?.signInWithEmailAndPassword(email, password)
    }

    fun resetPassword(email: String): Task<Void>? {
        return auth?.sendPasswordResetEmail(email)
    }

    fun checkEmailVerified(): Boolean? {
        return auth?.currentUser?.isEmailVerified
    }
}