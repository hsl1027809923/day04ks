package com.bawei.haoshilong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
/*
 *@auther:郝世龙
 *@Date: 2019-12-16
 *@Time:9:37
 *@Description:${主页面跳转登陆}
 **/
public class MainActivity extends AppCompatActivity {

    private TextView main_text_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //点击登陆
        main_text_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Login_Activity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        main_text_login = (TextView) findViewById(R.id.main_text_login);
    }
}
