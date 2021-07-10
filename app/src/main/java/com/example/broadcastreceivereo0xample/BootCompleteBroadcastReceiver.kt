package com.example.broadcastreceivereo0xample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BootCompleteBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isBootCompleteCompleted = intent?.getBooleanExtra("state", false) ?: return
        if (isBootCompleteCompleted) {
            Toast.makeText(context, "Boot Completed", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Boot Failed", Toast.LENGTH_SHORT).show()
        }
    }
}