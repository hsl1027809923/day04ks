package contract;

/*
 *@auther:郝世龙
 *@Date: 2019-12-18
 *@Time:14:15
 *@Description:${DESCRIPTION}
 **/
public interface Icontract {
    //MCallBack
    public interface MCallBack<T>{
        void onSuccess(T t);
        void onError(String er);
    }
    //M层
    public interface IModel{
        //二级类目
        void doGetInfo(String url,Class cls,MCallBack callBack);

    }
    //V层
    public interface IView<T>{
        void onSuccess(T t);
        void onError(String er);
    }
    //P层
    public interface IPresenter{
        void GetInfo(String url,Class cls);
    }
}
