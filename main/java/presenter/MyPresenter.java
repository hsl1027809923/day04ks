package presenter;

import base.BasePresenterFragment;
import contract.Icontract;
import model.MyModel;

/*
 *@auther:郝世龙
 *@Date: 2019-12-18
 *@Time:14:41
 *@Description:${DESCRIPTION}
 **/public class MyPresenter extends BasePresenterFragment implements Icontract.IPresenter {
    MyModel myModel;
    //二级类目
    @Override
    public void GetInfo(String url, Class cls) {
        myModel=new MyModel();
        myModel.doGetInfo(url, cls, new Icontract.MCallBack() {
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
