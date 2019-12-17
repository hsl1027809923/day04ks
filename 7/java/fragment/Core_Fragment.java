package fragment;

import android.view.View;

import com.bawei.dsxm.R;

import base.BaseFragment;
import base.BasePresenter;
import presenter.MyPressenter;

/*
 *@auther:郝世龙
 *@Date: 2019-12-10
 *@Time:10:50
 *@Description:${DESCRIPTION}
 **/public class Core_Fragment extends BaseFragment {

    private MyPressenter myPressenter;

    @Override
    protected void initData() {

    }

    @Override
    protected void initVeiw(View inflate) {

    }

    @Override
    protected BasePresenter initPresenter() {
        myPressenter = new MyPressenter();
        return myPressenter;
    }

    @Override
    protected int initLayout() {
        return R.layout.core_fragment;
    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onError(String er) {

    }
}
