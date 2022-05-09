package com.lads.myvolumeapp.Classes

import android.content.Context
import android.content.SharedPreferences
import android.content.res.ColorStateList
import android.graphics.PixelFormat
import android.media.AudioManager
import android.os.Build
import android.os.Handler
import android.util.Log
import android.view.*
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.SeekBar
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.bernaferrari.emojislider.EmojiSlider
import com.jem.rubberpicker.RubberSeekBar
import com.lads.myvolumeapp.R
import com.lads.myvolumeapp.R.*
import com.lads.myvolumeapp.Services.MyAccessibilityService
import com.lads.myvolumeapp.Util.PrefUtil
import com.lukelorusso.verticalseekbar.VerticalSeekBar
import com.sdsmdg.harjot.crollerTest.Croller


class Window {
    private var context: Context? = null
    private var mParams: WindowManager.LayoutParams? = null
    private var mWindowManager: WindowManager? = null
    private var layoutInflater: LayoutInflater? = null
    var audioManager: AudioManager? = null
    var sharedPreferences: SharedPreferences? = null
    var prefUtil: PrefUtil? = null
    var color_sharedPreferences: SharedPreferences? = null
    var position_sharedPreferences: SharedPreferences? = null

    var styleid: String? = null
    var coloridAndroid10: String? = null
    var positionidAndroid10: String? = null
    var coloridAndroid: String? = null
    var positionidAndroid: String? = null
    var coloridWindow10: String? = null
    var positionidWindow10: String? = null
    var coloridElastic: String? = null
    var positionidElastic: String? = null
    var coloridEmoji: String? = null
    var positionidEmoji: String? = null
    var coloridKnob: String? = null
    var positionidKnob: String? = null
    var coloridIos: String? = null
    var positionidIos: String? = null
    var coloridAndroid11: String? = null
    var positionidAndroid11: String? = null
    var coloridAndroidHorizontal: String? = null
    var positionidAndroidHorizontal: String? = null
    var coloridOneUi2: String? = null
    var positionidOneUi2: String? = null

    private var mView: View? = null
    var android10_seekbar: SeekBar? = null
    var music_icon_android10: ImageView? = null

    var ringicon_android10: ImageView? = null
    var btn_show_more: ImageButton? = null
    var btn_show_less: ImageButton? = null
    var ringcardView: CardView? = null

    var alarmcardView: CardView? = null
    var callcardView: CardView? = null
    var android10_ring_seekbar: SeekBar? = null
    var android10_alarm_seekbar: SeekBar? = null
    var android10_call_seekbar: SeekBar? = null
    var seekbarname_type: String? = null
    var android_music_seekbar: VerticalSeekBar? = null
    var android_music_seekbar_hidden: VerticalSeekBar? = null
    var android_ring_seekbar: VerticalSeekBar? = null
    var android_alarm_seekbar: VerticalSeekBar? = null
    var android_call_seekbar: VerticalSeekBar? = null
    var hiddencardView: CardView? = null

    var hiddenview: LinearLayout? = null
    var music_rubberseekbar: RubberSeekBar? = null
    var ring_rubberseekbar: RubberSeekBar? = null
    var alarm_rubberseekbar: RubberSeekBar? = null
    var call_rubberseekbar: RubberSeekBar? = null
    var music_emojiSlider: EmojiSlider? = null
    var ring_emojiSlider: EmojiSlider? = null
    var alarm_emojiSlider: EmojiSlider? = null
    var call_emojiSlider: EmojiSlider? = null
    var music_knob: Croller? = null
    var ring_knob: Croller? = null
    var alarm_knob: Croller? = null
    var call_knob: Croller? = null
    var knob_music_icon: ImageButton? = null
    var knob_ring_icon: ImageButton? = null
    var knob_alarm_icon: ImageButton? = null
    var knob_call_icon: ImageButton? = null

    var ic_call_center_knob: ImageButton? = null
    var ios_music_seekbar: VerticalSeekBar? = null
    var ios_ring_seekbar: VerticalSeekBar? = null
    var ios_alarm_seekbar: VerticalSeekBar? = null
    var ios_call_seekbar: VerticalSeekBar? = null

    var ios_call_image: ImageView? = null
    var ios_hidden_view: ConstraintLayout? = null
    var android11_music_seekbar: VerticalSeekBar? = null
    var android11_ring_seekbar: VerticalSeekBar? = null
    var android11_alarm_seekbar: VerticalSeekBar? = null
    var android11_call_seekbar: VerticalSeekBar? = null

    var android11_call_image: ImageView? = null
    var android11_hidden_view: ConstraintLayout? = null
    var btn_show_more_android11: ImageView? = null
    var androidHorizontal_music_seekbar: SeekBar? = null
    var androidHorizontal_ring_seekbar: SeekBar? = null
    var androidHorizontal_alarm_seekbar: SeekBar? = null
    var androidHorizontal_call_seekbar: SeekBar? = null
    var btn_show_more_OneUi2: ImageView? = null
    var oneUi_2_music_seekbar: SeekBar? = null
    var oneUi_2_ring_seekbar: SeekBar? = null
    var oneUi_2_alarm_seekbar: SeekBar? = null
    var oneUi_2_call_seekbar: SeekBar? = null
    var musicImage: ImageView? = null

    var ringImage: ImageView? = null
    var callImage: ImageView? = null
    var alarmImage: ImageView? = null

    var count: Int = 0
    var systemMusicProgress: Int? = null
    var systemRingProgress: Int? = null
    var systemAlarmProgress: Int? = null
    var systemCallProgress: Int? = null


    constructor(context: Context?) {
        this.context = context

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // set the layout parameters of the window

            mParams = WindowManager.LayoutParams(
                // Set Width and Height for Transparent Window
                WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT,
                // Display it on top of other application windows
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                // Don't let it grab the input focus
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                // Make the underlying application window visible
                // through any transparent parts
                PixelFormat.TRANSLUCENT
            );
        }
//        sharedPreferences = context!!.getSharedPreferences("Styles", Context.MODE_PRIVATE)
//        styleid = sharedPreferences!!.getString("style", "")


        color_sharedPreferences = context!!.getSharedPreferences("Color", Context.MODE_PRIVATE)
        coloridAndroid10 = color_sharedPreferences!!.getString("colorAndroid10", "")

        position_sharedPreferences =
            context!!.getSharedPreferences("Position", Context.MODE_PRIVATE)
        positionidAndroid10 = position_sharedPreferences!!.getString("positionAndroid10", "")

//        color_sharedPreferences=context!!.getSharedPreferences("Color", Context.MODE_PRIVATE)
//        coloridAndroid10=color_sharedPreferences!!.getString("colorAndroid","")
//
//        position_sharedPreferences=context!!.getSharedPreferences("Position", Context.MODE_PRIVATE)
//        positionidAndroid10=position_sharedPreferences!!.getString("positionAndroid","")

        color_sharedPreferences = context!!.getSharedPreferences("Color", Context.MODE_PRIVATE)
        coloridAndroid = color_sharedPreferences!!.getString("colorAndroid", "")

        position_sharedPreferences =
            context!!.getSharedPreferences("Position", Context.MODE_PRIVATE)
        positionidAndroid = position_sharedPreferences!!.getString("positionAndroid", "")

        color_sharedPreferences = context!!.getSharedPreferences("Color", Context.MODE_PRIVATE)
        coloridWindow10 = color_sharedPreferences!!.getString("colorWindow10", "")

        position_sharedPreferences =
            context!!.getSharedPreferences("Position", Context.MODE_PRIVATE)
        positionidWindow10 = position_sharedPreferences!!.getString("positionWindow10", "")

        color_sharedPreferences = context!!.getSharedPreferences("Color", Context.MODE_PRIVATE)
        coloridElastic = color_sharedPreferences!!.getString("colorElastic", "")

        position_sharedPreferences =
            context!!.getSharedPreferences("Position", Context.MODE_PRIVATE)
        positionidElastic = position_sharedPreferences!!.getString("positionElastic", "")

        color_sharedPreferences = context!!.getSharedPreferences("Color", Context.MODE_PRIVATE)
        coloridEmoji = color_sharedPreferences!!.getString("colorEmoji", "")

        position_sharedPreferences =
            context!!.getSharedPreferences("Position", Context.MODE_PRIVATE)
        positionidEmoji = position_sharedPreferences!!.getString("positionEmoji", "")

        color_sharedPreferences = context!!.getSharedPreferences("Color", Context.MODE_PRIVATE)
        coloridKnob = color_sharedPreferences!!.getString("colorKnob", "")

        position_sharedPreferences =
            context!!.getSharedPreferences("Position", Context.MODE_PRIVATE)
        positionidKnob = position_sharedPreferences!!.getString("positionKnob", "")

        color_sharedPreferences = context!!.getSharedPreferences("Color", Context.MODE_PRIVATE)
        coloridIos = color_sharedPreferences!!.getString("colorIos", "")

        position_sharedPreferences =
            context!!.getSharedPreferences("Position", Context.MODE_PRIVATE)
        positionidIos = position_sharedPreferences!!.getString("positionIos", "")

        color_sharedPreferences = context!!.getSharedPreferences("Color", Context.MODE_PRIVATE)
        coloridAndroid11 = color_sharedPreferences!!.getString("colorAndroid11", "")

        position_sharedPreferences =
            context!!.getSharedPreferences("Position", Context.MODE_PRIVATE)
        positionidAndroid11 = position_sharedPreferences!!.getString("positionAndroid11", "")

        color_sharedPreferences = context!!.getSharedPreferences("Color", Context.MODE_PRIVATE)
        coloridAndroidHorizontal = color_sharedPreferences!!.getString("colorAndroidHorizontal", "")

        position_sharedPreferences =
            context!!.getSharedPreferences("Position", Context.MODE_PRIVATE)
        positionidAndroidHorizontal =
            position_sharedPreferences!!.getString("positionAndroidHorizontal", "")

        color_sharedPreferences = context!!.getSharedPreferences("Color", Context.MODE_PRIVATE)
        coloridOneUi2 = color_sharedPreferences!!.getString("colorOneUi2", "")

        position_sharedPreferences =
            context!!.getSharedPreferences("Position", Context.MODE_PRIVATE)
        positionidOneUi2 = position_sharedPreferences!!.getString("positionOneUi2", "")


        if (prefUtil!!.getInt("selectedItem",0) == 1) {
            android10()
        }
        if (styleid == "2") {
            android()
        }
        if (styleid == "3") {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window10()
            }
        }
        if (styleid == "4") {
            elasticSeekbar()
        }
        if (styleid == "5") {
            emojiSeekbar()
        }
        if (styleid == "6") {
            knobSeekbar()
        }
        if (styleid == "7") {
            iosSeekbar()
        }
        if (styleid == "8") {
            android11Seekbar()
        }
        if (styleid == "9") {
            androidHorizontalSeekbar()
        }
        if (styleid == "10") {
            OneUi2Seekbar()
        }
    }

    //============================================================ONE UI 2 SEEKBAR=============================================================================//

    private fun OneUi2Seekbar() {
        layoutInflater =
            context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        // inflating the view with the custom layout created
        mView = layoutInflater!!.inflate(layout.style_10_full, null)
        audioManager = context!!.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        oneUi_2_music_seekbar = mView!!.findViewById<SeekBar>(id.oneUi_2_musicseekbar)
        oneUi_2_ring_seekbar = mView!!.findViewById<SeekBar>(id.oneUi_2_ringseekbar)
        oneUi_2_alarm_seekbar = mView!!.findViewById<SeekBar>(id.oneUi_2_alarmseekbar)
        oneUi_2_call_seekbar = mView!!.findViewById<SeekBar>(id.oneUi_2_callseekbar)
        hiddenview = mView!!.findViewById(id.hidden_view)

        musicImage = mView!!.findViewById(id.music_icon_oneUi_2)
        ringImage = mView!!.findViewById(id.oneUi_2_ringicon)
        alarmImage = mView!!.findViewById(id.oneUi_2_alarmicon)
        callImage = mView!!.findViewById(id.oneUi_2_callicon)

        oneUi_2_music_seekbar!!.max = (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_MUSIC))
        oneUi_2_music_seekbar!!.progress =
            (audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC));
        if (oneUi_2_music_seekbar!!.progress == 0) {
            if (coloridOneUi2 == "green") {
                musicImage!!.setImageResource(drawable.ic_play_cross_green)
            } else if (coloridOneUi2 == "teal") {
                musicImage!!.setImageResource(drawable.ic_play_cross_teal)
            } else if (coloridOneUi2 == "red") {
                musicImage!!.setImageResource(drawable.ic_play_cross_red)
            } else if (coloridOneUi2 == "pink") {
                musicImage!!.setImageResource(drawable.ic_play_cross_pink)
            } else {
                musicImage!!.setImageResource(drawable.ic_play_cross)
            }
//            musicImage!!.setImageResource(R.drawable.ic_play_cross)
        }

        oneUi_2_ring_seekbar!!.max = (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_RING))
        oneUi_2_ring_seekbar!!.progress =
            (audioManager!!.getStreamVolume(AudioManager.STREAM_RING));
        if (oneUi_2_ring_seekbar!!.progress == 0) {
            if (coloridOneUi2 == "green") {
                ringImage!!.setImageResource(drawable.ic_notifications_off_android10)
            } else if (coloridOneUi2 == "teal") {
                ringImage!!.setImageResource(drawable.ic_teal_notifications_off_android10)
            } else if (coloridOneUi2 == "red") {
                ringImage!!.setImageResource(drawable.ic_red_notifications_off_android10)
            } else if (coloridOneUi2 == "pink") {
                ringImage!!.setImageResource(drawable.ic_pink_notifications_off_android10)
            } else {
                ringImage!!.setImageResource(drawable.ic_blue_notifications_off_android10)
            }
//            ringImage!!.setImageResource(R.drawable.ic_notifications_off_ui2)
        }

        oneUi_2_alarm_seekbar!!.max = (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_ALARM))
        oneUi_2_alarm_seekbar!!.progress =
            (audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM));
        if (oneUi_2_alarm_seekbar!!.progress == 0) {
            if (coloridOneUi2 == "green") {
                alarmImage!!.setImageResource(drawable.ic_baseline_alarm_off_android10)
            } else if (coloridOneUi2 == "teal") {
                alarmImage!!.setImageResource(drawable.ic_teal_alarm_off_android10)
            } else if (coloridOneUi2 == "red") {
                alarmImage!!.setImageResource(drawable.ic_red_alarm_off_android10)
            } else if (coloridOneUi2 == "pink") {
                alarmImage!!.setImageResource(drawable.ic_pink_alarm_off_android10)
            } else {
                alarmImage!!.setImageResource(drawable.ic_blue_alarm_off_android10)
            }
//            alarmImage!!.setImageResource(R.drawable.ic_alarm_off_ui2)
        }

        oneUi_2_call_seekbar!!.max =
            (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL))
        oneUi_2_call_seekbar!!.progress =
            (audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL));

        myRunnable = Runnable {
            Log.e("TESTTAG", "onCreate: ")
            closeWindow()
        }

        start()

        seekbarname_type = "music"
        oneUi_2_music_seekbar!!.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                restart()

                seekbarname_type = "music"
                // write custom code for progress is changed
                audioManager!!.setStreamVolume(
                    AudioManager.STREAM_MUSIC,
                    progress, 0
                )
                if (oneUi_2_music_seekbar!!.progress > 0) {
                    if (coloridOneUi2 == "teal") {
                        musicImage!!.setImageResource(drawable.ic_music_ui2_teal)
                    } else if (coloridOneUi2 == "green") {
                        musicImage!!.setImageResource(drawable.ic_music_ui2_green)
                    } else if (coloridOneUi2 == "pink") {
                        musicImage!!.setImageResource(drawable.ic_music_ui2_pink)
                    } else if (coloridOneUi2 == "red") {
                        musicImage!!.setImageResource(drawable.ic_music_ui2_red)
                    } else {
                        musicImage!!.setImageResource(drawable.ic_music_ui2)
                    }
//                    musicImage!!.setImageResource(R.drawable.ic_music_ui2);
                }
                if (oneUi_2_music_seekbar!!.progress == 0) {
                    if (coloridOneUi2 == "teal") {
                        musicImage!!.setImageResource(drawable.ic_play_cross_teal)
                    } else if (coloridOneUi2 == "green") {
                        musicImage!!.setImageResource(drawable.ic_play_cross_green)
                    } else if (coloridOneUi2 == "pink") {
                        musicImage!!.setImageResource(drawable.ic_play_cross_pink)
                    } else if (coloridOneUi2 == "red") {
                        musicImage!!.setImageResource(drawable.ic_play_cross_red)
                    } else {
                        musicImage!!.setImageResource(drawable.ic_play_cross)
                    }
//                    musicImage!!.setImageResource(R.drawable.ic_play_cross)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })


        oneUi_2_ring_seekbar!!.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                restart()

                seekbarname_type = "ring"
                // write custom code for progress is changed
                audioManager!!.setStreamVolume(
                    AudioManager.STREAM_RING,
                    progress, 0
                )
                if (oneUi_2_ring_seekbar!!.progress > 0) {
                    if (coloridOneUi2 == "green") {
                        ringImage!!.setImageResource(drawable.ic_notification_android10)
                    } else if (coloridOneUi2 == "red") {
                        ringImage!!.setImageResource(drawable.ic_red_notifications_android10)
                    } else if (coloridOneUi2 == "teal") {
                        ringImage!!.setImageResource(drawable.ic_teal_notifications_android10)
                    } else if (coloridOneUi2 == "pink") {
                        ringImage!!.setImageResource(drawable.ic_pink_notifications_android10)
                    } else {
                        ringImage!!.setImageResource(drawable.ic_blue_notifications_android10)
                    }
//                    ringImage!!.setImageResource(R.drawable.ic_notifications_ui2);
                }
                if (oneUi_2_ring_seekbar!!.progress == 0) {
                    if (coloridOneUi2 == "green") {
                        ringImage!!.setImageResource(drawable.ic_notifications_off_android10)
                    } else if (coloridOneUi2 == "red") {
                        ringImage!!.setImageResource(drawable.ic_red_notifications_off_android10)
                    } else if (coloridOneUi2 == "teal") {
                        ringImage!!.setImageResource(drawable.ic_teal_notifications_off_android10)
                    } else if (coloridOneUi2 == "pink") {
                        ringImage!!.setImageResource(drawable.ic_pink_notifications_off_android10)
                    } else {
                        ringImage!!.setImageResource(drawable.ic_blue_notifications_off_android10)
                    }
//                    ringImage!!.setImageResource(R.drawable.ic_notifications_off_ui2)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        oneUi_2_alarm_seekbar!!.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                restart()

                seekbarname_type = "alarm"
                // write custom code for progress is changed
                audioManager!!.setStreamVolume(
                    AudioManager.STREAM_ALARM,
                    progress, 0
                )
                if (oneUi_2_alarm_seekbar!!.progress > 0) {
                    if (coloridOneUi2 == "green") {
                        alarmImage!!.setImageResource(drawable.ic_alarm_android10)
                    } else if (coloridOneUi2 == "red") {
                        alarmImage!!.setImageResource(drawable.ic_red_alarm_android10);
                    } else if (coloridOneUi2 == "teal") {
                        alarmImage!!.setImageResource(drawable.ic_teal_alarm_android10);
                    } else if (coloridOneUi2 == "pink") {
                        alarmImage!!.setImageResource(drawable.ic_pink_alarm_android10);
                    } else {
                        alarmImage!!.setImageResource(drawable.ic_blue_alarm_android10); }
//                    alarmImage!!.setImageResource(R.drawable.ic_alarm_ui2);
                }
                if (oneUi_2_alarm_seekbar!!.progress == 0) {
                    if (coloridOneUi2 == "green") {
                        alarmImage!!.setImageResource(drawable.ic_baseline_alarm_off_android10)
                    } else if (coloridOneUi2 == "red") {
                        alarmImage!!.setImageResource(drawable.ic_red_alarm_off_android10);
                    } else if (coloridOneUi2 == "teal") {
                        alarmImage!!.setImageResource(drawable.ic_teal_alarm_off_android10);
                    } else if (coloridOneUi2 == "pink") {
                        alarmImage!!.setImageResource(drawable.ic_pink_alarm_off_android10);
                    } else {
                        alarmImage!!.setImageResource(drawable.ic_blue_alarm_off_android10); }
//                    alarmImage!!.setImageResource(R.drawable.ic_alarm_off_ui2)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        oneUi_2_call_seekbar!!.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                seek: SeekBar,
                progress: Int, fromUser: Boolean
            ) {
                restart()

                seekbarname_type = "call"
                // write custom code for progress is changed
                audioManager!!.setStreamVolume(
                    AudioManager.STREAM_VOICE_CALL,
                    progress, 0
                )
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (coloridOneUi2 == "red") {
                if (oneUi_2_music_seekbar!!.progress > 0) {
                    musicImage!!.setImageResource(drawable.ic_music_ui2_red)
                } else if (oneUi_2_music_seekbar!!.progress == 0) {
                    musicImage!!.setImageResource(drawable.ic_play_cross_red)
                }
                if (oneUi_2_ring_seekbar!!.progress > 0) {
                    ringImage!!.setImageResource(drawable.ic_red_notifications_android10)
                } else if (oneUi_2_ring_seekbar!!.progress == 0) {
                    ringImage!!.setImageResource(drawable.ic_red_notifications_off_android10)
                }
                if (oneUi_2_alarm_seekbar!!.progress > 0) {
                    alarmImage!!.setImageResource(drawable.ic_red_alarm_android10)
                } else if (oneUi_2_alarm_seekbar!!.progress == 0) {
                    alarmImage!!.setImageResource(drawable.ic_red_alarm_off_android10)
                }
                callImage!!.setImageResource(drawable.ic_red_call_android10)

                oneUi_2_music_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.red, null
                        )
                    )
                )
                oneUi_2_music_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_red, null
                    )
                ))
                oneUi_2_ring_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.red, null
                        )
                    )
                )
                oneUi_2_ring_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_red, null
                    )
                ))
                oneUi_2_alarm_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.red, null
                        )
                    )
                )
                oneUi_2_alarm_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_red, null
                    )
                ))
                oneUi_2_call_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.red, null
                        )
                    )
                )
                oneUi_2_call_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_red, null
                    )
                ))
            } else if (coloridOneUi2 == "teal") {
                if (oneUi_2_music_seekbar!!.progress > 0) {
                    musicImage!!.setImageResource(drawable.ic_music_ui2_teal)
                } else if (oneUi_2_music_seekbar!!.progress == 0) {
                    musicImage!!.setImageResource(drawable.ic_play_cross_teal)
                }
                if (oneUi_2_ring_seekbar!!.progress > 0) {
                    ringImage!!.setImageResource(drawable.ic_teal_notifications_android10)
                } else if (oneUi_2_ring_seekbar!!.progress == 0) {
                    ringImage!!.setImageResource(drawable.ic_teal_notifications_off_android10)
                }
                if (oneUi_2_alarm_seekbar!!.progress > 0) {
                    alarmImage!!.setImageResource(drawable.ic_teal_alarm_android10)
                } else if (oneUi_2_alarm_seekbar!!.progress == 0) {
                    alarmImage!!.setImageResource(drawable.ic_teal_alarm_off_android10)
                }
                callImage!!.setImageResource(drawable.ic_teal_call_android10)

                oneUi_2_music_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.teal_200, null
                        )
                    )
                )
                oneUi_2_music_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_teal_200, null
                    )
                ))
                oneUi_2_ring_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.teal_200, null
                        )
                    )
                )
                oneUi_2_ring_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_teal_200, null
                    )
                ))
                oneUi_2_alarm_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.teal_200, null
                        )
                    )
                )
                oneUi_2_alarm_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_teal_200, null
                    )
                ))
                oneUi_2_call_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.teal_200, null
                        )
                    )
                )
                oneUi_2_call_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_teal_200, null
                    )
                ))
            } else if (coloridOneUi2 == "pink") {
                if (oneUi_2_music_seekbar!!.progress > 0) {
                    musicImage!!.setImageResource(drawable.ic_music_ui2_pink)
                } else if (oneUi_2_music_seekbar!!.progress == 0) {
                    musicImage!!.setImageResource(drawable.ic_play_cross_pink)
                }
                if (oneUi_2_ring_seekbar!!.progress > 0) {
                    ringImage!!.setImageResource(drawable.ic_pink_notifications_android10)
                } else if (oneUi_2_ring_seekbar!!.progress == 0) {
                    ringImage!!.setImageResource(drawable.ic_pink_notifications_off_android10)

                }
                if (oneUi_2_alarm_seekbar!!.progress > 0) {
                    alarmImage!!.setImageResource(drawable.ic_pink_alarm_android10)
                } else if (oneUi_2_alarm_seekbar!!.progress == 0) {
                    alarmImage!!.setImageResource(drawable.ic_pink_alarm_off_android10)
                }
                callImage!!.setImageResource(drawable.ic_pink_call_android10)

                oneUi_2_music_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.pink, null
                        )
                    )
                )
                oneUi_2_music_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_pink, null
                    )
                ))
                oneUi_2_ring_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.pink, null
                        )
                    )
                )
                oneUi_2_ring_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_pink, null
                    )
                ))
                oneUi_2_alarm_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.pink, null
                        )
                    )
                )
                oneUi_2_alarm_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_pink, null
                    )
                ))
                oneUi_2_call_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.pink, null
                        )
                    )
                )
                oneUi_2_call_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_pink, null
                    )
                ))
            } else if (coloridOneUi2 == "green") {
                if (oneUi_2_music_seekbar!!.progress > 0) {
                    musicImage!!.setImageResource(drawable.ic_music_ui2_green)
                } else if (oneUi_2_music_seekbar!!.progress == 0) {
                    musicImage!!.setImageResource(drawable.ic_play_cross_green)
                }
                if (oneUi_2_ring_seekbar!!.progress > 0) {
                    ringImage!!.setImageResource(drawable.ic_notification_android10)
                } else if (oneUi_2_ring_seekbar!!.progress == 0) {
                    ringImage!!.setImageResource(drawable.ic_notifications_off_android10)

                }
                if (oneUi_2_alarm_seekbar!!.progress > 0) {
                    alarmImage!!.setImageResource(drawable.ic_alarm_android10)
                } else if (oneUi_2_alarm_seekbar!!.progress == 0) {
                    alarmImage!!.setImageResource(drawable.ic_baseline_alarm_off_android10)
                }
                callImage!!.setImageResource(drawable.ic_call_android10)

                oneUi_2_music_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.green, null
                        )
                    )
                )
                oneUi_2_music_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_green, null
                    )
                ))
                oneUi_2_ring_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.green, null
                        )
                    )
                )
                oneUi_2_ring_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_green, null
                    )
                ))
                oneUi_2_alarm_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.green, null
                        )
                    )
                )
                oneUi_2_alarm_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_green, null
                    )
                ))
                oneUi_2_call_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.green, null
                        )
                    )
                )
                oneUi_2_call_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_green, null
                    )
                ))
            } else if (coloridOneUi2 == "default") {
                if (oneUi_2_music_seekbar!!.progress > 0) {
                    musicImage!!.setImageResource(drawable.ic_music_ui2)
                } else if (oneUi_2_music_seekbar!!.progress == 0) {
                    musicImage!!.setImageResource(drawable.ic_play_cross)
                }
                if (oneUi_2_ring_seekbar!!.progress > 0) {
                    ringImage!!.setImageResource(drawable.ic_blue_notifications_android10)
                } else if (oneUi_2_ring_seekbar!!.progress == 0) {
                    ringImage!!.setImageResource(drawable.ic_blue_notifications_off_android10)

                }
                if (oneUi_2_alarm_seekbar!!.progress > 0) {
                    alarmImage!!.setImageResource(drawable.ic_blue_alarm_android10)
                } else if (oneUi_2_alarm_seekbar!!.progress == 0) {
                    alarmImage!!.setImageResource(drawable.ic_blue_alarm_off_android10)
                }
                callImage!!.setImageResource(drawable.ic_blue_call_android)

                oneUi_2_music_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.blue, null
                        )
                    )
                )
                oneUi_2_music_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_blue, null
                    )
                ))
                oneUi_2_ring_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.blue, null
                        )
                    )
                )
                oneUi_2_ring_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_blue, null
                    )
                ))
                oneUi_2_alarm_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.blue, null
                        )
                    )
                )
                oneUi_2_alarm_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_blue, null
                    )
                ))
                oneUi_2_call_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.blue, null
                        )
                    )
                )
                oneUi_2_call_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_blue, null
                    )
                ))
            }
        }

        btn_show_more_OneUi2 = mView!!.findViewById(id.btn_show_more)
        btn_show_more_OneUi2!!.setOnClickListener {
            if (hiddenview!!.visibility == View.VISIBLE) {
                hiddenview!!.visibility = View.GONE
                seekbarname_type = "music"
            } else
                if (hiddenview!!.visibility == View.GONE) {
                    hiddenview!!.visibility = View.VISIBLE
                    seekbarname_type = "music"
                }
            mWindowManager!!.updateViewLayout(mView, mParams)
        }

        if (positionidOneUi2 == "left") {
            mParams!!.gravity = Gravity.LEFT
            mWindowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        } else if (positionidOneUi2 == "right") {
            mParams!!.gravity = Gravity.RIGHT
            mWindowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        } else/* if(positionid=="default")*/ {
            mParams!!.gravity = Gravity.RIGHT
            mWindowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        }
    }

    //========================================================ANDROID HORIZONTAL SEEKBAR========================================================================//

    private fun androidHorizontalSeekbar() {
        layoutInflater =
            context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        // inflating the view with the custom layout created
        mView = layoutInflater!!.inflate(layout.style_9_full, null)
        audioManager = context!!.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        androidHorizontal_music_seekbar =
            mView!!.findViewById<SeekBar>(id.androidHorizontal_music_seekbar)
//        androidHorizontal_ring_seekbar =
//            mView!!.findViewById<SeekBar>(id.androidHorizontal_ring_seekbar)
//        androidHorizontal_alarm_seekbar =
//            mView!!.findViewById<SeekBar>(id.androidHorizontal_alarm_seekbar)
//        androidHorizontal_call_seekbar =
//            mView!!.findViewById<SeekBar>(id.androidHorizontal_call_seekbar)
        hiddenview = mView!!.findViewById(id.hidden_view)

        musicImage = mView!!.findViewById(id.androidHorizontal_music_icon)
//        ringImage = mView!!.findViewById(id.androidHorizontal_ring_icon)
//        alarmImage = mView!!.findViewById(id.androidHorizontal_alarm_icon)
//        callImage = mView!!.findViewById(id.androidHorizontal_call_icon)

        androidHorizontal_music_seekbar!!.max =
            (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_MUSIC))
        androidHorizontal_music_seekbar!!.progress =
            (audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC));

        if (androidHorizontal_music_seekbar!!.progress == 0) {
            if (coloridAndroidHorizontal == "green") {
                musicImage!!.setImageResource(drawable.ic_android10_music_off)
            } else if (coloridAndroidHorizontal == "teal") {
                musicImage!!.setImageResource(drawable.ic_teal_music_off_android10)
            } else if (coloridAndroidHorizontal == "red") {
                musicImage!!.setImageResource(drawable.ic_red_music_off_android10)
            } else if (coloridAndroidHorizontal == "pink") {
                musicImage!!.setImageResource(drawable.ic_pink_music_off_android10)
            } else {
                musicImage!!.setImageResource(drawable.ic_blue_music_off_android10)
            }
//            musicImage!!.setImageResource(R.drawable.ic_music_off_black)
        }

        androidHorizontal_ring_seekbar!!.max =
            (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_RING))
        androidHorizontal_ring_seekbar!!.progress =
            (audioManager!!.getStreamVolume(AudioManager.STREAM_RING));

        if (androidHorizontal_ring_seekbar!!.progress == 0) {
            if (coloridAndroidHorizontal == "green") {
                ringImage!!.setImageResource(drawable.ic_notifications_off_android10)
            } else if (coloridAndroidHorizontal == "teal") {
                ringImage!!.setImageResource(drawable.ic_teal_notifications_off_android10)
            } else if (coloridAndroidHorizontal == "red") {
                ringImage!!.setImageResource(drawable.ic_red_notifications_off_android10)
            } else if (coloridAndroidHorizontal == "pink") {
                ringImage!!.setImageResource(drawable.ic_pink_notifications_off_android10)
            } else {
                ringImage!!.setImageResource(drawable.ic_blue_notifications_off_android10)
            }
//            ringImage!!.setImageResource(R.drawable.ic_notifications_off_black)
        }

        androidHorizontal_alarm_seekbar!!.max =
            (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_ALARM))
        androidHorizontal_alarm_seekbar!!.progress =
            (audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM));

        if (androidHorizontal_alarm_seekbar!!.progress == 0) {
            if (coloridAndroidHorizontal == "green") {
                alarmImage!!.setImageResource(drawable.ic_baseline_alarm_off_android10)
            } else if (coloridAndroidHorizontal == "teal") {
                alarmImage!!.setImageResource(drawable.ic_teal_alarm_off_android10)
            } else if (coloridAndroidHorizontal == "red") {
                alarmImage!!.setImageResource(drawable.ic_red_alarm_off_android10)
            } else if (coloridAndroidHorizontal == "pink") {
                alarmImage!!.setImageResource(drawable.ic_pink_alarm_off_android10)
            } else {
                alarmImage!!.setImageResource(drawable.ic_blue_alarm_off_android10)
            }
//            alarmImage!!.setImageResource(R.drawable.ic_alarm_off_black)
        }

        androidHorizontal_call_seekbar!!.max =
            (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL))
        androidHorizontal_call_seekbar!!.progress =
            (audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL));

        myRunnable = Runnable {
            Log.e("TESTTAG", "onCreate: ")
            closeWindow()
        }

        start()

        seekbarname_type = "music"
        androidHorizontal_music_seekbar!!.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                restart()
                seekbarname_type = "music"
                // write custom code for progress is changed
                audioManager!!.setStreamVolume(
                    AudioManager.STREAM_MUSIC,
                    progress, 0
                )
                if (androidHorizontal_music_seekbar!!.progress > 0) {
                    if (coloridAndroidHorizontal == "teal") {
                        musicImage!!.setImageResource(drawable.ic_teal_music_note_android10)
                    } else if (coloridAndroidHorizontal == "green") {
                        musicImage!!.setImageResource(drawable.ic_musicnote_android10)
                    } else if (coloridAndroidHorizontal == "pink") {
                        musicImage!!.setImageResource(drawable.ic_pink_music_note_android10)
                    } else if (coloridAndroidHorizontal == "red") {
                        musicImage!!.setImageResource(drawable.ic_red_music_note_android10)
                    } else {
                        musicImage!!.setImageResource(drawable.ic_blue_music_note_android10)
                    }
//                    musicImage!!.setImageResource(R.drawable.ic_music_window10)
                }
                if (androidHorizontal_music_seekbar!!.progress == 0) {
                    if (coloridAndroidHorizontal == "teal") {
                        musicImage!!.setImageResource(drawable.ic_teal_music_off_android10)
                    } else if (coloridAndroidHorizontal == "green") {
                        musicImage!!.setImageResource(drawable.ic_android10_music_off)
                    } else if (coloridAndroidHorizontal == "pink") {
                        musicImage!!.setImageResource(drawable.ic_pink_music_off_android10)
                    } else if (coloridAndroidHorizontal == "red") {
                        musicImage!!.setImageResource(drawable.ic_red_music_off_android10)
                    } else {
                        musicImage!!.setImageResource(drawable.ic_blue_music_off_android10)
                    }
//                    musicImage!!.setImageResource(R.drawable.ic_music_off_black)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        androidHorizontal_ring_seekbar!!.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                restart()
                seekbarname_type = "ring"
                // write custom code for progress is changed
                audioManager!!.setStreamVolume(
                    AudioManager.STREAM_RING,
                    progress, 0
                )
                if (androidHorizontal_ring_seekbar!!.progress > 0) {
                    if (coloridAndroidHorizontal == "green") {
                        ringImage!!.setImageResource(drawable.ic_notification_android10)
                    } else if (coloridAndroidHorizontal == "red") {
                        ringImage!!.setImageResource(drawable.ic_red_notifications_android10)
                    } else if (coloridAndroidHorizontal == "teal") {
                        ringImage!!.setImageResource(drawable.ic_teal_notifications_android10)
                    } else if (coloridAndroidHorizontal == "pink") {
                        ringImage!!.setImageResource(drawable.ic_pink_notifications_android10)
                    } else {
                        ringImage!!.setImageResource(drawable.ic_blue_notifications_android10)
                    }
//                    ringImage!!.setImageResource(R.drawable.ic_notification_window10);
                }
                if (androidHorizontal_ring_seekbar!!.progress == 0) {
                    if (coloridAndroidHorizontal == "green") {
                        ringImage!!.setImageResource(drawable.ic_notifications_off_android10)
                    } else if (coloridAndroidHorizontal == "red") {
                        ringImage!!.setImageResource(drawable.ic_red_notifications_off_android10)
                    } else if (coloridAndroidHorizontal == "teal") {
                        ringImage!!.setImageResource(drawable.ic_teal_notifications_off_android10)
                    } else if (coloridAndroidHorizontal == "pink") {
                        ringImage!!.setImageResource(drawable.ic_pink_notifications_off_android10)
                    } else {
                        ringImage!!.setImageResource(drawable.ic_blue_notifications_off_android10)
                    }
//                    ringImage!!.setImageResource(R.drawable.ic_notifications_off_black)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        androidHorizontal_alarm_seekbar!!.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                restart()

                seekbarname_type = "alarm"
                // write custom code for progress is changed
                audioManager!!.setStreamVolume(
                    AudioManager.STREAM_ALARM,
                    progress, 0
                )
                if (androidHorizontal_alarm_seekbar!!.progress > 0) {
                    if (coloridAndroidHorizontal == "green") {
                        alarmImage!!.setImageResource(drawable.ic_alarm_android10)
                    } else if (coloridAndroidHorizontal == "red") {
                        alarmImage!!.setImageResource(drawable.ic_red_alarm_android10);
                    } else if (coloridAndroidHorizontal == "teal") {
                        alarmImage!!.setImageResource(drawable.ic_teal_alarm_android10);
                    } else if (coloridAndroidHorizontal == "pink") {
                        alarmImage!!.setImageResource(drawable.ic_pink_alarm_android10);
                    } else {
                        alarmImage!!.setImageResource(drawable.ic_blue_alarm_android10); }
//                    alarmImage!!.setImageResource(R.drawable.ic_alarm_window10);
                }
                if (androidHorizontal_alarm_seekbar!!.progress == 0) {
                    if (coloridAndroidHorizontal == "green") {
                        alarmImage!!.setImageResource(drawable.ic_baseline_alarm_off_android10)
                    } else if (coloridAndroidHorizontal == "red") {
                        alarmImage!!.setImageResource(drawable.ic_red_alarm_off_android10);
                    } else if (coloridAndroidHorizontal == "teal") {
                        alarmImage!!.setImageResource(drawable.ic_teal_alarm_off_android10);
                    } else if (coloridAndroidHorizontal == "pink") {
                        alarmImage!!.setImageResource(drawable.ic_pink_alarm_off_android10);
                    } else {
                        alarmImage!!.setImageResource(drawable.ic_blue_alarm_off_android10); }
//                    alarmImage!!.setImageResource(R.drawable.ic_alarm_off_black)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        androidHorizontal_call_seekbar!!.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                restart()

                seekbarname_type = "call"
                // write custom code for progress is changed
                audioManager!!.setStreamVolume(
                    AudioManager.STREAM_VOICE_CALL,
                    progress, 0
                )
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (coloridAndroidHorizontal == "red") {
                if (androidHorizontal_music_seekbar!!.progress > 0) {
                    musicImage!!.setImageResource(drawable.ic_red_music_note_android10)
                } else if (androidHorizontal_music_seekbar!!.progress == 0) {
                    musicImage!!.setImageResource(drawable.ic_red_music_off_android10)
                }
                if (androidHorizontal_ring_seekbar!!.progress > 0) {
                    ringImage!!.setImageResource(drawable.ic_red_notifications_android10)
                } else if (androidHorizontal_ring_seekbar!!.progress == 0) {
                    ringImage!!.setImageResource(drawable.ic_red_notifications_off_android10)
                }
                if (androidHorizontal_alarm_seekbar!!.progress > 0) {
                    alarmImage!!.setImageResource(drawable.ic_red_alarm_android10)
                } else if (androidHorizontal_alarm_seekbar!!.progress == 0) {
                    alarmImage!!.setImageResource(drawable.ic_red_alarm_off_android10)
                }
                callImage!!.setImageResource(drawable.ic_red_call_android10)

                androidHorizontal_music_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.red, null
                        )
                    )
                )
                androidHorizontal_music_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.red, null
                    )
                ))
                androidHorizontal_ring_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.red, null
                        )
                    )
                )
                androidHorizontal_ring_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.red, null
                    )
                ))
                androidHorizontal_alarm_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.red, null
                        )
                    )
                )
                androidHorizontal_alarm_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.red, null
                    )
                ))
                androidHorizontal_call_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.red, null
                        )
                    )
                )
                androidHorizontal_call_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.red, null
                    )
                ))
            } else if (coloridAndroidHorizontal == "teal") {
                if (androidHorizontal_music_seekbar!!.progress > 0) {
                    musicImage!!.setImageResource(drawable.ic_teal_music_note_android10)
                } else if (androidHorizontal_music_seekbar!!.progress == 0) {
                    musicImage!!.setImageResource(drawable.ic_teal_music_off_android10)
                }
                if (androidHorizontal_ring_seekbar!!.progress > 0) {
                    ringImage!!.setImageResource(drawable.ic_teal_notifications_android10)
                } else if (androidHorizontal_ring_seekbar!!.progress == 0) {
                    ringImage!!.setImageResource(drawable.ic_teal_notifications_off_android10)
                }
                if (androidHorizontal_alarm_seekbar!!.progress > 0) {
                    alarmImage!!.setImageResource(drawable.ic_teal_alarm_android10)
                } else if (androidHorizontal_alarm_seekbar!!.progress == 0) {
                    alarmImage!!.setImageResource(drawable.ic_teal_alarm_off_android10)
                }
                callImage!!.setImageResource(drawable.ic_teal_call_android10)

                androidHorizontal_music_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.teal_200, null
                        )
                    )
                )
                androidHorizontal_music_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.teal_200, null
                    )
                ))
                androidHorizontal_ring_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.teal_200, null
                        )
                    )
                )
                androidHorizontal_ring_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.teal_200, null
                    )
                ))
                androidHorizontal_alarm_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.teal_200, null
                        )
                    )
                )
                androidHorizontal_alarm_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.teal_200, null
                    )
                ))
                androidHorizontal_call_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.teal_200, null
                        )
                    )
                )
                androidHorizontal_call_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.teal_200, null
                    )
                ))
            } else if (coloridAndroidHorizontal == "green") {
                if (androidHorizontal_music_seekbar!!.progress > 0) {
                    musicImage!!.setImageResource(drawable.ic_musicnote_android10)
                } else if (androidHorizontal_music_seekbar!!.progress == 0) {
                    musicImage!!.setImageResource(drawable.ic_android10_music_off)
                }
                if (androidHorizontal_ring_seekbar!!.progress > 0) {
                    ringImage!!.setImageResource(drawable.ic_notification_android10)
                } else if (androidHorizontal_ring_seekbar!!.progress == 0) {
                    ringImage!!.setImageResource(drawable.ic_notifications_off_android10)

                }
                if (androidHorizontal_alarm_seekbar!!.progress > 0) {
                    alarmImage!!.setImageResource(drawable.ic_alarm_android10)
                } else if (androidHorizontal_alarm_seekbar!!.progress == 0) {
                    alarmImage!!.setImageResource(drawable.ic_baseline_alarm_off_android10)
                }
                callImage!!.setImageResource(drawable.ic_call_android10)

                androidHorizontal_music_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.green, null
                        )
                    )
                )
                androidHorizontal_music_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.green, null
                    )
                ))
                androidHorizontal_ring_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.green, null
                        )
                    )
                )
                androidHorizontal_ring_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.green, null
                    )
                ))
                androidHorizontal_alarm_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.green, null
                        )
                    )
                )
                androidHorizontal_alarm_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.green, null
                    )
                ))
                androidHorizontal_call_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.green, null
                        )
                    )
                )
                androidHorizontal_call_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.green, null
                    )
                ))
            } else if (coloridAndroidHorizontal == "pink") {
                if (androidHorizontal_music_seekbar!!.progress > 0) {
                    musicImage!!.setImageResource(drawable.ic_pink_music_note_android10)
                } else if (androidHorizontal_music_seekbar!!.progress == 0) {
                    musicImage!!.setImageResource(drawable.ic_pink_music_off_android10)
                }
                if (androidHorizontal_ring_seekbar!!.progress > 0) {
                    ringImage!!.setImageResource(drawable.ic_pink_notifications_android10)
                } else if (androidHorizontal_ring_seekbar!!.progress == 0) {
                    ringImage!!.setImageResource(drawable.ic_pink_notifications_off_android10)

                }
                if (androidHorizontal_alarm_seekbar!!.progress > 0) {
                    alarmImage!!.setImageResource(drawable.ic_pink_alarm_android10)
                } else if (androidHorizontal_alarm_seekbar!!.progress == 0) {
                    alarmImage!!.setImageResource(drawable.ic_pink_alarm_off_android10)
                }
                callImage!!.setImageResource(drawable.ic_pink_call_android10)

                androidHorizontal_music_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.pink, null
                        )
                    )
                )
                androidHorizontal_music_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.pink, null
                    )
                ))
                androidHorizontal_ring_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.pink, null
                        )
                    )
                )
                androidHorizontal_ring_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.pink, null
                    )
                ))
                androidHorizontal_alarm_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.pink, null
                        )
                    )
                )
                androidHorizontal_alarm_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.pink, null
                    )
                ))
                androidHorizontal_call_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.pink, null
                        )
                    )
                )
                androidHorizontal_call_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.pink, null
                    )
                ))
            } else if (coloridAndroidHorizontal == "default") {
                if (androidHorizontal_music_seekbar!!.progress > 0) {
                    musicImage!!.setImageResource(drawable.ic_blue_music_note_android10)
                } else if (androidHorizontal_music_seekbar!!.progress == 0) {
                    musicImage!!.setImageResource(drawable.ic_blue_music_off_android10)
                }
                if (androidHorizontal_ring_seekbar!!.progress > 0) {
                    ringImage!!.setImageResource(drawable.ic_blue_notifications_android10)
                } else if (androidHorizontal_ring_seekbar!!.progress == 0) {
                    ringImage!!.setImageResource(drawable.ic_blue_notifications_off_android10)

                }
                if (androidHorizontal_alarm_seekbar!!.progress > 0) {
                    alarmImage!!.setImageResource(drawable.ic_blue_alarm_android10)
                } else if (androidHorizontal_alarm_seekbar!!.progress == 0) {
                    alarmImage!!.setImageResource(drawable.ic_blue_alarm_off_android10)
                }
                callImage!!.setImageResource(drawable.ic_blue_call_android)

                androidHorizontal_music_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.blue, null
                        )
                    )
                )
                androidHorizontal_music_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.blue, null
                    )
                ))
                androidHorizontal_ring_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.blue, null
                        )
                    )
                )
                androidHorizontal_ring_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.blue, null
                    )
                ))
                androidHorizontal_alarm_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.blue, null
                        )
                    )
                )
                androidHorizontal_alarm_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.blue, null
                    )
                ))
                androidHorizontal_call_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.blue, null
                        )
                    )
                )
                androidHorizontal_call_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.blue, null
                    )
                ))
            }
        }

        btn_show_more = mView!!.findViewById(id.btn_show_more)
        btn_show_more!!.setOnClickListener {
            hiddenview!!.visibility = View.VISIBLE

            btn_show_more!!.visibility = View.GONE
            btn_show_less!!.visibility = View.VISIBLE

            mWindowManager!!.updateViewLayout(mView, mParams)
        }

        btn_show_less = mView!!.findViewById(id.btn_show_less)
        btn_show_less!!.setOnClickListener {
            hiddenview!!.visibility = View.GONE

            btn_show_more!!.visibility = View.VISIBLE
            btn_show_less!!.visibility = View.GONE

            seekbarname_type = "music"
            mWindowManager!!.updateViewLayout(mView, mParams)
        }

        if (positionidAndroidHorizontal == "top") {
            mParams!!.gravity = Gravity.TOP
            mWindowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        } else if (positionidAndroidHorizontal == "bottom") {
            mParams!!.gravity = Gravity.BOTTOM
            mWindowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            btn_show_more!!.setImageResource(drawable.ic_arrow_up)
            btn_show_less!!.setImageResource(drawable.ic_arrow_down)
        } else/* if(positionid=="default")*/ {
            mParams!!.gravity = Gravity.TOP
            mWindowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        }
    }

    //==========================================================ANDROID 11 SEEKBAR==============================================================================//

    private fun android11Seekbar() {
        layoutInflater =
            context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        // inflating the view with the custom layout created
        mView = layoutInflater!!.inflate(layout.style_8_full, null)

        audioManager = context!!.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        android11_music_seekbar = mView!!.findViewById<VerticalSeekBar>(id.android11_music_seekbar)
        android11_ring_seekbar = mView!!.findViewById<VerticalSeekBar>(id.android11_ring_seekbar)
        android11_alarm_seekbar = mView!!.findViewById<VerticalSeekBar>(id.android11_alarm_seekbar)
        android11_call_seekbar = mView!!.findViewById<VerticalSeekBar>(id.android11_call_seekbar)
        android11_hidden_view = mView!!.findViewById(id.android11_hidden_view)

        musicImage = mView!!.findViewById(id.android11_music_image)
        ringImage = mView!!.findViewById(id.android11_ring_image)
        alarmImage = mView!!.findViewById(id.android11_alarm_image)
        android11_call_image = mView!!.findViewById(id.android11_call_image)

        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.O) {
            android11_music_seekbar!!.barCornerRadius = 43
            android11_ring_seekbar!!.barCornerRadius = 43
            android11_alarm_seekbar!!.barCornerRadius = 43
            android11_call_seekbar!!.barCornerRadius = 43
        } else if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            android11_music_seekbar!!.barCornerRadius = 60
            android11_ring_seekbar!!.barCornerRadius = 60
            android11_alarm_seekbar!!.barCornerRadius = 60
            android11_call_seekbar!!.barCornerRadius = 60
        }

        android11_music_seekbar!!.maxValue =
            (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_MUSIC))
        android11_music_seekbar!!.progress =
            (audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC))

        android11_call_seekbar!!.progress =
            (audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL))

        if (android11_music_seekbar!!.progress == 0) {
            musicImage!!.setImageResource(drawable.ic_music_off_black)
        }

        if (coloridAndroid11 == "red") {
            android11_music_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.red
            )
            android11_ring_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.red
            )
            android11_alarm_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.red
            )
            android11_call_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.red
            )
        } else if (coloridAndroid11 == "teal") {
            android11_music_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.teal_200
            )
            android11_ring_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.teal_200
            )
            android11_alarm_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.teal_200
            )
            android11_call_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.teal_200
            )
        } else if (coloridAndroid11 == "pink") {
            android11_music_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.pink
            )
            android11_ring_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.pink
            )
            android11_alarm_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.pink
            )
            android11_call_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.pink
            )
        } else if (coloridAndroid11 == "green") {
            android11_music_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.green
            )
            android11_ring_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.green
            )
            android11_alarm_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.green
            )
            android11_call_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.green
            )
        } else if (coloridAndroid11 == "blue") {
            android11_music_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.blue
            )
            android11_ring_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.blue
            )
            android11_alarm_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.blue
            )
            android11_call_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.blue
            )
        } else if (coloridAndroid11 == "default") {
            android11_music_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.white
            )
            android11_ring_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.white
            )
            android11_alarm_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.white
            )
            android11_call_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.white
            )
        }

        btn_show_more_android11 = mView!!.findViewById(id.btn_show_more)
        btn_show_more_android11!!.setOnClickListener {
            android11_hidden_view!!.visibility = View.VISIBLE

            btn_show_more_android11!!.visibility = View.GONE
//            btn_show_less!!.visibility=View.VISIBLE

            android11_ring_seekbar!!.maxValue =
                (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_RING))
            android11_ring_seekbar!!.progress =
                (audioManager!!.getStreamVolume(AudioManager.STREAM_RING))
            if (android11_ring_seekbar!!.progress == 0) {
                ringImage!!.setImageResource(drawable.ic_notifications_off_black)
            }

            android11_alarm_seekbar!!.maxValue =
                (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_ALARM))
            android11_alarm_seekbar!!.progress =
                (audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM))
            if (android11_alarm_seekbar!!.progress == 0) {
                alarmImage!!.setImageResource(drawable.ic_alarm_off_black)
            }

            android11_call_seekbar!!.maxValue =
                (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL))
            android11_call_seekbar!!.progress =
                (audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL))

            seekbarname_type = "music"

            mWindowManager!!.updateViewLayout(mView, mParams)
        }

        myRunnable = Runnable {
            Log.e("TESTTAG", "onCreate: ")
            closeWindow()
        }

        start()

        seekbarname_type = "music"

        android11_music_seekbar!!.setOnProgressChangeListener { progressValue ->
            Log.d("VerticalSeekBar", "PROGRESS CHANGED at value: $progressValue")

            restart()

            seekbarname_type = "music"
            audioManager!!.setStreamVolume(
                AudioManager.STREAM_MUSIC,
                progressValue, 0
            )
            if (android11_music_seekbar!!.progress > 0) {
                musicImage!!.setImageResource(drawable.ic_music_window10);
            } else if (android11_music_seekbar!!.progress == 0) {
                musicImage!!.setImageResource(drawable.ic_music_off_black)
            }
        }
        android11_music_seekbar!!.setOnReleaseListener { progressValue ->
            if (android11_music_seekbar!!.progress > 0) {
                musicImage!!.setImageResource(drawable.ic_music_window10);
            }
            if (android11_music_seekbar!!.progress == 0) {
                musicImage!!.setImageResource(drawable.ic_music_off_black)
            }
        }

        android11_ring_seekbar!!.setOnProgressChangeListener { progressValue ->

            restart()

            seekbarname_type = "ring"
            Log.d("VerticalSeekBar", "PROGRESS CHANGED at value: $progressValue")
            audioManager!!.setStreamVolume(
                AudioManager.STREAM_RING,
                progressValue, 0
            )
            if (android11_ring_seekbar!!.progress > 0) {
                ringImage!!.setImageResource(drawable.ic_notification_window10);
            } else if (android11_ring_seekbar!!.progress == 0) {
                ringImage!!.setImageResource(drawable.ic_notifications_off_black)
            }
        }
        android11_ring_seekbar!!.setOnReleaseListener { progressValue ->
            if (android11_ring_seekbar!!.progress > 0) {
                ringImage!!.setImageResource(drawable.ic_notification_window10);
            }
            if (android11_ring_seekbar!!.progress == 0) {
                ringImage!!.setImageResource(drawable.ic_notifications_off_black)
            }
        }

        android11_alarm_seekbar!!.setOnProgressChangeListener { progressValue ->

            restart()

            seekbarname_type = "alarm"
            Log.d("VerticalSeekBar", "PROGRESS CHANGED at value: $progressValue")
            audioManager!!.setStreamVolume(
                AudioManager.STREAM_ALARM,
                progressValue, 0
            )
            if (android11_alarm_seekbar!!.progress > 0) {
                alarmImage!!.setImageResource(drawable.ic_alarm_window10);
            } else if (android11_alarm_seekbar!!.progress == 0) {
                alarmImage!!.setImageResource(drawable.ic_alarm_off_black)
            }
        }
        android11_alarm_seekbar!!.setOnReleaseListener { progressValue ->
            if (android11_alarm_seekbar!!.progress > 0) {
                alarmImage!!.setImageResource(drawable.ic_alarm_window10);
            }
            if (android11_alarm_seekbar!!.progress == 0) {
                alarmImage!!.setImageResource(drawable.ic_alarm_off_black)
            }
        }

        android11_call_seekbar!!.setOnProgressChangeListener { progressValue ->

            restart()

            seekbarname_type = "call"
            Log.d("VerticalSeekBar", "PROGRESS CHANGED at value: $progressValue")
            audioManager!!.setStreamVolume(
                AudioManager.STREAM_VOICE_CALL,
                progressValue, 0
            )
        }

        if (positionidAndroid11 == "left") {
            mParams!!.gravity = Gravity.LEFT
            mWindowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        } else if (positionidAndroid11 == "right") {
            mParams!!.gravity = Gravity.RIGHT
            mWindowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        } else/* if(positionid=="default")*/ {
            mParams!!.gravity = Gravity.RIGHT
            mWindowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        }
    }

    //============================================================IOS SEEKBAR==============================================================================//

    private fun iosSeekbar() {
        layoutInflater =
            context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        // inflating the view with the custom layout created
        mView = layoutInflater!!.inflate(layout.style_7_full, null)

        audioManager = context!!.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        ios_music_seekbar = mView!!.findViewById<VerticalSeekBar>(id.ios_music_seekbar)
        ios_ring_seekbar = mView!!.findViewById<VerticalSeekBar>(id.ios_ring_seekbar)
        ios_alarm_seekbar = mView!!.findViewById<VerticalSeekBar>(id.ios_alarm_seekbar)
        ios_call_seekbar = mView!!.findViewById<VerticalSeekBar>(id.ios_call_seekbar)
//        ios_hidden_view = mView!!.findViewById(id.ios_hidden_view)

        musicImage = mView!!.findViewById(id.ios_music_image)
        ringImage = mView!!.findViewById(id.ios_ring_image)
        alarmImage = mView!!.findViewById(id.ios_alarm_image)
        ios_call_image = mView!!.findViewById(id.ios_call_image)



        ios_music_seekbar!!.maxValue =
            (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_MUSIC))
        ios_music_seekbar!!.progress = (audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC))

        ios_call_seekbar!!.progress =
            (audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL))

        if (ios_music_seekbar!!.progress == 0) {
            musicImage!!.setImageResource(drawable.ic_music_off_ios)
        }


//        if(coloridIos=="red")
//        {
//            ios_music_seekbar!!.barProgressStartColor = ContextCompat.getColor(context!!,
//                R.color.red
//            )
//            ios_ring_seekbar!!.barProgressStartColor = ContextCompat.getColor(context!!,
//                R.color.red
//            )
//            ios_alarm_seekbar!!.barProgressStartColor = ContextCompat.getColor(context!!,
//                R.color.red
//            )
//            ios_call_seekbar!!.barProgressStartColor = ContextCompat.getColor(context!!,
//                R.color.red
//            )
//        }else
        if (coloridIos == "teal") {
            ios_music_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.teal_200
            )
            ios_ring_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.teal_200
            )
            ios_alarm_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.teal_200
            )
            ios_call_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.teal_200
            )
        } else if (coloridIos == "green") {
            ios_music_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.green
            )
            ios_ring_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.green
            )
            ios_alarm_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.green
            )
            ios_call_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.green
            )
        } else if (coloridIos == "blue") {
            ios_music_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.blue
            )
            ios_ring_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.blue
            )
            ios_alarm_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.blue
            )
            ios_call_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.blue
            )
        } else if (coloridIos == "pink") {
            ios_music_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.pink
            )
            ios_ring_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.pink
            )
            ios_alarm_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.pink
            )
            ios_call_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.pink
            )
        } else if (coloridIos == "default") {
            ios_music_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.white
            )
            ios_ring_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.white
            )
            ios_alarm_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.white
            )
            ios_call_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                context!!,
                color.white
            )
        }

        btn_show_more = mView!!.findViewById(id.btn_show_more)
        btn_show_more!!.setOnClickListener {
            ios_hidden_view!!.visibility = View.VISIBLE

            btn_show_more!!.visibility = View.GONE
            btn_show_less!!.visibility = View.VISIBLE

            ios_music_seekbar!!.maxValue =
                (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_MUSIC))
            ios_music_seekbar!!.progress =
                (audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC))
            if (ios_music_seekbar!!.progress == 0) {
                musicImage!!.setImageResource(drawable.ic_music_off_ios)
            }

            ios_ring_seekbar!!.maxValue =
                (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_RING))
            ios_ring_seekbar!!.progress = (audioManager!!.getStreamVolume(AudioManager.STREAM_RING))
            if (ios_ring_seekbar!!.progress == 0) {
                ringImage!!.setImageResource(drawable.ic_notifications_off_ios)
            }

            ios_alarm_seekbar!!.maxValue =
                (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_ALARM))
            ios_alarm_seekbar!!.progress =
                (audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM))
            if (ios_alarm_seekbar!!.progress == 0) {
                alarmImage!!.setImageResource(drawable.ic_alarm_off_ios)
            }

            ios_call_seekbar!!.maxValue =
                (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL))
            ios_call_seekbar!!.progress =
                (audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL))

            seekbarname_type = "music"

            mWindowManager!!.updateViewLayout(mView, mParams)
        }

        btn_show_less = mView!!.findViewById(id.btn_show_less)
        btn_show_less!!.setOnClickListener {
            ios_hidden_view!!.visibility = View.GONE

            btn_show_more!!.visibility = View.VISIBLE
            btn_show_less!!.visibility = View.GONE

            seekbarname_type = "music"

            mWindowManager!!.updateViewLayout(mView, mParams)
        }

        myRunnable = Runnable {
            Log.e("TESTTAG", "onCreate: ")
            closeWindow()
        }

        start()

        seekbarname_type = "music"

        ios_music_seekbar!!.setOnProgressChangeListener { progressValue ->
            Log.d("VerticalSeekBar", "PROGRESS CHANGED at value: $progressValue")

            restart()

            seekbarname_type = "music"
            audioManager!!.setStreamVolume(
                AudioManager.STREAM_MUSIC,
                progressValue, 0
            )
            if (ios_music_seekbar!!.progress > 0) {
                musicImage!!.setImageResource(drawable.ic_ios_music);
            }
            if (ios_music_seekbar!!.progress == 0) {
                musicImage!!.setImageResource(drawable.ic_music_off_ios)
            }
        }

        ios_music_seekbar!!.setOnReleaseListener { progressValue ->
            if (ios_music_seekbar!!.progress > 0) {
                musicImage!!.setImageResource(drawable.ic_ios_music)
            }
            if (ios_music_seekbar!!.progress == 0) {
                musicImage!!.setImageResource(drawable.ic_music_off_ios)
            }
        }

        ios_ring_seekbar!!.setOnProgressChangeListener { progressValue ->

            restart()

            seekbarname_type = "ring"
            Log.d("VerticalSeekBar", "PROGRESS CHANGED at value: $progressValue")
            audioManager!!.setStreamVolume(
                AudioManager.STREAM_RING,
                progressValue, 0
            )
            if (ios_ring_seekbar!!.progress > 0) {
                ringImage!!.setImageResource(drawable.ic_ios_ring)
            }
            if (ios_ring_seekbar!!.progress == 0) {
                ringImage!!.setImageResource(drawable.ic_notifications_off_ios)
            }
        }

        ios_ring_seekbar!!.setOnReleaseListener { progressValue ->
            if (ios_ring_seekbar!!.progress > 0) {
                ringImage!!.setImageResource(drawable.ic_ios_ring)
            }
            if (ios_ring_seekbar!!.progress == 0) {
                ringImage!!.setImageResource(drawable.ic_notifications_off_ios)
            }
        }

        ios_alarm_seekbar!!.setOnProgressChangeListener { progressValue ->

            restart()

            seekbarname_type = "alarm"
            Log.d("VerticalSeekBar", "PROGRESS CHANGED at value: $progressValue")
            audioManager!!.setStreamVolume(
                AudioManager.STREAM_ALARM,
                progressValue, 0
            )
            if (ios_alarm_seekbar!!.progress > 0) {
                alarmImage!!.setImageResource(drawable.ic_ios_alarm);
            }
            if (ios_alarm_seekbar!!.progress == 0) {
                alarmImage!!.setImageResource(drawable.ic_alarm_off_ios)
            }
        }
        ios_alarm_seekbar!!.setOnReleaseListener { progressValue ->
            if (ios_alarm_seekbar!!.progress > 0) {
                alarmImage!!.setImageResource(drawable.ic_ios_alarm);
            }
            if (ios_alarm_seekbar!!.progress == 0) {
                alarmImage!!.setImageResource(drawable.ic_alarm_off_ios)
            }
        }

        ios_call_seekbar!!.setOnProgressChangeListener { progressValue ->

            restart()

            seekbarname_type = "call"
            Log.d("VerticalSeekBar", "PROGRESS CHANGED at value: $progressValue")
            audioManager!!.setStreamVolume(
                AudioManager.STREAM_VOICE_CALL,
                progressValue, 0
            )
        }

        if (positionidIos == "left") {
            mParams!!.gravity = Gravity.LEFT
            mWindowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            btn_show_more!!.setImageResource(drawable.ic_show_less)
            btn_show_less!!.setImageResource(drawable.ic_show_more)
        } else if (positionidIos == "right") {
            mParams!!.gravity = Gravity.RIGHT
            mWindowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        } else/* if(positionid=="default")*/ {
            mParams!!.gravity = Gravity.RIGHT
            mWindowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        }
    }

    //============================================================KNOB SEEKBAR==============================================================================//

    private fun knobSeekbar() {
        layoutInflater =
            context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        // inflating the view with the custom layout created
//        mView = layoutInflater!!.inflate(R.layout.style_6_full, null)
        audioManager = context!!.getSystemService(Context.AUDIO_SERVICE) as AudioManager
//        music_knob = mView!!.findViewById<Croller>(id.ic_music_center_knob)
//        ring_knob = mView!!.findViewById<Croller>(id.ring_knob)
//        alarm_knob = mView!!.findViewById<Croller>(id.alarm_knob)
//        call_knob = mView!!.findViewById<Croller>(id.call_knob)
//
//        knob_music_icon = mView!!.findViewById(id.knob_music_icon)
//        knob_ring_icon = mView!!.findViewById(id.knob_ring_icon)
//        knob_alarm_icon = mView!!.findViewById(id.knob_alarm_icon)
//        knob_call_icon = mView!!.findViewById(id.knob_call_icon)
//        musicImage = mView!!.findViewById(id.ic_music_center_knob)
//        ringImage = mView!!.findViewById(id.ic_ring_center_knob)
//        alarmImage = mView!!.findViewById(id.ic_alarm_center_knob)
//        ic_call_center_knob = mView!!.findViewById(id.ic_call_center_knob)


        myRunnable = Runnable {
            // your code here
            Log.e("TESTTAG", "onCreate: ")
            closeWindow()
        }

        start()

        seekbarname_type = "music"

        music_knob!!.max = (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_MUSIC))
        music_knob!!.setProgress((audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC)))

        ring_knob!!.max = (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_RING))
        ring_knob!!.setProgress((audioManager!!.getStreamVolume(AudioManager.STREAM_RING)))

        alarm_knob!!.max = (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_ALARM))
        alarm_knob!!.setProgress((audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM)))

        call_knob!!.max = (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL))
        call_knob!!.setProgress((audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL)))

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (coloridKnob == "red") {
                music_knob!!.setProgressPrimaryColor(context!!.resources.getColor(color.red, null))
                music_knob!!.setIndicatorColor(context!!.resources.getColor(color.red, null))
                music_knob!!.backCircleColor = (context!!.resources.getColor(color.red, null))
                ring_knob!!.setProgressPrimaryColor(context!!.resources.getColor(color.red, null))
                ring_knob!!.setIndicatorColor(context!!.resources.getColor(color.red, null))
                ring_knob!!.backCircleColor = (context!!.resources.getColor(color.red, null))
                alarm_knob!!.setProgressPrimaryColor(context!!.resources.getColor(color.red, null))
                alarm_knob!!.setIndicatorColor(context!!.resources.getColor(color.red, null))
                alarm_knob!!.backCircleColor = (context!!.resources.getColor(color.red, null))
                call_knob!!.setProgressPrimaryColor(context!!.resources.getColor(color.red, null))
                call_knob!!.setIndicatorColor(context!!.resources.getColor(color.red, null))
                call_knob!!.backCircleColor = (context!!.resources.getColor(color.red, null))

            } else if (coloridKnob == "teal") {
                music_knob!!.setProgressPrimaryColor(
                    context!!.resources.getColor(
                        color.teal_200,
                        null
                    )
                )
                music_knob!!.setIndicatorColor(context!!.resources.getColor(color.teal_200, null))
                music_knob!!.backCircleColor = (context!!.resources.getColor(color.teal_200, null))
                ring_knob!!.setProgressPrimaryColor(
                    context!!.resources.getColor(
                        color.teal_200,
                        null
                    )
                )
                ring_knob!!.setIndicatorColor(context!!.resources.getColor(color.teal_200, null))
                ring_knob!!.backCircleColor = (context!!.resources.getColor(color.teal_200, null))
                alarm_knob!!.setProgressPrimaryColor(
                    context!!.resources.getColor(
                        color.teal_200,
                        null
                    )
                )
                alarm_knob!!.setIndicatorColor(context!!.resources.getColor(color.teal_200, null))
                alarm_knob!!.backCircleColor = (context!!.resources.getColor(color.teal_200, null))
                call_knob!!.setProgressPrimaryColor(
                    context!!.resources.getColor(
                        color.teal_200,
                        null
                    )
                )
                call_knob!!.setIndicatorColor(context!!.resources.getColor(color.teal_200, null))
                call_knob!!.backCircleColor = (context!!.resources.getColor(color.teal_200, null))
            } else if (coloridKnob == "green") {
                music_knob!!.setProgressPrimaryColor(
                    context!!.resources.getColor(
                        color.green,
                        null
                    )
                )
                music_knob!!.setIndicatorColor(context!!.resources.getColor(color.green, null))
                music_knob!!.backCircleColor = (context!!.resources.getColor(color.green, null))
                ring_knob!!.setProgressPrimaryColor(context!!.resources.getColor(color.green, null))
                ring_knob!!.setIndicatorColor(context!!.resources.getColor(color.green, null))
                ring_knob!!.backCircleColor = (context!!.resources.getColor(color.green, null))
                alarm_knob!!.setProgressPrimaryColor(
                    context!!.resources.getColor(
                        color.green,
                        null
                    )
                )
                alarm_knob!!.setIndicatorColor(context!!.resources.getColor(color.green, null))
                alarm_knob!!.backCircleColor = (context!!.resources.getColor(color.green, null))
                call_knob!!.setProgressPrimaryColor(context!!.resources.getColor(color.green, null))
                call_knob!!.setIndicatorColor(context!!.resources.getColor(color.green, null))
                call_knob!!.backCircleColor = (context!!.resources.getColor(color.green, null))
            } else if (coloridKnob == "pink") {
                music_knob!!.setProgressPrimaryColor(context!!.resources.getColor(color.pink, null))
                music_knob!!.setIndicatorColor(context!!.resources.getColor(color.pink, null))
                music_knob!!.backCircleColor = (context!!.resources.getColor(color.pink, null))
                ring_knob!!.setProgressPrimaryColor(context!!.resources.getColor(color.pink, null))
                ring_knob!!.setIndicatorColor(context!!.resources.getColor(color.pink, null))
                ring_knob!!.backCircleColor = (context!!.resources.getColor(color.pink, null))
                alarm_knob!!.setProgressPrimaryColor(context!!.resources.getColor(color.pink, null))
                alarm_knob!!.setIndicatorColor(context!!.resources.getColor(color.pink, null))
                alarm_knob!!.backCircleColor = (context!!.resources.getColor(color.pink, null))
                call_knob!!.setProgressPrimaryColor(context!!.resources.getColor(color.pink, null))
                call_knob!!.setIndicatorColor(context!!.resources.getColor(color.pink, null))
                call_knob!!.backCircleColor = (context!!.resources.getColor(color.pink, null))
            } else if (coloridKnob == "default") {
                music_knob!!.setProgressPrimaryColor(context!!.resources.getColor(color.blue, null))
                music_knob!!.setIndicatorColor(context!!.resources.getColor(color.blue, null))
                music_knob!!.backCircleColor = (context!!.resources.getColor(color.blue, null))
                ring_knob!!.setProgressPrimaryColor(context!!.resources.getColor(color.blue, null))
                ring_knob!!.setIndicatorColor(context!!.resources.getColor(color.blue, null))
                ring_knob!!.backCircleColor = (context!!.resources.getColor(color.blue, null))
                alarm_knob!!.setProgressPrimaryColor(context!!.resources.getColor(color.blue, null))
                alarm_knob!!.setIndicatorColor(context!!.resources.getColor(color.blue, null))
                alarm_knob!!.backCircleColor = (context!!.resources.getColor(color.blue, null))
                call_knob!!.setProgressPrimaryColor(context!!.resources.getColor(color.blue, null))
                call_knob!!.setIndicatorColor(context!!.resources.getColor(color.blue, null))
                call_knob!!.backCircleColor = (context!!.resources.getColor(color.blue, null))
            }
        }

        knob_music_icon!!.setOnClickListener {
            seekbarname_type = "music"
            ringImage!!.visibility = View.GONE
            ring_knob!!.visibility = View.GONE
            alarmImage!!.visibility = View.GONE
            alarm_knob!!.visibility = View.GONE
            ic_call_center_knob!!.visibility = View.GONE
            call_knob!!.visibility = View.GONE

            musicImage!!.visibility = View.VISIBLE
            music_knob!!.visibility = View.VISIBLE
        }

        knob_ring_icon!!.setOnClickListener {

            seekbarname_type = "ring"
            musicImage!!.visibility = View.GONE
            music_knob!!.visibility = View.GONE
            alarmImage!!.visibility = View.GONE
            alarm_knob!!.visibility = View.GONE
            ic_call_center_knob!!.visibility = View.GONE
            call_knob!!.visibility = View.GONE

            ringImage!!.visibility = View.VISIBLE
            ring_knob!!.visibility = View.VISIBLE
        }

        knob_alarm_icon!!.setOnClickListener {

            seekbarname_type = "alarm"
            musicImage!!.visibility = View.GONE
            music_knob!!.visibility = View.GONE
            ringImage!!.visibility = View.GONE
            ring_knob!!.visibility = View.GONE
            ic_call_center_knob!!.visibility = View.GONE
            call_knob!!.visibility = View.GONE

            alarmImage!!.visibility = View.VISIBLE
            alarm_knob!!.visibility = View.VISIBLE
        }

        knob_call_icon!!.setOnClickListener {

            seekbarname_type = "call"
            musicImage!!.visibility = View.GONE
            music_knob!!.visibility = View.GONE
            ringImage!!.visibility = View.GONE
            ring_knob!!.visibility = View.GONE
            alarmImage!!.visibility = View.GONE
            alarm_knob!!.visibility = View.GONE

            ic_call_center_knob!!.visibility = View.VISIBLE
            call_knob!!.visibility = View.VISIBLE
        }


        music_knob!!.setOnProgressChangedListener {
            restart()

            seekbarname_type = "music"
            audioManager!!.setStreamVolume(
                AudioManager.STREAM_MUSIC,
                it, 0
            )
            if (music_knob!!.progress > 0) {
                musicImage!!.setImageResource(drawable.ic_music_window10);
            }
            if (music_knob!!.progress == 0) {
                musicImage!!.setImageResource(drawable.ic_music_off_black)
            }
        }
        ring_knob!!.setOnProgressChangedListener {
            restart()

            seekbarname_type = "ring"
            audioManager!!.setStreamVolume(
                AudioManager.STREAM_RING,
                it, 0
            )
            if (ring_knob!!.progress > 0) {
                ringImage!!.setImageResource(drawable.ic_notification_window10);
            }
            if (ring_knob!!.progress == 0) {
                ringImage!!.setImageResource(drawable.ic_notifications_off_black)
            }
        }
        alarm_knob!!.setOnProgressChangedListener {
            restart()

            seekbarname_type = "alarm"
            audioManager!!.setStreamVolume(
                AudioManager.STREAM_ALARM,
                it, 0
            )
            if (alarm_knob!!.progress > 0) {
                alarmImage!!.setImageResource(drawable.ic_alarm_window10);
            }
            if (alarm_knob!!.progress == 0) {
                alarmImage!!.setImageResource(drawable.ic_alarm_off_black)
            }
        }
        call_knob!!.setOnProgressChangedListener {
            restart()

            seekbarname_type = "call"
            audioManager!!.setStreamVolume(
                AudioManager.STREAM_VOICE_CALL,
                it, 0
            )
        }


        if (positionidKnob == "left") {
            mParams!!.gravity = Gravity.LEFT
            mWindowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        } else if (positionidKnob == "right") {
            mParams!!.gravity = Gravity.RIGHT
            mWindowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        } else/* if(positionid=="default")*/ {
            mParams!!.gravity = Gravity.RIGHT
            mWindowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        }
    }

    //==============================================================EMOJI SEEKBAR====================================================================================//

    private fun emojiSeekbar() {
        layoutInflater =
            context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        // inflating the view with the custom layout created
        mView = layoutInflater!!.inflate(layout.style_5_full, null)
        hiddenview = mView!!.findViewById(id.hidden_view)
        audioManager = context!!.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        music_emojiSlider = mView!!.findViewById<EmojiSlider>(id.music_emojiSlider)
        ring_emojiSlider = mView!!.findViewById<EmojiSlider>(id.ring_emojislider)
        alarm_emojiSlider = mView!!.findViewById<EmojiSlider>(id.alarm_emojislider)
        call_emojiSlider = mView!!.findViewById<EmojiSlider>(id.call_emojislider)

        musicImage = mView!!.findViewById(id.emoji_music_icon)
        ringImage = mView!!.findViewById(id.emoji_ring_icon)
        alarmImage = mView!!.findViewById(id.emoji_alarm_icon)
        callImage = mView!!.findViewById(id.emoji_call_icon)

        music_emojiSlider!!.progress =
            ((audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC)).toFloat()) / 15
        if (music_emojiSlider!!.progress <= 0) {
            if (coloridEmoji == "green") {
                musicImage!!.setImageResource(drawable.ic_android10_music_off)
            } else if (coloridEmoji == "teal") {
                musicImage!!.setImageResource(drawable.ic_teal_music_off_android10)
            } else if (coloridEmoji == "red") {
                musicImage!!.setImageResource(drawable.ic_red_music_off_android10)
            } else if (coloridEmoji == "pink") {
                musicImage!!.setImageResource(drawable.ic_pink_music_off_android10)
            } else {
                musicImage!!.setImageResource(drawable.ic_blue_music_off_android10)
            }
//            musicImage!!.setImageResource(R.drawable.ic_music_off_black)
        }

        ring_emojiSlider!!.progress =
            ((audioManager!!.getStreamVolume(AudioManager.STREAM_RING)).toFloat()) / 15
        if (ring_emojiSlider!!.progress <= 0) {
            if (coloridEmoji == "green") {
                ringImage!!.setImageResource(drawable.ic_notifications_off_android10)
            } else if (coloridEmoji == "teal") {
                ringImage!!.setImageResource(drawable.ic_teal_notifications_off_android10)
            } else if (coloridEmoji == "red") {
                ringImage!!.setImageResource(drawable.ic_red_notifications_off_android10)
            } else if (coloridEmoji == "pink") {
                ringImage!!.setImageResource(drawable.ic_pink_notifications_off_android10)
            } else {
                ringImage!!.setImageResource(drawable.ic_blue_notifications_off_android10)
            }
//            ringImage!!.setImageResource(R.drawable.ic_notifications_off_black)
        }

        alarm_emojiSlider!!.progress =
            ((audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM)).toFloat()) / 15
        if (alarm_emojiSlider!!.progress <= 0) {
            if (coloridEmoji == "green") {
                alarmImage!!.setImageResource(drawable.ic_baseline_alarm_off_android10)
            } else if (coloridEmoji == "teal") {
                alarmImage!!.setImageResource(drawable.ic_teal_alarm_off_android10)
            } else if (coloridEmoji == "red") {
                alarmImage!!.setImageResource(drawable.ic_red_alarm_off_android10)
            } else if (coloridEmoji == "pink") {
                alarmImage!!.setImageResource(drawable.ic_pink_alarm_off_android10)
            } else {
                alarmImage!!.setImageResource(drawable.ic_blue_alarm_off_android10)
            }
//            alarmImage!!.setImageResource(R.drawable.ic_alarm_off_black)
        }

        call_emojiSlider!!.progress =
            ((audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL)).toFloat()) / 15

        btn_show_more = mView!!.findViewById(id.btn_show_more)
        btn_show_more!!.setOnClickListener {
            hiddenview!!.visibility = View.VISIBLE

            btn_show_more!!.visibility = View.GONE
            btn_show_less!!.visibility = View.VISIBLE

            seekbarname_type = "music"

            mWindowManager!!.updateViewLayout(mView, mParams)
        }

        btn_show_less = mView!!.findViewById(id.btn_show_less)
        btn_show_less!!.setOnClickListener {
            hiddenview!!.visibility = View.GONE

            btn_show_more!!.visibility = View.VISIBLE
            btn_show_less!!.visibility = View.GONE

            seekbarname_type = "music"

            mWindowManager!!.updateViewLayout(mView, mParams)
        }

        myRunnable = Runnable {
            Log.e("TESTTAG", "onCreate: ")
            closeWindow()
        }

        start()

        seekbarname_type = "music"

        music_emojiSlider!!.positionListener = { p ->

            restart()

            seekbarname_type = "music"
            audioManager!!.setStreamVolume(AudioManager.STREAM_MUSIC, (p * 15).toInt(), 0)
            if (music_emojiSlider!!.progress > 0) {
                if (coloridEmoji == "teal") {
                    musicImage!!.setImageResource(drawable.ic_teal_music_note_android10)
                } else if (coloridEmoji == "green") {
                    musicImage!!.setImageResource(drawable.ic_musicnote_android10)
                } else if (coloridEmoji == "pink") {
                    musicImage!!.setImageResource(drawable.ic_pink_music_note_android10)
                } else if (coloridEmoji == "red") {
                    musicImage!!.setImageResource(drawable.ic_red_music_note_android10)
                } else {
                    musicImage!!.setImageResource(drawable.ic_blue_music_note_android10)
                }
//                musicImage!!.setImageResource(R.drawable.ic_music_window10);
            }
            if (music_emojiSlider!!.progress <= 0) {

                if (coloridEmoji == "teal") {
                    musicImage!!.setImageResource(drawable.ic_teal_music_off_android10)
                } else if (coloridEmoji == "green") {
                    musicImage!!.setImageResource(drawable.ic_android10_music_off)
                } else if (coloridEmoji == "pink") {
                    musicImage!!.setImageResource(drawable.ic_pink_music_off_android10)
                } else if (coloridEmoji == "red") {
                    musicImage!!.setImageResource(drawable.ic_red_music_off_android10)
                } else {
                    musicImage!!.setImageResource(drawable.ic_blue_music_off_android10)
                }
//                musicImage!!.setImageResource(R.drawable.ic_music_off_black)
            }
            Log.e("volume", p.toString() + " Sliderprogress")
        }


        ring_emojiSlider!!.positionListener = { p ->

            restart()

            seekbarname_type = "ring"
            audioManager!!.setStreamVolume(AudioManager.STREAM_RING, (p * 15).toInt(), 0)
            if (ring_emojiSlider!!.progress > 0) {
                if (coloridEmoji == "green") {
                    ringImage!!.setImageResource(drawable.ic_notification_android10)
                } else if (coloridEmoji == "red") {
                    ringImage!!.setImageResource(drawable.ic_red_notifications_android10)
                } else if (coloridEmoji == "teal") {
                    ringImage!!.setImageResource(drawable.ic_teal_notifications_android10)
                } else if (coloridEmoji == "pink") {
                    ringImage!!.setImageResource(drawable.ic_pink_notifications_android10)
                } else {
                    ringImage!!.setImageResource(drawable.ic_blue_notifications_android10)
                }
//                ringImage!!.setImageResource(R.drawable.ic_notification_window10);
            }
            if (ring_emojiSlider!!.progress <= 0) {
                if (coloridEmoji == "green") {
                    ringImage!!.setImageResource(drawable.ic_notifications_off_android10)
                } else if (coloridEmoji == "red") {
                    ringImage!!.setImageResource(drawable.ic_red_notifications_off_android10)
                } else if (coloridEmoji == "teal") {
                    ringImage!!.setImageResource(drawable.ic_teal_notifications_off_android10)
                } else if (coloridEmoji == "pink") {
                    ringImage!!.setImageResource(drawable.ic_pink_notifications_off_android10)
                } else {
                    ringImage!!.setImageResource(drawable.ic_blue_notifications_off_android10)
                }
//                ringImage!!.setImageResource(R.drawable.ic_notifications_off_black)
            }
        }

        alarm_emojiSlider!!.positionListener = { p ->

            restart()

            seekbarname_type = "alarm"
            audioManager!!.setStreamVolume(AudioManager.STREAM_ALARM, (p * 15).toInt(), 0)
            if (alarm_emojiSlider!!.progress > 0) {
                if (coloridEmoji == "green") {
                    alarmImage!!.setImageResource(drawable.ic_alarm_android10)
                } else if (coloridEmoji == "red") {
                    alarmImage!!.setImageResource(drawable.ic_red_alarm_android10);
                } else if (coloridEmoji == "teal") {
                    alarmImage!!.setImageResource(drawable.ic_teal_alarm_android10);
                } else if (coloridEmoji == "pink") {
                    alarmImage!!.setImageResource(drawable.ic_pink_alarm_android10);
                } else {
                    alarmImage!!.setImageResource(drawable.ic_blue_alarm_android10); }
//                alarmImage!!.setImageResource(R.drawable.ic_alarm_window10);
            }
            if (alarm_emojiSlider!!.progress <= 0) {
                if (coloridEmoji == "green") {
                    alarmImage!!.setImageResource(drawable.ic_baseline_alarm_off_android10)
                } else if (coloridEmoji == "red") {
                    alarmImage!!.setImageResource(drawable.ic_red_alarm_off_android10);
                } else if (coloridEmoji == "teal") {
                    alarmImage!!.setImageResource(drawable.ic_teal_alarm_off_android10);
                } else if (coloridEmoji == "pink") {
                    alarmImage!!.setImageResource(drawable.ic_pink_alarm_off_android10);
                } else {
                    alarmImage!!.setImageResource(drawable.ic_blue_alarm_off_android10); }
//                alarmImage!!.setImageResource(R.drawable.ic_alarm_off_black)
            }
        }

        call_emojiSlider!!.positionListener = { p ->

            restart()

            seekbarname_type = "call"
            audioManager!!.setStreamVolume(AudioManager.STREAM_VOICE_CALL, (p * 15).toInt(), 0)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (coloridEmoji == "red") {
                if (music_emojiSlider!!.progress > 0) {
                    musicImage!!.setImageResource(drawable.ic_red_music_note_android10)
                } else if (music_emojiSlider!!.progress <= 0) {
                    musicImage!!.setImageResource(drawable.ic_red_music_off_android10)
                }
                if (ring_emojiSlider!!.progress > 0) {
                    ringImage!!.setImageResource(drawable.ic_red_notifications_android10)
                } else if (ring_emojiSlider!!.progress <= 0) {
                    ringImage!!.setImageResource(drawable.ic_red_notifications_off_android10)

                }
                if (alarm_emojiSlider!!.progress > 0) {
                    alarmImage!!.setImageResource(drawable.ic_red_alarm_android10)
                } else if (alarm_emojiSlider!!.progress <= 0) {
                    alarmImage!!.setImageResource(drawable.ic_red_alarm_off_android10)
                }
                callImage!!.setImageResource(drawable.ic_red_call_android10)

                music_emojiSlider!!.colorStart = (context!!.resources.getColor(color.red, null))
                ring_emojiSlider!!.colorStart = (context!!.resources.getColor(color.red, null))
                alarm_emojiSlider!!.colorStart = (context!!.resources.getColor(color.red, null))
                call_emojiSlider!!.colorStart = (context!!.resources.getColor(color.red, null))
            } else if (coloridEmoji == "teal") {
                if (music_emojiSlider!!.progress > 0) {
                    musicImage!!.setImageResource(drawable.ic_teal_music_note_android10)
                } else if (music_emojiSlider!!.progress <= 0) {
                    musicImage!!.setImageResource(drawable.ic_teal_music_off_android10)
                }
                if (ring_emojiSlider!!.progress > 0) {
                    ringImage!!.setImageResource(drawable.ic_teal_notifications_android10)
                } else if (ring_emojiSlider!!.progress <= 0) {
                    ringImage!!.setImageResource(drawable.ic_teal_notifications_off_android10)
                }
                if (alarm_emojiSlider!!.progress > 0) {
                    alarmImage!!.setImageResource(drawable.ic_teal_alarm_android10)
                } else if (alarm_emojiSlider!!.progress <= 0) {
                    alarmImage!!.setImageResource(drawable.ic_teal_alarm_off_android10)
                }
                callImage!!.setImageResource(drawable.ic_teal_call_android10)

                music_emojiSlider!!.colorStart =
                    (context!!.resources.getColor(color.teal_200, null))
                ring_emojiSlider!!.colorStart = (context!!.resources.getColor(color.teal_200, null))
                alarm_emojiSlider!!.colorStart =
                    (context!!.resources.getColor(color.teal_200, null))
                call_emojiSlider!!.colorStart = (context!!.resources.getColor(color.teal_200, null))
            } else if (coloridEmoji == "green") {
                if (music_emojiSlider!!.progress > 0) {
                    musicImage!!.setImageResource(drawable.ic_musicnote_android10)
                } else if (music_emojiSlider!!.progress <= 0) {
                    musicImage!!.setImageResource(drawable.ic_android10_music_off)
                }
                if (ring_emojiSlider!!.progress > 0) {
                    ringImage!!.setImageResource(drawable.ic_notification_android10)
                } else if (ring_emojiSlider!!.progress <= 0) {
                    ringImage!!.setImageResource(drawable.ic_notifications_off_android10)

                }
                if (alarm_emojiSlider!!.progress > 0) {
                    alarmImage!!.setImageResource(drawable.ic_alarm_android10)
                } else if (alarm_emojiSlider!!.progress <= 0) {
                    alarmImage!!.setImageResource(drawable.ic_baseline_alarm_off_android10)
                }
                callImage!!.setImageResource(drawable.ic_call_android10)

                music_emojiSlider!!.colorStart = (context!!.resources.getColor(color.green, null))
                ring_emojiSlider!!.colorStart = (context!!.resources.getColor(color.green, null))
                alarm_emojiSlider!!.colorStart = (context!!.resources.getColor(color.green, null))
                call_emojiSlider!!.colorStart = (context!!.resources.getColor(color.green, null))
            } else if (coloridEmoji == "pink") {
                if (music_emojiSlider!!.progress > 0) {
                    musicImage!!.setImageResource(drawable.ic_pink_music_note_android10)
                } else if (music_emojiSlider!!.progress <= 0) {
                    musicImage!!.setImageResource(drawable.ic_pink_music_off_android10)
                }
                if (ring_emojiSlider!!.progress > 0) {
                    ringImage!!.setImageResource(drawable.ic_pink_notifications_android10)
                } else if (ring_emojiSlider!!.progress <= 0) {
                    ringImage!!.setImageResource(drawable.ic_pink_notifications_off_android10)

                }
                if (alarm_emojiSlider!!.progress > 0) {
                    alarmImage!!.setImageResource(drawable.ic_pink_alarm_android10)
                } else if (alarm_emojiSlider!!.progress <= 0) {
                    alarmImage!!.setImageResource(drawable.ic_pink_alarm_off_android10)
                }
                callImage!!.setImageResource(drawable.ic_pink_call_android10)

                music_emojiSlider!!.colorStart = (context!!.resources.getColor(color.pink, null))
                ring_emojiSlider!!.colorStart = (context!!.resources.getColor(color.pink, null))
                alarm_emojiSlider!!.colorStart = (context!!.resources.getColor(color.pink, null))
                call_emojiSlider!!.colorStart = (context!!.resources.getColor(color.pink, null))
            } else if (coloridEmoji == "default") {
                if (music_emojiSlider!!.progress > 0) {
                    musicImage!!.setImageResource(drawable.ic_blue_music_note_android10)
                } else if (music_emojiSlider!!.progress <= 0) {
                    musicImage!!.setImageResource(drawable.ic_blue_music_off_android10)
                }
                if (ring_emojiSlider!!.progress > 0) {
                    ringImage!!.setImageResource(drawable.ic_blue_notifications_android10)
                } else if (ring_emojiSlider!!.progress <= 0) {
                    ringImage!!.setImageResource(drawable.ic_blue_notifications_off_android10)

                }
                if (alarm_emojiSlider!!.progress > 0) {
                    alarmImage!!.setImageResource(drawable.ic_blue_alarm_android10)
                } else if (alarm_emojiSlider!!.progress <= 0) {
                    alarmImage!!.setImageResource(drawable.ic_blue_alarm_off_android10)
                }
                callImage!!.setImageResource(drawable.ic_blue_call_android)

                music_emojiSlider!!.colorStart = (context!!.resources.getColor(color.blue, null))
                ring_emojiSlider!!.colorStart = (context!!.resources.getColor(color.blue, null))
                alarm_emojiSlider!!.colorStart = (context!!.resources.getColor(color.blue, null))
                call_emojiSlider!!.colorStart = (context!!.resources.getColor(color.blue, null))
            }
//            else if (coloridEmoji == "default") {
//
//                music_emojiSlider!!.colorStart = (context!!.resources.getColor(R.color.purple_500, null))
//                ring_emojiSlider!!.colorStart = (context!!.resources.getColor(R.color.purple_500, null))
//                alarm_emojiSlider!!.colorStart = (context!!.resources.getColor(R.color.purple_500, null))
//                call_emojiSlider!!.colorStart = (context!!.resources.getColor(R.color.purple_500, null))
//            }
        }

        if (positionidEmoji == "top") {
            mParams!!.gravity = Gravity.TOP
            mWindowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        } else if (positionidEmoji == "bottom") {
            mParams!!.gravity = Gravity.BOTTOM
            mWindowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            btn_show_more!!.setImageResource(drawable.ic_arrow_up)
            btn_show_less!!.setImageResource(drawable.ic_arrow_down)
        } else/* if(positionid=="default")*/ {
            mParams!!.gravity = Gravity.TOP
            mWindowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        }
    }

    //==============================================================ELASTIC SEEKBAR====================================================================================//

    private fun elasticSeekbar() {
        layoutInflater =
            context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        // inflating the view with the custom layout created
        mView = layoutInflater!!.inflate(layout.style_4_full, null)
        hiddenview = mView!!.findViewById(id.hidden_view)
        audioManager = context!!.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        music_rubberseekbar = mView!!.findViewById(id.music_rubberseekbar) as RubberSeekBar
        ring_rubberseekbar = mView!!.findViewById(id.ring_rubberseekbar) as RubberSeekBar
        alarm_rubberseekbar = mView!!.findViewById(id.alarm_rubberseekbar) as RubberSeekBar
        call_rubberseekbar = mView!!.findViewById(id.call_rubberseekbar) as RubberSeekBar

        musicImage = mView!!.findViewById(id.elastic_music_icon)
//        ringImage = mView!!.findViewById(id.elastic_ring_icon)
//        alarmImage = mView!!.findViewById(id.elastic_alarm_icon)
//        callImage = mView!!.findViewById(id.elastic_call_icon)

        myRunnable = Runnable {
            Log.e("TESTTAG", "onCreate: ")
            closeWindow()
        }

        start()

        seekbarname_type = "music"

        music_rubberseekbar!!.setCurrentValue((audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC)))
        if (music_rubberseekbar!!.getCurrentValue() == 0) {
            if (coloridElastic == "green") {
                musicImage!!.setImageResource(drawable.ic_android10_music_off)
            } else if (coloridElastic == "teal") {
                musicImage!!.setImageResource(drawable.ic_teal_music_off_android10)
            } else if (coloridElastic == "red") {
                musicImage!!.setImageResource(drawable.ic_red_music_off_android10)
            } else if (coloridElastic == "pink") {
                musicImage!!.setImageResource(drawable.ic_pink_music_off_android10)
            } else {
                musicImage!!.setImageResource(drawable.ic_blue_music_off_android10)
            }
//            musicImage!!.setImageResource(R.drawable.ic_music_off_black)
        }
        ring_rubberseekbar!!.setCurrentValue((audioManager!!.getStreamVolume(AudioManager.STREAM_RING)))
        if (ring_rubberseekbar!!.getCurrentValue() == 0) {
            if (coloridElastic == "green") {
                ringImage!!.setImageResource(drawable.ic_notifications_off_android10)
            } else if (coloridElastic == "teal") {
                ringImage!!.setImageResource(drawable.ic_teal_notifications_off_android10)
            } else if (coloridElastic == "red") {
                ringImage!!.setImageResource(drawable.ic_red_notifications_off_android10)
            } else if (coloridElastic == "pink") {
                ringImage!!.setImageResource(drawable.ic_pink_notifications_off_android10)
            } else {
                ringImage!!.setImageResource(drawable.ic_blue_notifications_off_android10)
            }
//            ringImage!!.setImageResource(R.drawable.ic_notifications_off_black)
        }
        alarm_rubberseekbar!!.setCurrentValue((audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM)))
        if (alarm_rubberseekbar!!.getCurrentValue() == 0) {
            if (coloridElastic == "green") {
                alarmImage!!.setImageResource(drawable.ic_baseline_alarm_off_android10)
            } else if (coloridElastic == "teal") {
                alarmImage!!.setImageResource(drawable.ic_teal_alarm_off_android10)
            } else if (coloridElastic == "red") {
                alarmImage!!.setImageResource(drawable.ic_red_alarm_off_android10)
            } else if (coloridElastic == "pink") {
                alarmImage!!.setImageResource(drawable.ic_pink_alarm_off_android10)
            } else {
                alarmImage!!.setImageResource(drawable.ic_blue_alarm_off_android10)
            }
//            alarmImage!!.setImageResource(R.drawable.ic_alarm_off_black)
        }
        call_rubberseekbar!!.setCurrentValue((audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL)))
        Log.d("volumm", audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC).toString())

        btn_show_more = mView!!.findViewById(id.btn_show_more)
        btn_show_more!!.setOnClickListener {

            hiddenview!!.visibility = View.VISIBLE

            btn_show_more!!.visibility = View.GONE
            btn_show_less!!.visibility = View.VISIBLE

            seekbarname_type = "music"

            mWindowManager!!.updateViewLayout(mView, mParams)

        }

        btn_show_less = mView!!.findViewById(id.btn_show_less)
        btn_show_less!!.setOnClickListener {
            hiddenview!!.visibility = View.GONE

            btn_show_more!!.visibility = View.VISIBLE
            btn_show_less!!.visibility = View.GONE

            seekbarname_type = "music"

            mWindowManager!!.updateViewLayout(mView, mParams)

        }

        music_rubberseekbar!!.setOnRubberSeekBarChangeListener(object :
            RubberSeekBar.OnRubberSeekBarChangeListener {
            override fun onProgressChanged(seekBar: RubberSeekBar, value: Int, fromUser: Boolean) {
                restart()

                seekbarname_type = "music"
                audioManager!!.setStreamVolume(
                    AudioManager.STREAM_MUSIC,
                    value, 0
                )
                if (music_rubberseekbar!!.getCurrentValue() > 0) {
                    if (coloridElastic == "teal") {
                        musicImage!!.setImageResource(drawable.ic_teal_music_note_android10)
                    } else if (coloridElastic == "green") {
                        musicImage!!.setImageResource(drawable.ic_musicnote_android10)
                    } else if (coloridElastic == "pink") {
                        musicImage!!.setImageResource(drawable.ic_pink_music_note_android10)
                    } else if (coloridElastic == "red") {
                        musicImage!!.setImageResource(drawable.ic_red_music_note_android10)
                    } else {
                        musicImage!!.setImageResource(drawable.ic_blue_music_note_android10)
                    }
//                        musicImage!!.setImageResource(R.drawable.ic_music_window10);
                }
                if (music_rubberseekbar!!.getCurrentValue() == 0) {
                    if (coloridElastic == "teal") {
                        musicImage!!.setImageResource(drawable.ic_teal_music_off_android10)
                    } else if (coloridElastic == "green") {
                        musicImage!!.setImageResource(drawable.ic_android10_music_off)
                    } else if (coloridElastic == "pink") {
                        musicImage!!.setImageResource(drawable.ic_pink_music_off_android10)
                    } else if (coloridElastic == "red") {
                        musicImage!!.setImageResource(drawable.ic_red_music_off_android10)
                    } else {
                        musicImage!!.setImageResource(drawable.ic_blue_music_off_android10)
                    }
//                        musicImage!!.setImageResource(R.drawable.ic_music_off_black)
                }
            }

            override fun onStartTrackingTouch(seekBar: RubberSeekBar) {}
            override fun onStopTrackingTouch(seekBar: RubberSeekBar) {}
        })
        ring_rubberseekbar!!.setOnRubberSeekBarChangeListener(object :
            RubberSeekBar.OnRubberSeekBarChangeListener {
            override fun onProgressChanged(seekBar: RubberSeekBar, value: Int, fromUser: Boolean) {

                restart()

                seekbarname_type = "ring"
                audioManager!!.setStreamVolume(
                    AudioManager.STREAM_RING,
                    value, 0
                )
                if (ring_rubberseekbar!!.getCurrentValue() > 0) {
                    if (coloridElastic == "green") {
                        ringImage!!.setImageResource(drawable.ic_notification_android10)
                    } else if (coloridElastic == "red") {
                        ringImage!!.setImageResource(drawable.ic_red_notifications_android10)
                    } else if (coloridElastic == "teal") {
                        ringImage!!.setImageResource(drawable.ic_teal_notifications_android10)
                    } else if (coloridElastic == "pink") {
                        ringImage!!.setImageResource(drawable.ic_pink_notifications_android10)
                    } else {
                        ringImage!!.setImageResource(drawable.ic_blue_notifications_android10)
                    }
//                    ringImage!!.setImageResource(R.drawable.ic_notification_window10);
                }
                if (ring_rubberseekbar!!.getCurrentValue() == 0) {
                    if (coloridElastic == "green") {
                        ringImage!!.setImageResource(drawable.ic_notifications_off_android10)
                    } else if (coloridElastic == "red") {
                        ringImage!!.setImageResource(drawable.ic_red_notifications_off_android10)
                    } else if (coloridElastic == "teal") {
                        ringImage!!.setImageResource(drawable.ic_teal_notifications_off_android10)
                    } else if (coloridElastic == "pink") {
                        ringImage!!.setImageResource(drawable.ic_pink_notifications_off_android10)
                    } else {
                        ringImage!!.setImageResource(drawable.ic_blue_notifications_off_android10)
                    }
//                    ringImage!!.setImageResource(R.drawable.ic_notifications_off_black)
                }
            }

            override fun onStartTrackingTouch(seekBar: RubberSeekBar) {}
            override fun onStopTrackingTouch(seekBar: RubberSeekBar) {}
        })
        alarm_rubberseekbar!!.setOnRubberSeekBarChangeListener(object :
            RubberSeekBar.OnRubberSeekBarChangeListener {
            override fun onProgressChanged(seekBar: RubberSeekBar, value: Int, fromUser: Boolean) {

                restart()

                seekbarname_type = "alarm"
                audioManager!!.setStreamVolume(
                    AudioManager.STREAM_ALARM,
                    value, 0
                )
                if (alarm_rubberseekbar!!.getCurrentValue() > 0) {
                    if (coloridElastic == "green") {
                        alarmImage!!.setImageResource(drawable.ic_alarm_android10)
                    } else if (coloridElastic == "red") {
                        alarmImage!!.setImageResource(drawable.ic_red_alarm_android10);
                    } else if (coloridElastic == "teal") {
                        alarmImage!!.setImageResource(drawable.ic_teal_alarm_android10);
                    } else if (coloridElastic == "pink") {
                        alarmImage!!.setImageResource(drawable.ic_pink_alarm_android10);
                    } else {
                        alarmImage!!.setImageResource(drawable.ic_blue_alarm_android10); }
//                    alarmImage!!.setImageResource(R.drawable.ic_alarm_window10);
                }
                if (alarm_rubberseekbar!!.getCurrentValue() == 0) {
                    if (coloridElastic == "green") {
                        alarmImage!!.setImageResource(drawable.ic_baseline_alarm_off_android10)
                    } else if (coloridElastic == "red") {
                        alarmImage!!.setImageResource(drawable.ic_red_alarm_off_android10);
                    } else if (coloridElastic == "teal") {
                        alarmImage!!.setImageResource(drawable.ic_teal_alarm_off_android10);
                    } else if (coloridElastic == "pink") {
                        alarmImage!!.setImageResource(drawable.ic_pink_alarm_off_android10);
                    } else {
                        alarmImage!!.setImageResource(drawable.ic_blue_alarm_off_android10); }
//                    alarmImage!!.setImageResource(R.drawable.ic_alarm_off_black)
                }
            }

            override fun onStartTrackingTouch(seekBar: RubberSeekBar) {}
            override fun onStopTrackingTouch(seekBar: RubberSeekBar) {}
        })
        call_rubberseekbar!!.setOnRubberSeekBarChangeListener(object :
            RubberSeekBar.OnRubberSeekBarChangeListener {
            override fun onProgressChanged(seekBar: RubberSeekBar, value: Int, fromUser: Boolean) {

                restart()

                seekbarname_type = "call"
                audioManager!!.setStreamVolume(
                    AudioManager.STREAM_VOICE_CALL,
                    value, 0
                )
            }

            override fun onStartTrackingTouch(seekBar: RubberSeekBar) {}
            override fun onStopTrackingTouch(seekBar: RubberSeekBar) {}
        })

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (coloridElastic == "red") {
                if (music_rubberseekbar!!.getCurrentValue() > 0) {
                    musicImage!!.setImageResource(drawable.ic_red_music_note_android10)
                } else if (music_rubberseekbar!!.getCurrentValue() == 0) {
                    musicImage!!.setImageResource(drawable.ic_red_music_off_android10)
                }
                if (ring_rubberseekbar!!.getCurrentValue() > 0) {
                    ringImage!!.setImageResource(drawable.ic_red_notifications_android10)
                } else if (ring_rubberseekbar!!.getCurrentValue() == 0) {
                    ringImage!!.setImageResource(drawable.ic_red_notifications_off_android10)

                }
                if (alarm_rubberseekbar!!.getCurrentValue() > 0) {
                    alarmImage!!.setImageResource(drawable.ic_red_alarm_android10)
                } else if (alarm_rubberseekbar!!.getCurrentValue() == 0) {
                    alarmImage!!.setImageResource(drawable.ic_red_alarm_off_android10)
                }
                callImage!!.setImageResource(drawable.ic_red_call_android10)

                music_rubberseekbar!!.setHighlightTrackColor(
                    context!!.resources.getColor(
                        color.red,
                        null
                    )
                )
                music_rubberseekbar!!.setHighlightThumbOnTouchColor(
                    context!!.resources.getColor(
                        color.red, null
                    )
                )
                ring_rubberseekbar!!.setHighlightTrackColor(
                    context!!.resources.getColor(
                        color.red,
                        null
                    )
                )
                ring_rubberseekbar!!.setHighlightThumbOnTouchColor(
                    context!!.resources.getColor(
                        color.red, null
                    )
                )
                alarm_rubberseekbar!!.setHighlightTrackColor(
                    context!!.resources.getColor(
                        color.red,
                        null
                    )
                )
                alarm_rubberseekbar!!.setHighlightThumbOnTouchColor(
                    context!!.resources.getColor(
                        color.red, null
                    )
                )
                call_rubberseekbar!!.setHighlightTrackColor(
                    context!!.resources.getColor(
                        color.red,
                        null
                    )
                )
                call_rubberseekbar!!.setHighlightThumbOnTouchColor(
                    context!!.resources.getColor(
                        color.red, null
                    )
                )
            } else if (coloridElastic == "teal") {
                if (music_rubberseekbar!!.getCurrentValue() > 0) {
                    musicImage!!.setImageResource(drawable.ic_teal_music_note_android10)
                } else if (music_rubberseekbar!!.getCurrentValue() == 0) {
                    musicImage!!.setImageResource(drawable.ic_teal_music_off_android10)
                }
                if (ring_rubberseekbar!!.getCurrentValue() > 0) {
                    ringImage!!.setImageResource(drawable.ic_teal_notifications_android10)
                } else if (ring_rubberseekbar!!.getCurrentValue() == 0) {
                    ringImage!!.setImageResource(drawable.ic_teal_notifications_off_android10)
                }
                if (alarm_rubberseekbar!!.getCurrentValue() > 0) {
                    alarmImage!!.setImageResource(drawable.ic_teal_alarm_android10)
                } else if (alarm_rubberseekbar!!.getCurrentValue() == 0) {
                    alarmImage!!.setImageResource(drawable.ic_teal_alarm_off_android10)
                }
                callImage!!.setImageResource(drawable.ic_teal_call_android10)

                music_rubberseekbar!!.setHighlightTrackColor(
                    context!!.resources.getColor(
                        color.teal_200,
                        null
                    )
                )
                music_rubberseekbar!!.setHighlightThumbOnTouchColor(
                    context!!.resources.getColor(
                        color.teal_200, null
                    )
                )
                ring_rubberseekbar!!.setHighlightTrackColor(
                    context!!.resources.getColor(
                        color.teal_200,
                        null
                    )
                )
                ring_rubberseekbar!!.setHighlightThumbOnTouchColor(
                    context!!.resources.getColor(
                        color.teal_200, null
                    )
                )
                alarm_rubberseekbar!!.setHighlightTrackColor(
                    context!!.resources.getColor(
                        color.teal_200,
                        null
                    )
                )
                alarm_rubberseekbar!!.setHighlightThumbOnTouchColor(
                    context!!.resources.getColor(
                        color.teal_200, null
                    )
                )
                call_rubberseekbar!!.setHighlightTrackColor(
                    context!!.resources.getColor(
                        color.teal_200,
                        null
                    )
                )
                call_rubberseekbar!!.setHighlightThumbOnTouchColor(
                    context!!.resources.getColor(
                        color.teal_200, null
                    )
                )
            } else if (coloridElastic == "pink") {
                if (music_rubberseekbar!!.getCurrentValue() > 0) {
                    musicImage!!.setImageResource(drawable.ic_pink_music_note_android10)
                } else if (music_rubberseekbar!!.getCurrentValue() == 0) {
                    musicImage!!.setImageResource(drawable.ic_pink_music_off_android10)
                }
                if (ring_rubberseekbar!!.getCurrentValue() > 0) {
                    ringImage!!.setImageResource(drawable.ic_pink_notifications_android10)
                } else if (ring_rubberseekbar!!.getCurrentValue() == 0) {
                    ringImage!!.setImageResource(drawable.ic_pink_notifications_off_android10)

                }
                if (alarm_rubberseekbar!!.getCurrentValue() > 0) {
                    alarmImage!!.setImageResource(drawable.ic_pink_alarm_android10)
                } else if (alarm_rubberseekbar!!.getCurrentValue() == 0) {
                    alarmImage!!.setImageResource(drawable.ic_pink_alarm_off_android10)
                }
                callImage!!.setImageResource(drawable.ic_pink_call_android10)

                music_rubberseekbar!!.setHighlightTrackColor(
                    context!!.resources.getColor(
                        color.pink,
                        null
                    )
                )
                music_rubberseekbar!!.setHighlightThumbOnTouchColor(
                    context!!.resources.getColor(
                        color.pink, null
                    )
                )
                ring_rubberseekbar!!.setHighlightTrackColor(
                    context!!.resources.getColor(
                        color.pink,
                        null
                    )
                )
                ring_rubberseekbar!!.setHighlightThumbOnTouchColor(
                    context!!.resources.getColor(
                        color.pink, null
                    )
                )
                alarm_rubberseekbar!!.setHighlightTrackColor(
                    context!!.resources.getColor(
                        color.pink,
                        null
                    )
                )
                alarm_rubberseekbar!!.setHighlightThumbOnTouchColor(
                    context!!.resources.getColor(
                        color.pink, null
                    )
                )
                call_rubberseekbar!!.setHighlightTrackColor(
                    context!!.resources.getColor(
                        color.pink,
                        null
                    )
                )
                call_rubberseekbar!!.setHighlightThumbOnTouchColor(
                    context!!.resources.getColor(
                        color.pink, null
                    )
                )
            } else if (coloridElastic == "green") {
                if (music_rubberseekbar!!.getCurrentValue() > 0) {
                    musicImage!!.setImageResource(drawable.ic_musicnote_android10)
                } else if (music_rubberseekbar!!.getCurrentValue() == 0) {
                    musicImage!!.setImageResource(drawable.ic_android10_music_off)
                }
                if (ring_rubberseekbar!!.getCurrentValue() > 0) {
                    ringImage!!.setImageResource(drawable.ic_notification_android10)
                } else if (ring_rubberseekbar!!.getCurrentValue() == 0) {
                    ringImage!!.setImageResource(drawable.ic_notifications_off_android10)

                }
                if (alarm_rubberseekbar!!.getCurrentValue() > 0) {
                    alarmImage!!.setImageResource(drawable.ic_alarm_android10)
                } else if (alarm_rubberseekbar!!.getCurrentValue() == 0) {
                    alarmImage!!.setImageResource(drawable.ic_baseline_alarm_off_android10)
                }
                callImage!!.setImageResource(drawable.ic_call_android10)

                music_rubberseekbar!!.setHighlightTrackColor(
                    context!!.resources.getColor(
                        color.green,
                        null
                    )
                )
                music_rubberseekbar!!.setHighlightThumbOnTouchColor(
                    context!!.resources.getColor(
                        color.green, null
                    )
                )
                ring_rubberseekbar!!.setHighlightTrackColor(
                    context!!.resources.getColor(
                        color.green,
                        null
                    )
                )
                ring_rubberseekbar!!.setHighlightThumbOnTouchColor(
                    context!!.resources.getColor(
                        color.green, null
                    )
                )
                alarm_rubberseekbar!!.setHighlightTrackColor(
                    context!!.resources.getColor(
                        color.green,
                        null
                    )
                )
                alarm_rubberseekbar!!.setHighlightThumbOnTouchColor(
                    context!!.resources.getColor(
                        color.green, null
                    )
                )
                call_rubberseekbar!!.setHighlightTrackColor(
                    context!!.resources.getColor(
                        color.green,
                        null
                    )
                )
                call_rubberseekbar!!.setHighlightThumbOnTouchColor(
                    context!!.resources.getColor(
                        color.green, null
                    )
                )
            } else if (coloridElastic == "default") {
                if (music_rubberseekbar!!.getCurrentValue() > 0) {
                    musicImage!!.setImageResource(drawable.ic_blue_music_note_android10)
                } else if (music_rubberseekbar!!.getCurrentValue() == 0) {
                    musicImage!!.setImageResource(drawable.ic_blue_music_off_android10)
                }
                if (ring_rubberseekbar!!.getCurrentValue() > 0) {
                    ringImage!!.setImageResource(drawable.ic_blue_notifications_android10)
                } else if (ring_rubberseekbar!!.getCurrentValue() == 0) {
                    ringImage!!.setImageResource(drawable.ic_blue_notifications_off_android10)

                }
                if (alarm_rubberseekbar!!.getCurrentValue() > 0) {
                    alarmImage!!.setImageResource(drawable.ic_blue_alarm_android10)
                } else if (alarm_rubberseekbar!!.getCurrentValue() == 0) {
                    alarmImage!!.setImageResource(drawable.ic_blue_alarm_off_android10)
                }
                callImage!!.setImageResource(drawable.ic_blue_call_android)

                music_rubberseekbar!!.setHighlightTrackColor(
                    context!!.resources.getColor(
                        color.blue,
                        null
                    )
                )
                music_rubberseekbar!!.setHighlightThumbOnTouchColor(
                    context!!.resources.getColor(
                        color.blue, null
                    )
                )
                ring_rubberseekbar!!.setHighlightTrackColor(
                    context!!.resources.getColor(
                        color.blue,
                        null
                    )
                )
                ring_rubberseekbar!!.setHighlightThumbOnTouchColor(
                    context!!.resources.getColor(
                        color.blue, null
                    )
                )
                alarm_rubberseekbar!!.setHighlightTrackColor(
                    context!!.resources.getColor(
                        color.blue,
                        null
                    )
                )
                alarm_rubberseekbar!!.setHighlightThumbOnTouchColor(
                    context!!.resources.getColor(
                        color.blue, null
                    )
                )
                call_rubberseekbar!!.setHighlightTrackColor(
                    context!!.resources.getColor(
                        color.blue,
                        null
                    )
                )
                call_rubberseekbar!!.setHighlightThumbOnTouchColor(
                    context!!.resources.getColor(
                        color.blue, null
                    )
                )
            }
        }

        if (positionidElastic == "top") {
            mParams!!.gravity = Gravity.TOP
            mWindowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        } else if (positionidElastic == "bottom") {
            mParams!!.gravity = Gravity.BOTTOM
            mWindowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            btn_show_more!!.setImageResource(drawable.ic_arrow_up)
            btn_show_less!!.setImageResource(drawable.ic_arrow_down)

        } else/* if(positionid=="default")*/ {
            mParams!!.gravity = Gravity.TOP
            mWindowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        }

    }

    //==============================================================WINDOW10 SEEKBAR=================================================================================//


    private fun window10() {
        layoutInflater =
            context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        // inflating the view with the custom layout created
        mView = layoutInflater!!.inflate(layout.style_3_full, null)
        audioManager = context!!.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        android10_seekbar = mView!!.findViewById<SeekBar>(id.window10_musicseekbar)
        android10_ring_seekbar = mView!!.findViewById<SeekBar>(id.window10_ringseekbar)
        android10_alarm_seekbar = mView!!.findViewById<SeekBar>(id.window10_alarm_seekbar)
        android10_call_seekbar = mView!!.findViewById<SeekBar>(id.window10_call_seekbar)

        musicImage = mView!!.findViewById(id.music_icon_window10)
        ringImage = mView!!.findViewById(id.ring_icon_window10)
        alarmImage = mView!!.findViewById(id.alarmicon_window10)
        callImage = mView!!.findViewById(id.callicon_window10)

        hiddenview = mView!!.findViewById(id.hidden_view)

        myRunnable = Runnable {
            Log.e("TESTTAG", "onCreate: ")
            closeWindow()
        }
        start()

        seekbarname_type = "music"

        android10_seekbar!!.max = (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_MUSIC))
        android10_seekbar!!.progress = (audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC))
        if (android10_seekbar!!.progress == 0) {
            if (coloridWindow10 == "green") {
                musicImage!!.setImageResource(drawable.ic_android10_music_off)
            } else if (coloridWindow10 == "teal") {
                musicImage!!.setImageResource(drawable.ic_teal_music_off_android10)
            } else if (coloridWindow10 == "red") {
                musicImage!!.setImageResource(drawable.ic_red_music_off_android10)
            } else if (coloridWindow10 == "pink") {
                musicImage!!.setImageResource(drawable.ic_pink_music_off_android10)
            } else {
                musicImage!!.setImageResource(drawable.ic_blue_music_off_android10)
            }

//            musicImage!!.setImageResource(R.drawable.ic_music_off_black)
        }

        android10_ring_seekbar!!.max = (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_RING))
        android10_ring_seekbar!!.progress =
            (audioManager!!.getStreamVolume(AudioManager.STREAM_RING))
        if (android10_ring_seekbar!!.progress == 0) {
            if (coloridWindow10 == "green") {
                ringImage!!.setImageResource(drawable.ic_notifications_off_android10)
            } else if (coloridWindow10 == "teal") {
                ringImage!!.setImageResource(drawable.ic_teal_notifications_off_android10)
            } else if (coloridWindow10 == "red") {
                ringImage!!.setImageResource(drawable.ic_red_notifications_off_android10)
            } else if (coloridWindow10 == "pink") {
                ringImage!!.setImageResource(drawable.ic_pink_notifications_off_android10)
            } else {
                ringImage!!.setImageResource(drawable.ic_blue_notifications_off_android10)
            }

//            ringImage!!.setImageResource(R.drawable.ic_notifications_off_black)
        }

        android10_alarm_seekbar!!.max =
            (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_ALARM))
        android10_alarm_seekbar!!.progress =
            (audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM))
        if (android10_alarm_seekbar!!.progress == 0) {
            if (coloridWindow10 == "green") {
                alarmImage!!.setImageResource(drawable.ic_baseline_alarm_off_android10)
            } else if (coloridWindow10 == "teal") {
                alarmImage!!.setImageResource(drawable.ic_teal_alarm_off_android10)
            } else if (coloridWindow10 == "red") {
                alarmImage!!.setImageResource(drawable.ic_red_alarm_off_android10)
            } else if (coloridWindow10 == "pink") {
                alarmImage!!.setImageResource(drawable.ic_pink_alarm_off_android10)
            } else {
                alarmImage!!.setImageResource(drawable.ic_blue_alarm_off_android10)
            }
//            alarmImage!!.setImageResource(R.drawable.ic_alarm_off_black)
        }

        android10_call_seekbar!!.max =
            (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL))
        android10_call_seekbar!!.progress =
            (audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL))


        btn_show_more = mView!!.findViewById(id.btn_show_more)
        btn_show_more!!.setOnClickListener {
            hiddenview!!.visibility = View.VISIBLE

            btn_show_more!!.visibility = View.GONE
            btn_show_less!!.visibility = View.VISIBLE

            seekbarname_type = "music"

            mWindowManager!!.updateViewLayout(mView, mParams)
        }

        btn_show_less = mView!!.findViewById(id.btn_show_less)
        btn_show_less!!.setOnClickListener {
            hiddenview!!.visibility = View.GONE

            btn_show_more!!.visibility = View.VISIBLE
            btn_show_less!!.visibility = View.GONE

            seekbarname_type = "music"

            mWindowManager!!.updateViewLayout(mView, mParams)

        }

        Log.e("volume", android10_seekbar!!.progress.toString() + " volume")
        android10_seekbar!!.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {

                restart()

                seekbarname_type = "music"
                // write custom code for progress is changed
                audioManager!!.setStreamVolume(
                    AudioManager.STREAM_MUSIC,
                    progress, 0
                )
                if (android10_seekbar!!.progress > 0) {
                    if (coloridWindow10 == "teal") {
                        musicImage!!.setImageResource(drawable.ic_teal_music_note_android10)
                    } else if (coloridWindow10 == "green") {
                        musicImage!!.setImageResource(drawable.ic_musicnote_android10)
                    } else if (coloridWindow10 == "pink") {
                        musicImage!!.setImageResource(drawable.ic_pink_music_note_android10)
                    } else if (coloridWindow10 == "red") {
                        musicImage!!.setImageResource(drawable.ic_red_music_note_android10)
                    } else {
                        musicImage!!.setImageResource(drawable.ic_blue_music_note_android10)
                    }
                }
                if (android10_seekbar!!.progress == 0) {
                    if (coloridWindow10 == "teal") {
                        musicImage!!.setImageResource(drawable.ic_teal_music_off_android10)
                    } else if (coloridWindow10 == "green") {
                        musicImage!!.setImageResource(drawable.ic_android10_music_off)
                    } else if (coloridWindow10 == "pink") {
                        musicImage!!.setImageResource(drawable.ic_pink_music_off_android10)
                    } else if (coloridWindow10 == "red") {
                        musicImage!!.setImageResource(drawable.ic_red_music_off_android10)
                    } else {
                        musicImage!!.setImageResource(drawable.ic_blue_music_off_android10)
                    }
                }

//                if(android10_seekbar!!.progress>0)
//                {
//                    musicImage!!.setImageResource(R.drawable.ic_music_window10);
//                }
//                if(android10_seekbar!!.progress==0){
//                    musicImage!!.setImageResource(R.drawable.ic_music_off_black)
//                }
            }

            override fun onStartTrackingTouch(seek: SeekBar) {}

            override fun onStopTrackingTouch(seek: SeekBar) {}
        })

        android10_ring_seekbar!!.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {

                restart()

                seekbarname_type = "ring"
                // write custom code for progress is changed

                audioManager!!.setStreamVolume(
                    AudioManager.STREAM_RING,
                    progress, 0
                )
                if (android10_ring_seekbar!!.progress > 0) {
                    if (coloridWindow10 == "green") {
                        ringImage!!.setImageResource(drawable.ic_notification_android10)
                    } else if (coloridWindow10 == "red") {
                        ringImage!!.setImageResource(drawable.ic_red_notifications_android10)
                    } else if (coloridWindow10 == "teal") {
                        ringImage!!.setImageResource(drawable.ic_teal_notifications_android10)
                    } else if (coloridWindow10 == "pink") {
                        ringImage!!.setImageResource(drawable.ic_pink_notifications_android10)
                    } else {
                        ringImage!!.setImageResource(drawable.ic_blue_notifications_android10)
                    }
                }
                if (android10_ring_seekbar!!.progress == 0) {
                    if (coloridWindow10 == "green") {
                        ringImage!!.setImageResource(drawable.ic_notifications_off_android10)
                    } else if (coloridWindow10 == "red") {
                        ringImage!!.setImageResource(drawable.ic_red_notifications_off_android10)
                    } else if (coloridWindow10 == "teal") {
                        ringImage!!.setImageResource(drawable.ic_teal_notifications_off_android10)
                    } else if (coloridWindow10 == "pink") {
                        ringImage!!.setImageResource(drawable.ic_pink_notifications_off_android10)
                    } else {
                        ringImage!!.setImageResource(drawable.ic_blue_notifications_off_android10)
                    }
                }
//                if(android10_ring_seekbar!!.progress>0)
//                {
//                    ringImage!!.setImageResource(R.drawable.ic_notification_window10)
//                }
//                if(android10_ring_seekbar!!.progress==0){
//                    ringImage!!.setImageResource(R.drawable.ic_notifications_off_black)
//                }
            }

            override fun onStartTrackingTouch(seek: SeekBar) {}

            override fun onStopTrackingTouch(seek: SeekBar) {}
        })

        android10_alarm_seekbar!!.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {

                restart()

                seekbarname_type = "alarm"
                // write custom code for progress is changed
                audioManager!!.setStreamVolume(AudioManager.STREAM_ALARM, progress, 0)
                if (android10_alarm_seekbar!!.progress > 0) {
                    if (coloridWindow10 == "green") {
                        alarmImage!!.setImageResource(drawable.ic_alarm_android10)
                    } else if (coloridWindow10 == "red") {
                        alarmImage!!.setImageResource(drawable.ic_red_alarm_android10);
                    } else if (coloridWindow10 == "teal") {
                        alarmImage!!.setImageResource(drawable.ic_teal_alarm_android10);
                    } else if (coloridWindow10 == "pink") {
                        alarmImage!!.setImageResource(drawable.ic_pink_alarm_android10);
                    } else {
                        alarmImage!!.setImageResource(drawable.ic_blue_alarm_android10); }
                }
                if (android10_alarm_seekbar!!.progress == 0) {
                    if (coloridWindow10 == "green") {
                        alarmImage!!.setImageResource(drawable.ic_baseline_alarm_off_android10)
                    } else if (coloridWindow10 == "red") {
                        alarmImage!!.setImageResource(drawable.ic_red_alarm_off_android10);
                    } else if (coloridWindow10 == "teal") {
                        alarmImage!!.setImageResource(drawable.ic_teal_alarm_off_android10);
                    } else if (coloridWindow10 == "pink") {
                        alarmImage!!.setImageResource(drawable.ic_pink_alarm_off_android10);
                    } else {
                        alarmImage!!.setImageResource(drawable.ic_blue_alarm_off_android10); }
                }
//                if(android10_alarm_seekbar!!.progress>0)
//                {
//                    alarmImage!!.setImageResource(R.drawable.ic_alarm_window10)
//                }
//                if(android10_alarm_seekbar!!.progress==0){
//                    alarmImage!!.setImageResource(R.drawable.ic_alarm_off_black)
//                }
            }

            override fun onStartTrackingTouch(seek: SeekBar) {}

            override fun onStopTrackingTouch(seek: SeekBar) {}
        })

        android10_call_seekbar!!.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                restart()

                seekbarname_type = "call"
                // write custom code for progress is changed
                audioManager!!.setStreamVolume(
                    AudioManager.STREAM_VOICE_CALL,
                    progress, 0
                )
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
            }
        })

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (coloridWindow10 == "red") {
                if (android10_seekbar!!.progress > 0) {
                    musicImage!!.setImageResource(drawable.ic_red_music_note_android10)
                } else if (android10_seekbar!!.progress == 0) {
                    musicImage!!.setImageResource(drawable.ic_red_music_off_android10)
                }
                if (android10_ring_seekbar!!.progress > 0) {
                    ringImage!!.setImageResource(drawable.ic_red_notifications_android10)
                } else if (android10_ring_seekbar!!.progress == 0) {
                    ringImage!!.setImageResource(drawable.ic_red_notifications_off_android10)

                }
                if (android10_alarm_seekbar!!.progress > 0) {
                    alarmImage!!.setImageResource(drawable.ic_red_alarm_android10)
                } else if (android10_alarm_seekbar!!.progress == 0) {
                    alarmImage!!.setImageResource(drawable.ic_red_alarm_off_android10)
                }
                callImage!!.setImageResource(drawable.ic_red_call_android10)

                android10_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.red, null
                        )
                    )
                )
                android10_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.red, null
                    )
                ))
                android10_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_red, null
                    )
                ))
                android10_ring_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.red, null
                        )
                    )
                )
                android10_ring_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.red, null
                    )
                ))
                android10_ring_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_red, null
                    )
                ))
                android10_alarm_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.red, null
                        )
                    )
                )
                android10_alarm_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.red, null
                    )
                ))
                android10_alarm_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_red, null
                    )
                ))
                android10_call_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.red, null
                        )
                    )
                )
                android10_call_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.red, null
                    )
                ))
                android10_call_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_red, null
                    )
                ))
            } else if (coloridWindow10 == "teal") {
                if (android10_seekbar!!.progress > 0) {
                    musicImage!!.setImageResource(drawable.ic_teal_music_note_android10)
                } else if (android10_seekbar!!.progress == 0) {
                    musicImage!!.setImageResource(drawable.ic_teal_music_off_android10)
                }
                if (android10_ring_seekbar!!.progress > 0) {
                    ringImage!!.setImageResource(drawable.ic_teal_notifications_android10)
                } else if (android10_ring_seekbar!!.progress == 0) {
                    ringImage!!.setImageResource(drawable.ic_teal_notifications_off_android10)
                }
                if (android10_alarm_seekbar!!.progress > 0) {
                    alarmImage!!.setImageResource(drawable.ic_teal_alarm_android10)
                } else if (android10_alarm_seekbar!!.progress == 0) {
                    alarmImage!!.setImageResource(drawable.ic_teal_alarm_off_android10)
                }
                callImage!!.setImageResource(drawable.ic_teal_call_android10)

                android10_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.teal_200, null
                        )
                    )
                )
                android10_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.teal_200, null
                    )
                ))
                android10_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_teal_200, null
                    )
                ))
                android10_ring_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.teal_200, null
                        )
                    )
                )
                android10_ring_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.teal_200, null
                    )
                ))
                android10_ring_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_teal_200, null
                    )
                ))
                android10_alarm_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.teal_200, null
                        )
                    )
                )
                android10_alarm_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.teal_200, null
                    )
                ))
                android10_alarm_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_teal_200, null
                    )
                ))
                android10_call_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.teal_200, null
                        )
                    )
                )
                android10_call_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.teal_200, null
                    )
                ))
                android10_call_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_teal_200, null
                    )
                ))
            } else if (coloridWindow10 == "green") {
                if (android10_seekbar!!.progress > 0) {
                    musicImage!!.setImageResource(drawable.ic_musicnote_android10)
                } else if (android10_seekbar!!.progress == 0) {
                    musicImage!!.setImageResource(drawable.ic_android10_music_off)
                }
                if (android10_ring_seekbar!!.progress > 0) {
                    ringImage!!.setImageResource(drawable.ic_notification_android10)
                } else if (android10_ring_seekbar!!.progress == 0) {
                    ringImage!!.setImageResource(drawable.ic_notifications_off_android10)

                }
                if (android10_alarm_seekbar!!.progress > 0) {
                    alarmImage!!.setImageResource(drawable.ic_alarm_android10)
                } else if (android10_alarm_seekbar!!.progress == 0) {
                    alarmImage!!.setImageResource(drawable.ic_baseline_alarm_off_android10)
                }
                callImage!!.setImageResource(drawable.ic_call_android10)

                android10_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.green, null
                        )
                    )
                )
                android10_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.green, null
                    )
                ))
                android10_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_green, null
                    )
                ))
                android10_ring_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.green, null
                        )
                    )
                )
                android10_ring_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.green, null
                    )
                ))
                android10_ring_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_green, null
                    )
                ))
                android10_alarm_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.green, null
                        )
                    )
                )
                android10_alarm_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.green, null
                    )
                ))
                android10_alarm_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_green, null
                    )
                ))
                android10_call_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.green, null
                        )
                    )
                )
                android10_call_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.green, null
                    )
                ))
                android10_call_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_green, null
                    )
                ))
            } else if (coloridWindow10 == "pink") {
                if (android10_seekbar!!.progress > 0) {
                    musicImage!!.setImageResource(drawable.ic_pink_music_note_android10)
                } else if (android10_seekbar!!.progress == 0) {
                    musicImage!!.setImageResource(drawable.ic_pink_music_off_android10)
                }
                if (android10_ring_seekbar!!.progress > 0) {
                    ringImage!!.setImageResource(drawable.ic_pink_notifications_android10)
                } else if (android10_ring_seekbar!!.progress == 0) {
                    ringImage!!.setImageResource(drawable.ic_pink_notifications_off_android10)

                }
                if (android10_alarm_seekbar!!.progress > 0) {
                    alarmImage!!.setImageResource(drawable.ic_pink_alarm_android10)
                } else if (android10_alarm_seekbar!!.progress == 0) {
                    alarmImage!!.setImageResource(drawable.ic_pink_alarm_off_android10)
                }
                callImage!!.setImageResource(drawable.ic_pink_call_android10)

                android10_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.pink, null
                        )
                    )
                )
                android10_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.pink, null
                    )
                ))
                android10_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_pink, null
                    )
                ))
                android10_ring_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.pink, null
                        )
                    )
                )
                android10_ring_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.pink, null
                    )
                ))
                android10_ring_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_pink, null
                    )
                ))
                android10_alarm_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.pink, null
                        )
                    )
                )
                android10_alarm_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.pink, null
                    )
                ))
                android10_alarm_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_pink, null
                    )
                ))
                android10_call_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.pink, null
                        )
                    )
                )
                android10_call_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.pink, null
                    )
                ))
                android10_call_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_pink, null
                    )
                ))
            } else if (coloridWindow10 == "default") {
                if (android10_seekbar!!.progress > 0) {
                    musicImage!!.setImageResource(drawable.ic_blue_music_note_android10)
                } else if (android10_seekbar!!.progress == 0) {
                    musicImage!!.setImageResource(drawable.ic_blue_music_off_android10)
                }
                if (android10_ring_seekbar!!.progress > 0) {
                    ringImage!!.setImageResource(drawable.ic_blue_notifications_android10)
                } else if (android10_ring_seekbar!!.progress == 0) {
                    ringImage!!.setImageResource(drawable.ic_blue_notifications_off_android10)

                }
                if (android10_alarm_seekbar!!.progress > 0) {
                    alarmImage!!.setImageResource(drawable.ic_blue_alarm_android10)
                } else if (android10_alarm_seekbar!!.progress == 0) {
                    alarmImage!!.setImageResource(drawable.ic_blue_alarm_off_android10)
                }
                callImage!!.setImageResource(drawable.ic_blue_call_android)

                android10_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.blue, null
                        )
                    )
                )
                android10_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.blue, null
                    )
                ))
                android10_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_blue, null
                    )
                ))
                android10_ring_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.blue, null
                        )
                    )
                )
                android10_ring_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.blue, null
                    )
                ))
                android10_ring_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_blue, null
                    )
                ))
                android10_alarm_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.blue, null
                        )
                    )
                )
                android10_alarm_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.blue, null
                    )
                ))
                android10_alarm_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_blue, null
                    )
                ))
                android10_call_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.blue, null
                        )
                    )
                )
                android10_call_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.blue, null
                    )
                ))
                android10_call_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_blue, null
                    )
                ))
            }
        }

        if (positionidWindow10 == "left") {
            mParams!!.gravity = Gravity.LEFT
            mWindowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            btn_show_more!!.setImageResource(drawable.ic_show_less)
            btn_show_less!!.setImageResource(drawable.ic_show_more)
        } else if (positionidWindow10 == "right") {
            mParams!!.gravity = Gravity.RIGHT
            mWindowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        } else/* if(positionid=="default")*/ {
            mParams!!.gravity = Gravity.RIGHT
            mWindowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        }
    }

    //===============================================================ANDROID SEEKBAR==============================================================================//

    private fun android() {
        layoutInflater =
            context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        var cardview: CardView? = null
        var btn_show_less_android: ImageView? = null
        mView = layoutInflater!!.inflate(layout.style_2_full, null)
        hiddencardView = mView!!.findViewById(id.hidden_view)
//        cardview = mView!!.findViewById(id.cardview_show_less)


        audioManager = context!!.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        android_music_seekbar = mView!!.findViewById<VerticalSeekBar>(id.android_music_seekBar)
        android_ring_seekbar = mView!!.findViewById<VerticalSeekBar>(id.android_ring_seekBar)
        android_alarm_seekbar = mView!!.findViewById<VerticalSeekBar>(id.android_alarm_seekBar)
        android_call_seekbar = mView!!.findViewById<VerticalSeekBar>(id.android_call_seekBar)
        android_music_seekbar_hidden =
            mView!!.findViewById<VerticalSeekBar>(id.android_music_seekBar_hidden)
        btn_show_less_android = mView!!.findViewById(id.btn_show_less)

        musicImage = mView!!.findViewById(id.android_music_image)
        music_icon_android10 = mView!!.findViewById(id.android_music_image_hidden)
        ringImage = mView!!.findViewById(id.android_ring_image)
        alarmImage = mView!!.findViewById(id.android_alarm_image)

        android_music_seekbar!!.maxValue =
            (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_MUSIC))
        android_music_seekbar!!.progress =
            (audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC))
        if (android_music_seekbar!!.progress == 0) {
            musicImage!!.setImageResource(drawable.ic_music_off_black)
            music_icon_android10!!.setImageResource(drawable.ic_music_off_white)
        }
        android_music_seekbar_hidden!!.maxValue =
            (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_MUSIC))
        android_music_seekbar_hidden!!.progress =
            (audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC))
        if (android_music_seekbar_hidden!!.progress == 0) {
            musicImage!!.setImageResource(drawable.ic_music_off_white)
            music_icon_android10!!.setImageResource(drawable.ic_music_off_white)
        }

        android_ring_seekbar!!.maxValue =
            (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_RING))
        android_ring_seekbar!!.progress = (audioManager!!.getStreamVolume(AudioManager.STREAM_RING))
        if (android_ring_seekbar!!.progress == 0) {
            ringImage!!.setImageResource(drawable.ic_notifications_off_white)
        }

        android_alarm_seekbar!!.maxValue =
            (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_ALARM))
        android_alarm_seekbar!!.progress =
            (audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM))
        if (android_alarm_seekbar!!.progress == 0) {
            alarmImage!!.setImageResource(drawable.ic_alarm_off_white)
        }
        android_call_seekbar!!.maxValue =
            (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL))
        android_call_seekbar!!.progress =
            (audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL))

//        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.O) {
//            android_music_seekbar!!.barCornerRadius = 60
//        }

        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.O) {
            android_music_seekbar!!.barCornerRadius = 50
            android_music_seekbar_hidden!!.barCornerRadius = 50
            android_ring_seekbar!!.barCornerRadius = 50
            android_alarm_seekbar!!.barCornerRadius = 50
            android_call_seekbar!!.barCornerRadius = 50
        } else if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            android_music_seekbar!!.barCornerRadius = 80
            android_music_seekbar_hidden!!.barCornerRadius = 80
            android_ring_seekbar!!.barCornerRadius = 80
            android_alarm_seekbar!!.barCornerRadius = 80
            android_call_seekbar!!.barCornerRadius = 80
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (coloridAndroid == "green") {
                android_music_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                    context!!,
                    color.android_green_start
                )
                android_music_seekbar!!.barProgressEndColor = ContextCompat.getColor(
                    context!!,
                    color.green
                )
                android_music_seekbar_hidden!!.barProgressStartColor = ContextCompat.getColor(
                    context!!,
                    color.android_green_start
                )
                android_music_seekbar_hidden!!.barProgressEndColor = ContextCompat.getColor(
                    context!!,
                    color.green
                )
                android_ring_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                    context!!,
                    color.android_green_start
                )
                android_ring_seekbar!!.barProgressEndColor = ContextCompat.getColor(
                    context!!,
                    color.green
                )
                android_alarm_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                    context!!,
                    color.android_green_start
                )
                android_alarm_seekbar!!.barProgressEndColor = ContextCompat.getColor(
                    context!!,
                    color.green
                )
                android_call_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                    context!!,
                    color.android_green_start
                )
                android_call_seekbar!!.barProgressEndColor = ContextCompat.getColor(
                    context!!,
                    color.green
                )
            } else if (coloridAndroid == "teal") {
                android_music_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                    context!!,
                    color.android_teal_start
                )
                android_music_seekbar!!.barProgressEndColor = ContextCompat.getColor(
                    context!!,
                    color.teal_200
                )
                android_music_seekbar_hidden!!.barProgressStartColor = ContextCompat.getColor(
                    context!!,
                    color.android_teal_start
                )
                android_music_seekbar_hidden!!.barProgressEndColor = ContextCompat.getColor(
                    context!!,
                    color.teal_200
                )
                android_ring_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                    context!!,
                    color.android_teal_start
                )
                android_ring_seekbar!!.barProgressEndColor = ContextCompat.getColor(
                    context!!,
                    color.teal_200
                )
                android_alarm_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                    context!!,
                    color.android_teal_start
                )
                android_alarm_seekbar!!.barProgressEndColor = ContextCompat.getColor(
                    context!!,
                    color.teal_200
                )
                android_call_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                    context!!,
                    color.android_teal_start
                )
                android_call_seekbar!!.barProgressEndColor = ContextCompat.getColor(
                    context!!,
                    color.teal_200
                )
            } else if (coloridAndroid == "red") {
                android_music_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                    context!!,
                    color.android_red_start
                )
                android_music_seekbar!!.barProgressEndColor = ContextCompat.getColor(
                    context!!,
                    color.red
                )
                android_music_seekbar_hidden!!.barProgressStartColor = ContextCompat.getColor(
                    context!!,
                    color.android_red_start
                )
                android_music_seekbar_hidden!!.barProgressEndColor = ContextCompat.getColor(
                    context!!,
                    color.red
                )
                android_ring_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                    context!!,
                    color.android_red_start
                )
                android_ring_seekbar!!.barProgressEndColor = ContextCompat.getColor(
                    context!!,
                    color.red
                )
                android_alarm_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                    context!!,
                    color.android_red_start
                )
                android_alarm_seekbar!!.barProgressEndColor = ContextCompat.getColor(
                    context!!,
                    color.red
                )
                android_call_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                    context!!,
                    color.android_red_start
                )
                android_call_seekbar!!.barProgressEndColor = ContextCompat.getColor(
                    context!!,
                    color.red
                )
            } else if (coloridAndroid == "pink") {
                android_music_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                    context!!,
                    color.android_pink_start
                )
                android_music_seekbar!!.barProgressEndColor = ContextCompat.getColor(
                    context!!,
                    color.pink
                )
                android_music_seekbar_hidden!!.barProgressStartColor = ContextCompat.getColor(
                    context!!,
                    color.android_pink_start
                )
                android_music_seekbar_hidden!!.barProgressEndColor = ContextCompat.getColor(
                    context!!,
                    color.pink
                )
                android_ring_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                    context!!,
                    color.android_pink_start
                )
                android_ring_seekbar!!.barProgressEndColor = ContextCompat.getColor(
                    context!!,
                    color.pink
                )
                android_alarm_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                    context!!,
                    color.android_pink_start
                )
                android_alarm_seekbar!!.barProgressEndColor = ContextCompat.getColor(
                    context!!,
                    color.pink
                )
                android_call_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                    context!!,
                    color.android_pink_start
                )
                android_call_seekbar!!.barProgressEndColor = ContextCompat.getColor(
                    context!!,
                    color.pink
                )
            } else if (coloridAndroid == "default") {
                android_music_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                    context!!,
                    color.android_blue_start
                )
                android_music_seekbar!!.barProgressEndColor = ContextCompat.getColor(
                    context!!,
                    color.android_blue_end
                )
                android_music_seekbar_hidden!!.barProgressStartColor = ContextCompat.getColor(
                    context!!,
                    color.android_blue_start
                )
                android_music_seekbar_hidden!!.barProgressEndColor = ContextCompat.getColor(
                    context!!,
                    color.android_blue_end
                )
                android_ring_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                    context!!,
                    color.android_blue_start
                )
                android_ring_seekbar!!.barProgressEndColor = ContextCompat.getColor(
                    context!!,
                    color.android_blue_end
                )
                android_alarm_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                    context!!,
                    color.android_blue_start
                )
                android_alarm_seekbar!!.barProgressEndColor = ContextCompat.getColor(
                    context!!,
                    color.android_blue_end
                )
                android_call_seekbar!!.barProgressStartColor = ContextCompat.getColor(
                    context!!,
                    color.android_blue_start
                )
                android_call_seekbar!!.barProgressEndColor = ContextCompat.getColor(
                    context!!,
                    color.android_blue_end
                )
            }
        }


        btn_show_more_android11 = mView!!.findViewById(id.btn_show_more)
        btn_show_more_android11!!.setOnClickListener {

            hiddencardView!!.visibility = View.VISIBLE
            android_music_seekbar!!.visibility = View.GONE

            cardview!!.visibility = View.VISIBLE
            btn_show_less_android!!.visibility = View.VISIBLE

            setHiddenViewSeekbars()

        }


        btn_show_less_android!!.setOnClickListener {

            hiddencardView!!.visibility = View.GONE
            android_music_seekbar!!.visibility = View.VISIBLE

            cardview!!.visibility = View.GONE
            btn_show_less_android!!.visibility = View.VISIBLE

            android_music_seekbar!!.maxValue =
                (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_MUSIC))
            android_music_seekbar!!.progress =
                (audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC))
            if (android_music_seekbar!!.progress == 0) {
                musicImage!!.setImageResource(drawable.ic_music_off_black)
                music_icon_android10!!.setImageResource(drawable.ic_music_off_white)
            }
            seekbarname_type = "music"

            mWindowManager!!.updateViewLayout(mView, mParams)

        }

        myRunnable = Runnable {

            Log.e("TESTTAG", "onCreate: ")
            closeWindow()
        }

        start()

        seekbarname_type = "music"

        android_music_seekbar!!.setOnProgressChangeListener { progressValue ->
            Log.d("VerticalSeekBar", "PROGRESS CHANGED at value: $progressValue")

            restart()

            seekbarname_type = "music"
            audioManager!!.setStreamVolume(
                AudioManager.STREAM_MUSIC,
                progressValue, 0
            )

            if (android_music_seekbar!!.progress > 0) {
                musicImage!!.setImageResource(drawable.ic_android_music_note)
                music_icon_android10!!.setImageResource(drawable.ic_android_music_note)
            }
            if (android_music_seekbar!!.progress == 0) {
                musicImage!!.setImageResource(drawable.ic_music_off_white)
                music_icon_android10!!.setImageResource(drawable.ic_music_off_white)
            }
        }
        android_music_seekbar!!.setOnReleaseListener { progressValue ->
            if (android_music_seekbar!!.progress > 0) {
                musicImage!!.setImageResource(drawable.ic_android_music_note)
                music_icon_android10!!.setImageResource(drawable.ic_android_music_note)
            }
            if (android_music_seekbar!!.progress == 0) {
                musicImage!!.setImageResource(drawable.ic_music_off_white)
                music_icon_android10!!.setImageResource(drawable.ic_music_off_white)
            }
        }

        android_music_seekbar_hidden!!.setOnProgressChangeListener { progressValue ->
            Log.d("VerticalSeekBar", "PROGRESS CHANGED at value: $progressValue")

            restart()

            seekbarname_type = "music"
            audioManager!!.setStreamVolume(
                AudioManager.STREAM_MUSIC,
                progressValue, 0
            )


            if (android_music_seekbar_hidden!!.progress > 0) {
                musicImage!!.setImageResource(drawable.ic_android_music_note)
                music_icon_android10!!.setImageResource(drawable.ic_android_music_note)
            }
            if (android_music_seekbar_hidden!!.progress == 0) {
                musicImage!!.setImageResource(drawable.ic_music_off_white)
                music_icon_android10!!.setImageResource(drawable.ic_music_off_white)
            }
        }

        android_music_seekbar_hidden!!.setOnReleaseListener { progressValue ->
            if (android_music_seekbar_hidden!!.progress > 0) {
                musicImage!!.setImageResource(drawable.ic_android_music_note)
                music_icon_android10!!.setImageResource(drawable.ic_android_music_note)
            }
            if (android_music_seekbar_hidden!!.progress == 0) {
                musicImage!!.setImageResource(drawable.ic_music_off_white)
                music_icon_android10!!.setImageResource(drawable.ic_music_off_white)
            }
        }

        android_ring_seekbar!!.setOnProgressChangeListener { progressValue ->
            Log.d("VerticalSeekBar", "PROGRESS CHANGED at value: $progressValue")

            restart()

            seekbarname_type = "ring"
            audioManager!!.setStreamVolume(
                AudioManager.STREAM_RING,
                progressValue, 0
            )

            if (android_ring_seekbar!!.progress > 0) {
                ringImage!!.setImageResource(drawable.ic_notifications_android)
            }
            if (android_ring_seekbar!!.progress == 0) {
                ringImage!!.setImageResource(drawable.ic_notifications_off_white)
            }
        }

        android_ring_seekbar!!.setOnReleaseListener { progressValue ->
            if (android_ring_seekbar!!.progress > 0) {
                ringImage!!.setImageResource(drawable.ic_notifications_android)
            }
            if (android_ring_seekbar!!.progress == 0) {
                ringImage!!.setImageResource(drawable.ic_notifications_off_white)
            }
        }

        android_alarm_seekbar!!.setOnProgressChangeListener { progressValue ->
            Log.d("VerticalSeekBar", "PROGRESS CHANGED at value: $progressValue")

            restart()

            seekbarname_type = "alarm"
            audioManager!!.setStreamVolume(
                AudioManager.STREAM_ALARM,
                progressValue, 0
            )

            if (android_alarm_seekbar!!.progress > 0) {
                alarmImage!!.setImageResource(drawable.ic_alarm_android)
            }
            if (android_alarm_seekbar!!.progress == 0) {
                alarmImage!!.setImageResource(drawable.ic_alarm_off_white)
            }
        }

        android_alarm_seekbar!!.setOnReleaseListener { progressValue ->
            if (android_alarm_seekbar!!.progress > 0) {
                alarmImage!!.setImageResource(drawable.ic_alarm_android)
            }
            if (android_alarm_seekbar!!.progress == 0) {
                alarmImage!!.setImageResource(drawable.ic_alarm_off_white)
            }
        }

        android_call_seekbar!!.setOnProgressChangeListener { progressValue ->
            Log.d("VerticalSeekBar", "PROGRESS CHANGED at value: $progressValue")

            restart()

            seekbarname_type = "call"
            audioManager!!.setStreamVolume(
                AudioManager.STREAM_VOICE_CALL,
                progressValue, 0
            )
        }


        if (positionidAndroid == "left") {
            mParams!!.gravity = Gravity.LEFT
            mWindowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        } else if (positionidAndroid == "right") {
            mParams!!.gravity = Gravity.RIGHT
            mWindowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        } else/* if(positionid=="default")*/ {
            mParams!!.gravity = Gravity.RIGHT
            mWindowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        }
    }

    //=====================================================ANDROID HIDDEN SEEKBAR======================================================================//

    private fun setHiddenViewSeekbars() {
        android_music_seekbar_hidden!!.maxValue =
            (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_MUSIC))
        android_music_seekbar_hidden!!.progress =
            (audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC))

        android_ring_seekbar!!.maxValue =
            (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_RING))
        android_ring_seekbar!!.progress = (audioManager!!.getStreamVolume(AudioManager.STREAM_RING))

        android_alarm_seekbar!!.maxValue =
            (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_ALARM))
        android_alarm_seekbar!!.progress =
            (audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM))

        android_call_seekbar!!.maxValue =
            (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL))
        android_call_seekbar!!.progress =
            (audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL))

        seekbarname_type = "music"

        mWindowManager!!.updateViewLayout(mView, mParams)
    }

    //============================================================ANDROID 10 SEEKBAR==============================================================================//

    var myHandler: Handler = Handler()
    private val TIME_TO_WAIT = 3000
    lateinit var myRunnable: Runnable

    fun start() {
        Log.e("TESTTAG", "TIMER STARTED")
        myHandler.postDelayed(myRunnable, TIME_TO_WAIT.toLong())
    }

    fun stop() {
        myHandler.removeCallbacks(myRunnable)
    }

    fun restart() {
        Log.e("TESTTAG", "TIMER RESTARTED")
        myHandler.removeCallbacks(myRunnable)
        myHandler.postDelayed(myRunnable, TIME_TO_WAIT.toLong())
    }

    private fun android10() {
        layoutInflater =
            context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        // inflating the view with the custom layout created
//        mView = layoutInflater!!.inflate(layout.android10, null)
        audioManager = context!!.getSystemService(Context.AUDIO_SERVICE) as AudioManager
//        android10_seekbar= mView!!.findViewById<SeekBar>(id.android10_musicseekbar)
//        android10_ring_seekbar=mView!!.findViewById<SeekBar>(id.android10_ring_seekbar)
//        android10_alarm_seekbar=mView!!.findViewById<SeekBar>(id.android10_alarm_seekbar)
//        android10_call_seekbar=mView!!.findViewById<SeekBar>(id.android10_call_seekbar)

        musicImage = mView!!.findViewById(id.music_icon_android10)
//        ringImage=mView!!.findViewById(id.ring_icon_android10)
        ringicon_android10 = mView!!.findViewById(id.ringicon_android10)
        alarmImage = mView!!.findViewById(id.alarmicon_android10)
        callImage = mView!!.findViewById(id.callicon_android10)

//        vibratecardView=mView!!.findViewById(R.id.vibratecardView)
        ringcardView = mView!!.findViewById(id.ringcardView)
        alarmcardView = mView!!.findViewById(id.alarmcardView)
        callcardView = mView!!.findViewById(id.callcardView)

        systemMusicProgress = (audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC))
        systemRingProgress = (audioManager!!.getStreamVolume(AudioManager.STREAM_RING))
        systemAlarmProgress = (audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM))
        systemCallProgress = (audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL))

        myRunnable = Runnable {
            // your code here
            Log.e("TESTTAG", "onCreate: ")
            closeWindow()
        }

        start()

        seekbarname_type = "music"

        android10_seekbar!!.max = (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_MUSIC))
        android10_seekbar!!.progress = (audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC))

        if (android10_seekbar!!.progress == 0) {
            if (coloridAndroid10 == "blue") {
                musicImage!!.setImageResource(drawable.ic_blue_music_off_android10)
            } else if (coloridAndroid10 == "teal") {
                musicImage!!.setImageResource(drawable.ic_teal_music_off_android10)
            } else if (coloridAndroid10 == "red") {
                musicImage!!.setImageResource(drawable.ic_red_music_off_android10)
            } else if (coloridAndroid10 == "pink") {
                musicImage!!.setImageResource(drawable.ic_pink_music_off_android10)
            } else {
                musicImage!!.setImageResource(drawable.ic_android10_music_off)
            }
        }

        android10_ring_seekbar!!.max = (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_RING))
        android10_ring_seekbar!!.progress =
            (audioManager!!.getStreamVolume(AudioManager.STREAM_RING))

        if (android10_ring_seekbar!!.progress == 0) {
            if (coloridAndroid10 == "blue") {
                ringImage!!.setImageResource(drawable.ic_blue_notifications_off_android10)
                ringicon_android10!!.setImageResource(drawable.ic_blue_notifications_off_android10)
            } else if (coloridAndroid10 == "red") {
                ringImage!!.setImageResource(drawable.ic_red_notifications_off_android10)
                ringicon_android10!!.setImageResource(drawable.ic_red_notifications_off_android10)
            } else if (coloridAndroid10 == "teal") {
                ringImage!!.setImageResource(drawable.ic_teal_notifications_off_android10)
                ringicon_android10!!.setImageResource(drawable.ic_teal_notifications_off_android10)
            } else if (coloridAndroid10 == "pink") {
                ringImage!!.setImageResource(drawable.ic_pink_notifications_off_android10)
                ringicon_android10!!.setImageResource(drawable.ic_pink_notifications_off_android10)
            } else {
                ringImage!!.setImageResource(drawable.ic_notifications_off_android10)
                ringicon_android10!!.setImageResource(drawable.ic_notifications_off_android10)
            }
        }

        android10_alarm_seekbar!!.max =
            (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_ALARM))
        android10_alarm_seekbar!!.progress =
            (audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM))

        if (android10_alarm_seekbar!!.progress == 0) {
            if (coloridAndroid10 == "red") {
                alarmImage!!.setImageResource(drawable.ic_red_alarm_off_android10)
            } else if (coloridAndroid10 == "teal") {
                alarmImage!!.setImageResource(drawable.ic_teal_alarm_off_android10)
            } else if (coloridAndroid10 == "blue") {
                alarmImage!!.setImageResource(drawable.ic_blue_alarm_off_android10)
            } else if (coloridAndroid10 == "pink") {
                alarmImage!!.setImageResource(drawable.ic_pink_alarm_off_android10)
            } else {
                alarmImage!!.setImageResource(drawable.ic_baseline_alarm_off_android10)
            }
        }

        android10_call_seekbar!!.max =
            (audioManager!!.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL))
        android10_call_seekbar!!.progress =
            (audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL))


        btn_show_more = mView!!.findViewById(id.btn_show_more)
        btn_show_more!!.setOnClickListener {
            openPanel()
        }

        btn_show_less = mView!!.findViewById(id.btn_show_less)
        btn_show_less!!.setOnClickListener {
            closePanel()
        }

        Log.e("volume", android10_seekbar!!.progress.toString() + " volume")
        android10_seekbar!!.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {

                restart()

                seekbarname_type = "music"
                // write custom code for progress is changed
                audioManager!!.setStreamVolume(
                    AudioManager.STREAM_MUSIC,
                    progress, 0
                )
                if (android10_seekbar!!.progress > 0) {
                    if (coloridAndroid10 == "teal") {
                        musicImage!!.setImageResource(drawable.ic_teal_music_note_android10)
                    } else if (coloridAndroid10 == "blue") {
                        musicImage!!.setImageResource(drawable.ic_blue_music_note_android10)
                    } else if (coloridAndroid10 == "pink") {
                        musicImage!!.setImageResource(drawable.ic_pink_music_note_android10)
                    } else if (coloridAndroid10 == "red") {
                        musicImage!!.setImageResource(drawable.ic_red_music_note_android10)
                    } else {
                        musicImage!!.setImageResource(drawable.ic_musicnote_android10)
                    }
                }
                if (android10_seekbar!!.progress == 0) {
                    if (coloridAndroid10 == "teal") {
                        musicImage!!.setImageResource(drawable.ic_teal_music_off_android10)
                    } else if (coloridAndroid10 == "blue") {
                        musicImage!!.setImageResource(drawable.ic_blue_music_off_android10)
                    } else if (coloridAndroid10 == "pink") {
                        musicImage!!.setImageResource(drawable.ic_pink_music_off_android10)
                    } else if (coloridAndroid10 == "red") {
                        musicImage!!.setImageResource(drawable.ic_red_music_off_android10)
                    } else {
                        musicImage!!.setImageResource(drawable.ic_android10_music_off)
                    }
                }
            }

            override fun onStartTrackingTouch(seek: SeekBar) {}

            override fun onStopTrackingTouch(seek: SeekBar) {}

        })

        android10_ring_seekbar!!.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {

                restart()

                seekbarname_type = "ring"
                // write custom code for progress is changed

                audioManager!!.setStreamVolume(
                    AudioManager.STREAM_RING,
                    progress, 0
                )
                if (android10_ring_seekbar!!.progress > 0) {
                    if (coloridAndroid10 == "blue") {
                        ringImage!!.setImageResource(drawable.ic_blue_notifications_android10)
                        ringicon_android10!!.setImageResource(drawable.ic_blue_notifications_android10)
                    } else if (coloridAndroid10 == "red") {
                        ringImage!!.setImageResource(drawable.ic_red_notifications_android10)
                        ringicon_android10!!.setImageResource(drawable.ic_red_notifications_android10)
                    } else if (coloridAndroid10 == "teal") {
                        ringImage!!.setImageResource(drawable.ic_teal_notifications_android10)
                        ringicon_android10!!.setImageResource(drawable.ic_teal_notifications_android10)
                    } else if (coloridAndroid10 == "pink") {
                        ringImage!!.setImageResource(drawable.ic_pink_notifications_android10)
                        ringicon_android10!!.setImageResource(drawable.ic_pink_notifications_android10)
                    } else {
                        ringImage!!.setImageResource(drawable.ic_notification_android10)
                        ringicon_android10!!.setImageResource(drawable.ic_notification_android10)
                    }
                }
                if (android10_ring_seekbar!!.progress == 0) {
                    if (coloridAndroid10 == "blue") {
                        ringImage!!.setImageResource(drawable.ic_blue_notifications_off_android10)
                        ringicon_android10!!.setImageResource(drawable.ic_blue_notifications_off_android10)
                    } else if (coloridAndroid10 == "red") {
                        ringImage!!.setImageResource(drawable.ic_red_notifications_off_android10)
                        ringicon_android10!!.setImageResource(drawable.ic_red_notifications_off_android10)
                    } else if (coloridAndroid10 == "teal") {
                        ringImage!!.setImageResource(drawable.ic_teal_notifications_off_android10)
                        ringicon_android10!!.setImageResource(drawable.ic_teal_notifications_off_android10)
                    } else if (coloridAndroid10 == "pink") {
                        ringImage!!.setImageResource(drawable.ic_pink_notifications_off_android10)
                        ringicon_android10!!.setImageResource(drawable.ic_pink_notifications_off_android10)
                    } else {
                        ringImage!!.setImageResource(drawable.ic_notifications_off_android10)
                        ringicon_android10!!.setImageResource(drawable.ic_notifications_off_android10)
                    }
                }
            }

            override fun onStartTrackingTouch(seek: SeekBar) {}

            override fun onStopTrackingTouch(seek: SeekBar) {}
        })

        android10_alarm_seekbar!!.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {

                restart()

                seekbarname_type = "alarm"
                // write custom code for progress is changed
                audioManager!!.setStreamVolume(
                    AudioManager.STREAM_ALARM,
                    progress, 0
                )
                if (android10_alarm_seekbar!!.progress > 0) {
                    if (coloridAndroid10 == "blue") {
                        alarmImage!!.setImageResource(drawable.ic_blue_alarm_android10)
                    } else if (coloridAndroid10 == "red") {
                        alarmImage!!.setImageResource(drawable.ic_red_alarm_android10);
                    } else if (coloridAndroid10 == "teal") {
                        alarmImage!!.setImageResource(drawable.ic_teal_alarm_android10);
                    } else if (coloridAndroid10 == "pink") {
                        alarmImage!!.setImageResource(drawable.ic_pink_alarm_android10);
                    } else {
                        alarmImage!!.setImageResource(drawable.ic_alarm_android10); }
                }
                if (android10_alarm_seekbar!!.progress == 0) {
                    if (coloridAndroid10 == "blue") {
                        alarmImage!!.setImageResource(drawable.ic_blue_alarm_off_android10)
                    } else if (coloridAndroid10 == "red") {
                        alarmImage!!.setImageResource(drawable.ic_red_alarm_off_android10);
                    } else if (coloridAndroid10 == "teal") {
                        alarmImage!!.setImageResource(drawable.ic_teal_alarm_off_android10);
                    } else if (coloridAndroid10 == "pink") {
                        alarmImage!!.setImageResource(drawable.ic_pink_alarm_off_android10);
                    } else {
                        alarmImage!!.setImageResource(drawable.ic_baseline_alarm_off_android10); }
                }
            }

            override fun onStartTrackingTouch(seek: SeekBar) {}

            override fun onStopTrackingTouch(seek: SeekBar) {}
        })

        android10_call_seekbar!!.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {

                restart()

                seekbarname_type = "call"
                // write custom code for progress is changed
                audioManager!!.setStreamVolume(
                    AudioManager.STREAM_VOICE_CALL,
                    progress, 0
                )
            }

            override fun onStartTrackingTouch(seek: SeekBar) {}

            override fun onStopTrackingTouch(seek: SeekBar) {}
        })

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (coloridAndroid10 == "blue") {
                if (android10_seekbar!!.progress > 0) {
                    musicImage!!.setImageResource(drawable.ic_blue_music_note_android10)
                } else if (android10_seekbar!!.progress == 0) {
                    musicImage!!.setImageResource(drawable.ic_blue_music_off_android10)
                }
                if (android10_ring_seekbar!!.progress > 0) {
                    ringImage!!.setImageResource(drawable.ic_blue_notifications_android10)
                    ringicon_android10!!.setImageResource(drawable.ic_blue_notifications_android10)
                } else if (android10_ring_seekbar!!.progress == 0) {
                    ringImage!!.setImageResource(drawable.ic_blue_notifications_off_android10)
                    ringicon_android10!!.setImageResource(drawable.ic_blue_notifications_off_android10)
                }
                if (android10_alarm_seekbar!!.progress > 0) {
                    alarmImage!!.setImageResource(drawable.ic_blue_alarm_android10)
                } else if (android10_alarm_seekbar!!.progress == 0) {
                    alarmImage!!.setImageResource(drawable.ic_blue_alarm_off_android10)
                }
                callImage!!.setImageResource(drawable.ic_blue_call_android)

                android10_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.blue, null
                        )
                    )
                )
                android10_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.blue, null
                    )
                ))
                android10_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_blue, null
                    )
                ))
                android10_ring_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.blue, null
                        )
                    )
                )
                android10_ring_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.blue, null
                    )
                ))
                android10_ring_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_blue, null
                    )
                ))
                android10_alarm_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.blue, null
                        )
                    )
                )
                android10_alarm_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.blue, null
                    )
                ))
                android10_alarm_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_blue, null
                    )
                ))
                android10_call_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.blue, null
                        )
                    )
                )
                android10_call_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.blue, null
                    )
                ))
                android10_call_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_blue, null
                    )
                ))
            } else if (coloridAndroid10 == "teal") {
                if (android10_seekbar!!.progress > 0) {
                    musicImage!!.setImageResource(drawable.ic_teal_music_note_android10)
                } else if (android10_seekbar!!.progress == 0) {
                    musicImage!!.setImageResource(drawable.ic_teal_music_off_android10)
                }
                if (android10_ring_seekbar!!.progress > 0) {
                    ringImage!!.setImageResource(drawable.ic_teal_notifications_android10)
                    ringicon_android10!!.setImageResource(drawable.ic_teal_notifications_android10)
                } else if (android10_ring_seekbar!!.progress == 0) {
                    ringImage!!.setImageResource(drawable.ic_teal_notifications_off_android10)
                    ringicon_android10!!.setImageResource(drawable.ic_teal_notifications_off_android10)
                }
                if (android10_alarm_seekbar!!.progress > 0) {
                    alarmImage!!.setImageResource(drawable.ic_teal_alarm_android10)
                } else if (android10_alarm_seekbar!!.progress == 0) {
                    alarmImage!!.setImageResource(drawable.ic_teal_alarm_off_android10)
                }

                callImage!!.setImageResource(drawable.ic_teal_call_android10)
                android10_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.teal_200, null
                        )
                    )
                )
                android10_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.teal_200, null
                    )
                ))
                android10_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_teal_200, null
                    )
                ))
                android10_ring_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.teal_200, null
                        )
                    )
                )
                android10_ring_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.teal_200, null
                    )
                ))
                android10_ring_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_teal_200, null
                    )
                ))
                android10_alarm_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.teal_200, null
                        )
                    )
                )
                android10_alarm_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.teal_200, null
                    )
                ))
                android10_alarm_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_teal_200, null
                    )
                ))
                android10_call_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.teal_200, null
                        )
                    )
                )
                android10_call_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.teal_200, null
                    )
                ))
                android10_call_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_teal_200, null
                    )
                ))
            } else if (coloridAndroid10 == "red") {
                if (android10_seekbar!!.progress > 0) {
                    musicImage!!.setImageResource(drawable.ic_red_music_note_android10)
                } else if (android10_seekbar!!.progress == 0) {
                    musicImage!!.setImageResource(drawable.ic_red_music_off_android10)
                }
                if (android10_ring_seekbar!!.progress > 0) {
                    ringImage!!.setImageResource(drawable.ic_red_notifications_android10)
                    ringicon_android10!!.setImageResource(drawable.ic_red_notifications_android10)
                } else if (android10_ring_seekbar!!.progress == 0) {
                    ringImage!!.setImageResource(drawable.ic_red_notifications_off_android10)
                    ringicon_android10!!.setImageResource(drawable.ic_red_notifications_off_android10)
                }
                if (android10_alarm_seekbar!!.progress > 0) {
                    alarmImage!!.setImageResource(drawable.ic_red_alarm_android10)
                } else if (android10_alarm_seekbar!!.progress == 0) {
                    alarmImage!!.setImageResource(drawable.ic_red_alarm_off_android10)
                }
                callImage!!.setImageResource(drawable.ic_red_call_android10)
                android10_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.red, null
                        )
                    )
                )
                android10_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.red, null
                    )
                ))
                android10_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_red, null
                    )
                ))
                android10_ring_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.red, null
                        )
                    )
                )
                android10_ring_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.red, null
                    )
                ))
                android10_ring_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_red, null
                    )
                ))
                android10_alarm_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.red, null
                        )
                    )
                )
                android10_alarm_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.red, null
                    )
                ))
                android10_alarm_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_red, null
                    )
                ))
                android10_call_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.red, null
                        )
                    )
                )
                android10_call_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.red, null
                    )
                ))
                android10_call_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_red, null
                    )
                ))
            } else if (coloridAndroid10 == "pink") {
                if (android10_seekbar!!.progress > 0) {
                    musicImage!!.setImageResource(drawable.ic_pink_music_note_android10)
                } else if (android10_seekbar!!.progress == 0) {
                    musicImage!!.setImageResource(drawable.ic_pink_music_off_android10)
                }
                if (android10_ring_seekbar!!.progress > 0) {
                    ringImage!!.setImageResource(drawable.ic_pink_notifications_android10)
                    ringicon_android10!!.setImageResource(drawable.ic_pink_notifications_android10)
                } else if (android10_ring_seekbar!!.progress == 0) {
                    ringImage!!.setImageResource(drawable.ic_pink_notifications_off_android10)
                    ringicon_android10!!.setImageResource(drawable.ic_pink_notifications_off_android10)
                }
                if (android10_alarm_seekbar!!.progress > 0) {
                    alarmImage!!.setImageResource(drawable.ic_pink_alarm_android10)
                } else if (android10_alarm_seekbar!!.progress == 0) {
                    alarmImage!!.setImageResource(drawable.ic_pink_alarm_off_android10)
                }
                callImage!!.setImageResource(drawable.ic_pink_call_android10)
                android10_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.pink, null
                        )
                    )
                )
                android10_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.pink, null
                    )
                ))
                android10_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_pink, null
                    )
                ))
                android10_ring_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.pink, null
                        )
                    )
                )
                android10_ring_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.pink, null
                    )
                ))
                android10_ring_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_pink, null
                    )
                ))
                android10_alarm_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.pink, null
                        )
                    )
                )
                android10_alarm_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.pink, null
                    )
                ))
                android10_alarm_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_pink, null
                    )
                ))
                android10_call_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.pink, null
                        )
                    )
                )
                android10_call_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.pink, null
                    )
                ))
                android10_call_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_pink, null
                    )
                ))
            } else if (coloridAndroid10 == "default") {
                if (android10_seekbar!!.progress > 0) {
                    musicImage!!.setImageResource(drawable.ic_musicnote_android10)
                } else if (android10_seekbar!!.progress == 0) {
                    musicImage!!.setImageResource(drawable.ic_android10_music_off)
                }
                if (android10_ring_seekbar!!.progress > 0) {
                    ringImage!!.setImageResource(drawable.ic_notification_android10)
                    ringicon_android10!!.setImageResource(drawable.ic_notification_android10)
                } else if (android10_ring_seekbar!!.progress == 0) {
                    ringImage!!.setImageResource(drawable.ic_notifications_off_android10)
                    ringicon_android10!!.setImageResource(drawable.ic_notifications_off_android10)
                }
                if (android10_alarm_seekbar!!.progress > 0) {
                    alarmImage!!.setImageResource(drawable.ic_alarm_android10)
                } else if (android10_alarm_seekbar!!.progress == 0) {
                    alarmImage!!.setImageResource(drawable.ic_baseline_alarm_off_android10)
                }
                if (android10_call_seekbar!!.progress > 0) {
                    callImage!!.setImageResource(drawable.ic_call_android10)
                }
                android10_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.green, null
                        )
                    )
                )
                android10_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.green, null
                    )
                ))
                android10_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_green, null
                    )
                ))
                android10_ring_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.green, null
                        )
                    )
                )
                android10_ring_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.green, null
                    )
                ))
                android10_ring_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_green, null
                    )
                ))
                android10_alarm_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.green, null
                        )
                    )
                )
                android10_alarm_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.green, null
                    )
                ))
                android10_alarm_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_green, null
                    )
                ))
                android10_call_seekbar!!.setProgressTintList(
                    ColorStateList.valueOf(
                        context!!.resources.getColor(
                            color.green, null
                        )
                    )
                )
                android10_call_seekbar!!.thumbTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.green, null
                    )
                ))
                android10_call_seekbar!!.progressBackgroundTintList = (ColorStateList.valueOf(
                    context!!.resources.getColor(
                        color.light_green, null
                    )
                ))
            }
        }

        if (positionidAndroid10 == "left") {
            mParams!!.gravity = Gravity.LEFT
            mWindowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            btn_show_more!!.setImageResource(drawable.ic_show_less)
            btn_show_less!!.setImageResource(drawable.ic_show_more)
        } else if (positionidAndroid10 == "right") {
            mParams!!.gravity = Gravity.RIGHT
            mWindowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        } else/* if(positionid=="default")*/ {
            mParams!!.gravity = Gravity.RIGHT
            mWindowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        }
    }

    //============================================================SHOW LESS(CLOSE FULL PANEL)========================================================================//

    private fun closePanel() {
//        vibratecardView!!.visibility=View.GONE
        ringcardView!!.visibility = View.GONE
        alarmcardView!!.visibility = View.GONE
        callcardView!!.visibility = View.GONE

        btn_show_more!!.visibility = View.VISIBLE
        btn_show_less!!.visibility = View.GONE

        seekbarname_type = "music"

        mWindowManager!!.updateViewLayout(mView, mParams)
    }

    //============================================================SHOW MORE(OPEN FULL PANEL)========================================================================//

    private fun openPanel() {
//        vibratecardView!!.visibility=View.VISIBLE
        ringcardView!!.visibility = View.VISIBLE
        alarmcardView!!.visibility = View.VISIBLE
        callcardView!!.visibility = View.VISIBLE

        btn_show_more!!.visibility = View.GONE
        btn_show_less!!.visibility = View.VISIBLE

        seekbarname_type = "music"

        mWindowManager!!.updateViewLayout(mView, mParams)
    }

    //============================================================PROGRESS INCREMENT==============================================================================//

    fun progressIncrement() {
        if (styleid == "1") {

            if (seekbarname_type == "music") {
                android10_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC) + 1)
                Log.e("volume", android10_seekbar!!.progress.toString() + " music increment")


            }

            if (seekbarname_type.equals("ring")) {

                android10_ring_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_RING) + 1)
                Log.e("volume", android10_ring_seekbar!!.progress.toString() + " ring increment")

            }

            if (seekbarname_type == "alarm") {
                android10_alarm_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM) + 1)
                Log.e("volume", android10_alarm_seekbar!!.progress.toString() + " alarm increment")

            }

            if (seekbarname_type == "call") {

                android10_call_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL) + 1)
                Log.e("volume", android10_call_seekbar!!.progress.toString() + " call increment")

            }
        }
        //-------------------------------------------------------------------------------------------------------------------//
        if (styleid == "2") {
            if (seekbarname_type == "music") {
                if (hiddencardView!!.visibility == View.VISIBLE) {
                    android_music_seekbar_hidden!!.progress =
                        (audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC) + 1)
                }
                android_music_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC) + 1)

                if (android_music_seekbar!!.progress > 0) {
                    musicImage!!.setImageResource(drawable.ic_android_music_note)
                    music_icon_android10!!.setImageResource(drawable.ic_android_music_note)
                }
//                closeWindow()
            }
            if (seekbarname_type == "ring") {
                android_ring_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_RING) + 1)
                Log.e("volume", android_ring_seekbar!!.progress.toString() + " ring increment")
                if (android_ring_seekbar!!.progress > 0) {
                    ringImage!!.setImageResource(drawable.ic_notifications_android)
                }
//                closeWindow()
            }
            if (seekbarname_type == "alarm") {
                android_alarm_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM) + 1)
                if (android_alarm_seekbar!!.progress > 0) {
                    alarmImage!!.setImageResource(drawable.ic_alarm_android)
                }
//                closeWindow()
            }
            if (seekbarname_type == "call") {
                android_call_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL) + 1)
//                closeWindow()
            }
        }

        //-------------------------------------------------------------------------------------------------------------------//
        if (styleid == "3") {
            if (seekbarname_type == "music") {
                android10_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC) + 1)
                Log.e("volume", android10_seekbar!!.progress.toString() + " music increment")

            }

            if (seekbarname_type == "ring") {
                android10_ring_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_RING) + 1)
                Log.e("volume", android10_ring_seekbar!!.progress.toString() + " ring increment")
            }

            if (seekbarname_type == "alarm") {
                android10_alarm_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM) + 1)
                Log.e("volume", android10_alarm_seekbar!!.progress.toString() + " alarm increment")
            }

            if (seekbarname_type == "call") {
                android10_call_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL) + 1)
                Log.e("volume", android10_call_seekbar!!.progress.toString() + " call increment")
            }
        }
        //-------------------------------------------------------------------------------------------------------------------//
        if (styleid == "4") {
            if (seekbarname_type == "music") {
                music_rubberseekbar!!.setCurrentValue((audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC) + 1))
            }

            if (seekbarname_type == "ring") {
                ring_rubberseekbar!!.setCurrentValue((audioManager!!.getStreamVolume(AudioManager.STREAM_RING) + 1))
            }

            if (seekbarname_type == "alarm") {
                alarm_rubberseekbar!!.setCurrentValue((audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM) + 1))
            }

            if (seekbarname_type == "call") {
                call_rubberseekbar!!.setCurrentValue((audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL) + 1))
            }
        }
        //-------------------------------------------------------------------------------------------------------------------//
        if (styleid == "5") {
            if (seekbarname_type == "music") {
                music_emojiSlider!!.progress =
                    ((audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC) + 1).toFloat()) / 15
                audioManager!!.setStreamVolume(
                    AudioManager.STREAM_MUSIC,
                    (music_emojiSlider!!.progress * 15).toInt(), 0
                )

                if (music_emojiSlider!!.progress > 0) {
                    if (coloridEmoji == "teal") {
                        musicImage!!.setImageResource(drawable.ic_teal_music_note_android10)
                    } else if (coloridEmoji == "green") {
                        musicImage!!.setImageResource(drawable.ic_musicnote_android10)
                    } else if (coloridEmoji == "pink") {
                        musicImage!!.setImageResource(drawable.ic_pink_music_note_android10)
                    } else if (coloridEmoji == "red") {
                        musicImage!!.setImageResource(drawable.ic_red_music_note_android10)
                    } else {
                        musicImage!!.setImageResource(drawable.ic_blue_music_note_android10)
                    }
//                musicImage!!.setImageResource(R.drawable.ic_music_window10);
                }
//                if(music_emojiSlider!!.progress>0)
//                {
//                    musicImage!!.setImageResource(R.drawable.ic_music_window10);
//                }
            }
            if (seekbarname_type == "ring") {
                ring_emojiSlider!!.progress =
                    ((audioManager!!.getStreamVolume(AudioManager.STREAM_RING) + 1).toFloat()) / 15
                audioManager!!.setStreamVolume(
                    AudioManager.STREAM_RING,
                    (ring_emojiSlider!!.progress * 15).toInt(), 0
                )
                if (ring_emojiSlider!!.progress > 0) {
                    if (coloridEmoji == "green") {
                        ringImage!!.setImageResource(drawable.ic_notification_android10)
                    } else if (coloridEmoji == "red") {
                        ringImage!!.setImageResource(drawable.ic_red_notifications_android10)
                    } else if (coloridEmoji == "teal") {
                        ringImage!!.setImageResource(drawable.ic_teal_notifications_android10)
                    } else if (coloridEmoji == "pink") {
                        ringImage!!.setImageResource(drawable.ic_pink_notifications_android10)
                    } else {
                        ringImage!!.setImageResource(drawable.ic_blue_notifications_android10)
                    }
//                ringImage!!.setImageResource(R.drawable.ic_notification_window10);
                }
//                if(ring_emojiSlider!!.progress>0)
//                {
//                    ringImage!!.setImageResource(R.drawable.ic_notification_window10);
//                }
            }
            if (seekbarname_type == "alarm") {
                alarm_emojiSlider!!.progress =
                    ((audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM) + 1).toFloat()) / 15
                audioManager!!.setStreamVolume(
                    AudioManager.STREAM_ALARM,
                    (alarm_emojiSlider!!.progress * 15).toInt(), 0
                )
                if (alarm_emojiSlider!!.progress > 0) {
                    if (coloridEmoji == "green") {
                        alarmImage!!.setImageResource(drawable.ic_alarm_android10)
                    } else if (coloridEmoji == "red") {
                        alarmImage!!.setImageResource(drawable.ic_red_alarm_android10);
                    } else if (coloridEmoji == "teal") {
                        alarmImage!!.setImageResource(drawable.ic_teal_alarm_android10);
                    } else if (coloridEmoji == "pink") {
                        alarmImage!!.setImageResource(drawable.ic_pink_alarm_android10);
                    } else {
                        alarmImage!!.setImageResource(drawable.ic_blue_alarm_android10); }
//                alarmImage!!.setImageResource(R.drawable.ic_alarm_window10);
                }
//                if(alarm_emojiSlider!!.progress>0)
//                {
//                    alarmImage!!.setImageResource(R.drawable.ic_alarm_window10);
//                }
            }
            if (seekbarname_type == "call") {
                call_emojiSlider!!.progress =
                    ((audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL) + 1).toFloat()) / 15
                audioManager!!.setStreamVolume(
                    AudioManager.STREAM_VOICE_CALL,
                    (call_emojiSlider!!.progress * 15).toInt(), 0
                )
            }
        }
        //-------------------------------------------------------------------------------------------------------------------//
        if (styleid == "6") {
            if (seekbarname_type == "music") {
                music_knob!!.setProgress((audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC) + 1))
            }
            if (seekbarname_type == "ring") {
                ring_knob!!.setProgress((audioManager!!.getStreamVolume(AudioManager.STREAM_RING) + 1))
            }
            if (seekbarname_type == "alarm") {
                alarm_knob!!.setProgress((audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM) + 1))
            }
            if (seekbarname_type == "call") {
                call_knob!!.setProgress((audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL) + 1))
            }
        }
        //-------------------------------------------------------------------------------------------------------------------//
        if (styleid == "7") {
            if (seekbarname_type == "music") {
                ios_music_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC) + 1)
                if (ios_music_seekbar!!.progress > 0) {
                    musicImage!!.setBackgroundResource(drawable.ic_ios_music);
                }
                Log.e("count", "COUNT INC1: $count")
                if (count == 1 && ios_hidden_view!!.visibility == View.GONE) {
                    if (Build.VERSION.SDK_INT == Build.VERSION_CODES.O) {
                        musicImage!!.visibility = View.INVISIBLE
                        ios_music_seekbar!!.barWidth = 18
                        ios_music_seekbar!!.barCornerRadius = 10
                    } else if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
                        musicImage!!.visibility = View.INVISIBLE
                        ios_music_seekbar!!.barWidth = 18
                        ios_music_seekbar!!.barCornerRadius = 40
                    }
//                    ios_music_image!!.visibility=View.INVISIBLE
//                    ios_music_seekbar!!.barWidth = 18
//                    ios_music_seekbar!!.barCornerRadius = 40
                }
                count = 1
            }
            if (seekbarname_type == "ring") {
                ios_ring_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_RING) + 1)
                if (ios_ring_seekbar!!.progress > 0) {
                    ringImage!!.setBackgroundResource(drawable.ic_ios_ring);
                }
            }
            if (seekbarname_type == "alarm") {
                ios_alarm_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM) + 1)
                if (ios_alarm_seekbar!!.progress > 0) {
                    alarmImage!!.setBackgroundResource(drawable.ic_ios_alarm);
                }
            }
            if (seekbarname_type == "call") {
                ios_call_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL) + 1)
            }
        }
        //-------------------------------------------------------------------------------------------------------------------//
        if (styleid == "8") {
            if (seekbarname_type == "music") {
                android11_music_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC) + 1)
                if (android11_music_seekbar!!.progress > 0) {
                    musicImage!!.setImageResource(drawable.ic_music_window10)
                }
            }
            if (seekbarname_type == "ring") {
                android11_ring_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_RING) + 1)
                if (android11_ring_seekbar!!.progress > 0) {
                    ringImage!!.setImageResource(drawable.ic_notification_window10);
                }
            }
            if (seekbarname_type == "alarm") {
                android11_alarm_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM) + 1)
                if (android11_alarm_seekbar!!.progress > 0) {
                    alarmImage!!.setImageResource(drawable.ic_alarm_window10);
                }

            }
            if (seekbarname_type == "call") {
                android11_call_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL) + 1)
            }
        }
        //-------------------------------------------------------------------------------------------------------------------//
        if (styleid == "9") {
            if (seekbarname_type == "music") {
                androidHorizontal_music_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC) + 1)
            }
            if (seekbarname_type == "ring") {
                androidHorizontal_ring_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_RING) + 1)

            }
            if (seekbarname_type == "alarm") {
                androidHorizontal_alarm_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM) + 1)
            }
            if (seekbarname_type == "call") {
                androidHorizontal_call_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL) + 1)
            }
        }
        //-------------------------------------------------------------------------------------------------------------------//
        if (styleid == "10") {
            if (seekbarname_type == "music") {
                oneUi_2_music_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC) + 1)
//                if(oneUi_2_music_seekbar!!.progress>0)
//                {
//                    musicImage!!.setImageResource(R.drawable.ic_music_ui2);
//                }

            }
            if (seekbarname_type == "ring") {
                oneUi_2_ring_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_RING) + 1)

            }
            if (seekbarname_type == "alarm") {
                oneUi_2_alarm_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM) + 1)
            }
            if (seekbarname_type == "call") {
                oneUi_2_call_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL) + 1)
            }
        }
        //-------------------------------------------------------------------------------------------------------------------//
        mWindowManager!!.updateViewLayout(mView, mParams)
    }

    //============================================================PROGRESS DECREMENT==============================================================================//

    fun progressDecrement() {
        if (styleid == "1") {

            if (seekbarname_type == "music") {

                android10_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC) - 1)
                Log.e("volume", android10_seekbar!!.progress.toString() + " music decrement")

            }

            if (seekbarname_type == "ring") {

                android10_ring_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_RING) - 1)
                Log.e("volume", android10_ring_seekbar!!.progress.toString() + " ring decrement")

            }

            if (seekbarname_type == "alarm") {

                android10_alarm_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM) - 1)
                Log.e("volume", android10_alarm_seekbar!!.progress.toString() + " alarm decrement")

            }

            if (seekbarname_type == "call") {

                android10_call_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL) - 1)
                Log.e("volume", android10_call_seekbar!!.progress.toString() + " call decrement")

            }
        }
        //-------------------------------------------------------------------------------------------------------------------//
        if (styleid == "2") {
            if (seekbarname_type == "music") {
                if (hiddencardView!!.visibility == View.VISIBLE) {
                    android_music_seekbar_hidden!!.progress =
                        (audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC) - 1)
                }
                android_music_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC) - 1)
                if (android_music_seekbar!!.progress == 0) {
                    musicImage!!.setImageResource(drawable.ic_music_off_white)
                    music_icon_android10!!.setImageResource(drawable.ic_music_off_white)
                }
//                closeWindow()
            }
            if (seekbarname_type == "ring") {
                android_ring_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_RING) - 1)
                if (android_ring_seekbar!!.progress == 0) {
                    ringImage!!.setImageResource(drawable.ic_notifications_off_white)
                }
//                closeWindow()
            }
            if (seekbarname_type == "alarm") {
                android_alarm_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM) - 1)
                if (android_alarm_seekbar!!.progress == 0) {
                    alarmImage!!.setImageResource(drawable.ic_alarm_off_white)
                }
//                closeWindow()
            }
            if (seekbarname_type == "call") {
                android_call_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL) - 1)
//                closeWindow()
            }
        }
        //-------------------------------------------------------------------------------------------------------------------//
        if (styleid == "3") {

            if (seekbarname_type == "music") {
                android10_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC) - 1)
//                if(android10_seekbar!!.progress==0){
//                    music_icon_android10!!.setBackgroundResource(R.drawable.ic_android10_music_off)
//                }
                Log.e("volume", android10_seekbar!!.progress.toString() + " music decrement")
            }

            if (seekbarname_type == "ring") {
                android10_ring_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_RING) - 1)
                Log.e("volume", android10_ring_seekbar!!.progress.toString() + " ring decrement")
            }

            if (seekbarname_type == "alarm") {
                android10_alarm_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM) - 1)
                Log.e("volume", android10_alarm_seekbar!!.progress.toString() + " alarm decrement")
            }

            if (seekbarname_type == "call") {
                android10_call_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL) - 1)
                Log.e("volume", android10_call_seekbar!!.progress.toString() + " call decrement")
            }
        }
        //-------------------------------------------------------------------------------------------------------------------//
        if (styleid == "4") {
            if (seekbarname_type == "music") {
                music_rubberseekbar!!.setCurrentValue((audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC) - 1))
            }

            if (seekbarname_type == "ring") {
                ring_rubberseekbar!!.setCurrentValue((audioManager!!.getStreamVolume(AudioManager.STREAM_RING) - 1))
            }

            if (seekbarname_type == "alarm") {
                alarm_rubberseekbar!!.setCurrentValue((audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM) - 1))
            }

            if (seekbarname_type == "call") {
                call_rubberseekbar!!.setCurrentValue((audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL) - 1))
            }
        }
        //-------------------------------------------------------------------------------------------------------------------//
        if (styleid == "5") {
            if (seekbarname_type == "music") {
                music_emojiSlider!!.progress =
                    ((audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC) - 1).toFloat()) / 15
                audioManager!!.setStreamVolume(
                    AudioManager.STREAM_MUSIC,
                    (music_emojiSlider!!.progress * 15).toInt(), 0
                )

                if (music_emojiSlider!!.progress <= 0) {

                    if (coloridEmoji == "teal") {
                        musicImage!!.setImageResource(drawable.ic_teal_music_off_android10)
                    } else if (coloridEmoji == "green") {
                        musicImage!!.setImageResource(drawable.ic_android10_music_off)
                    } else if (coloridEmoji == "pink") {
                        musicImage!!.setImageResource(drawable.ic_pink_music_off_android10)
                    } else if (coloridEmoji == "red") {
                        musicImage!!.setImageResource(drawable.ic_red_music_off_android10)
                    } else {
                        musicImage!!.setImageResource(drawable.ic_blue_music_off_android10)
                    }
//                musicImage!!.setImageResource(R.drawable.ic_music_off_black)
                }
//                if(music_emojiSlider!!.progress<=0){
//                    musicImage!!.setImageResource(R.drawable.ic_music_off_black)
//                }
            }
            if (seekbarname_type == "ring") {
                ring_emojiSlider!!.progress =
                    ((audioManager!!.getStreamVolume(AudioManager.STREAM_RING) - 1).toFloat()) / 15
                audioManager!!.setStreamVolume(
                    AudioManager.STREAM_RING,
                    (ring_emojiSlider!!.progress * 15).toInt(), 0
                )
                if (ring_emojiSlider!!.progress <= 0) {
                    if (coloridEmoji == "green") {
                        ringImage!!.setImageResource(drawable.ic_notifications_off_android10)
                    } else if (coloridEmoji == "red") {
                        ringImage!!.setImageResource(drawable.ic_red_notifications_off_android10)
                    } else if (coloridEmoji == "teal") {
                        ringImage!!.setImageResource(drawable.ic_teal_notifications_off_android10)
                    } else if (coloridEmoji == "pink") {
                        ringImage!!.setImageResource(drawable.ic_pink_notifications_off_android10)
                    } else {
                        ringImage!!.setImageResource(drawable.ic_blue_notifications_off_android10)
                    }
//                ringImage!!.setImageResource(R.drawable.ic_notifications_off_black)
                }
//                if(ring_emojiSlider!!.progress<=0){
//                    ringImage!!.setImageResource(R.drawable.ic_notifications_off_black)
//                }
            }
            if (seekbarname_type == "alarm") {
                alarm_emojiSlider!!.progress =
                    ((audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM) - 1).toFloat()) / 15
                audioManager!!.setStreamVolume(
                    AudioManager.STREAM_ALARM,
                    (alarm_emojiSlider!!.progress * 15).toInt(), 0
                )
                if (alarm_emojiSlider!!.progress <= 0) {
                    if (coloridEmoji == "green") {
                        alarmImage!!.setImageResource(drawable.ic_baseline_alarm_off_android10)
                    } else if (coloridEmoji == "red") {
                        alarmImage!!.setImageResource(drawable.ic_red_alarm_off_android10);
                    } else if (coloridEmoji == "teal") {
                        alarmImage!!.setImageResource(drawable.ic_teal_alarm_off_android10);
                    } else if (coloridEmoji == "pink") {
                        alarmImage!!.setImageResource(drawable.ic_pink_alarm_off_android10);
                    } else {
                        alarmImage!!.setImageResource(drawable.ic_blue_alarm_off_android10); }
//                alarmImage!!.setImageResource(R.drawable.ic_alarm_off_black)
                }
//                if(alarm_emojiSlider!!.progress<=0){
//                    alarmImage!!.setImageResource(R.drawable.ic_alarm_off_black)
//                }
            }
            if (seekbarname_type == "call") {
                call_emojiSlider!!.progress =
                    ((audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL) - 1).toFloat()) / 15
                audioManager!!.setStreamVolume(
                    AudioManager.STREAM_VOICE_CALL,
                    (call_emojiSlider!!.progress * 15).toInt(), 0
                )
            }
        }
        //-------------------------------------------------------------------------------------------------------------------//
        if (styleid == "6") {
            if (seekbarname_type == "music") {
                music_knob!!.setProgress((audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC) - 1))
            }
            if (seekbarname_type == "ring") {
                ring_knob!!.setProgress((audioManager!!.getStreamVolume(AudioManager.STREAM_RING) - 1))
            }
            if (seekbarname_type == "alarm") {
                alarm_knob!!.setProgress((audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM) - 1))
            }
            if (seekbarname_type == "call") {
                call_knob!!.setProgress((audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL) - 1))
            }
        }
        //-------------------------------------------------------------------------------------------------------------------//
        if (styleid == "7") {
            if (seekbarname_type == "music") {
                ios_music_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC) - 1)
                if (ios_music_seekbar!!.progress == 0) {
                    musicImage!!.setBackgroundResource(drawable.ic_music_off_ios);
                }
                Log.e("count", "COUNT INC1: $count")
                if (count == 1 && ios_hidden_view!!.visibility == View.GONE) {
                    if (Build.VERSION.SDK_INT == Build.VERSION_CODES.O) {
                        musicImage!!.visibility = View.INVISIBLE
                        ios_music_seekbar!!.barWidth = 18
                        ios_music_seekbar!!.barCornerRadius = 10
                    } else if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
                        musicImage!!.visibility = View.INVISIBLE
                        ios_music_seekbar!!.barWidth = 18
                        ios_music_seekbar!!.barCornerRadius = 40
                    }
                }
                count = 1
            }
            if (seekbarname_type == "ring") {
                ios_ring_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_RING) - 1)
                if (ios_ring_seekbar!!.progress == 0) {
                    ringImage!!.setBackgroundResource(drawable.ic_notifications_off_ios);
                }
            }
            if (seekbarname_type == "alarm") {
                ios_alarm_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM) - 1)
                if (ios_alarm_seekbar!!.progress == 0) {
                    alarmImage!!.setBackgroundResource(drawable.ic_alarm_off_ios);
                }
            }
            if (seekbarname_type == "call") {
                ios_call_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL) - 1)
            }
        }
        //-------------------------------------------------------------------------------------------------------------------//
        if (styleid == "8") {
            if (seekbarname_type == "music") {
                android11_music_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC) - 1)
                if (android11_music_seekbar!!.progress == 0) {
                    musicImage!!.setImageResource(drawable.ic_music_off_black)
                }
            }
            if (seekbarname_type == "ring") {
                android11_ring_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_RING) - 1)
                if (android11_ring_seekbar!!.progress == 0) {
                    ringImage!!.setImageResource(drawable.ic_notifications_off_black)
                }
            }
            if (seekbarname_type == "alarm") {
                android11_alarm_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM) - 1)
                if (android11_alarm_seekbar!!.progress == 0) {
                    alarmImage!!.setImageResource(drawable.ic_alarm_off_black)
                }
            }
            if (seekbarname_type == "call") {
                android11_call_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL) - 1)
            }
        }
        //-------------------------------------------------------------------------------------------------------------------//
        if (styleid == "9") {
            if (seekbarname_type == "music") {
                androidHorizontal_music_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC) - 1)
            }
            if (seekbarname_type == "ring") {
                androidHorizontal_ring_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_RING) - 1)

            }
            if (seekbarname_type == "alarm") {
                androidHorizontal_alarm_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM) - 1)
            }
            if (seekbarname_type == "call") {
                androidHorizontal_call_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL) - 1)
            }
        }
        //-------------------------------------------------------------------------------------------------------------------//
        if (styleid == "10") {
            if (seekbarname_type == "music") {
                oneUi_2_music_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC) - 1)
//                if(oneUi_2_music_seekbar!!.progress==0){
//                    musicImage!!.setImageResource(R.drawable.ic_android_music_off)
//                }
            }
            if (seekbarname_type == "ring") {
                oneUi_2_ring_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_RING) - 1)

            }
            if (seekbarname_type == "alarm") {
                oneUi_2_alarm_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM) - 1)
            }
            if (seekbarname_type == "call") {
                oneUi_2_call_seekbar!!.progress =
                    (audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL) - 1)
            }
        }
        //-------------------------------------------------------------------------------------------------------------------//
        mWindowManager!!.updateViewLayout(mView, mParams)

    }

    //============================================================OPEN SELECTED CUSTOMIZED VOLUME PANEL==============================================================//
    fun open() {
        try {
            // check if the view is already
            // inflated or present in the window
            if (mView!!.getWindowToken() == null) {
                if (mView!!.getParent() == null) {
                    mWindowManager!!.addView(mView, mParams)
                }
            }
        } catch (e: Exception) {
            Log.d("Error1", e.toString())
        }
    }

    //====================================================CLOSE SELECTED CUSTOMIZED VOLUME PANEL==================================================//

    fun close() {
        try {
            // remove the view from the window
            (context!!.getSystemService(Context.WINDOW_SERVICE) as WindowManager).removeView(mView)
            // invalidate the view
            mView!!.invalidate()
            // remove all views
            (mView!!.getParent() as ViewGroup).removeAllViews()

            // the above steps are necessary when you are adding and removing
            // the view simultaneously, it might give some exceptions
        } catch (e: Exception) {
            Log.d("Error2", e.toString())
        }
    }

    //====================================================CLOSE WINDOW & ACCESSIBILITY SERVICE==================================================//

    fun closeWindow() {
        if (MyAccessibilityService.isopen.equals(true)) {
//            val handler = Handler()
//            handler.postDelayed({
            close()
            MyAccessibilityService.isopen = false
//            }, 3000)
        }
    }

//    companion object{
//        var touch:Boolean=true
//    }
}