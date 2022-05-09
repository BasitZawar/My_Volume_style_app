package com.lads.myvolumeapp.Activities

import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.lads.myvolumeapp.R
import com.lads.myvolumeapp.Services.MyAccessibilityService

class SplashActivity : AppCompatActivity() {
    private lateinit var buttonGetStarted: TextView
    var dont_disturb: Boolean = false

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //app bar color
        if (Build.VERSION.SDK_INT >= 21) {
            val window: Window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.setStatusBarColor(this.resources.getColor(com.lads.myvolumeapp.R.color.theme))
        }

        setContentView(R.layout.activity_splash)

        buttonGetStarted = findViewById<Button>(R.id.btnGetStarted)
        buttonGetStarted.setOnClickListener {
            val mNotificationManager =
                this!!.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?

            if (!Settings.canDrawOverlays(this)) {
                // send user to the device settings
                val myIntent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION)
                startActivity(myIntent)
            } else if (isAccessServiceEnabled(
                    applicationContext,
                    MyAccessibilityService::class.java
                )
            ) {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(applicationContext, PermissionActivity::class.java)
                startActivity(intent)
                finish()
            }
            if (!mNotificationManager!!.isNotificationPolicyAccessGranted) {
                val i = Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS)
                i!!.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
                i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
                this!!.startActivity(i)
                dont_disturb = false
            } else {
                dont_disturb = true

            }
        }
    }

    fun isAccessServiceEnabled(context: Context, accessibilityServiceClass: Class<*>): Boolean {
        val prefString = Settings.Secure.getString(
            context.contentResolver,
            Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES
        )
        return prefString != null && prefString.contains(context.packageName + "/" + accessibilityServiceClass.name)
    }
}