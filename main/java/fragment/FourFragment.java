package fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.haoshilong.R;
import com.google.gson.Gson;

import adapter.MyAdapter;
import bean.Shop;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import presenter.MyPresenter;

/*1、	在昨天的基础上引入GreenDao库（20分）
 *@auther:郝世龙
 *@Date: 2019-12-03
 *@Time:9:19
 *@Description:${DESCRIPTION}
 **/public class FourFragment extends Fragment{
    @BindView(R.id.recycl_view)
    RecyclerView recyclView;
    Unbinder unbinder;
    private View mview;
    private MyPresenter myPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mview = inflater.inflate(R.layout.four_layout, null);
        unbinder = ButterKnife.bind(this, mview);
        return mview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String shop = getArguments().getString("shop");
        Log.e("shopfour",shop);

        //解析
        Gson gson=new Gson();
        Shop shop1 = gson.fromJson(shop, Shop.class);
        MyAdapter adapter=new MyAdapter(shop1.getResult().getRxxp().getCommodityList(),getContext());
        recyclView.setAdapter(adapter);
        //设置数据
        initData();
    }

    private void initData() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclView.setLayoutManager(manager);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
