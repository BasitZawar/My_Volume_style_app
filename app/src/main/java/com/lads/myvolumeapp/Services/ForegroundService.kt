package com.lads.myvolumeapp.Services

import android.R
import android.annotation.SuppressLint
import android.app.*
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.lads.myvolumeapp.Activities.MainActivity

class ForegroundService : Service() {

    val CHANNEL_ID = "ForegroundServiceChannel"

    private val event: Any? = null

    @SuppressLint("NewApi")
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {

        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show()
        if (intent.action === "ACTION_STOP") {
            stopSelf()
            Log.d("TAG", "ACTION_STOP: ")
        }
        val input = intent.getStringExtra("Foreground service is running")
        createNotificationChannel()

        // Service action intent
        val notificationIntent = Intent(this, ForegroundService::class.java)
        notificationIntent.action = "ACTION_STOP"
        val servicePendingIntent = PendingIntent.getService(
            this,
            0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT
        )
        // on notification click intent
        val mainActivityIntent = Intent(this, MainActivity::class.java)
        val activityPendingIntent = PendingIntent.getActivity(
            this,
            0, mainActivityIntent, PendingIntent.FLAG_UPDATE_CURRENT
        )
        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Service is Enabled")
            .setContentText(input)
            .setSmallIcon(R.drawable.ic_dialog_alert)
            .setContentIntent(activityPendingIntent)
            .addAction(R.drawable.ic_media_pause, "Stop", servicePendingIntent)
            .build()
        startForeground(1, notification)
        //do heavy work on a background thread
//        stopSelf();
        return START_STICKY
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                CHANNEL_ID,
                "Foreground Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(
                NotificationManager::class.java
            )
            manager.createNotificationChannel(serviceChannel)
        }
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        stopSelf()
        stopForeground(true)
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_SHORT).show()

    }
}