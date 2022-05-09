package com.lads.myvolumeapp.Util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.gesture.Gesture;
import android.graphics.PixelFormat;
import android.os.Build;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;


public class WindowParamsManager {

    private static PrefUtil prefUtil;
   public static GestureDetector myG;
    // FullWindowLayout Parms..........
    @SuppressLint("WrongConstant")
    public static WindowManager.LayoutParams getMainLayoutParams() {
        final WindowManager.LayoutParams params;
        params = new WindowManager.LayoutParams();

        params.format = PixelFormat.TRANSLUCENT;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            params.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
            params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                    WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                    WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH;
        } else {
            params.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT |
                    WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY;
            params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                    WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH;
        }
//        setMainWindowHeightWidth(params);


        params.width = 700;
        params.height = 650;
        if (prefUtil.getInt("selectedItem", 0) == 4 || prefUtil.getInt("selectedItem", 0) == 9) {
            params.gravity = Gravity.TOP;
            Log.e("TESTTAG", "Selected item is 4,5,9");
        } else {
            setVerticalPosition(params);
        }

        return params;
    }

    private static void setVerticalPosition(WindowManager.LayoutParams params) {

        int verticalPosition = prefUtil.getInt("verticalPositionSlider", 0);
        params.y = verticalPosition;
        Log.d("TAG", "setWindowVerticalPosition: 2222" + verticalPosition);

    }

    private static void setWindowPosition(WindowManager.LayoutParams params) {
        int position = prefUtil.getInt("panel_position", 0);
        Log.e("TESTTAG", "setWindowPosition: 2222" + position);
        if (position == 0)
            params.gravity = Gravity.LEFT;
        else
            params.gravity = Gravity.RIGHT;
    }

//    private static void setMainWindowHeightWidth(WindowManager.LayoutParams params) {
//        PrefUtil prefUtil = null;
//        int width = prefUtil.getInt("", CommonKeys.EXPANDED_VOLUME_SLIDERS_WIDTH);
//        int height = PrefUtils.getInt(VolumeControls.getAppContext(), CommonKeys.EXPANDED_VOLUME_SLIDERS_HEIGHT);
//        params.width = width;
//        params.height = height;
//    }

//    private static void setWindowHeight(WindowManager.LayoutParams params) {
//        int height = prefUtil.getInt("sliderHeight", 0);
//        Log.e("TESTTAG", "setWindowHeight: 1214" + height);
//
//        params.height = height;
//    }

    @SuppressLint("WrongConstant")
    public static WindowManager.LayoutParams getLayoutParams(Context context) {
        final WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        prefUtil = new PrefUtil(context);
        params.format = PixelFormat.TRANSLUCENT;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            params.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
            params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                    WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                    WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH;
        } else {
            params.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT |
                    WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY;
            params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE|
                    WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH;
        }


        if (prefUtil != null) {
            if (prefUtil.getInt("selectedItem", 0) == 4 || prefUtil.getInt("selectedItem", 0) == 9) {
                params.gravity = Gravity.TOP;
                params.height = 190;
                params.width = 700;
            } else {
                setWindowPosition(params);
                setVerticalPosition(params);
                params.height = 700;
                params.width = 150;
//                setWindowHeight(params);
            }
        } else {
            Log.d("TAG", "pref is null ");
        }
        return params;
    }

}
