package com.lads.myvolumeapp.Activities

import android.annotation.SuppressLint
import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.lads.myvolumeapp.Services.ForegroundService
import com.lads.myvolumeapp.Util.PrefUtil
import com.lads.myvolumeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var backgroundDialog: BackgroundDialog
    private var prefUtil: PrefUtil? = null


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= 21) {
            val window: Window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.setStatusBarColor(this.resources.getColor(com.lads.myvolumeapp.R.color.theme))
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        backgroundDialog = BackgroundDialog(this@MainActivity)
        setContentView(binding.root)

        var backgroundDialog: BackgroundDialog

        val serviceIntent = Intent(this, ForegroundService::class.java)
//        val serviceIntent = Intent(this, BackgroundService::class.java)
        if (isMyServiceRunning(ForegroundService::class.java)) {
            binding.txtStart.setText("Stop")
            binding.startIcon.setImageResource(com.lads.myvolumeapp.R.drawable.ic_stop)
        } else {
            binding.txtStart.setText("Start")
            binding.startIcon.setImageResource(com.lads.myvolumeapp.R.drawable.ic_start_icon)
        }

        binding.card1Lay.setOnClickListener {
            if (!isMyServiceRunning(ForegroundService::class.java)) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    startForegroundService(serviceIntent)
                    binding.txtStart.setText("Stop")
                    binding.startIcon.setImageResource(com.lads.myvolumeapp.R.drawable.ic_stop)
                } else {
                    startService(serviceIntent)
                }
            } else {
                stopService(serviceIntent)
                binding.txtStart.setText("Start")

                binding.startIcon.setImageResource(com.lads.myvolumeapp.R.drawable.ic_start_icon)
            }
        }
        binding.card2Lay.setOnClickListener {
            Intent(this, SkinsActivity::class.java).apply {
                startActivity(this)
            }
        }
        binding.card3Lay.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        binding.card4Lay.setOnClickListener {
            val intent = Intent(this, MoreActivity::class.java)
            startActivity(intent)
        }
    }

    private fun isMyServiceRunning(serviceClass: Class<*>): Boolean {
        try {
            val manager =
                getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            for (service in manager.getRunningServices(
                Int.MAX_VALUE
            )) {
                if (serviceClass.name == service.service.className) {
                    return true
                }
            }
        } catch (e: Exception) {
            return false
        }
        return false
    }

    companion object {
        var close: Boolean? = null
    }

    override fun onBackPressed() {
//        exitAlertDialog()
        showExitPopup()
    }

    //Back Press alert dialog
    @SuppressLint("ResourceType")


    private fun showExitPopup() {
        backgroundDialog.alertDialogShow()
    }
}
