package fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.shoppingcarlx.R;

import java.util.ArrayList;
import java.util.List;

import adapter.Home_f_Adapter;
import adapter.Home_z_Adapter;
import base.BaseFragment;
import base.BasePresenterFragment;
import bean.HomeBean;
import presenter.MyPresenter;
import url.MyUrl;

/*
 *@auther:郝世龙
 *@Date: 2019-12-18
 *@Time:15:08
 *@Description:${DESCRIPTION}
 **/public class Home_fragment extends BaseFragment {
    private RecyclerView home_recyclerview1;
    private RecyclerView home_recyclerview2;
    private MyPresenter myPresenter;
    private List<HomeBean.ResultBean> rlist=new ArrayList<>();
    private List<HomeBean.ResultBean.SecondCategoryVoBean> slist=new ArrayList<>();
    private Home_f_Adapter home_f_adapter;
    private Home_z_Adapter home_z_adapter;

    @Override
    protected void initView(View inflate) {
        home_recyclerview1=inflate.findViewById(R.id.home_recyclerview1);
        home_recyclerview1.setLayoutManager(new LinearLayoutManager(getContext()));
        home_recyclerview2=inflate.findViewById(R.id.home_recyclerview2);
        home_recyclerview2.setLayoutManager(new GridLayoutManager(getContext(),2));
    }

    @Override
    protected int initLayot() {
        return R.layout.home_layout;
    }

    @Override
    protected BasePresenterFragment initPresenter() {
        myPresenter = new MyPresenter();
        return myPresenter;
    }

    @Override
    protected void initData() {
        myPresenter.GetInfo(MyUrl.ERJILM,HomeBean.class);
        home_f_adapter = new Home_f_Adapter(rlist,getActivity());

        home_recyclerview1.setAdapter(home_f_adapter);
        home_z_adapter = new Home_z_Adapter(slist,getActivity());
        home_recyclerview2.setAdapter(home_z_adapter);

//        slist.addAll(rlist.get(0).getSecondCategoryVo());
        home_f_adapter.setCallBack(new Home_f_Adapter.CallBack() {
            @Override
            public void setCall(int i) {
                home_f_adapter.setColorposition(i);
                slist.clear();
                slist.addAll(rlist.get(i).getSecondCategoryVo());
                home_z_adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof HomeBean){
            Log.e("hsl'",((HomeBean) o).getResult().toString());
            rlist.addAll(((HomeBean) o).getResult());
            home_f_adapter.notifyDataSetChanged();
            slist.addAll(((HomeBean) o).getResult().get(0).getSecondCategoryVo());

            home_z_adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onError(String er) {

    }
}
