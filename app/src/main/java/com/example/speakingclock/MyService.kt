package com.example.speakingclock

import android.app.Service
import android.content.Intent
import android.icu.util.Calendar
import android.os.IBinder
import android.speech.tts.TextToSpeech
import android.util.Log
import java.text.SimpleDateFormat
import java.util.Locale

class MyService : Service(), TextToSpeech.OnInitListener {

    private lateinit var tts: TextToSpeech

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("check","onStartCommand")
        val currentTime:String= getCurrentTime()
        speak(currentTime)
        return START_STICKY
    }

    private fun speak( currentTime:String) {
        tts.speak(currentTime,TextToSpeech.QUEUE_FLUSH,null,"")
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
        Log.i("check","onCreate")
        tts=TextToSpeech(this,this)
        tts.setLanguage(Locale.getDefault())
        val currentTime:String= getCurrentTime()
        speak(currentTime)
    }

    override fun onInit(p0: Int) {

    }

}