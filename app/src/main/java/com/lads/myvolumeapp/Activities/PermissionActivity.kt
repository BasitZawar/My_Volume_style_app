package com.lads.myvolumeapp.Activities

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GestureDetectorCompat
import com.lads.myvolumeapp.R
import com.lads.myvolumeapp.Services.MyAccessibilityService
import com.lads.myvolumeapp.Util.PrefUtil

private const val DEBUG_TAG = "Gestures"

class PermissionActivity : AppCompatActivity() {
    private lateinit var switch: Switch
    private lateinit var btnContinue: Button
    private lateinit var mDetector: GestureDetectorCompat
    lateinit var prefUtil: PrefUtil


    var accessibilityEnabled = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= 21) {
            val window: Window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.setStatusBarColor(this.resources.getColor(com.lads.myvolumeapp.R.color.theme))
        }

        setContentView(R.layout.activity_permission)


        prefUtil = PrefUtil(this)
        switch = findViewById(R.id.btnSwitch)
        btnContinue = findViewById(R.id.btnContinue)

        if (isAccessServiceEnabled(applicationContext, MyAccessibilityService::class.java)) {
            switch.isChecked = true
        }
        switch.setOnClickListener(View.OnClickListener {

            if (switch.isChecked() && !isAccessServiceEnabled(
                    applicationContext,
                    MyAccessibilityService::class.java
                )
            ) {
                val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                // request permission via start activity for result
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
                intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
                startActivity(intent)
                prefUtil.setInt("accessibilityOn", 0)
            } else {
                prefUtil.setInt("accessibilityOn", 1)

//                Toast.makeText(applicationContext, "On Service", Toast.LENGTH_LONG).show()
            }
        })

        btnContinue.setOnClickListener(View.OnClickListener {
            if (isAccessServiceEnabled(
                    applicationContext,
                    MyAccessibilityService::class.java
                )
            ) {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
                finish()
//                Toast.makeText(applicationContext, "welcome to Main activity", Toast.LENGTH_LONG)
//                    .show()

            } else {
//                startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
                Toast.makeText(
                    applicationContext,
                    "Please give Accessibility Permission",
                    Toast.LENGTH_LONG
                ).show()
            }
        })

    }
    fun isAccessServiceEnabled(context: Context, accessibilityServiceClass: Class<*>): Boolean {
        val prefString = Settings.Secure.getString(
            context.contentResolver,
            Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES
        )
        return prefString != null && prefString.contains(context.packageName + "/" + accessibilityServiceClass.name)
    }


}