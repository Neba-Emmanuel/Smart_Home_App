package com.example.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Signup : AppCompatActivity() {
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

    }
}