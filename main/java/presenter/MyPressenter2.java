package presenter;

import android.util.Log;

import java.util.Map;

import base.BasePresenter;
import base.BasePresenter2;
import contract.Icontract;
import model.MyModel;

/*
 *@auther:郝世龙
 *@Date: 2019-12-09
 *@Time:9:52
 *@Description:${DESCRIPTION}
 **/public class MyPressenter2 extends BasePresenter2 {
    MyModel model;

    @Override
    public void getInfo(String url, Class cls) {

    }
    //登陆
    @Override
    public void PostInfo(String url, Class cls, Map<String, Object> map) {
        model=new MyModel();
        model.doPost(url, cls, map, new Icontract.MCallBack() {
            @Override
            public void onSuccess(Object o) {
                v.onSuccess(o);
            }

            @Override
            public void onError(String er) {
                v.onError(er);
            }
        });
    }
}
