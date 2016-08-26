package com.bjw.rxjavatest;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2016/8/15 0015.
 */
public class AppInfo {
    private String mAppName;
    private String mPackageName;
    private long mAppSize;
    private boolean mInRoom;
    private Drawable mAppIcon;
    private boolean mIsSystemApp;

    public AppInfo() {

    }


    public String getAppName() {
        return mAppName;
    }

    public void setAppName(String appName) {
        mAppName = appName;
    }

    public String getPackageName() {
        return mPackageName;
    }

    public void setPackageName(String packageName) {
        mPackageName = packageName;
    }

    public long getAppSize() {
        return mAppSize;
    }

    public void setAppSize(long appSize) {
        mAppSize = appSize;
    }

    public boolean getInRoom() {
        return mInRoom;
    }

    public void setInRoom(boolean inRoom) {
        mInRoom = inRoom;
    }

    public Drawable getAppIcon() {
        return mAppIcon;
    }

    public void setAppIcon(Drawable appIcon) {
        mAppIcon = appIcon;
    }

    public boolean getIsSystemApp() {
        return mIsSystemApp;
    }

    public void setIsSystemApp(boolean isSystemApp) {
        mIsSystemApp = isSystemApp;
    }
}
