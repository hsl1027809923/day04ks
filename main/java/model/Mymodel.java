package model;

import cotract.Icontract;
import util.OKHttpUtil;
import util.VolleyUtil;

/*
 *@auther:郝世龙
 *@Date: 2019-12-03
 *@Time:10:26
 *@Description:${DESCRIPTION}
 **/public class Mymodel {
    public void TO(String url, Icontract.CallBack callBack){
//        VolleyUtil.getInstance().ToGet(url, callBack);
        OKHttpUtil.getInstance().asynGet(url,callBack);
    }
}
