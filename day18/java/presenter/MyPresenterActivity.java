package presenter;

import base.BasePresenterActivity;
import base.BasePresenterFragment;
import contract.Icontract;
import model.MyModel;

/*
 *@auther:郝世龙
 *@Date: 2019-12-18
 *@Time:14:41
 *@Description:${DESCRIPTION}
 **/public class MyPresenterActivity extends BasePresenterActivity implements Icontract.IPresenter {
    MyModel myModel;
    //二级类目
    @Override
    public void GetInfo(String url, Class cls) {

    }

    @Override
    public void GetInfoCar(String url, Class cls) {

    }

}
