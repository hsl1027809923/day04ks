package fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.bawei.dsxm.R;

import base.BaseFragment;
import base.BasePresenter;
import presenter.MyPressenter;

/*
 *@auther:郝世龙
 *@Date: 2019-12-10
 *@Time:10:50
 *@Description:${DESCRIPTION}
 **/public class Order_Fragment extends BaseFragment {

    private MyPressenter myPressenter;
    private Button order_all;
    private Button order_obligation;
    private Button order_sh;
    private Button order_pj;
    private Button order_ok;
//    SharedPreferences sharedPreferences;
//    String userId = sharedPreferences.getString("userId", "");
//    String sessionId = sharedPreferences.getString("sessionId", "");

    @Override
    protected void initData() {
//        Log.e("userIdhsl",userId);
//        Log.e("sessionIdhsl",sessionId);

        //全部订单
        order_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //待付款
        order_obligation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //待收货
        order_sh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //待评价
        order_pj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //已完成
        order_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void initVeiw(View inflate) {
        order_all=inflate.findViewById(R.id.order_all);
        order_obligation=inflate.findViewById(R.id.order_obligation);
        order_sh=inflate.findViewById(R.id.order_sh);
        order_pj=inflate.findViewById(R.id.order_pj);
        order_ok=inflate.findViewById(R.id.order_ok);
    }

    @Override
    protected BasePresenter initPresenter() {
        myPressenter = new MyPressenter();
        return myPressenter;
    }

    @Override
    protected int initLayout() {
        return R.layout.order_fragment;
    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onError(String er) {

    }


}
