package com.example.helloworld

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.helloworld.databinding.LoginBinding
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private lateinit var binding: LoginBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        go to signup page
        val buttonClick = findViewById<Button>(R.id.signup)

        buttonClick.setOnClickListener(){
            val intent = Intent(this,Signup::class.java)
            startActivity(intent)
            overridePendingTransition(0,0)

        }

//        go to app dashboard
        firebaseAuth = FirebaseAuth.getInstance()
        binding.loginbtn.setOnClickListener{
            val Email = binding.editTextTextEmailAddress.text.toString()
            val Pwd = binding.editTextTextPassword.text.toString()

            if (Email.isNotEmpty() && Pwd.isNotEmpty()){
                    firebaseAuth.signInWithEmailAndPassword(Email,Pwd).addOnCompleteListener{
                        if (it.isSuccessful){
                            val intent = Intent(this,MainActivity::class.java)
                            startActivity(intent)
                        }
                        else{
                            Toast.makeText(this,it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
            }
            else{
                Toast.makeText(this,"Please fill the form", Toast.LENGTH_SHORT).show()
            }
        }
    }
}