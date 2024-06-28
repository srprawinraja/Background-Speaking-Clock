
package com.example.speakingclock

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_SCREEN_ON
import android.icu.util.Calendar
import android.util.Log
import java.text.SimpleDateFormat
import java.util.Locale

class onScreenReceiver: BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        if(p1?.action=="android.intent.action.SCREEN_ON"){
            var intent=Intent(p0, MyService::class.java)
            if (p0 != null) {
                p0.startService(intent)
            }
        }
    }
}