package com.example.broadcastreceivereo0xample

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window

class MainActivity : AppCompatActivity() {

    lateinit var airplaneModeChangedReceiver: AirplaneModeChangedReceiver
    lateinit var bootCompleteBroadcastReceiver: BootCompleteBroadcastReceiver
    lateinit var connectivityModeChangedReceiver: ConnectivityModeChangedReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        // Airplane Mode Broadcast Receiver
        airplaneModeChangedReceiver = AirplaneModeChangedReceiver()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(airplaneModeChangedReceiver, it)
        }
        //  Boot Complete Broadcast Receiver
        bootCompleteBroadcastReceiver = BootCompleteBroadcastReceiver()
        IntentFilter(Intent.ACTION_REBOOT).also {
            registerReceiver(bootCompleteBroadcastReceiver, it)
        }
        // Connectivity Mode Changed Receiver
        connectivityModeChangedReceiver = ConnectivityModeChangedReceiver()
        IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION).also {
            registerReceiver(connectivityModeChangedReceiver, it)
        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(airplaneModeChangedReceiver)
        unregisterReceiver(bootCompleteBroadcastReceiver)
        unregisterReceiver(connectivityModeChangedReceiver)
    }
}