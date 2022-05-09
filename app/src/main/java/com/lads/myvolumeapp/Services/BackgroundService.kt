package com.lads.myvolumeapp.Services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class BackgroundService : Service() {
    override fun onBind(p0: Intent?): IBinder? {
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        onTaskRemoved(intent)
        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show()

        return START_STICKY
    }

    override fun onTaskRemoved(rootIntent: Intent?) {

        val restartServiceIntent = Intent(applicationContext, this.javaClass)
        restartServiceIntent.setPackage(packageName)
        try {
            startService(restartServiceIntent)
        } catch (e: Exception) {

        }

        super.onTaskRemoved(rootIntent)
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_SHORT).show()

    }
}