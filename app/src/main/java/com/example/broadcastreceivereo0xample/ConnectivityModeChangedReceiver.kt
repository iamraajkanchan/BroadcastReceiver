package com.example.broadcastreceivereo0xample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast

class ConnectivityModeChangedReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isNoConnectivity =
            intent?.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false) ?: return
        if (isNoConnectivity) {
            Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show()
        }
    }
}