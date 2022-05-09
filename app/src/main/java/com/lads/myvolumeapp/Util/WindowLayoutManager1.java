package com.lads.myvolumeapp.Util;

import static android.content.Context.AUDIO_SERVICE;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.media.AudioManager;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.jem.rubberpicker.RubberSeekBar;
import com.lads.myvolumeapp.R;
import com.lukelorusso.verticalseekbar.VerticalSeekBar;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import petrov.kristiyan.colorpicker.ColorPicker;


public class WindowLayoutManager1 {
    static CountDownTimer timerFullScreen;
    static CountDownTimer timerSingleScreen;
    static AudioManager audioManager;
    static PrefUtil prefUtil;
    static int timeOnScreen;
    static ColorPicker colorPicker;
    static SeekBar style_1_single;

    @SuppressLint({"LongLogTag", "ResourceAsColor"})
    public static <Knob> void setWindow(Context context, WindowManager windowManager, View fullVolumePanelView, View singleVolumePanelView) {

        Runnable r;
        final boolean[] isStopped = {false};
        final boolean[] isInteracting = {false};
        Handler handler;
        handler = new Handler();
        prefUtil = new PrefUtil(context);
        timeOnScreen = prefUtil.getInt("VolumeSlider", 2000);
//        colorPicker = new ColorPicker();
        if (timerFullScreen != null) {
            timerFullScreen.cancel();
        }


        audioManager = (AudioManager) context.getSystemService(AUDIO_SERVICE);
            if (windowManager != null && (prefUtil.getBool("viewadd", false) != true)) {
                prefUtil.setBool("viewadd", true);

                    windowManager.addView(singleVolumePanelView, WindowParamsManager.getLayoutParams(context));

            } else {
                Log.d("TESTTTTTTTTT", "  Null");
            }

        r = () -> {
//                if (!isInteracting[0]) {
            if (isStopped[0]) {
                prefUtil.setBool("viewadd", false);
                try {
//                    windowManager.removeView(singleVolumePanelView);
                } catch (Exception e) {
                }
            } else {
                prefUtil.setBool("viewadd", false);
                try {
                    windowManager.removeView(singleVolumePanelView);
                } catch (Exception e) {
                }
            }
//                }
        };
        handler.postDelayed(r, timeOnScreen);

        ImageButton btnShowMore = singleVolumePanelView.findViewById(R.id.btn_show_more);

//        if (prefUtil.getInt("selectedItem", 0) == 10) {
//            btnShowMore.setBackgroundColor(0xFFFFFFFF);
//        }
        if (prefUtil.getInt("selectedItem", 0) == 8) {
            btnShowMore.setBackgroundColor(0xD81B60);
        }
        if (prefUtil.getInt("selectedItem", 0) == 7) {
            btnShowMore.setBackgroundColor(0x000000);
        }

        // Set right/left icon..........................
        if (prefUtil.getInt("selectedItem", 0) == 1 || prefUtil.getInt("selectedItem", 0) == 3 || prefUtil.getInt("selectedItem", 0) == 7) {
//
            if (prefUtil.getInt("panel_position", 0) == 0) {
                btnShowMore.setBackgroundResource(R.drawable.ic_baseline_navigate_next_24);
//
            } else {
                btnShowMore.setBackgroundResource(R.drawable.ic_baseline_navigate_before_24);
//
            }
        }

        btnShowMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isStopped[0] = true;
                handler.removeCallbacksAndMessages(null);
                handler.removeCallbacks(r);

                // Time is in millisecond so 50sec = 50000 I have used
                timerFullScreen = new CountDownTimer(timeOnScreen, 10) {
                    public void onTick(long millisUntilFinished) {
                        // Used for formatting digit to be in 2 digits only
                        NumberFormat f = new DecimalFormat("00");
                    }

                    public void onFinish() {

                        windowManager.removeView(fullVolumePanelView);

                        timerFullScreen.cancel();
                        handler.removeCallbacks(r);
                        Log.d("TAG", "Time is Finished..........: ");
                    }
                }.start();
                r.run();
                Thread thread = new Thread(r);
//                thread.start();


                windowManager.removeView(singleVolumePanelView);

                windowManager.addView(fullVolumePanelView, WindowParamsManager.getMainLayoutParams());

                //full Volume panel 1
                if (prefUtil.getInt("selectedItem", 0) == 1) {
                    CardView musiccardView = fullVolumePanelView.findViewById(R.id.musiccardView);
                    CardView ringcardView = fullVolumePanelView.findViewById(R.id.ringcardView);
                    CardView alarmcardView = fullVolumePanelView.findViewById(R.id.alarmcardView);
                    CardView callcardView = fullVolumePanelView.findViewById(R.id.callcardView);
                    SeekBar volume_ring = fullVolumePanelView.findViewById(R.id.ringSeekbar);
                    SeekBar volume_music = fullVolumePanelView.findViewById(R.id.music_seekbar);
                    SeekBar volume_alarm = fullVolumePanelView.findViewById(R.id.alarm_seekbar);
                    SeekBar volume_call = fullVolumePanelView.findViewById(R.id.call_seekbar);
                    volume_music.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
                    volume_music.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
                    volume_ring.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_RING));
                    volume_ring.setMax(audioManager.getStreamVolume(AudioManager.STREAM_RING));
                    volume_alarm.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_ALARM));
                    volume_alarm.setMax(audioManager.getStreamVolume(AudioManager.STREAM_ALARM));
                    volume_call.setProgress(audioManager.getStreamVolume(AudioManager.MODE_IN_CALL));
                    volume_call.setMax(audioManager.getStreamVolume(AudioManager.MODE_IN_CALL));
                    //Accent Color
                    if (prefUtil.getInt("AccentColor", 00) != 00) {
                        volume_music.setProgressTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 00)));
                        volume_music.setThumbTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 00)));
                        volume_alarm.setProgressTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 00)));
                        volume_alarm.setThumbTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 00)));
                        volume_ring.setProgressTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 00)));
                        volume_ring.setThumbTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 00)));
                        volume_call.setProgressTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 00)));
                        volume_call.setThumbTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 00)));
                    }
                    //Background Color
                    if (prefUtil.getInt("BackgroundColor", 00) != 00) {
                        musiccardView.setBackgroundColor(prefUtil.getInt("BackgroundColor", 00));
                        ringcardView.setBackgroundColor(prefUtil.getInt("BackgroundColor", 00));
                        alarmcardView.setBackgroundColor(prefUtil.getInt("BackgroundColor", 00));
                        callcardView.setBackgroundColor(prefUtil.getInt("BackgroundColor", 00));
                    }

                    volume_music.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                            timerFullScreen.cancel();

                            boolean permission;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                permission = Settings.System.canWrite(context);
                            } else {
                                permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                            }
                            if (!permission) {
                                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
                                timerFullScreen.start();
                            }
                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {
                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {
                        }
                    });
                    volume_ring.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                            timerFullScreen.cancel();
                            boolean permission;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                permission = Settings.System.canWrite(context);
                            } else {
                                permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                            }
                            if (!permission) {
                                audioManager.setStreamVolume(AudioManager.STREAM_RING, i, 0);
                                timerFullScreen.start();
                            }
                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {

                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {

                        }
                    });
                    volume_alarm.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                            timerFullScreen.cancel();
                            boolean permission;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                permission = Settings.System.canWrite(context);
                            } else {
                                permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                            }
                            if (!permission) {
                                audioManager.setStreamVolume(AudioManager.STREAM_ALARM, i, 0);
                                timerFullScreen.start();
                            }
                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {
                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {
                        }
                    });
                    volume_call.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                            timerFullScreen.cancel();
                            boolean permission;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                permission = Settings.System.canWrite(context);
                            } else {
                                permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                            }
                            if (!permission) {
                                audioManager.setStreamVolume(AudioManager.MODE_IN_CALL, i, 0);
                                timerFullScreen.start();
                            }
                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {

                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {

                        }
                    });

                }
                //style 2 full
                if (prefUtil.getInt("selectedItem", 0) == 2) {
                    CardView hidden_view = fullVolumePanelView.findViewById(R.id.hidden_view);
                    VerticalSeekBar style_2_music = fullVolumePanelView.findViewById(R.id.android_music_seekBar_hidden);
                    VerticalSeekBar style_2_ring = fullVolumePanelView.findViewById(R.id.android_ring_seekBar);
                    VerticalSeekBar style_2_alarm = fullVolumePanelView.findViewById(R.id.android_alarm_seekBar);
                    VerticalSeekBar style_2_call = fullVolumePanelView.findViewById(R.id.android_call_seekBar);
                    style_2_music.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
                    style_2_music.setMaxValue(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
                    style_2_ring.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_RING));
                    style_2_ring.setMaxValue(audioManager.getStreamVolume(AudioManager.STREAM_RING));
                    style_2_alarm.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_ALARM));
                    style_2_alarm.setMaxValue(audioManager.getStreamVolume(AudioManager.STREAM_ALARM));
                    style_2_call.setProgress(audioManager.getStreamVolume(AudioManager.MODE_IN_CALL));
                    style_2_call.setMaxValue(audioManager.getStreamVolume(AudioManager.MODE_IN_CALL));
                    //Accent Color
                    if (prefUtil.getInt("AccentColor", 00) != 00) {
                        style_2_music.setBarProgressEndColor(prefUtil.getInt("AccentColor", 00));
                        style_2_music.setBarProgressStartColor(prefUtil.getInt("AccentColor", 00));
                        style_2_ring.setBarProgressEndColor(prefUtil.getInt("AccentColor", 00));
                        style_2_ring.setBarProgressStartColor(prefUtil.getInt("AccentColor", 00));
                        style_2_alarm.setBarProgressEndColor(prefUtil.getInt("AccentColor", 00));
                        style_2_alarm.setBarProgressStartColor(prefUtil.getInt("AccentColor", 00));
                        style_2_call.setBarProgressEndColor(prefUtil.getInt("AccentColor", 00));
                        style_2_call.setBarProgressStartColor(prefUtil.getInt("AccentColor", 00));
                    }
                    //Background Color
                    if (prefUtil.getInt("BackgroundColor", 00) != 00) {
                        hidden_view.setBackgroundColor(prefUtil.getInt("BackgroundColor", 00));
                    }

                    style_2_music.setOnProgressChangeListener(new Function1<Integer, Unit>() {
                        @Override
                        public Unit invoke(Integer integer) {
                            timerFullScreen.cancel();
                            boolean permission;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                permission = Settings.System.canWrite(context);
                            } else {
                                permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                            }
                            if (!permission) {
                                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, integer, 0);
                                timerFullScreen.start();
                            }
                            return null;
                        }
                    });
                    style_2_ring.setOnProgressChangeListener(new Function1<Integer, Unit>() {
                        @Override
                        public Unit invoke(Integer integer) {
                            timerFullScreen.cancel();
                            boolean permission;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                permission = Settings.System.canWrite(context);
                            } else {
                                permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                            }
                            if (!permission) {
                                audioManager.setStreamVolume(AudioManager.STREAM_RING, integer, 0);
                                timerFullScreen.start();
                            }
                            return null;
                        }
                    });
                    style_2_alarm.setOnProgressChangeListener(new Function1<Integer, Unit>() {
                        @Override
                        public Unit invoke(Integer integer) {
                            timerFullScreen.cancel();
                            boolean permission;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                permission = Settings.System.canWrite(context);
                            } else {
                                permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                            }
                            if (!permission) {
                                audioManager.setStreamVolume(AudioManager.STREAM_ALARM, integer, 0);
                                timerFullScreen.start();
                            }
                            return null;
                        }
                    });
                    style_2_call.setOnProgressChangeListener(new Function1<Integer, Unit>() {
                        @Override
                        public Unit invoke(Integer integer) {
                            timerFullScreen.cancel();
                            boolean permission;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                permission = Settings.System.canWrite(context);
                            } else {
                                permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                            }
                            if (!permission) {
                                audioManager.setStreamVolume(AudioManager.STREAM_VOICE_CALL, integer, 0);
                                timerFullScreen.start();
                            }
                            return null;
                        }
                    });
                }
                //style 3 full
                if (prefUtil.getInt("selectedItem", 0) == 3) {
                    CardView cardView = fullVolumePanelView.findViewById(R.id.cardView2);

                    SeekBar style_3_full_music = fullVolumePanelView.findViewById(R.id.window10_musicseekbar);
                    SeekBar style_3_full_ring = fullVolumePanelView.findViewById(R.id.window10_ringseekbar);
                    SeekBar style_3_full_alarm = fullVolumePanelView.findViewById(R.id.window10_alarm_seekbar);
                    SeekBar style_3_full_call = fullVolumePanelView.findViewById(R.id.window10_call_seekbar);
                    style_3_full_music.setProgress(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
                    style_3_full_music.setMax(audioManager
                            .getStreamMaxVolume(AudioManager.STREAM_MUSIC));
                    style_3_full_ring.setProgress(audioManager.getStreamMaxVolume(AudioManager.STREAM_RING));
                    style_3_full_ring.setMax(audioManager
                            .getStreamMaxVolume(AudioManager.STREAM_RING));
                    style_3_full_alarm.setProgress(audioManager.getStreamMaxVolume(AudioManager.STREAM_ALARM));
                    style_3_full_alarm.setMax(audioManager
                            .getStreamMaxVolume(AudioManager.STREAM_ALARM));
                    style_3_full_call.setProgress(audioManager.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL));
                    style_3_full_call.setMax(audioManager
                            .getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL));
                    //Accent Color
                    if (prefUtil.getInt("AccentColor", 00) != 00) {
                        style_3_full_music.setProgressTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 00)));
                        style_3_full_music.setThumbTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 00)));
                        style_3_full_ring.setProgressTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 00)));
                        style_3_full_ring.setThumbTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 00)));
                        style_3_full_alarm.setProgressTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 00)));
                        style_3_full_alarm.setThumbTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 00)));
                        style_3_full_call.setProgressTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 00)));
                        style_3_full_call.setThumbTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 00)));
                    }
                    //Background Color
                    if (prefUtil.getInt("BackgroundColor", 00) != 00) {
                        cardView.setBackgroundColor(prefUtil.getInt("BackgroundColor", 00));
                    }

                    style_3_full_music.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                            timerFullScreen.cancel();
                            boolean permission;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                permission = Settings.System.canWrite(context);
                            } else {
                                permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                            }
                            if (!permission) {
                                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
                                timerFullScreen.start();
                            }
                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {

                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {

                        }
                    });
                    style_3_full_ring.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                            timerFullScreen.cancel();
                            boolean permission;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                permission = Settings.System.canWrite(context);
                            } else {
                                permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                            }
                            if (!permission) {
                                audioManager.setStreamVolume(AudioManager.STREAM_RING, i, 0);
                                timerFullScreen.start();
                            }
//                            Log.d("VerticalSeekBar", "PROGRESS CHANGED at value: " + progressValue);
                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {

                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {

                        }
                    });
                    style_3_full_alarm.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                            timerFullScreen.cancel();
                            boolean permission;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                permission = Settings.System.canWrite(context);
                            } else {
                                permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                            }
                            if (!permission) {
                                audioManager.setStreamVolume(AudioManager.STREAM_ALARM, i, 0);
                                timerFullScreen.start();
                            }
                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {

                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {

                        }
                    });
                    style_3_full_call.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                            timerFullScreen.cancel();
                            boolean permission;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                permission = Settings.System.canWrite(context);
                            } else {
                                permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                            }
                            if (!permission) {
                                audioManager.setStreamVolume(AudioManager.STREAM_VOICE_CALL, i, 0);
                                timerFullScreen.start();
                            }
//                            Log.d("VerticalSeekBar", "PROGRESS CHANGED at value: " + progressValue);
                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {

                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {

                        }
                    });
                }
                //style 4 full
                if (prefUtil.getInt("selectedItem", 0) == 4) {
                    CardView base_cardview = fullVolumePanelView.findViewById(R.id.base_cardviewAndroid);
                    RubberSeekBar style_4_full_music = fullVolumePanelView.findViewById(R.id.music_rubberseekbar);
                    RubberSeekBar style_4_full_ring = fullVolumePanelView.findViewById(R.id.ring_rubberseekbar);
                    RubberSeekBar style_4_full_alarm = fullVolumePanelView.findViewById(R.id.alarm_rubberseekbar);
                    RubberSeekBar style_4_full_call = fullVolumePanelView.findViewById(R.id.call_rubberseekbar);
                    style_4_full_music.setCurrentValue(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
                    style_4_full_music.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
                    style_4_full_ring.setCurrentValue(audioManager.getStreamVolume(AudioManager.STREAM_RING));
                    style_4_full_ring.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_RING));
                    style_4_full_alarm.setCurrentValue(audioManager.getStreamVolume(AudioManager.STREAM_ALARM));
                    style_4_full_alarm.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_ALARM));
                    style_4_full_call.setCurrentValue(audioManager.getStreamVolume(AudioManager.STREAM_VOICE_CALL));
                    style_4_full_call.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL));
                    //Accent Color
                    if (prefUtil.getInt("AccentColor", 00) != 00) {
                        style_4_full_music.setHighlightThumbOnTouchColor(prefUtil.getInt("AccentColor", 000));
                        style_4_full_music.setHighlightTrackColor(prefUtil.getInt("AccentColor", 000));
                        style_4_full_ring.setHighlightThumbOnTouchColor(prefUtil.getInt("AccentColor", 000));
                        style_4_full_ring.setHighlightTrackColor(prefUtil.getInt("AccentColor", 000));
                        style_4_full_alarm.setHighlightThumbOnTouchColor(prefUtil.getInt("AccentColor", 000));
                        style_4_full_alarm.setHighlightTrackColor(prefUtil.getInt("AccentColor", 000));
                        style_4_full_call.setHighlightThumbOnTouchColor(prefUtil.getInt("AccentColor", 000));
                        style_4_full_call.setHighlightTrackColor(prefUtil.getInt("AccentColor", 000));
                    }
                    //Background Color
                    if (prefUtil.getInt("BackgroundColor", 00) != 00) {
                        base_cardview.setBackgroundColor(prefUtil.getInt("BackgroundColor", 00));
                    }
                    style_4_full_music.setOnRubberSeekBarChangeListener(new RubberSeekBar.OnRubberSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(@NonNull RubberSeekBar rubberSeekBar, int i, boolean b) {
                            timerFullScreen.cancel();
                            boolean permission;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                permission = Settings.System.canWrite(context);
                            } else {
                                permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                            }
                            if (!permission) {
                                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
                                timerFullScreen.start();
                            }
                        }

                        @Override
                        public void onStartTrackingTouch(@NonNull RubberSeekBar rubberSeekBar) {

                        }

                        @Override
                        public void onStopTrackingTouch(@NonNull RubberSeekBar rubberSeekBar) {

                        }
                    });
                    style_4_full_ring.setOnRubberSeekBarChangeListener(new RubberSeekBar.OnRubberSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(@NonNull RubberSeekBar rubberSeekBar, int i, boolean b) {
                            timerFullScreen.cancel();
                            boolean permission;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                permission = Settings.System.canWrite(context);
                            } else {
                                permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                            }
                            if (!permission) {
                                audioManager.setStreamVolume(AudioManager.STREAM_RING, i, 0);
                                timerFullScreen.start();
                            }
                        }

                        @Override
                        public void onStartTrackingTouch(@NonNull RubberSeekBar rubberSeekBar) {

                        }

                        @Override
                        public void onStopTrackingTouch(@NonNull RubberSeekBar rubberSeekBar) {

                        }
                    });
                    style_4_full_alarm.setOnRubberSeekBarChangeListener(new RubberSeekBar.OnRubberSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(@NonNull RubberSeekBar rubberSeekBar, int i, boolean b) {
                            timerFullScreen.cancel();
                            boolean permission;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                permission = Settings.System.canWrite(context);
                            } else {
                                permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                            }
                            if (!permission) {
                                audioManager.setStreamVolume(AudioManager.STREAM_ALARM, i, 0);
                                timerFullScreen.start();
                            }
                        }

                        @Override
                        public void onStartTrackingTouch(@NonNull RubberSeekBar rubberSeekBar) {

                        }

                        @Override
                        public void onStopTrackingTouch(@NonNull RubberSeekBar rubberSeekBar) {

                        }
                    });
                    style_4_full_call.setOnRubberSeekBarChangeListener(new RubberSeekBar.OnRubberSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(@NonNull RubberSeekBar rubberSeekBar, int i, boolean b) {
                            timerFullScreen.cancel();
                            boolean permission;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                permission = Settings.System.canWrite(context);
                            } else {
                                permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                            }
                            if (!permission) {
                                audioManager.setStreamVolume(AudioManager.STREAM_VOICE_CALL, i, 0);
                                timerFullScreen.start();
                            }
                        }

                        @Override
                        public void onStartTrackingTouch(@NonNull RubberSeekBar rubberSeekBar) {

                        }

                        @Override
                        public void onStopTrackingTouch(@NonNull RubberSeekBar rubberSeekBar) {

                        }
                    });
                }
                //style 5 full
                if (prefUtil.getInt("selectedItem", 0) == 7) {
                    ConstraintLayout childConstraint = fullVolumePanelView.findViewById(R.id.childConstraint);
                    VerticalSeekBar style_7_full_music = fullVolumePanelView.findViewById(R.id.ios_music_seekbar);
                    VerticalSeekBar style_7_full_ring = fullVolumePanelView.findViewById(R.id.ios_ring_seekbar);
                    VerticalSeekBar style_7_full_alarm = fullVolumePanelView.findViewById(R.id.ios_alarm_seekbar);
                    VerticalSeekBar style_7_full_call = fullVolumePanelView.findViewById(R.id.ios_call_seekbar);
                    style_7_full_music.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
                    style_7_full_music.setMaxValue(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
                    style_7_full_ring.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_RING));
                    style_7_full_ring.setMaxValue(audioManager.getStreamVolume(AudioManager.STREAM_RING));
                    style_7_full_alarm.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_ALARM));
                    style_7_full_alarm.setMaxValue(audioManager.getStreamVolume(AudioManager.STREAM_ALARM));
                    style_7_full_call.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_VOICE_CALL));
                    style_7_full_call.setMaxValue(audioManager.getStreamVolume(AudioManager.STREAM_VOICE_CALL));
                    //Accent Color
                    if (prefUtil.getInt("AccentColor", 00) != 00) {
                        style_7_full_music.setBarProgressEndColor(prefUtil.getInt("AccentColor", 00));
                        style_7_full_ring.setBarProgressEndColor(prefUtil.getInt("AccentColor", 00));
                        style_7_full_alarm.setBarProgressEndColor(prefUtil.getInt("AccentColor", 00));
                        style_7_full_call.setBarProgressEndColor(prefUtil.getInt("AccentColor", 00));
                    }
                    //Background Color
                    if (prefUtil.getInt("BackgroundColor", 00) != 00)
                        childConstraint.setBackgroundColor(prefUtil.getInt("BackgroundColor", 00));

                    style_7_full_music.setOnProgressChangeListener(
                            new Function1<Integer, Unit>() {
                                @Override
                                public Unit invoke(Integer progressValue) {
                                    timerFullScreen.cancel();
                                    boolean permission;
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        permission = Settings.System.canWrite(context);
                                    } else {
                                        permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                                    }
                                    if (!permission) {
                                        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progressValue, 0);
                                        timerFullScreen.start();
                                    }
                                    return null;
                                }
                            }
                    );
                    style_7_full_ring.setOnProgressChangeListener(
                            new Function1<Integer, Unit>() {
                                @Override
                                public Unit invoke(Integer progressValue) {
                                    timerFullScreen.cancel();
                                    boolean permission;
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        permission = Settings.System.canWrite(context);
                                    } else {
                                        permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                                    }
                                    if (!permission) {
                                        audioManager.setStreamVolume(AudioManager.STREAM_RING, progressValue, 0);
                                        timerFullScreen.start();
                                    }
                                    return null;
                                }
                            }
                    );
                    style_7_full_alarm.setOnProgressChangeListener(
                            new Function1<Integer, Unit>() {
                                @Override
                                public Unit invoke(Integer progressValue) {
                                    timerFullScreen.cancel();
                                    boolean permission;
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        permission = Settings.System.canWrite(context);
                                    } else {
                                        permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                                    }
                                    if (!permission) {
                                        audioManager.setStreamVolume(AudioManager.STREAM_ALARM, progressValue, 0);
                                        timerFullScreen.start();
                                    }
                                    return null;
                                }
                            }
                    );
                    style_7_full_call.setOnProgressChangeListener(
                            new Function1<Integer, Unit>() {
                                @Override
                                public Unit invoke(Integer progressValue) {
                                    timerFullScreen.cancel();
                                    boolean permission;
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        permission = Settings.System.canWrite(context);
                                    } else {
                                        permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                                    }
                                    if (!permission) {
                                        audioManager.setStreamVolume(AudioManager.STREAM_VOICE_CALL, progressValue, 0);
                                        timerFullScreen.start();
                                    }
                                    return null;
                                }
                            }
                    );
                }
                //style 6 full
                if (prefUtil.getInt("selectedItem", 0) == 8) {
                    CardView cardView2 = fullVolumePanelView.findViewById(R.id.cardView2);
                    VerticalSeekBar style_8_full_music = fullVolumePanelView.findViewById(R.id.android11_music_seekbar);
                    VerticalSeekBar style_8_full_ring = fullVolumePanelView.findViewById(R.id.android11_ring_seekbar);
                    VerticalSeekBar style_8_full_alarm = fullVolumePanelView.findViewById(R.id.android11_alarm_seekbar);
                    VerticalSeekBar style_8_full_call = fullVolumePanelView.findViewById(R.id.android11_call_seekbar);
                    style_8_full_music.setMaxValue(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
                    style_8_full_music.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
                    style_8_full_ring.setMaxValue(audioManager.getStreamVolume(AudioManager.STREAM_RING));
                    style_8_full_ring.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_RING));
                    style_8_full_alarm.setMaxValue(audioManager.getStreamVolume(AudioManager.STREAM_ALARM));
                    style_8_full_alarm.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_ALARM));
                    style_8_full_call.setMaxValue(audioManager.getStreamVolume(AudioManager.STREAM_VOICE_CALL));
                    style_8_full_call.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_VOICE_CALL));
                    //Accent Color
                    if (prefUtil.getInt("AccentColor", 00) != 00) {
                        style_8_full_music.setBarProgressEndColor(prefUtil.getInt("AccentColor", 00));
                        style_8_full_ring.setBarProgressEndColor(prefUtil.getInt("AccentColor", 00));
                        style_8_full_alarm.setBarProgressEndColor(prefUtil.getInt("AccentColor", 00));
                        style_8_full_call.setBarProgressEndColor(prefUtil.getInt("AccentColor", 00));
                        style_8_full_music.setBarBackgroundStartColor(prefUtil.getInt("BackgroundColor", 000));
                        style_8_full_music.setBarBackgroundEndColor(prefUtil.getInt("BackgroundColor", 000));
                        style_8_full_ring.setBarBackgroundEndColor(prefUtil.getInt("BackgroundColor", 000));
                        style_8_full_ring.setBarBackgroundStartColor(prefUtil.getInt("BackgroundColor", 000));
                        style_8_full_alarm.setBarBackgroundEndColor(prefUtil.getInt("BackgroundColor", 000));
                        style_8_full_alarm.setBarBackgroundStartColor(prefUtil.getInt("BackgroundColor", 000));
                        style_8_full_call.setBarBackgroundEndColor(prefUtil.getInt("BackgroundColor", 000));
                        style_8_full_call.setBarBackgroundStartColor(prefUtil.getInt("BackgroundColor", 000));
                    }
                    //Background Color
//                    cardView2.setBackgroundColor(prefUtil.getInt("BackgroundColor", 00));
                    style_8_full_music.setOnProgressChangeListener(
                            new Function1<Integer, Unit>() {
                                @Override
                                public Unit invoke(Integer progressValue) {
                                    timerFullScreen.cancel();
                                    boolean permission;
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        permission = Settings.System.canWrite(context);
                                    } else {
                                        permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                                    }
                                    if (!permission) {
                                        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progressValue, 0);
                                        timerFullScreen.start();
                                    }

                                    return null;
                                }
                            }
                    );
                    style_8_full_ring.setOnProgressChangeListener(
                            new Function1<Integer, Unit>() {
                                @Override
                                public Unit invoke(Integer progressValue) {
                                    timerFullScreen.cancel();
                                    boolean permission;
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        permission = Settings.System.canWrite(context);
                                    } else {
                                        permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                                    }
                                    if (!permission) {
                                        audioManager.setStreamVolume(AudioManager.STREAM_RING, progressValue, 0);
                                        timerFullScreen.start();
                                    }
                                    return null;
                                }
                            }
                    );
                    style_8_full_alarm.setOnProgressChangeListener(
                            new Function1<Integer, Unit>() {
                                @Override
                                public Unit invoke(Integer progressValue) {
                                    timerFullScreen.cancel();
                                    boolean permission;
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        permission = Settings.System.canWrite(context);
                                    } else {
                                        permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                                    }
                                    if (!permission) {
                                        audioManager.setStreamVolume(AudioManager.STREAM_ALARM, progressValue, 0);
                                        timerFullScreen.start();
                                    }
                                    return null;
                                }
                            }
                    );
                    style_8_full_call.setOnProgressChangeListener(
                            new Function1<Integer, Unit>() {
                                @Override
                                public Unit invoke(Integer progressValue) {
                                    timerFullScreen.cancel();
                                    boolean permission;
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        permission = Settings.System.canWrite(context);
                                    } else {
                                        permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                                    }
                                    if (!permission) {
                                        audioManager.setStreamVolume(AudioManager.STREAM_VOICE_CALL, progressValue, 0);
                                        timerFullScreen.start();
                                    }
                                    return null;
                                }
                            }
                    );
                }
                //style 7 full
                if (prefUtil.getInt("selectedItem", 0) == 9) {
                    CardView base_cardviewAndroid = fullVolumePanelView.findViewById(R.id.base_cardviewAndroid);
                    SeekBar style_9_full_music = fullVolumePanelView.findViewById(R.id.android_horizontal_music_seekbar);
                    SeekBar style_9_full_ring = fullVolumePanelView.findViewById(R.id.android_horizontal_ring_seekbar);
                    SeekBar style_9_full_alarm = fullVolumePanelView.findViewById(R.id.android_horizontal_alarm_seekbar);
                    SeekBar style_9_full_call = fullVolumePanelView.findViewById(R.id.android_horizontal_call_seekbar);
                    style_9_full_music.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
                    style_9_full_music.setProgress(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
                    style_9_full_ring.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_RING));
                    style_9_full_ring.setProgress(audioManager.getStreamMaxVolume(AudioManager.STREAM_RING));
                    style_9_full_alarm.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_ALARM));
                    style_9_full_alarm.setProgress(audioManager.getStreamMaxVolume(AudioManager.STREAM_ALARM));
                    style_9_full_call.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL));
                    style_9_full_call.setProgress(audioManager.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL));
                    //Accent Color
                    if (prefUtil.getInt("AccentColor", 00) != 00) {
                        style_9_full_music.setProgressTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 00)));
                        style_9_full_music.setThumbTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 00)));
                        style_9_full_ring.setProgressTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 00)));
                        style_9_full_ring.setThumbTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 00)));
                        style_9_full_alarm.setProgressTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 00)));
                        style_9_full_alarm.setThumbTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 00)));
                        style_9_full_call.setProgressTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 00)));
                        style_9_full_call.setThumbTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 00)));
                    }
                    //Background Color
                    if (prefUtil.getInt("BackgroundColor", 00) != 00) {
                        base_cardviewAndroid.setBackgroundColor(prefUtil.getInt("BackgroundColor", 00));
                    }
                    style_9_full_music.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                            timerFullScreen.cancel();
                            boolean permission;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                permission = Settings.System.canWrite(context);
                            } else {
                                permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                            }
                            if (!permission) {
                                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
                                timerFullScreen.start();
                            }
                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {

                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {

                        }
                    });
                    style_9_full_ring.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                            timerFullScreen.cancel();
                            boolean permission;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                permission = Settings.System.canWrite(context);
                            } else {
                                permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                            }
                            if (!permission) {
                                audioManager.setStreamVolume(AudioManager.STREAM_RING, i, 0);
                                timerFullScreen.start();
                            }
                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {

                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {

                        }
                    });
                    style_9_full_alarm.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                            timerFullScreen.cancel();
                            boolean permission;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                permission = Settings.System.canWrite(context);
                            } else {
                                permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                            }
                            if (!permission) {
                                audioManager.setStreamVolume(AudioManager.STREAM_ALARM, i, 0);
                                timerFullScreen.start();
                            }
                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {

                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {

                        }
                    });
                    style_9_full_call.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                            timerFullScreen.cancel();
                            boolean permission;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                permission = Settings.System.canWrite(context);
                            } else {
                                permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                            }
                            if (!permission) {
                                audioManager.setStreamVolume(AudioManager.STREAM_VOICE_CALL, i, 0);
                                timerFullScreen.start();
                            }
                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {

                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {

                        }
                    });
                }
                //style 8 full
                if (prefUtil.getInt("selectedItem", 0) == 10) {
                    CardView musiccardView = fullVolumePanelView.findViewById(R.id.musiccardView);
                    CardView cardView_ui2 = fullVolumePanelView.findViewById(R.id.cardView_ui2);
                    CardView cardView2 = fullVolumePanelView.findViewById(R.id.cardView2);
                    SeekBar style_10_full_music = fullVolumePanelView.findViewById(R.id.oneUi_2_musicseekbar);
                    SeekBar style_10_full_ring = fullVolumePanelView.findViewById(R.id.oneUi_2_ringseekbar);
                    SeekBar style_10_full_alarm = fullVolumePanelView.findViewById(R.id.oneUi_2_alarmseekbar);
                    SeekBar style_10_full_call = fullVolumePanelView.findViewById(R.id.oneUi_2_callseekbar);
                    style_10_full_music.setMax(audioManager
                            .getStreamMaxVolume(AudioManager.STREAM_MUSIC));
                    style_10_full_music.setProgress(audioManager
                            .getStreamVolume(AudioManager.STREAM_MUSIC));
                    style_10_full_ring.setMax(audioManager
                            .getStreamMaxVolume(AudioManager.STREAM_RING));
                    style_10_full_ring.setProgress(audioManager
                            .getStreamVolume(AudioManager.STREAM_RING));
                    style_10_full_alarm.setMax(audioManager
                            .getStreamMaxVolume(AudioManager.STREAM_ALARM));
                    style_10_full_alarm.setProgress(audioManager
                            .getStreamVolume(AudioManager.STREAM_ALARM));
                    style_10_full_call.setMax(audioManager
                            .getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL));
                    style_10_full_call.setProgress(audioManager
                            .getStreamVolume(AudioManager.STREAM_VOICE_CALL));

                    // AccentColor
                    if (prefUtil.getInt("AccentColor", 00) != 00) {
                        style_10_full_ring.setProgressTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 00)));
                        style_10_full_music.setProgressTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 00)));
                        style_10_full_alarm.setProgressTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 00)));
                        style_10_full_call.setProgressTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 00)));
                    }

                    //Background Color
                    if (prefUtil.getInt("BackgroundColor", 00) != 00) {
                        musiccardView.setBackgroundColor(prefUtil.getInt("BackgroundColor", 00));
                        cardView_ui2.setBackgroundColor(prefUtil.getInt("BackgroundColor", 00));
//                    cardView2.setBackgroundColor(prefUtil.getInt("BackgroundColor",00));
                    }
                    style_10_full_music.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                            timerFullScreen.cancel();
                            boolean permission;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                permission = Settings.System.canWrite(context);
                            } else {
                                permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                            }
                            if (!permission) {
                                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
                                timerFullScreen.start();
                            }
                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {
                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {
                        }
                    });
                    style_10_full_ring.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                            timerFullScreen.cancel();
                            boolean permission;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                permission = Settings.System.canWrite(context);
                            } else {
                                permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                            }
                            if (!permission) {
                                audioManager.setStreamVolume(AudioManager.STREAM_RING, i, 0);
                                timerFullScreen.start();
                            }
                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {
                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {
                        }
                    });
                    style_10_full_alarm.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                            timerFullScreen.cancel();
                            boolean permission;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                permission = Settings.System.canWrite(context);
                            } else {
                                permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                            }
                            if (!permission) {
                                audioManager.setStreamVolume(AudioManager.STREAM_ALARM, i, 0);
                                timerFullScreen.start();
                            }
                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {
                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {
                        }
                    });
                    style_10_full_call.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                            timerFullScreen.cancel();
                            boolean permission;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                permission = Settings.System.canWrite(context);
                            } else {
                                permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                            }
                            if (!permission) {
                                audioManager.setStreamVolume(AudioManager.STREAM_VOICE_CALL, i, 0);
                                timerFullScreen.start();
                            }
                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {
                            timerFullScreen.cancel();
                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {
                            handler.postDelayed(r, timeOnScreen);

                        }
                    });
                }
            }
        });


        // PopUp Style_1_single open when press volume button.....................................................................
        if (prefUtil.getInt("selectedItem", 1) == 1) {
            CardView cardViewBellIcon = singleVolumePanelView.findViewById(R.id.cardViewBellIcon);
            CardView constraintLay = singleVolumePanelView.findViewById(R.id.constraintLay);
            ImageButton btnMoreCard = singleVolumePanelView.findViewById(R.id.btn_show_more);
            ImageView ring_icon = singleVolumePanelView.findViewById(R.id.ring_icon);
            style_1_single = singleVolumePanelView.findViewById(R.id.ringSeekbar);

            //Accent Color
            if (prefUtil.getInt("AccentColor", 000) != 000) {
                style_1_single.setThumbTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 000)));
                style_1_single.setProgressTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 000)));
                btnShowMore.setBackgroundColor((prefUtil.getInt("AccentColor", 000)));
                ring_icon.setColorFilter(prefUtil.getInt("AccentColor", 000));
            }

            //Background color
            if (prefUtil.getInt("BackgroundColor", 000) != 000) {
                cardViewBellIcon.setBackgroundColor(prefUtil.getInt("BackgroundColor", 00));
                btnMoreCard.setBackgroundColor(prefUtil.getInt("BackgroundColor", 00));
                constraintLay.setBackgroundColor(prefUtil.getInt("BackgroundColor", 00));
                style_1_single.setBackgroundColor(prefUtil.getInt("BackgroundColor", 00));
            }
//            else {
//                btnMoreCard.setBackgroundColor(R.color.grey);
//            }

            style_1_single.setMax(audioManager
                    .getStreamMaxVolume(AudioManager.STREAM_MUSIC));
            style_1_single.setProgress(audioManager
                    .getStreamVolume(AudioManager.STREAM_MUSIC));


            style_1_single.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {


                    boolean permission;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        permission = Settings.System.canWrite(context);
                    } else {
                        permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                    }
                    if (!permission) {
                        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    handler.removeCallbacks(r);

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                    handler.postDelayed(r, timeOnScreen);
//
                }
            });
        }
        // PopUp Single_2_style open when press volume button.....................................................................
        else if (prefUtil.getInt("selectedItem", -1) == 2) {
//            ConstraintLayout mainLayout = singleVolumePanelView.findViewById(R.id.mainLayout);
            VerticalSeekBar style_2_single = singleVolumePanelView.findViewById(R.id.android_music_seekBar);
            CardView btnMoreCard = singleVolumePanelView.findViewById(R.id.cardView3);
            style_2_single.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
            style_2_single.setMaxValue(audioManager
                    .getStreamMaxVolume(AudioManager.STREAM_MUSIC));

            //Accent Color
            if (prefUtil.getInt("AccentColor", 000) != 000) {
                style_2_single.setBarProgressEndColor(prefUtil.getInt("AccentColor", 000));
                style_2_single.setBarProgressStartColor(prefUtil.getInt("AccentColor", 000));
            }

            //Background Color
            if (prefUtil.getInt("BackgroundColor", 000) != 000) {
//                mainLayout.setBackgroundColor(prefUtil.getInt("BackgroundColor", 00));
                style_2_single.setBarBackgroundStartColor(prefUtil.getInt("BackgroundColor", 000));

            } else {
                style_2_single.setBarBackgroundStartColor(ContextCompat.getColor(context, R.color.grey));

            }
            style_2_single.setOnProgressChangeListener(
                    new Function1<Integer, Unit>() {
                        @Override
                        public Unit invoke(Integer progressValue) {
                            handler.removeCallbacks(r);
                            boolean permission;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                permission = Settings.System.canWrite(context);
                            } else {
                                permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                            }
                            if (!permission) {
                                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progressValue, 0);
                                handler.postDelayed(r, timeOnScreen);
                            }
                            return null;
                        }
                    }
            );
        }
        // PopUp Style_3_single open when press volume button.....................................................................
        else if (prefUtil.getInt("selectedItem", -1) == 3) {
            ConstraintLayout main_lay = singleVolumePanelView.findViewById(R.id.main_lay);
            SeekBar style_3_single = singleVolumePanelView.findViewById(R.id.window10_musicseekbar);
            style_3_single.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
            style_3_single.setMax(audioManager
                    .getStreamMaxVolume(AudioManager.STREAM_MUSIC));
            //Accent Color
            if (prefUtil.getInt("AccentColor", 000) != 000) {
                style_3_single.setThumbTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 000)));
                style_3_single.setProgressTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 000)));
            }

            //Background color
            if (prefUtil.getInt("BackgroundColor", 000) != 000) {
                main_lay.setBackgroundColor(prefUtil.getInt("BackgroundColor", 000));
//                style_3_single.setBackgroundColor(prefUtil.getInt("BackgroundColor", 000));
            }


            style_3_single.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    boolean permission;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        permission = Settings.System.canWrite(context);
                    } else {
                        permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                    }
                    if (!permission) {
                        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
                    }
//                  Log.d("VerticalSeekBar", "PROGRESS CHANGED at value: " + progressValue);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    handler.removeCallbacks(r);
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    handler.postDelayed(r, timeOnScreen);
                }
            });
        }
        //  Style_4_single open when press volume button.....................................................................
        else if (prefUtil.getInt("selectedItem", -1) == 4) {
            CardView fixed_layout1 = singleVolumePanelView.findViewById(R.id.base_cardviewAndroid);
            RubberSeekBar style_4_single = singleVolumePanelView.findViewById(R.id.music_rubberseekbar);
            style_4_single.setCurrentValue(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
//            style_4_single.setMax(20);
            style_4_single.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
            Log.d("TAG", "setWindow: style_4_single" + audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
            //Accent color
            if (prefUtil.getInt("AccentColor", 000) != 000) {
                style_4_single.setHighlightThumbOnTouchColor(prefUtil.getInt("AccentColor", 000));
//            style_4_single.setDefaultThumbInsideColor(prefUtil.getInt("AccentColor", 000));
                style_4_single.setHighlightTrackColor(prefUtil.getInt("AccentColor", 000));
            }
            //Background color
            if (prefUtil.getInt("BackgroundColor", 000) != 000) {
                fixed_layout1.setBackgroundColor(prefUtil.getInt("BackgroundColor", 000));
            }
            style_4_single.setOnRubberSeekBarChangeListener(new RubberSeekBar.OnRubberSeekBarChangeListener() {
                @Override
                public void onProgressChanged(@NonNull RubberSeekBar rubberSeekBar, int i, boolean b) {

                    boolean permission;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        permission = Settings.System.canWrite(context);
                    } else {
                        permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                    }
                    if (!permission) {
                        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);

                    }
                    style_4_single.post(() -> style_4_single.setCurrentValue(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)));
                    style_4_single.refreshDrawableState();
                }

                @Override
                public void onStartTrackingTouch(@NonNull RubberSeekBar rubberSeekBar) {
                    handler.removeCallbacks(r);
                }

                @Override
                public void onStopTrackingTouch(@NonNull RubberSeekBar rubberSeekBar) {
                    handler.postDelayed(r, timeOnScreen);
                }
            });
            style_4_single.post(() -> style_4_single.setCurrentValue(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)));
            style_4_single.refreshDrawableState();
        }
        // single style 5 .............................................................................
        else if (prefUtil.getInt("selectedItem", -1) == 7) {
            VerticalSeekBar style_7_single = singleVolumePanelView.findViewById(R.id.ios_music_seekbar);
            style_7_single.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
            style_7_single.setMaxValue(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
            //Accent color
            if (prefUtil.getInt("AccentColor", 000) != 000) {
                style_7_single.setBarProgressEndColor(prefUtil.getInt("AccentColor", 000));
                style_7_single.setBarBackgroundStartColor(prefUtil.getInt("BackgroundColor", 000));
                style_7_single.setBarBackgroundEndColor(prefUtil.getInt("BackgroundColor", 000));
            }

            //Background color
//            style_7_single.setBarBackgroundStartColor(
//                    prefUtil.getInt("BackgroundColor", 000)
//            );
            style_7_single.setOnProgressChangeListener(
                    new Function1<Integer, Unit>() {
                        @Override
                        public Unit invoke(Integer progressValue) {
                            handler.removeCallbacks(r);
                            boolean permission;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                permission = Settings.System.canWrite(context);
                            } else {
                                permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                            }
                            if (!permission) {
                                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progressValue, 0);
                                handler.postDelayed(r, timeOnScreen);

                            }
                            Log.d("VerticalSeekBar", "PROGRESS CHANGED at value: " + progressValue);
                            return null;
                        }
                    }
            );

        }
        //single style 8 ......................................................................................
        else if (prefUtil.getInt("selectedItem", -1) == 8) {
            VerticalSeekBar style_8_single = singleVolumePanelView.findViewById(R.id.android11_music_seekbar);
            style_8_single.setMaxValue(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
            style_8_single.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
            //AccentColor
            if (prefUtil.getInt("AccentColor", 000) != 000) {
                style_8_single.setBarProgressEndColor(prefUtil.getInt("AccentColor", 000));
                style_8_single.setBarBackgroundStartColor(prefUtil.getInt("BackgroundColor", 000));
                style_8_single.setBarBackgroundEndColor(prefUtil.getInt("BackgroundColor", 000));
            }

            //Background Color
//            if (true) {
//                style_8_single.setBarBackgroundStartColor(prefUtil.getInt("BackgroundColor", 000));
//            } else {
//                style_8_single.setBarBackgroundStartColor(ContextCompat.getColor(context, R.color.grey));
//
//            }
            style_8_single.setOnProgressChangeListener(
                    new Function1<Integer, Unit>() {
                        @Override
                        public Unit invoke(Integer progressValue) {
                            handler.removeCallbacks(r);
                            boolean permission;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                permission = Settings.System.canWrite(context);
                            } else {
                                permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                            }
                            if (!permission) {
                                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progressValue, 0);
                                handler.postDelayed(r, timeOnScreen);

                            }
                            Log.d("VerticalSeekBar", "PROGRESS CHANGED at value: " + progressValue);
                            return null;
                        }
                    }
            );
            style_8_single.post(() -> style_8_single.setProgress(audioManager
                    .getStreamVolume(AudioManager.STREAM_MUSIC)));
            style_8_single.refreshDrawableState();
        }
        // style 9 single ......................................................................................
        else if (prefUtil.getInt("selectedItem", -1) == 9) {
            ConstraintLayout fixed_layout = singleVolumePanelView.findViewById(R.id.fixed_layout);
            SeekBar style_9_single = singleVolumePanelView.findViewById(R.id.androidHorizontal_music_seekbar);
            style_9_single.setMax(audioManager
                    .getStreamMaxVolume(AudioManager.STREAM_MUSIC));
            style_9_single.setProgress(audioManager
                    .getStreamVolume(AudioManager.STREAM_MUSIC));
            //Accent Color
            if (prefUtil.getInt("AccentColor", 000) != 000) {
                style_9_single.setThumbTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 000)));
                style_9_single.setProgressTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 000)));
            }
            //Background Color
            if (prefUtil.getInt("BackgroundColor", 000) != 000) {
                fixed_layout.setBackgroundColor(prefUtil.getInt("BackgroundColor", 000));
//            style_9_single.setBackgroundColor(prefUtil.getInt("BackgroundColor", 000));
            }
//            else {
//                fixed_layout.setBackgroundColor(ContextCompat.getColor(context, R.color.grey));
//
//            }
            style_9_single.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    boolean permission;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        permission = Settings.System.canWrite(context);
                    } else {
                        permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                    }
                    if (!permission) {
                        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    handler.removeCallbacks(r);
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    handler.postDelayed(r, timeOnScreen);
                }
            });
            style_9_single.post(() -> style_9_single.setProgress(audioManager
                    .getStreamVolume(AudioManager.STREAM_MUSIC)));
            style_9_single.refreshDrawableState();
        }
        //single style 10......................................................................................
        else if (prefUtil.getInt("selectedItem", -1) == 10) {
            ImageButton btn_show_more = singleVolumePanelView.findViewById(R.id.btn_show_more);
            ConstraintLayout mainLay = singleVolumePanelView.findViewById(R.id.mainLay);

            SeekBar style_10_single = singleVolumePanelView.findViewById(R.id.oneUi_2_musicseekbar);
            style_10_single.setMax(audioManager
                    .getStreamMaxVolume(AudioManager.STREAM_MUSIC));
            style_10_single.setProgress(audioManager
                    .getStreamVolume(AudioManager.STREAM_MUSIC));
            //Accent Color
            if (prefUtil.getInt("AccentColor", 000) != 000) {
                style_10_single.setProgressTintList(ColorStateList.valueOf(prefUtil.getInt("AccentColor", 000)));
            }
//            else {
//                style_10_single.setProgressTintList(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.blue)));
//            }
            //Background color
            if (prefUtil.getInt("BackgroundColor", 000) != 000) {
                mainLay.setBackgroundColor(prefUtil.getInt("BackgroundColor", 000));
                btn_show_more.setBackgroundColor(prefUtil.getInt("BackgroundColor", 000));
            }
//                style_10_single.setBackgroundColor(prefUtil.getInt("BackgroundColor", 000));

//            else
//                mainLay.setBackgroundColor(ContextCompat.getColor(context, R.color.grey));

            style_10_single.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    boolean permission;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        permission = Settings.System.canWrite(context);
                    } else {
                        permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;
                    }
                    if (!permission) {
                        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    handler.removeCallbacks(r);
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    handler.postDelayed(r, timeOnScreen);
                }
            });
        }


//        style_1_single.setOnTouchListener((view, motionEvent) -> {
//            switch (motionEvent.getAction()) {
//                case MotionEvent.ACTION_DOWN:
//                    break;
//                case MotionEvent.ACTION_UP:
//                    Log.d("TAG", "RingTone Volume Value: ");
//                    break;
//            }
//            return false;
//        });
    }

    public static void resetAll(Context context) {
        style_1_single.setThumbTintList(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.red)));

    }

    public static void timeOnScreen() {
        int timeOnScreen = prefUtil.getInt("VolumeSlider", 0);
        Log.e("TAG", "onStopTrackingTouch: 27337" + timeOnScreen);

    }


}

