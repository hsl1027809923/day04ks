package com.bawei.haoshilong;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import adapter.MyFragmentAdapter;
import base.BaseActivity;
import base.BasePresenter;
import bean.Shop;
import butterknife.BindView;
import cotract.Icontract;
import fragment.FourFragment;
import fragment.OneFragment;
import fragment.ThreeFragment;
import fragment.TwoFragment;
import presenter.MyPresenter;

/*
 *@auther:郝世龙
 *@Date: 2019-12-03
 *@Time:9:19
 *@Description:${滑动页面}
 **/
public class MainActivity extends BaseActivity implements Icontract.IView {


    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    //集合
    List<String> slist=new ArrayList<>();
    List<Fragment> flist=new ArrayList<>();
    OneFragment oneFragment;
    TwoFragment twoFragment;
    ThreeFragment threeFragment;
    FourFragment fourFragment;
    TabLayout.Tab one,two,three,four;
    private Shop shop1;
    private MyPresenter myPresenter;

    @Override
    protected void initData() {
        //添加数据
        slist.add("付款码");
        slist.add("收款码");
        slist.add("扫一扫");
        slist.add("卡管理");

        oneFragment=new OneFragment();
        twoFragment=new TwoFragment();
        threeFragment=new ThreeFragment();
        fourFragment=new FourFragment();
        Bundle bund=new Bundle();
        bund.putString("shop", String.valueOf(shop1));
        fourFragment.setArguments(bund);
        //添加
        flist.add(oneFragment);
        flist.add(twoFragment);
        flist.add(threeFragment);
        flist.add(fourFragment);
        //适配器
        MyFragmentAdapter adapter=new MyFragmentAdapter(getSupportFragmentManager(),slist,flist);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        one=tabLayout.getTabAt(0);
        two=tabLayout.getTabAt(1);
        three=tabLayout.getTabAt(2);
        four=tabLayout.getTabAt(3);
        one.setIcon(R.mipmap.fk);
        two.setIcon(R.mipmap.sk);
        three.setIcon(R.mipmap.sys);
        four.setIcon(R.mipmap.kgl);
        //接口
        myPresenter.success("http://172.17.8.100/small/commodity/v1/commodityList");
    }



    @Override
    protected void initView() {

    }

    @Override
    protected int Layout() {
        //视图
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter Payout() {
        myPresenter = new MyPresenter();
        return myPresenter;
    }

    @Override
    public void success(String shop) {
        Log.e("shop",shop);
        if (shop!=null){
            Bundle bund=new Bundle();
            bund.putString("shop",shop);
            fourFragment.setArguments(bund);
        }
    }
}
