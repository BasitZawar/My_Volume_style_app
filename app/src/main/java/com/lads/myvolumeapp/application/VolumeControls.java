package com.lads.myvolumeapp.application;

import android.app.Application;
import android.content.Context;

public class VolumeControls extends Application {
    private static Context context;

    public static Context getAppContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
