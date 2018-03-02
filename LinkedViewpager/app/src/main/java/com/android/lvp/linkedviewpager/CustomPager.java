package com.android.lvp.linkedviewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;


/**
 * Created by hml on 2017/7/13.
 */

public class CustomPager extends ViewPager {
    CustomPager mCustomPager;
    private boolean forSuper;

    public CustomPager(Context context) {
        super(context);
    }

    public CustomPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (!forSuper && mCustomPager != null) {
            mCustomPager.forSuper(true);
            mCustomPager.onInterceptTouchEvent(event);
            mCustomPager.forSuper(false);
        }
        return super.onInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!forSuper && mCustomPager != null) {
            mCustomPager.forSuper(true);
            mCustomPager.onTouchEvent(event);
            mCustomPager.forSuper(false);
        }
        return super.onTouchEvent(event);
    }


    public void forSuper(boolean forSuper) {
        this.forSuper = forSuper;
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        if (!forSuper && mCustomPager != null) {
            mCustomPager.forSuper(true);
            mCustomPager.setCurrentItem(item, smoothScroll);
            mCustomPager.forSuper(false);
        }
        super.setCurrentItem(item, smoothScroll);
    }

    @Override
    public void setCurrentItem(int item) {
        if (!forSuper && mCustomPager != null) {
            mCustomPager.forSuper(true);
            mCustomPager.setCurrentItem(item);
            mCustomPager.forSuper(false);
        }
        super.setCurrentItem(item);
    }

}