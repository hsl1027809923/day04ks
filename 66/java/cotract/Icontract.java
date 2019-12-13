package cotract;

import bean.Shop;

/*
 *@auther:郝世龙
 *@Date: 2019-12-03
 *@Time:10:22
 *@Description:${DESCRIPTION}
 **/public interface Icontract {

    //Iv
    public interface IView{
        void success(String json);
    }
    //IP
    public interface IPresenter{
        void success(String url);
    }
    //CallBack
    public interface CallBack{
        void success(String json);
        void error(String er);
    }
}
