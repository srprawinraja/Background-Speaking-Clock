package com.example.speakingclock

import android.annotation.SuppressLint
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val filter=IntentFilter()
        filter.addAction(Intent.ACTION_SCREEN_ON)

        applicationContext.registerReceiver(onScreenReceiver(),filter)
        val button=findViewById<Button>(R.id.button)
        button.setOnClickListener {
            Toast.makeText(this,"This app announces the current time when the screen is unlocked.",Toast.LENGTH_SHORT).show()
        }
    }


}