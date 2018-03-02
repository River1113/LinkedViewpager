package com.android.lvp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.lvp.R;
import com.android.lvp.bean.TopPagerBean;
import com.android.lvp.linkedviewpager.PagerAdapter;

import java.util.List;


public class TopPagerAdapter extends PagerAdapter {

    private List<TopPagerBean> mData;

    public TopPagerAdapter(List<TopPagerBean> mPageViews) {
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
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_top_view, null);
        LinearLayout ll_content = view.findViewById(R.id.ll_content);
        TextView tv_title = view.findViewById(R.id.tv_title);

        TopPagerBean bean = mData.get(position % mData.size());
        ll_content.setBackground(bean.getBackRes());
        tv_title.setText(bean.getTitle());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}