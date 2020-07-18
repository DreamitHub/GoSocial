package com.demoPurpose.core;

import android.os.Environment;

import com.demoPurpose.R;
import com.demoPurpose.common.Constants;

import java.io.File;

public class ApplicationSetting {

    private static ApplicationSetting applicationSetting = null;
    private static final String KEY_IS_REMEMBER = "KEY_IS_REMEMBER";
    private static final String KEY_EMAIL_ID = "KEY_EMAIL_ID";
    private static final String KEY_PASSWORD = "KEY_PASSWORD";
    private static final String USER_INFO = "USER_INFO";
    private static final String KEY_REG_ID = "KEY_REG_ID";


    private final String rootDir = Environment.getExternalStorageDirectory().getPath() + File.separator + R.string.app_name;
    private final String mediaDir = rootDir + File.separator + Constants.media;
    private final String mediaPhotosDir = mediaDir + File.separator + Constants.photo;
    private final String mediaVideosDir = mediaDir + File.separator + Constants.video;
    private final String mediaAudiosDir = mediaDir + File.separator + Constants.audio;

    private ApplicationSetting() {

    }

    public static ApplicationSetting getInstance() {
        if (applicationSetting == null) {
            applicationSetting = new ApplicationSetting();
        }
        return applicationSetting;
    }


    public void setIsRemember(boolean isRemember) {
        PrefHelper.getInstance().putBoolean(KEY_IS_REMEMBER, isRemember);
    }

    public boolean getIsRemember() {
        return PrefHelper.getInstance().getBoolean(KEY_IS_REMEMBER, false);
    }

    public void setEmailId(String emaiId) {
        PrefHelper.getInstance().putString(KEY_EMAIL_ID, emaiId);
    }

    public String getKeyEmailId() {
        return PrefHelper.getInstance().getString(KEY_EMAIL_ID, "");
    }

    public void setPassword(String password) {
        PrefHelper.getInstance().putString(KEY_PASSWORD, password);
    }

    public String getPassword() {
        return PrefHelper.getInstance().getString(KEY_PASSWORD, "");
    }


    public String getRootDir() {
        return rootDir;
    }

    public String getMediaDir() {
        return mediaDir;
    }

    public String getPhotosDir() {
        return mediaPhotosDir;
    }

    public String getVideosDir() {
        return mediaVideosDir;
    }

    public String getAudiosDir() {
        return mediaAudiosDir;
    }

    public String getRegistrationId() {
        return PrefHelper.getInstance().getString(KEY_REG_ID, null);
    }

    public void setRegistrationId(String registrationId) {
        PrefHelper.getInstance().putString(KEY_REG_ID, registrationId);
    }


}
