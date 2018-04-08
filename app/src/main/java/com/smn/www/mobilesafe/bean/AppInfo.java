package com.smn.www.mobilesafe.bean;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2018-04-08.
 */

public class AppInfo {

    private String packageName;
    private String name;
    private Drawable drawable;

    public AppInfo(String packageName, String name, Drawable drawable) {
        this.packageName = packageName;
        this.name = name;
        this.drawable = drawable;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    @Override
    public String toString() {
        return "AppInfo{" +
                "packageName='" + packageName + '\'' +
                ", name='" + name + '\'' +
                ", drawable=" + drawable +
                '}';
    }
}
