package presenter;

import java.util.Map;

import base.BasePresenter;
import contract.Icontract;
import model.MyModel;

/*
 *@auther:郝世龙
 *@Date: 2019-12-16
 *@Time:9:44
 *@Description:${P层}
 **/public class MyPresenter extends BasePresenter {
    //实例化model
    MyModel mymodel;
    //登陆
    @Override
    public void PostHave(String url, Class cls, Map map) {
        mymodel=new MyModel();
        mymodel.PostHave(url, cls, map, new Icontract.MCallBack() {
            @Override
            public void onSuccess(Object o) {
                //回调
                v.onsuccess(o);
            }

            @Override
            public void onError(String er) {
                v.onerror(er);
            }
        });
    }
    //订单
    @Override
    public void GetHave(String url, Class cls, Map map) {
        mymodel=new MyModel();
        mymodel.GetHave(url, cls, map, new Icontract.MCallBack() {
            @Override
            public void onSuccess(Object o) {
                v.onsuccess(o);
            }

            @Override
            public void onError(String er) {
                v.onerror(er);
            }
        });
    }
}
