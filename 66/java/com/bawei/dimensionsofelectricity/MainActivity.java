package com.bawei.dimensionsofelectricity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import adapter.MyFragmentAdapter;
import base.BaseActivity;
import base.BasePresenter;
import butterknife.BindView;
import cotract.Icontract;
import fragment.Circle_fragment;
import fragment.Home_page_fragment;
import fragment.My_fragment;
import fragment.Order_form_fragment;
import fragment.Shopping_trolley_fragment;
import presenter.MyPresenter;

public class MainActivity extends BaseActivity implements Icontract.IView {


    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.text_main)
    TextView text_main;
    List<Fragment> flist=new ArrayList<>();
    //fragment
    Home_page_fragment home_page_fragment;
    Circle_fragment circle_fragment;
    Shopping_trolley_fragment shopping_trolley_fragment;
    Order_form_fragment order_form_fragment;
    My_fragment my_fragment;
    private TabLayout.Tab one,two,three,four,five;
    private MyPresenter myPresenter;
    private String jsona;

    @Override
    protected void initData() {
        home_page_fragment=new Home_page_fragment();
        circle_fragment=new Circle_fragment();
        shopping_trolley_fragment=new Shopping_trolley_fragment();
        order_form_fragment=new Order_form_fragment();
        my_fragment=new My_fragment();
        flist.add(home_page_fragment);
        flist.add(circle_fragment);
        flist.add(shopping_trolley_fragment);
        flist.add(order_form_fragment);
        flist.add(my_fragment);
        MyFragmentAdapter adapter=new MyFragmentAdapter(getSupportFragmentManager(),flist,this);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        one = tabLayout.getTabAt(0);
        two=tabLayout.getTabAt(1);
        three=tabLayout.getTabAt(2);
        four=tabLayout.getTabAt(3);
        five=tabLayout.getTabAt(4);

        one.setIcon(R.mipmap.ic_launcher);
        two.setIcon(R.mipmap.fk);
        three.setIcon(R.mipmap.kgl);
        four.setIcon(R.mipmap.sk);
        five.setIcon(R.mipmap.sys);
        myPresenter.success("http://172.17.8.100/small/commodity/v1/commodityList");

    }

    @Override
    protected void initView() {
        //if (EventBus.getDefault().isRegistered(this)){
//            EventBus.getDefault().register(this);
        //}

    }

    @Override
    protected int Layout() {
        return R.layout.activity_main;

    }

    @Override
    protected BasePresenter Payout() {
        myPresenter = new MyPresenter();
        return myPresenter;
    }


    @Override
    public void success(String json) {

        jsona = json;
        Log.e("json", jsona);
        EventBus.getDefault().postSticky(jsona);
    }
//    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
//    public void getInfo(String info){
//
//    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注销注册
//        EventBus.getDefault().unregister(this);

    }

}
