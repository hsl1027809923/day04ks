package fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.dimensionsofelectricity.R;

import bean.Shop;

/*
 *@auther:郝世龙
 *@Date: 2019-12-04
 *@Time:14:05
 *@Description:${DESCRIPTION}
 **/public class Shopping_trolley_fragment extends Fragment {
    private View mview;
    private Shop.ResultBean result;
    private RecyclerView reclHome;

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EventBus.getDefault().register(this);
//
//
//    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mview=inflater.inflate(R.layout.three_layout,null);
//        reclHome = mview.findViewById(R.id.recl_shop);
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        reclHome.setLayoutManager(linearLayoutManager);
        return mview;
    }


//    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
//    public void getInfo(String message) {
//        String json=message;
//        Gson gson = new Gson();
//        Shop shop = gson.fromJson(json, Shop.class);
//        result = shop.getResult();
//        MyAdapter adapter = new MyAdapter(result.getRxxp().getCommodityList(), getContext());
//        reclHome.setAdapter(adapter);
//    }

//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        if (EventBus.getDefault().isRegistered(true)){
//            EventBus.getDefault().unregister(this);
//        }
//    }
}
