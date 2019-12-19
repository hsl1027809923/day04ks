package com.bawei.haoshilong;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adapter.MyOrderAdapter;
import base.BaseActivity;
import base.BasePresenter;
import bean.OrderBean;
import presenter.MyPresenter;
import url.MyUrl;

public class Order_Activity extends BaseActivity implements View.OnClickListener {


    private MyPresenter myPresenter;
    private ImageView order_img;
    private TextView order_name;
    private TextView order_text1;
    private TextView order_text2;
    private TextView order_text3;
    private TextView order_text4;
    private TextView order_text5;
    private RecyclerView order_review;
    private Map<String,Object> map=new HashMap<>();
    private List<OrderBean.OrderListBean> list=new ArrayList<>();
    private MyOrderAdapter adapter;
    private List<OrderBean.OrderListBean> orderList;

    @Override
    protected int initLayout() {
        return R.layout.activity_order_;
    }

    @Override
    protected void initView() {
        SharedPreferences hslda = getSharedPreferences("hsldg", MODE_PRIVATE);
        String headPic = hslda.getString("headPic", "");
        String phone = hslda.getString("phone1", "");
        Log.e("hslphone",phone);
        Log.e("hslheadPic",headPic);
        order_img=findViewById(R.id.order_img);
        Glide.with(this)
                .load(headPic)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(order_img);
        order_name=findViewById(R.id.order_name);
        order_name.setText(phone);
        order_text1=findViewById(R.id.order_text1);
        order_text2=findViewById(R.id.order_text2);
        order_text3=findViewById(R.id.order_text3);
        order_text4=findViewById(R.id.order_text4);
        order_text5=findViewById(R.id.order_text5);
        order_review=findViewById(R.id.order_review);
        //布局管理器
        order_review.setLayoutManager(new LinearLayoutManager(this));


        order_text1.setOnClickListener(this);
        order_text2.setOnClickListener(this);
        order_text3.setOnClickListener(this);
        order_text4.setOnClickListener(this);
        order_text5.setOnClickListener(this);

    }

    @Override
    protected BasePresenter initPresenter() {
        myPresenter = new MyPresenter();
        return myPresenter;
    }

    @Override
    protected void initData() {
        adapter = new MyOrderAdapter(list,this);
        order_review.setAdapter(adapter);
        map.put("status",0);
        map.put("page",1);
        map.put("count",10);
        myPresenter.GetHave(MyUrl.ORDER,OrderBean.class,map);
    }

    @Override
    public void onsuccess(Object o) {
        if (o instanceof OrderBean){
            orderList = ((OrderBean) o).getOrderList();
            Log.e("hslorder",((OrderBean) o).getOrderList().toString());
            list.addAll(orderList);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onerror(String er) {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.order_text1:
                list.clear();
                list.addAll(orderList);
                adapter.notifyDataSetChanged();
                break;
            case R.id.order_text2:
                list.clear();
                for (int i = 0; i < orderList.size(); i++) {
                    if (orderList.get(i).getOrderStatus()==1){
                        list.add(orderList.get(i));
                        adapter.notifyDataSetChanged();
                    }
                }
                break;
            case R.id.order_text3:
                list.clear();
                for (int i = 0; i < orderList.size(); i++) {
                    if (orderList.get(i).getOrderStatus()==2){
                        list.add(orderList.get(i));
                        adapter.notifyDataSetChanged();
                    }
                }
                break;
            case R.id.order_text4:
                list.clear();
                for (int i = 0; i < orderList.size(); i++) {
                    List<OrderBean.OrderListBean.DetailListBean> olist=new ArrayList<>();
                    for (int j = 0; j < orderList.get(i).getDetailList().size(); j++) {
                        if (orderList.get(i).getDetailList().get(j).getCommentStatus()==1){
                            olist.add(orderList.get(i).getDetailList().get(j));
                        }
                        orderList.get(i).setDetailList(olist);
                        list.addAll(orderList);
                    }


                }
                break;
            case R.id.order_text5:

                break;
        }
    }
}
