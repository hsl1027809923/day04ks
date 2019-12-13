
package com.bawei.dsxm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Shipping_address_Activity extends AppCompatActivity {
    Button address_xzdz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping_address_);
        initView();
        initData();
    }

    private void initData() {
        address_xzdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Shipping_address_Activity.this,Site_Activity.class);
                startActivity(intent);
            }
        });
    }
    //初始化控件
    private void initView() {
        address_xzdz=findViewById(R.id.address_xzdz);
    }
}
