package com.bawei.haoshilong;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import base.BaseActivity;
import base.BasePresenter;
import bean.LoginBean;
import presenter.MyPresenter;
import url.MyUrl;

/*
 *@auther:郝世龙
 *@Date: 2019-12-16
 *@Time:9:37
 *@Description:${登陆页面}
 **/
public class Login_Activity extends BaseActivity {

    private EditText login_phone;
    private EditText login_pwd;
    private Button login_but;
    private SharedPreferences hsldg;
    private MyPresenter myPresenter;
    private Map<String,Object> map=new HashMap<>();
    String zz="/^[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,8,9]))[0-9]{8}$/";

    //布局
    @Override
    protected int initLayout() {
        return R.layout.activity_login_;
    }
    //初始化控件
    @Override
    protected void initView() {
        hsldg = getSharedPreferences("hsldg", MODE_PRIVATE);
        login_phone=findViewById(R.id.login_phone);
        login_pwd=findViewById(R.id.login_pwd);
        login_but=findViewById(R.id.login_but);
    }
    //实例化p
    @Override
    protected BasePresenter initPresenter() {
        myPresenter = new MyPresenter();
        return myPresenter;
    }
    //设置数据
    @Override
    protected void initData() {
        login_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = login_phone.getText().toString().trim();
                String pwd = login_pwd.getText().toString().trim();
                boolean matches = zz.matches(phone);
                Log.e("hslzz",matches+"");
                map.put("phone",phone);
                map.put("pwd",pwd);
                myPresenter.PostHave(MyUrl.LOGIN,LoginBean.class,map);
            }
        });
    }

    @Override   //成功方法
    public void onsuccess(Object o) {
        if (o instanceof LoginBean){
            SharedPreferences.Editor edit = hsldg.edit();
            int userId = ((LoginBean) o).getResult().getUserId();
            String sessionId = ((LoginBean) o).getResult().getSessionId();
            String headPic = ((LoginBean) o).getResult().getHeadPic();
            String phone = ((LoginBean) o).getResult().getPhone();
            edit.putString("userId",userId+"");
            edit.putString("sessionId",sessionId+"");
            edit.putString("headPic",headPic+"");
            edit.putString("phone1",phone+"");
            edit.commit();
            //判断是否成功
            if (((LoginBean) o).getStatus().equals("0000")){
                    //跳转
                Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Login_Activity.this,Order_Activity.class);
                startActivity(intent);
            }else {
                //i.	在登录页面用户可以收入手机号和密码，点击登录按钮调用登录接口，登录成功，展示用户订单，登录失败吐司提示。
                Toast.makeText(this, "登陆失败", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onerror(String er) {

    }
}
