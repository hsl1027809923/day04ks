package contract;

import java.util.Map;

/*
 *@auther:郝世龙
 *@Date: 2019-12-16
 *@Time:9:45
 *@Description:${契约类}
 **/public interface Icontract {
    //MCallBack
    public interface MCallBack<T>{
        void onSuccess(T t);
        void onError(String er);
    }
    //M层
    public interface IModel{
        //登陆
        void PostHave(String url, Class cls, Map map,MCallBack callBack);
        void GetHave(String url, Class cls, Map map,MCallBack callBack);
    }
    //V层
    public interface IView<T>{
        void onsuccess(T t);
        void onerror(String er);
    }
    //P层
    public interface IPresenter{
        void PostHave(String url, Class cls, Map map);
        void GetHave(String url, Class cls, Map map);
    }
}
