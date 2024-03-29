package model;

import android.util.Log;

import java.util.Map;

import contract.Icontract;
import util.HttpUtil;

/*
 *@auther:郝世龙
 *@Date: 2019-12-09
 *@Time:9:50
 *@Description:${model层}
 **/public class MyModel implements Icontract.IModel {

    @Override
    public void doGet(String url, Class cls, final Icontract.MCallBack callBack) {
        HttpUtil.getInstance().doGet(url, cls, new HttpUtil.HCallBack() {
            @Override
            public void onSuccess(Object o) {
                Log.e("modeloo",o.toString());
                callBack.onSuccess(o);
            }

            @Override
            public void onError(String er) {
                callBack.onError(er);
            }
        });

    }
    //登陆
    @Override
    public void doPost(String url, Class cls, Map<String, Object> map, final Icontract.MCallBack callBack) {
        HttpUtil.getInstance().doPost(url, cls, map, new HttpUtil.HCallBack() {
            @Override
            public void onSuccess(Object o) {
                callBack.onSuccess(o);
            }

            @Override
            public void onError(String er) {
                callBack.onError(er);
            }
        });
    }
}
