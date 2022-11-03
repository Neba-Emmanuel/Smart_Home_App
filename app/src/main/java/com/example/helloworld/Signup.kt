package com.example.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Signup : AppCompatActivity() {
    lateinit var userName: EditText
    lateinit var etEmail: EditText
    lateinit var etConfPass: EditText
    private lateinit var etPass: EditText
    private lateinit var btnSignUp: Button
//    lateinit var tvRedirectLogin: TextView

    // create Firebase authentication object
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup2)

//        go to Login page
        val signupClick = findViewById<Button>(R.id.button)

        signupClick.setOnClickListener(){
            val intent = Intent(this,Login::class.java)
            startActivity(intent)
            overridePendingTransition(0,0)
        }

//        go to app dashboard
        val appDashboardClick = findViewById<Button>(R.id.loginbtn)

        appDashboardClick.setOnClickListener(){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        // View Bindings
        userName = findViewById(R.id.UserName)
        etEmail = findViewById(R.id.editTextTextEmailAddress)
        etConfPass = findViewById(R.id.ConfirmPassword)
        etPass = findViewById(R.id.editTextTextPassword)
        btnSignUp = findViewById(R.id.loginbtn)
//        tvRedirectLogin = findViewById(R.id.tvRedirectLogin)

        // Initialising auth object
        auth = Firebase.auth

        btnSignUp.setOnClickListener {
            signUpUser()
        }
    }
}