package contract;

import java.util.Map;

import base.BaseActivity;
import base.BasePresenter;

/*
 *@auther:郝世龙
 *@Date: 2019-12-09
 *@Time:9:44
 *@Description:${契约类}
 **/public interface Icontract {
    //M
    interface MCallBack<T>{
        void onSuccess(T t);
        void onError(String er);
    }
    //M
    interface IModel{
        void doGet(String url, Class cls, MCallBack callBack);
        void doPost(String url, Class cls, Map<String,Object> map, MCallBack callBack);
    }
    //IV
    interface IView<T>{
        void onSuccess(T t);
        void onError(String er);
    }
    interface IPresent{
        void getInfo(String url, Class cls);
        void PostInfo(String url, Class cls,Map<String,Object> map);
    }
}
