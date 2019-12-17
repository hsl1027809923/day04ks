package com.bawei.dsxm;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import base.BaseActivity;
import base.BasePresenter;
import base.BasePresenter2;
import bean.LoginBean;
import contract.Icontract;
import fragment.Order_Fragment;
import presenter.MyPressenter;
import presenter.MyPressenter2;
import url.MyUrl;

public class LoginActivity extends BaseActivity{
    private EditText login_sj;
    private EditText login_pwd;
    private CheckBox login_check;
    private TextView login_text;
    private Button login_but;
    private MyPressenter2 myPressenter2;

    SharedPreferences sharedPreferences;
    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    //注册点击
    @SuppressLint("CommitPrefEdits")
    @Override
    protected void initData() {
        boolean flag = sharedPreferences.getBoolean("flag", false);
        if (sharedPreferences.getBoolean("flag",false)){
            String phone = sharedPreferences.getString("phone", "111");
            String pwd = sharedPreferences.getString("pwd", "111");
            onRequest(phone,pwd);
        }
        //注册跳转
        login_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(LoginActivity.this,RegisterActivity.class),100);
            }
        });
        //登陆点击
        login_but.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                if (login_check.isChecked()){
                    String  phone = login_sj.getText().toString().trim();
                    String  pwd = login_pwd.getText().toString().trim();
                    edit.putString("phone",phone);
                    edit.putString("pwd",pwd);
                    edit.putBoolean("flag",true);
                    edit.commit();
                }else {
                    edit.clear();
                    edit.putBoolean("flag",false);
                }
                String phone = login_sj.getText().toString().trim();
                String pwd = login_pwd.getText().toString().trim();
                onRequest(phone,pwd);
            }
        });

    }

    private void onRequest(String phone,String pwd) {
        Map<String,Object> map = new HashMap<>();
        map.put("phone",phone);
        map.put("pwd",pwd);
        myPressenter2.PostInfo(MyUrl.LOGIN, LoginBean.class,map);
    }

    @Override
    protected void initView() {
        login_sj = findViewById(R.id.login_sj);
        login_pwd = findViewById(R.id.login_pwd);
        login_check = findViewById(R.id.login_check);
        login_text = findViewById(R.id.login_text);
        login_but = findViewById(R.id.login_but);
        sharedPreferences=getSharedPreferences("AutoLogin",MODE_PRIVATE);
    }

    @Override
    protected BasePresenter2 initPresenter() {
        myPressenter2 = new MyPressenter2();
        return myPressenter2;
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof LoginBean){
            SharedPreferences.Editor edit = sharedPreferences.edit();
            String status = ((LoginBean) o).getStatus();
            Log.e("status",status);
            int userId = ((LoginBean) o).getResult().getUserId();
            String sessionId = ((LoginBean) o).getResult().getSessionId();
            edit.putString("userId",userId+"");
            edit.putString("sessionId",sessionId+"");
            edit.commit();
            if (status.equals("0000")){
                Intent intent=new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }

    @Override
    public void onError(String er) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
