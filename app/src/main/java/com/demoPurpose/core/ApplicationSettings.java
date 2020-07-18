package com.demoPurpose.core;

import android.os.Environment;

import com.demoPurpose.MyAppicaion;

import java.io.File;

/**
 * Created by Darshan on 12-06-2017.
 */

public class ApplicationSettings {
    private static ApplicationSettings applicationSetting = null;

    public static final String APP_DIR = Environment.getExternalStorageDirectory().getPath() + File.separator + "WebserviceURL" + File.separator;
    public static final String MEDIA_DIR = APP_DIR + "Media" + File.separator;
    public static final String CHAT_DIR = APP_DIR + "WebserviceURL Chat" + File.separator;
    public static final String CHAT_SENT_DIR = CHAT_DIR + "Sent" + File.separator;
    public static final String MEDIA_IMAGE_DIR = MEDIA_DIR + "Images" + File.separator;
    public static final String MEDIA_IMAGE_SENT_DIR = MEDIA_IMAGE_DIR + "Sent" + File.separator;
    public static final String MEDIA_PROFILE_PIC_DIR = APP_DIR + ".Profile Pictures" + File.separator;
    public static final String MEDIA_FRAME_DIR = MEDIA_DIR + "Frames" + File.separator;
    public static final String CACHE_DIR = APP_DIR + ".cache" + File.separator;

    private ApplicationSettings() {

    }

    public static ApplicationSettings getInstance() {
        if (applicationSetting == null) {
            applicationSetting = new ApplicationSettings();
        }
        return applicationSetting;
    }

    public String getTempDir() {
        return MyAppicaion.getAppContext().getCacheDir().getAbsolutePath();
    }

    public String getFileDir() {
        return MyAppicaion.getAppContext().getFilesDir().getAbsolutePath();
    }

    public void createAppFolders() {
        File appdir = new File(APP_DIR);
        appdir.mkdirs();
        appdir.setExecutable(true);
        appdir.setWritable(true);
        appdir.setReadable(true);
        new File(MEDIA_DIR).mkdirs();
        new File(MEDIA_IMAGE_DIR).mkdirs();
        new File(MEDIA_IMAGE_SENT_DIR).mkdirs();
        new File(MEDIA_PROFILE_PIC_DIR).mkdirs();
        new File(MEDIA_FRAME_DIR).mkdirs();
        new File(CHAT_DIR).mkdirs();
        new File(CHAT_SENT_DIR).mkdirs();
        new File(CACHE_DIR).mkdirs();
    }
}
