package com.example.helloworld

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

//        go to signup page
        val buttonClick = findViewById<Button>(R.id.signup)

        buttonClick.setOnClickListener(){
            val intent = Intent(this,Signup::class.java)
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