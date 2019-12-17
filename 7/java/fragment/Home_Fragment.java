package fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import com.bawei.dsxm.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import adapter.Home_Adapter;
import base.BaseFragment;
import base.BasePresenter;
import bean.HomeBean;
import bean.Home_Bannerbean;
import okhttp3.OkHttpClient;
import presenter.MyPressenter;
import url.MyUrl;
import util.HttpUtil;

/*
 *@auther:郝世龙
 *@Date: 2019-12-10
 *@Time:10:43
 *@Description:${DESCRIPTION}
 **/public class Home_Fragment extends BaseFragment {

    private MyPressenter myPressenter;
    private XRecyclerView xRecyclerView;

    private List<Home_Bannerbean.ResultBean> blist = new ArrayList<>();
    private Home_Adapter adapter;
    int curr;

    private HomeBean.ResultBean result;


    @Override
    protected void initData() {
        myPressenter.getInfo(MyUrl.SY, HomeBean.class);
        myPressenter.getInfo(MyUrl.BN, Home_Bannerbean.class);
        adapter = new Home_Adapter(result, getContext(), blist);
        xRecyclerView.setAdapter(adapter);
        //上拉刷新 下拉加载
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                curr = 0;

                myPressenter.getInfo(MyUrl.SY, HomeBean.class);
                xRecyclerView.refreshComplete();

            }

            @Override
            public void onLoadMore() {
                curr++;
                myPressenter.getInfo(MyUrl.SY, HomeBean.class);
                xRecyclerView.refreshComplete();
            }
        });
    }

    //初始化控件
    @Override
    protected void initVeiw(View inflate) {
        //xRecyclerView
        xRecyclerView = inflate.findViewById(R.id.xrecycl_view);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(manager);
    }

    @Override
    protected BasePresenter initPresenter() {
        myPressenter = new MyPressenter();
        return myPressenter;
    }

    @Override
    protected int initLayout() {
        return R.layout.home_fragment;
    }

    //请求成功
    @Override
    public void onSuccess(Object o) {
        if (o instanceof HomeBean) {
                result = ((HomeBean) o).getResult();
        }
        if (o instanceof Home_Bannerbean) {
            blist.addAll(((Home_Bannerbean) o).getResult());
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String er) {

    }

}
