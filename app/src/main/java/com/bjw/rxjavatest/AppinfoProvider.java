package com.bjw.rxjavatest;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;

import com.orhanobut.logger.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Administrator on 2016/8/15 0015.
 */
public class AppinfoProvider {

    public static Observable<List<AppInfo>> getAllAppInfo(final Context context) {

        Observable<List<AppInfo>> observable =
                Observable.create(new Observable.OnSubscribe<List<AppInfo>>() {
            @Override
            public void call(Subscriber<? super List<AppInfo>> subscriber) {
                PackageManager manager = context.getPackageManager();
                List<AppInfo> appInfos = new ArrayList<>();
                List<PackageInfo> packageInfos = manager.getInstalledPackages(0);
                for (PackageInfo packageInfo : packageInfos) {
                    AppInfo info = new AppInfo();
                    String packageName = packageInfo.packageName;
                    Drawable appIcon = packageInfo.applicationInfo.loadIcon(manager);
                    String appName = packageInfo.applicationInfo
                            .loadLabel(manager).toString();
                    String appPath = packageInfo.applicationInfo.sourceDir;
                    int flag = packageInfo.applicationInfo.flags;
                    if ((flag & ApplicationInfo.FLAG_SYSTEM) != 0) {
                        info.setIsSystemApp(true);
                    } else {
                        info.setIsSystemApp(false);
                    }
                    if ((flag & ApplicationInfo.FLAG_EXTERNAL_STORAGE) != 0) {
                        info.setInRoom(false);
                    } else {
                        info.setInRoom(true);
                    }
                    File file = new File(appPath);
                    long appSize = file.length();
                    info.setAppSize(appSize);
                    info.setPackageName(packageName);
                    info.setAppIcon(appIcon);
                    info.setAppName(appName);
                    appInfos.add(info);
                    SystemClock.sleep(50);
                }
                Logger.w("ddddddddddd1");
                subscriber.onNext(appInfos);
                subscriber.onCompleted();
            }
        });
        return observable;
    }
}
