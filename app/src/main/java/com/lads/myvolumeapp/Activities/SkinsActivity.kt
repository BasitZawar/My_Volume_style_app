package com.lads.myvolumeapp.Activities

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.MotionEvent
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.lads.myvolumeapp.R
import com.lads.myvolumeapp.Util.PrefUtil
import com.lads.myvolumeapp.databinding.ActivitySkinsBinding

class SkinsActivity : AppCompatActivity() {

    var styleid: Int? = null
    var position: Int? = null
    var prefUtil: PrefUtil? = null

    private lateinit var binding: ActivitySkinsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySkinsBinding.inflate(layoutInflater)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
//        window.setFlags(
//            WindowManager.LayoutParams.FLAG_FULLSCREEN,
//            WindowManager.LayoutParams.FLAG_FULLSCREEN
//        )
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= 21) {
            val window: Window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.setStatusBarColor(this.resources.getColor(com.lads.myvolumeapp.R.color.theme))
        }

        setContentView(binding.root)
        prefUtil = PrefUtil(applicationContext)

        if (prefUtil?.getInt("selectedItem", 0) == 1) {
            binding.s1Checkbox.visibility = View.VISIBLE
            binding.s1Checkbox.isChecked = true
        } else if (prefUtil?.getInt("selectedItem", 0) == 2) {
            binding.s2Checkbox.visibility = View.VISIBLE
            binding.s2Checkbox.isChecked = true
        } else if (prefUtil?.getInt("selectedItem", 0) == 3) {
            binding.s3Checkbox.isChecked = true
            binding.s3Checkbox.visibility = View.VISIBLE
        } else if (prefUtil?.getInt("selectedItem", 0) == 4) {
            binding.s4Checkbox.isChecked = true
            binding.s4Checkbox.visibility = View.VISIBLE
        } else if (prefUtil?.getInt("selectedItem", 0) == 7) {
            binding.s7Checkbox.isChecked = true
            binding.s7Checkbox.visibility = View.VISIBLE
        } else if (prefUtil?.getInt("selectedItem", 0) == 8) {
            binding.s8Checkbox.isChecked = true
            binding.s8Checkbox.visibility = View.VISIBLE
        } else if (prefUtil?.getInt("selectedItem", 0) == 9) {
            binding.s9Checkbox.isChecked = true
            binding.s9Checkbox.visibility = View.VISIBLE
        } else if (prefUtil?.getInt("selectedItem", 0) == 10) {
            binding.s10Checkbox.isChecked = true
            binding.s10Checkbox.visibility = View.VISIBLE
        } else {

        }



        binding.apply {
            s1.setOnClickListener {
                checkLastStoredValue()
                styleid = 1
                s1Checkbox.visibility = View.VISIBLE
                s1Checkbox.isChecked = true
                s1!!.setBackgroundDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.card_selected_border
                    )
                )
                Toast.makeText(applicationContext, "Volume style 1 is applied", Toast.LENGTH_SHORT)
                    .show()
                prefUtil?.setInt("selectedItem", 1);
            }
            s2.setOnClickListener {
                checkLastStoredValue()
                styleid = 2
                s2Checkbox.visibility = View.VISIBLE
                s2Checkbox.isChecked = true
                s2!!.setBackgroundDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.card_selected_border
                    )
                )
                Toast.makeText(applicationContext, "Volume style 2 is applied", Toast.LENGTH_SHORT)
                    .show()
                prefUtil?.setInt("selectedItem", 2);
            }
            s3.setOnClickListener {
                checkLastStoredValue()
                styleid = 3
                s3Checkbox.visibility = View.VISIBLE
                s3Checkbox.isChecked = true
                s3!!.setBackgroundDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.card_selected_border
                    )
                )
                Toast.makeText(applicationContext, "Volume style 3 is applied", Toast.LENGTH_SHORT)
                    .show()
                prefUtil?.setInt("selectedItem", 3);
            }
            s4.setOnClickListener {
                checkLastStoredValue()
                styleid = 4
                s4Checkbox.visibility = View.VISIBLE
                s4Checkbox.isChecked = true
                s4!!.setBackgroundDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.card_selected_border
                    )
                )
                Toast.makeText(applicationContext, "Elastic style  is applied", Toast.LENGTH_SHORT)
                    .show()
                prefUtil?.setInt("selectedItem", 4);
            }
            s7.setOnClickListener {
                checkLastStoredValue()
                styleid = 7
                s7Checkbox.visibility = View.VISIBLE
                s7Checkbox.isChecked = true
                s7!!.setBackgroundDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.card_selected_border
                    )
                )
                Toast.makeText(applicationContext, "IOS style  is applied", Toast.LENGTH_SHORT)
                    .show()
                prefUtil?.setInt("selectedItem", 7)
            }
            s8.setOnClickListener {
                checkLastStoredValue()
                styleid = 8
                s8Checkbox.visibility = View.VISIBLE
                s8Checkbox.isChecked = true
                s8!!.setBackgroundDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.card_selected_border
                    )
                )
                Toast.makeText(applicationContext, "Volume style 6 is applied", Toast.LENGTH_SHORT)
                    .show()
                prefUtil?.setInt("selectedItem", 8)
            }
            s9.setOnClickListener {
                checkLastStoredValue()
                styleid = 9
                s9Checkbox.visibility = View.VISIBLE
                s9Checkbox.isChecked = true
                s9!!.setBackgroundDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.card_selected_border
                    )
                )
                Toast.makeText(
                    applicationContext,
                    "Horizontal style 7 is applied",
                    Toast.LENGTH_SHORT
                ).show()
                prefUtil?.setInt("selectedItem", 9)
            }
            s10.setOnClickListener {
                checkLastStoredValue()
                styleid = 10
                s10Checkbox.visibility = View.VISIBLE
                s10Checkbox.isChecked = true
                s10!!.setBackgroundDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.card_selected_border
                    )
                )
                Toast.makeText(applicationContext, "Volume style 8 is applied", Toast.LENGTH_SHORT)
                    .show()
                prefUtil?.setInt("selectedItem", 10)
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


    private fun checkLastStoredValue() {

        position = prefUtil!!.getInt("selectedItem", -1)
        binding.apply {
            if (position == 1) {
                s1Checkbox!!.visibility = View.GONE
                s1Checkbox!!.isChecked = false
                s1!!.setBackgroundDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.card_border
                    )
                )
            } else if (position == 2) {
                s2Checkbox!!.visibility = View.GONE
                s2Checkbox!!.isChecked = false
                s2!!.setBackgroundDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.card_border
                    )
                )
            } else if (position == 3) {
                s3Checkbox!!.visibility = View.GONE
                s3Checkbox!!.isChecked = false
                s3!!.setBackgroundDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.card_border
                    )
                )
            } else if (position == 4) {
                s4Checkbox!!.visibility = View.GONE
                s4Checkbox!!.isChecked = false
                s4!!.setBackgroundDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.card_border
                    )
                )
            } else if (position == 7) {
                s7Checkbox!!.visibility = View.GONE
                s7Checkbox!!.isChecked = false
                s7!!.setBackgroundDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.card_border
                    )
                )
            } else if (position == 8) {
                s8Checkbox!!.visibility = View.GONE
                s8Checkbox!!.isChecked = false
                s8!!.setBackgroundDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.card_border
                    )
                )
            } else if (position == 9) {
                s9Checkbox!!.visibility = View.GONE
                s9Checkbox!!.isChecked = false
                s9!!.setBackgroundDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.card_border
                    )
                )
            } else if (position == 10) {
                s10Checkbox!!.visibility = View.GONE
                s10Checkbox!!.isChecked = false
                s10!!.setBackgroundDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.card_border
                    )
                )
            }
        }

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Toast.makeText(applicationContext, "OnTouchEvent", Toast.LENGTH_SHORT).show()
        return super.onTouchEvent(event)


    }
}