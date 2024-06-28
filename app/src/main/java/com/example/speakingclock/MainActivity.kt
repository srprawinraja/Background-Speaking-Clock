package com.example.speakingclock

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var filter=IntentFilter()
        filter.addAction(Intent.ACTION_SCREEN_ON)
        getApplicationContext().registerReceiver(onScreenReceiver(),filter)
    }

}