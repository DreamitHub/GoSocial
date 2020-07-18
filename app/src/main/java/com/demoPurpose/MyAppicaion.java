package com.demoPurpose;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.demoPurpose.core.ApplicationSettings;

import java.io.File;
import java.lang.ref.WeakReference;

public class MyAppicaion extends Application {
    public static WeakReference<Activity> mAppWeakReference;
    public static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
        ApplicationSettings.getInstance().createAppFolders();
        File tempDir = new File(ApplicationSettings.getInstance().getTempDir());
        tempDir.setExecutable(true);
        tempDir.setWritable(true);
        tempDir.setReadable(true);
        tempDir.mkdirs();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static Activity getWeakReferenceActivity() {

        return mAppWeakReference.get();
    }

    public static Context getAppContext() {
        return appContext;
    }
}
