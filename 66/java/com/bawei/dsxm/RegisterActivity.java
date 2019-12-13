package com.bawei.dsxm;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import base.BaseActivity;
import base.BasePresenter2;
import bean.HomeBean;
import bean.LoginBean;
import bean.RegisBean;
import presenter.MyPressenter2;
import url.MyUrl;

public class RegisterActivity extends BaseActivity {

    private MyPressenter2 myPressenter2;
    Map<String, Object> map = new HashMap<>();
    private EditText regis_sj;
    private EditText regis_pwd;
    private Button regis_but;

    @Override
    protected int initLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void initData() {
        regis_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = regis_sj.getText().toString().trim();
                String pwd = regis_pwd.getText().toString().trim();
                onRequest(phone,pwd);

            }
        });
    }
    private void onRequest(String phone,String pwd) {
        Map<String,Object> map = new HashMap<>();
        map.put("phone",phone);
        map.put("pwd",pwd);
        myPressenter2.PostInfo(MyUrl.ZHUCE, RegisBean.class,map);
    }
    @Override
    protected void initView() {
        regis_sj=findViewById(R.id.regis_sj);
        regis_pwd=findViewById(R.id.regis_pwd);
        regis_but=findViewById(R.id.regis_but);
    }

    @Override
    protected BasePresenter2 initPresenter() {
        myPressenter2 = new MyPressenter2();
        return myPressenter2;
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof RegisBean){
            if (((RegisBean) o).getStatus().equals("0000")){
                Log.i("hsl", "onSuccess: "+(((RegisBean) o).getStatus()));
                Intent data = new Intent(RegisterActivity.this, LoginActivity.class);
                data.putExtra("phone",regis_sj.getText().toString().trim());
                data.putExtra("pwd",regis_pwd.getText().toString().trim());
                setResult(100, data);
                finish();
            }
            Toast.makeText(this, ((RegisBean) o).getMessage(), Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onError(String er) {

    }

}
