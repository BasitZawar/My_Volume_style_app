package com.lads.myvolumeapp.Services


import android.accessibilityservice.AccessibilityService
import android.media.AudioManager
import android.media.AudioManager.ADJUST_RAISE
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.view.accessibility.AccessibilityEvent
import com.lads.myvolumeapp.R
import com.lads.myvolumeapp.Util.PrefUtil
import com.lads.myvolumeapp.Util.WindowLayoutManager1
import java.lang.Exception


class MyAccessibilityService : AccessibilityService() {

    var volumeCount = 0
    var windowManager: WindowManager? = null
    var singleVolumePanelView: View? = null
    var fullVolumePanelView: View? = null
    private var isNull = false
    var audioManager: AudioManager? = null
    var prefUtil: PrefUtil? = null



    override fun onAccessibilityEvent(accessibilityEvent: AccessibilityEvent) {
        val audioManager = getSystemService(AUDIO_SERVICE) as AudioManager
        if (accessibilityEvent.getEventType() == AccessibilityEvent.TYPE_VIEW_FOCUSED) {
//        if (accessibilityEvent.source.text == "Increase volume") {
            audioManager.adjustStreamVolume(AudioManager.STREAM_ACCESSIBILITY, ADJUST_RAISE, 0)
//            Toast.makeText(applicationContext,"AS",Toast.LENGTH_SHORT).show()
        }

    }

    override fun onInterrupt() {
        TODO("Not yet implemented")
    }

    override fun onKeyEvent(event: KeyEvent): Boolean {
        prefUtil = PrefUtil(applicationContext)
        val action = event.action
        val keyCode = event.keyCode
        audioManager = getSystemService(AUDIO_SERVICE) as AudioManager
        volumeCount = audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC)

        if (action == KeyEvent.ACTION_UP) {

            if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {

                ++volumeCount

                    setSelectedLayout()
                Log.d("TAG", "KeyUp: $volumeCount")
                audioManager!!.setStreamVolume(AudioManager.STREAM_MUSIC, volumeCount, 0);
                audioManager!!.adjustVolume(ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND)
                //                setSelectedLayout();
                isNull = true
                return true
            }
        }
        if (action == KeyEvent.ACTION_DOWN) {
            if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {

                    setSelectedLayout()

                --volumeCount
                audioManager!!.setStreamVolume(AudioManager.STREAM_MUSIC, volumeCount, 0);
                audioManager!!.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND)
                Log.d("TAG", "KeyDown$volumeCount")
                return true
            }
            return true
        }
        return super.onKeyEvent(event)
    }

    private fun setSelectedLayout() {
        prefUtil = PrefUtil(applicationContext)
        windowManager = getSystemService(WINDOW_SERVICE) as WindowManager
        Log.d("setSelectedLayout", " FUNCTION RUNS")
        if (prefUtil!!.getInt("selectedItem", 1) == 1) {
            if (currentFullView!=null)
                try{
                    windowManager?.removeView(currentFullView)
                }catch (e:Exception){}
            singleVolumePanelView =
                LayoutInflater.from(applicationContext).inflate(R.layout.style_1_single, null)
            fullVolumePanelView =
                LayoutInflater.from(applicationContext).inflate(R.layout.style_1_full, null)
            currentFullView=fullVolumePanelView
            WindowLayoutManager1.setWindow<Any>(
                applicationContext,
                windowManager,
                fullVolumePanelView,
                singleVolumePanelView
            )
//                singleVolumePanelView!!.setOnTouchListener(object :View.OnTouchListener{
//                    override fun onTouch(p0: View?, event: MotionEvent?): Boolean {
//                        when (event?.action) {
//                            MotionEvent.ACTION_OUTSIDE ->  windowManager!!.removeView(singleVolumePanelView)
//                        }
//                        return true
//                    }
//                })
//                fullVolumePanelView!!.setOnTouchListener(object :View.OnTouchListener{
//                    override fun onTouch(p0: View?, event: MotionEvent?): Boolean {
//                        when (event?.action) {
//                            MotionEvent.ACTION_OUTSIDE ->  windowManager!!.removeView(fullVolumePanelView)
//                        }
//                        return true
//                    }
//                })
//        Toast.makeText(applicationContext, " Selected Item is 1 ", Toast.LENGTH_SHORT).show()
        } else if (prefUtil!!.getInt("selectedItem", 2) == 2) {
            if (currentFullView!=null)
                try{
                    windowManager?.removeView(currentFullView)
                }catch (e:Exception){}
            singleVolumePanelView =
                LayoutInflater.from(applicationContext).inflate(R.layout.style_2_single, null)
            fullVolumePanelView =
                LayoutInflater.from(applicationContext).inflate(R.layout.style_2_full, null)
            currentFullView=fullVolumePanelView
            //            VerticalSeekBar seekBar=singleVolumePanelView.findViewById(R.id.android_music_seekBar);
//            seekBar.setBarBackgroundStartColor(ContextCompat.getColor(this,R.color.colorAccent));
            WindowLayoutManager1.setWindow<Any>(
                applicationContext,
                windowManager,
                fullVolumePanelView,
                singleVolumePanelView
            )
//                singleVolumePanelView!!.setOnTouchListener(object :View.OnTouchListener{
//                    override fun onTouch(p0: View?, event: MotionEvent?): Boolean {
//                        when (event?.action) {
//                            MotionEvent.ACTION_OUTSIDE ->  windowManager!!.removeView(singleVolumePanelView)
//                        }
//                        return true
//                    }
//                })
//                fullVolumePanelView!!.setOnTouchListener(object :View.OnTouchListener{
//                    override fun onTouch(p0: View?, event: MotionEvent?): Boolean {
//                        when (event?.action) {
//                            MotionEvent.ACTION_OUTSIDE ->  windowManager!!.removeView(fullVolumePanelView)
//                        }
//                        return true
//                    }
//                })
//        Toast.makeText(this, " Selected Item is 2 ", Toast.LENGTH_SHORT).show()
        } else if (prefUtil!!.getInt("selectedItem", 3) == 3) {
            if (currentFullView!=null)
                try{
                    windowManager?.removeView(currentFullView)
                }catch (e:Exception){}
            singleVolumePanelView =
                LayoutInflater.from(applicationContext).inflate(R.layout.style_3_single, null)
            fullVolumePanelView =
                LayoutInflater.from(applicationContext).inflate(R.layout.style_3_full, null)
            currentFullView=fullVolumePanelView
            WindowLayoutManager1.setWindow<Any>(
                applicationContext,
                windowManager,
                fullVolumePanelView,
                singleVolumePanelView
            )
//                singleVolumePanelView!!.setOnTouchListener(object :View.OnTouchListener{
//                    override fun onTouch(p0: View?, event: MotionEvent?): Boolean {
//                        when (event?.action) {
//                            MotionEvent.ACTION_OUTSIDE ->  windowManager!!.removeView(singleVolumePanelView)
//                        }
//                        return true
//                    }
//                })
//                fullVolumePanelView!!.setOnTouchListener(object :View.OnTouchListener{
//                    override fun onTouch(p0: View?, event: MotionEvent?): Boolean {
//                        when (event?.action) {
//                            MotionEvent.ACTION_OUTSIDE ->  windowManager!!.removeView(fullVolumePanelView)
//                        }
//                        return true
//                    }
//                })
//        Toast.makeText(this, " Selected Item is 3 ", Toast.LENGTH_SHORT).show()
        } else if (prefUtil!!.getInt("selectedItem", 4) == 4) {
            if (currentFullView!=null)
                try{
                    windowManager?.removeView(currentFullView)
                }catch (e:Exception){}
            singleVolumePanelView =
                LayoutInflater.from(applicationContext).inflate(R.layout.style_4_single, null)
            fullVolumePanelView =
                LayoutInflater.from(applicationContext).inflate(R.layout.style_4_full, null)
            currentFullView=fullVolumePanelView
            WindowLayoutManager1.setWindow<Any>(
                applicationContext,
                windowManager,
                fullVolumePanelView,
                singleVolumePanelView
            )
//                singleVolumePanelView!!.setOnTouchListener(object :View.OnTouchListener{
//                    override fun onTouch(p0: View?, event: MotionEvent?): Boolean {
//                        when (event?.action) {
//                            MotionEvent.ACTION_OUTSIDE ->  windowManager!!.removeView(singleVolumePanelView)
//                        }
//                        return true
//                    }
//                })
//                fullVolumePanelView!!.setOnTouchListener(object :View.OnTouchListener{
//                    override fun onTouch(p0: View?, event: MotionEvent?): Boolean {
//                        when (event?.action) {
//                            MotionEvent.ACTION_OUTSIDE ->  windowManager!!.removeView(fullVolumePanelView)
//                        }
//                        return true
//                    }
//                })
//        Toast.makeText(this, " Selected Item is 4 ", Toast.LENGTH_SHORT).show()
        } else if (prefUtil!!.getInt("selectedItem", 7) == 7) {
            if (currentFullView!=null)
                try{
                    windowManager?.removeView(currentFullView)
                }catch (e:Exception){}
            singleVolumePanelView =
                LayoutInflater.from(applicationContext).inflate(R.layout.style_7_single, null)
            fullVolumePanelView =
                LayoutInflater.from(applicationContext).inflate(R.layout.style_7_full, null)
            currentFullView=fullVolumePanelView
            WindowLayoutManager1.setWindow<Any>(
                applicationContext,
                windowManager,
                fullVolumePanelView,
                singleVolumePanelView
            )
//                singleVolumePanelView!!.setOnTouchListener(object :View.OnTouchListener{
//                    override fun onTouch(p0: View?, event: MotionEvent?): Boolean {
//                        when (event?.action) {
//                            MotionEvent.ACTION_OUTSIDE ->  windowManager!!.removeView(singleVolumePanelView)
//                        }
//                        return true
//                    }
//                })
//                fullVolumePanelView!!.setOnTouchListener(object :View.OnTouchListener{
//                    override fun onTouch(p0: View?, event: MotionEvent?): Boolean {
//                        when (event?.action) {
//                            MotionEvent.ACTION_OUTSIDE ->  windowManager!!.removeView(fullVolumePanelView)
//                        }
//                        return true
//                    }
//                })
//        Toast.makeText(this, " Selected Item is 7 ", Toast.LENGTH_SHORT).show()
        } else if (prefUtil!!.getInt("selectedItem", 8) == 8) {
            if (currentFullView!=null)
                try{
                    windowManager?.removeView(currentFullView)
                }catch (e:Exception){}
            singleVolumePanelView =
                LayoutInflater.from(applicationContext).inflate(R.layout.style_8_single, null)
            fullVolumePanelView =
                LayoutInflater.from(applicationContext).inflate(R.layout.style_8_full, null)
            currentFullView=fullVolumePanelView
            WindowLayoutManager1.setWindow<Any>(
                applicationContext,
                windowManager,
                fullVolumePanelView,
                singleVolumePanelView
            )
//                singleVolumePanelView!!.setOnTouchListener(object :View.OnTouchListener{
//                    override fun onTouch(p0: View?, event: MotionEvent?): Boolean {
//                        when (event?.action) {
//                            MotionEvent.ACTION_OUTSIDE ->  windowManager!!.removeView(singleVolumePanelView)
//                        }
//                        return true
//                    }
//                })
//                fullVolumePanelView!!.setOnTouchListener(object :View.OnTouchListener{
//                    override fun onTouch(p0: View?, event: MotionEvent?): Boolean {
//                        when (event?.action) {
//                            MotionEvent.ACTION_OUTSIDE ->  windowManager!!.removeView(fullVolumePanelView)
//                        }
//                        return true
//                    }
//                })
//        Toast.makeText(this, " Selected Item is 8 ", Toast.LENGTH_SHORT).show()
        } else if (prefUtil!!.getInt("selectedItem", 9) == 9) {
            if (currentFullView!=null)
                try{
                    windowManager?.removeView(currentFullView)
                }catch (e:Exception){}
            singleVolumePanelView =
                LayoutInflater.from(applicationContext).inflate(R.layout.style_9_single, null)
            fullVolumePanelView =
                LayoutInflater.from(applicationContext).inflate(R.layout.style_9_full, null)
            currentFullView=fullVolumePanelView
            WindowLayoutManager1.setWindow<Any>(
                applicationContext,
                windowManager,
                fullVolumePanelView,
                singleVolumePanelView
            )
//                singleVolumePanelView!!.setOnTouchListener(object :View.OnTouchListener{
//                    override fun onTouch(p0: View?, event: MotionEvent?): Boolean {
//                        when (event?.action) {
//                            MotionEvent.ACTION_OUTSIDE ->  windowManager!!.removeView(singleVolumePanelView)
//                        }
//                        return true
//                    }
//                })
//                fullVolumePanelView!!.setOnTouchListener(object :View.OnTouchListener{
//                    override fun onTouch(p0: View?, event: MotionEvent?): Boolean {
//                        when (event?.action) {
//                            MotionEvent.ACTION_OUTSIDE ->  windowManager!!.removeView(fullVolumePanelView)
//                        }
//                        return true
//                    }
//                })
//        Toast.makeText(this, " Selected Item is 9 ", Toast.LENGTH_SHORT).show()
        } else if (prefUtil!!.getInt("selectedItem", 10) == 10) {
            if (currentFullView!=null)
                try{
                    windowManager?.removeView(currentFullView)
                }catch (e:Exception){}

            singleVolumePanelView =
                LayoutInflater.from(applicationContext).inflate(R.layout.style_10_single, null)
            fullVolumePanelView =
                LayoutInflater.from(applicationContext).inflate(R.layout.style_10_full, null)
            currentFullView=fullVolumePanelView
            WindowLayoutManager1.setWindow<Any>(
                applicationContext,
                windowManager,
                fullVolumePanelView,
                singleVolumePanelView
            )
//                singleVolumePanelView!!.setOnTouchListener(object :View.OnTouchListener{
//                    override fun onTouch(p0: View?, event: MotionEvent?): Boolean {
//                        when (event?.action) {
//                            MotionEvent.ACTION_OUTSIDE ->  windowManager!!.removeView(singleVolumePanelView)
//                        }
//                        return true
//                    }
//                })
//                fullVolumePanelView!!.setOnTouchListener(object :View.OnTouchListener{
//                    override fun onTouch(p0: View?, event: MotionEvent?): Boolean {
//                        when (event?.action) {
//                            MotionEvent.ACTION_OUTSIDE ->  windowManager!!.removeView(fullVolumePanelView)
//                        }
//                        return true
//                    }
//                })
//        Toast.makeText(this, " Selected Item is 10 ", Toast.LENGTH_SHORT).show()
//            } else {
//                Toast.makeText(this, " No Style Selected  ", Toast.LENGTH_SHORT).show()
//            }
//        } catch (Exception e) {
//            Log.d("setSelectedLayout", " Catch part is running " + e.getMessage());
//        }
        }
    }


    companion object {
        var isopen: Boolean = false
        var currentFullView:View?=null

    }
}