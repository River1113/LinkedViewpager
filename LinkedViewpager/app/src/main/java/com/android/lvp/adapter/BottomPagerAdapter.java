package com.android.lvp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.lvp.linkedviewpager.PagerAdapter;

import java.util.List;


public class BottomPagerAdapter extends PagerAdapter {

    private List<Integer> mData;

    public BottomPagerAdapter(List<Integer> mPageViews) {
        super();
        this.mData = mPageViews;
    }

    @Override
    public int getCount() {
        return 10000;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Integer layout = mData.get(position % mData.size());
        View view = LayoutInflater.from(container.getContext()).inflate(layout, null);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}