package com.demoPurpose.core;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.demoPurpose.MyAppicaion;
import com.demoPurpose.R;


public class PrefHelper {
    private static Context context;
    private static PrefHelper instance;

    public static PrefHelper getInstance() {
        if (instance == null) {
            instance = new PrefHelper();
        }
        return instance;
    }

    private PrefHelper() {
        context = MyAppicaion.appContext.getApplicationContext();
    }

    public boolean getBoolean(String paramString, boolean paramBoolean) {
        return getSharedPreferences(context).getBoolean(paramString, paramBoolean);
    }

    public float getFloat(String paramString, float paramFloat) {
        return getSharedPreferences(context).getFloat(paramString, paramFloat);
    }

    public int getInt(String paramString, int paramInt) {
        return getSharedPreferences(context).getInt(paramString, paramInt);
    }

    public long getLong(String paramString, long paramLong) {
        return getSharedPreferences(context).getLong(paramString, paramLong);
    }

    public SharedPreferences getSharedPreferences(Context paramContext) {
        if (TextUtils.isEmpty(paramContext.getString(R.string.app_name))) {
        }
        SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
        localSharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);
        return localSharedPreferences;
    }

    public String getString(String paramString1, String paramString2) {
        return getSharedPreferences(context).getString(paramString1, paramString2);
    }

    public void putBoolean(String paramString, boolean paramBoolean) {
        getSharedPreferences(context).edit().putBoolean(paramString, paramBoolean).commit();
    }

    public void putFloat(String paramString, float paramFloat) {
        getSharedPreferences(context).edit().putFloat(paramString, paramFloat).commit();
    }

    public void putInt(String paramString, int paramInt) {
        getSharedPreferences(context).edit().putInt(paramString, paramInt).commit();
    }

    public void putLong(String paramString, long paramLong) {
        getSharedPreferences(context).edit().putLong(paramString, paramLong).commit();
    }

    public void putString(String paramString1, String paramString2) {
        getSharedPreferences(context).edit().putString(paramString1, paramString2).commit();
    }

    public void remove(String paramString) {
        getSharedPreferences(context).edit().remove(paramString).commit();
    }
}