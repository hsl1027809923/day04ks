package fragment;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.bawei.dsxm.R;
import com.bawei.dsxm.Shipping_address_Activity;

import base.BaseFragment;
import base.BasePresenter;
import presenter.MyPressenter;

/*
 *@auther:郝世龙
 *@Date: 2019-12-10
 *@Time:10:50
 *@Description:${DESCRIPTION}
 **/public class Mine_Fragment extends BaseFragment {

    private MyPressenter myPressenter;
    private LinearLayout mine_shdz;

    @Override
    protected void initData() {

    }

    @Override
    protected void initVeiw(View inflate) {
        mine_shdz = inflate.findViewById(R.id.mine_shdz);
        mine_shdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Shipping_address_Activity.class);
                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    protected BasePresenter initPresenter() {
        myPressenter = new MyPressenter();
        return myPressenter;
    }

    @Override
    protected int initLayout() {
        return R.layout.mine_fragment;
    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onError(String er) {

    }
}
