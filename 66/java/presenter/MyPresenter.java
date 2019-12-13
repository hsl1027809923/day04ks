package presenter;

import android.util.Log;

import com.bawei.haoshilong.MainActivity;
import com.google.gson.Gson;

import base.BasePresenter;
import bean.Shop;
import cotract.Icontract;
import fragment.FourFragment;
import model.Mymodel;

/*
 *@auther:郝世龙
 *@Date: 2019-12-03
 *@Time:10:22
 *@Description:${DESCRIPTION}
 **/public class MyPresenter extends BasePresenter implements Icontract.IPresenter {
    Mymodel mymodel;

    public MyPresenter() {
        mymodel=new Mymodel();
    }

    @Override
    public void success(String url) {
        mymodel.TO(url, new Icontract.CallBack() {
            @Override
            public void success(String json) {
                MainActivity activity= (MainActivity) v;
                activity.success(json);
                Log.e("json",json);
            }

            @Override
            public void error(String er) {

            }
        });
    }
}
