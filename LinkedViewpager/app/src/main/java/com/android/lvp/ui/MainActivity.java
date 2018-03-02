package com.android.lvp.ui;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.android.lvp.R;
import com.android.lvp.adapter.BottomPagerAdapter;
import com.android.lvp.adapter.TopPagerAdapter;
import com.android.lvp.bean.TopPagerBean;
import com.android.lvp.linkedviewpager.CustomPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CustomPager bottomPager;
    private List<Integer> bottomPagerList;
    private BottomPagerAdapter bottomPagerAdapter;

    private CustomPager topPager;
    private List<TopPagerBean> topPagerList;
    private TopPagerAdapter topPagerAdapter;
    private LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewPager();
    }

    public void initViewPager() {
        topPager = findViewById(R.id.topPager);
        bottomPager = findViewById(R.id.bottomPager);
        container = findViewById(R.id.container);

        // 1.设置幕后item的缓存数目
        topPager.setOffscreenPageLimit(3);
        bottomPager.setOffscreenPageLimit(3);

        // 2.顶部viewPager父容器的Touch事件交给Viewpager处理，否则会出现viewpager的触摸范围只限于中间的卡片区域
        container.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return topPager.dispatchTouchEvent(event);
            }
        });


        // 3.模拟数据
        initData();

        // 4.绑定适配器
        topPagerAdapter = new TopPagerAdapter(topPagerList);
        topPager.setAdapter(topPagerAdapter);
        bottomPagerAdapter = new BottomPagerAdapter(bottomPagerList);
        bottomPager.setAdapter(bottomPagerAdapter);

        // 5.设置起始显示页
        topPager.setCurrentItem(5000);
        bottomPager.setCurrentItem(5000);

        // 6.设置联动
        topPager.setFollowViewPager(bottomPager);
        bottomPager.setFollowViewPager(topPager);
    }


    private void initData() {
        topPagerList = new ArrayList<>();
        Drawable drawable1 = getResources().getDrawable(R.drawable.bg_top_1);
        Drawable drawable2 = getResources().getDrawable(R.drawable.bg_top_2);
        Drawable drawable3 = getResources().getDrawable(R.drawable.bg_top_3);
        Drawable drawable4 = getResources().getDrawable(R.drawable.bg_top_4);
        topPagerList.add(new TopPagerBean(drawable1, "春"));
        topPagerList.add(new TopPagerBean(drawable2, "夏"));
        topPagerList.add(new TopPagerBean(drawable3, "秋"));
        topPagerList.add(new TopPagerBean(drawable4, "冬"));

        bottomPagerList = new ArrayList<>();
        bottomPagerList.add(R.layout.bottom_pager_list1);
        bottomPagerList.add(R.layout.bottom_pager_list2);
        bottomPagerList.add(R.layout.bottom_pager_list3);
        bottomPagerList.add(R.layout.bottom_pager_list4);
    }
}
