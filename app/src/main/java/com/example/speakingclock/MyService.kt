package com.example.speakingclock

import android.app.Service
import android.content.Intent
import android.icu.util.Calendar
import android.os.IBinder
import android.speech.tts.TextToSpeech
import android.util.Log
import java.text.SimpleDateFormat
import java.util.Locale

@Suppress("DEPRECATION")
class MyService : Service() {

    private lateinit var tts: TextToSpeech

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("this services ", "Service started")
        val currentTime:String= getCurrentTime()
        tts = TextToSpeech(this) { status ->
            if (status == TextToSpeech.SUCCESS) {
                val result = tts.setLanguage(Locale.getDefault())
                if (result != TextToSpeech.LANG_MISSING_DATA && result != TextToSpeech.LANG_NOT_SUPPORTED) {
                    tts.speak(currentTime, TextToSpeech.QUEUE_FLUSH, null)
                }

            }
        }
        return START_STICKY
    }

    private fun getCurrentTime(): String {
        val calendar = Calendar.getInstance()
        val timeFormatter = SimpleDateFormat("hh:mm a", Locale.getDefault()) // "hh" for 12-hour format, "a" for AM/PM
        val currentTime = timeFormatter.format(calendar.time)
        return currentTime
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.i("this services", "Service created")
    }


}