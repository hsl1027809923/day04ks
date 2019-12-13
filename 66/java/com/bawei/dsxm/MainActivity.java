package com.bawei.dsxm;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import fragment.Core_Fragment;
import fragment.Home_Fragment;
import fragment.Mine_Fragment;
import fragment.Order_Fragment;
import fragment.Shopping_Fragment;

public class MainActivity extends AppCompatActivity {
    List<Fragment> list = new ArrayList<>();
    private ViewPager view_pager;
    private TabLayout tab_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        initView();
        //设置数据
        initData();
    }

    private void initData() {
        list.add(new Home_Fragment());
        list.add(new Core_Fragment());
        list.add(new Shopping_Fragment());
        list.add(new Order_Fragment());
        list.add(new Mine_Fragment());
        view_pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }

        });
        tab_layout.setupWithViewPager(view_pager);
        TabLayout.Tab tabAt1 = tab_layout.getTabAt(0);
        TabLayout.Tab tabAt2 = tab_layout.getTabAt(1);
        TabLayout.Tab tabAt3 = tab_layout.getTabAt(2);
        TabLayout.Tab tabAt4 = tab_layout.getTabAt(3);
        TabLayout.Tab tabAt5 = tab_layout.getTabAt(4);
        tabAt1.setIcon(R.drawable.one);
        tabAt2.setIcon(R.drawable.two);
        tabAt3.setIcon(R.drawable.three);
        tabAt4.setIcon(R.drawable.four);
        tabAt5.setIcon(R.drawable.five);

    }

    private void initView() {
        view_pager = (ViewPager) findViewById(R.id.view_pager);

        tab_layout = (TabLayout) findViewById(R.id.tab_layout);
    }
}
