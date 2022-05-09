package com.lads.myvolumeapp.Activities

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.slider.Slider
import com.lads.myvolumeapp.R
import com.lads.myvolumeapp.Util.PrefUtil
import com.lads.myvolumeapp.Util.WindowLayoutManager1
import com.lads.myvolumeapp.databinding.ActivitySettingsBinding
import petrov.kristiyan.colorpicker.ColorPicker
import petrov.kristiyan.colorpicker.ColorPicker.OnChooseColorListener


class SettingsActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivitySettingsBinding
    lateinit var prefUtil: PrefUtil
    var colorPicker: ColorPicker? = null
    var lastAccentColor = 0
    var lastBackgroundColor = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        mBinding = ActivitySettingsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= 21) {
            val window: Window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.setStatusBarColor(this.resources.getColor(com.lads.myvolumeapp.R.color.theme))
        }

        setContentView(mBinding.root)
        prefUtil = PrefUtil(this)
        lastAccentColor = prefUtil.getInt("AccentColor", 20)
        colorPicker?.setColors(lastAccentColor)

        lastBackgroundColor = prefUtil.getInt("BackgroundColor", 20)
        colorPicker?.setColors(lastBackgroundColor)


        Log.d("Last Accent Color", " Not Null" + lastAccentColor)
        Log.d("Last Background Color", " Not Null" + lastBackgroundColor)

        setListeners()

        var verticalPosition: Int = prefUtil.getInt(
            "verticalPositionSlider", 0
        )
        var timeOnScreenValue: Int = prefUtil.getInt("VolumeSlider", 0)

        mBinding.volumePositionSlider.value = verticalPosition.toFloat()
        mBinding.sliderScreen.value = prefUtil.getInt("currentPosition", 20).toFloat()

        var lastPosition: Int = prefUtil.getInt("panel_position", 0)
        if (lastPosition == 1) {
            mBinding.consLeft.background = ContextCompat.getDrawable(this, R.drawable.left_empty)
            mBinding.btnLeft.setTextColor(ContextCompat.getColor(this, R.color.black))

            mBinding.consRight.background =
                ContextCompat.getDrawable(this, R.drawable.my_shape_three)
            mBinding.btnRight.setTextColor(ContextCompat.getColor(this, R.color.white))
        } else {
            mBinding.consLeft.background = ContextCompat.getDrawable(this, R.drawable.my_shape_two)
            mBinding.btnLeft.setTextColor(ContextCompat.getColor(this, R.color.white))

            mBinding.consRight.background = ContextCompat.getDrawable(this, R.drawable.right_empty)
            mBinding.btnRight.setTextColor(ContextCompat.getColor(this, R.color.black))
        }


        colorList = ArrayList<String>()
        colorList!!.add("#3aa8c1")
        colorList!!.add("#8bbe1b")
        colorList!!.add("#ffc3a0")
        colorList!!.add("#a29088")
        colorList!!.add("#1f2212")
        colorList!!.add("#8657c5")
        colorList!!.add("#caeb5e")
        colorList!!.add("#095e79")
        colorList!!.add("#33cc5a")
        colorList!!.add("#ba160c")
        colorList!!.add("#f498ad")
        colorList!!.add("#ba160c")
        colorList!!.add("#f498ad")
        colorList!!.add("#283747")
        colorList!!.add("#F1948A")
        colorList!!.add("#ABB2B9")
        colorList!!.add("#626567")
        colorList!!.add("#D0ECE7")
        colorList!!.add("#FFFFFF")
    }

    private fun setListeners() {
        //Left button
        mBinding.consLeft.setOnClickListener(View.OnClickListener {
            // to align volume slide on left
            prefUtil.setInt("panel_position", 0)
            mBinding.consLeft.background = ContextCompat.getDrawable(this, R.drawable.my_shape_two)
            mBinding.btnLeft.setTextColor(ContextCompat.getColor(this, R.color.white))

            mBinding.consRight.background = ContextCompat.getDrawable(this, R.drawable.right_empty)
            mBinding.btnRight.setTextColor(ContextCompat.getColor(this, R.color.black))

        })
        // Right button
        mBinding.consRight.setOnClickListener(View.OnClickListener {
            // to align volume slide on right
            prefUtil.setInt("panel_position", 1)
            mBinding.consLeft.background = ContextCompat.getDrawable(this, R.drawable.left_empty)
            mBinding.btnLeft.setTextColor(ContextCompat.getColor(this, R.color.black))

            mBinding.consRight.background =
                ContextCompat.getDrawable(this, R.drawable.my_shape_three)
            mBinding.btnRight.setTextColor(ContextCompat.getColor(this, R.color.white))


        })
        //Position slider
        mBinding.volumePositionSlider.value =
            prefUtil.getInt("verticalPositionSlider", 20).toFloat()
        mBinding.volumePositionSlider.addOnSliderTouchListener(object :
            Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
            }

            override fun onStopTrackingTouch(slider: Slider) {
                val verticalPosition = slider.value.toInt()
                Log.d("TAG", "onStopTrackingTouch: $verticalPosition")
                prefUtil.setInt(
                    "verticalPositionSlider",
                    verticalPosition
                )
            }
        })

        //Time on Screen slider
        mBinding.sliderScreen.addOnChangeListener(object : Slider.OnChangeListener {
            override fun onValueChange(slider: Slider, value: Float, fromUser: Boolean) {
                prefUtil.setInt("currentPosition", value.toInt())
                val screenTime = value * 20
                prefUtil.setInt("VolumeSlider", screenTime.toInt())
            }
        })
        //Accent color radio button
        mBinding.radioAccent.setOnClickListener(View.OnClickListener {

            val colorPicker = ColorPicker(this)
            colorPicker.setColors(colorList)
            colorPicker.show()
            colorPicker.setOnChooseColorListener(object : OnChooseColorListener {
                override fun onChooseColor(position: Int, color: Int) {
                    // put code
                    Log.e("TESTTAG", "Color $color")
                    prefUtil.setInt("AccentColor", color)
//                    colorPicker.dismissDialog()
                }

                override fun onCancel() {
                    // put code
                }
            })
        })
        //Background color radio button
        mBinding.btnBackgroundColor.setOnClickListener(View.OnClickListener {
            val colorPicker = ColorPicker(this)
            colorPicker.setColors(colorList)
            colorPicker.show()

            colorPicker.setOnChooseColorListener(object : OnChooseColorListener {
                override fun onChooseColor(position: Int, color: Int) {
                    Log.e("TESTTAG", "Color $color")
                    // put code
                    prefUtil.setInt("BackgroundColor", color)
//                    colorPicker.dismissDialog()
                }

                override fun onCancel() {
                    // put code
                }
            })
        })
//        mBinding.txtResetToDefault.setOnClickListener(View.OnClickListener {
//            resetAlertDialog()
//        })
    }

    private fun resetAlertDialog() {
        val alertDialog: AlertDialog = AlertDialog.Builder(this) //set icon
            .setIcon(android.R.drawable.ic_dialog_alert) //set title
            .setTitle("Are you sure to Reset") //set message
//            .setMessage("Exiting will call finish() method") //set positive button
            .setPositiveButton(
                "Yes",
                DialogInterface.OnClickListener { dialogInterface, i -> //set what would happen when positive button is clicked
                    WindowLayoutManager1.resetAll(applicationContext)
                }) //set negative button
            .setNegativeButton(
                "No",
                DialogInterface.OnClickListener { dialogInterface, i -> //set what should happen when negative button is clicked
                    Toast.makeText(applicationContext, "Nothing Happened", Toast.LENGTH_LONG).show()
                })
            .show()

    }

//    override fun onTouchEvent(event: MotionEvent?): Boolean {
//        Toast.makeText(applicationContext, "Nothing Happened", Toast.LENGTH_LONG).show()
//
//        return super.onTouchEvent(event)
//    }

    companion object {
        var colorList: ArrayList<String>? = null

    }

}