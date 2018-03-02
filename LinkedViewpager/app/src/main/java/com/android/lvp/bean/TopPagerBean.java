package com.android.lvp.bean;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Author：Road
 * Date  ：2018/2/28
 */

public class TopPagerBean implements Serializable {
    private Drawable backRes;
    private String title;

    public TopPagerBean() {
    }

    public TopPagerBean(Drawable backRes, String title) {
        this.backRes = backRes;
        this.title = title;
    }

    public Drawable getBackRes() {
        return backRes;
    }

    public void setBackRes(Drawable backRes) {
        this.backRes = backRes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
