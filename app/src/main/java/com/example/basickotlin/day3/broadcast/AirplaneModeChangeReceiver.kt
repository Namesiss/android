package com.example.basickotlin.day3.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeChangeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirPlaneModeEnabled = intent?.getBooleanExtra("state", false) ?: return
        if(isAirPlaneModeEnabled){
            Toast.makeText(context, "Đã bật chế độ máy bay", Toast.LENGTH_LONG).show()
        }
        else Toast.makeText(context, "Đã tắt chế độ máy bay", Toast.LENGTH_LONG).show()
    }
}