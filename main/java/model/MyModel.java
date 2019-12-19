package model;

import contract.Icontract;
import util.MyUtil;

/*
 *@auther:郝世龙
 *@Date: 2019-12-18
 *@Time:14:41
 *@Description:${DESCRIPTION}
 **/public class MyModel implements Icontract.IModel {
    //二级类目
    @Override
    public void doGetInfo(String url, Class cls, final Icontract.MCallBack callBack) {
        MyUtil.getInstance().GetInfo(url, cls, new MyUtil.HCallBack() {
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
