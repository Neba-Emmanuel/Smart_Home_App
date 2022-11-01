package com.example.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import java.util.*
import kotlin.concurrent.timerTask

class FlashScreen : AppCompatActivity() {

    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.flash_screen)

        handler = Handler()
        handler.postDelayed({
            val intent = Intent(this,Login::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}