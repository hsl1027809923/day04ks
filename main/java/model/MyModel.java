package model;

import java.util.Map;

import contract.Icontract;
import util.HttpUtil;

/*
 *@auther:郝世龙
 *@Date: 2019-12-16
 *@Time:9:50
 *@Description:${M层}
 **/public class MyModel implements Icontract.IModel {
    //登陆
    @Override
    public void PostHave(String url, Class cls, Map map, final Icontract.MCallBack callBack) {
        HttpUtil.getInstance().PostHaveDL(url, map, cls, new HttpUtil.HCallBack() {
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
    //订单
    @Override
    public void GetHave(String url, Class cls, Map map, final Icontract.MCallBack callBack) {
        HttpUtil.getInstance().GetHaveorder(url, map, cls, new HttpUtil.HCallBack() {
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
