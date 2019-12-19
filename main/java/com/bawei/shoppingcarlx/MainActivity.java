package com.bawei.shoppingcarlx;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import base.BaseActivity;
import base.BasePresenterActivity;
import fragment.Home_fragment;
import fragment.Mine_fragment;

public class MainActivity extends BaseActivity {


    private ViewPager activity_viewPage;
    private TabLayout activity_tab;
    private List<Fragment> list=new ArrayList<>();
    private List<String> slist=new ArrayList<>();

    @Override
    protected int initLayout() {
        return R.layout.activity_main;

    }

    @Override
    protected BasePresenterActivity initPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        activity_viewPage=findViewById(R.id.activity_viewPage);
        activity_tab=findViewById(R.id.activity_tab);
    }

    @Override
    protected void initData() {
        Home_fragment home_fragment=new Home_fragment();
        Mine_fragment mine_fragment=new Mine_fragment();
        list.add(home_fragment);
        list.add(mine_fragment);
        slist.add("首页");
        slist.add("我的");
        activity_viewPage.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return slist.get(position);
            }
        });
        activity_tab.setupWithViewPager(activity_viewPage);

    }


    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onError(String er) {

    }
}
