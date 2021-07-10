package com.example.broadcastreceivereo0xample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeChangedReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirplaneModeEnabled = intent?.getBooleanExtra("state", false) ?: return
//        If you want to avoid this null safety isAirplaneModeEnabled!! use the above code
        if (isAirplaneModeEnabled) {
            Toast.makeText(context, "Airplane Mode Enabled", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Airplane Mode Disabled", Toast.LENGTH_SHORT).show()
        }
    }
}