package com.example.helloworld
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.helloworld.databinding.ActivitySignup2Binding
import com.google.firebase.auth.FirebaseAuth

class Signup : AppCompatActivity() {
    private lateinit var binding: ActivitySignup2Binding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignup2Binding.inflate(layoutInflater)
        setContentView(binding.root)

//        go to Login page
        val signupClick = findViewById<Button>(R.id.button)

        signupClick.setOnClickListener(){
            val intent = Intent(this,Login::class.java)
            startActivity(intent)
            overridePendingTransition(0,0)
        }

//        go to app dashboard
//        val appDashboardClick = findViewById<Button>(R.id.loginbtn)
//
//        appDashboardClick.setOnClickListener(){
//            val intent = Intent(this,MainActivity::class.java)
//            startActivity(intent)
//        }
        firebaseAuth = FirebaseAuth.getInstance()
        binding.loginbtn.setOnClickListener{
            val UserName = binding.UserName.text.toString()
            val Email = binding.editTextTextEmailAddress.text.toString()
            val Pwd = binding.editTextTextPassword.text.toString()
            val CfmPwd = binding.ConfirmPassword.text.toString()

            if (UserName.isNotEmpty() && Email.isNotEmpty() && Pwd.isNotEmpty() && CfmPwd.isNotEmpty()){
                if (Pwd == CfmPwd){
                    firebaseAuth.createUserWithEmailAndPassword(Email,Pwd).addOnCompleteListener{
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
                    Toast.makeText(this,"Password mismatch", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this,"Please fill the form", Toast.LENGTH_SHORT).show()
            }
    }
    }
}