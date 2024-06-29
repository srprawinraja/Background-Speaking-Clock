
package com.example.speakingclock

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class onScreenReceiver: BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        val intent=Intent(p0, MyService::class.java)
        p0?.startService(intent)
    }
}