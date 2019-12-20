package fragment;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.bawei.shoppingcarlx.R;

import java.util.ArrayList;
import java.util.List;

import adapter.Car_ExpandAdapter;
import base.BaseFragment;
import base.BasePresenterFragment;
import bean.CarBean;
import presenter.MyPresenterFragment;
import url.MyUrl;

/*
 *@auther:郝世龙
 *@Date: 2019-12-18
 *@Time:19:40
 *@Description:${购物车}
 **/public class Mine_fragment extends BaseFragment {

    private ExpandableListView car_expand;
    private MyPresenterFragment myPresenterFragment;
    private List<CarBean.ResultBean> list = new ArrayList<>();
    private Car_ExpandAdapter car_expandAdapter;
    private CheckBox All_check;
    private TextView All_Price;
    private TextView All_Count;

    @Override
    protected void initView(View inflate) {
        car_expand = inflate.findViewById(R.id.car_expand);
        All_check = inflate.findViewById(R.id.All_check);
        All_Price = inflate.findViewById(R.id.All_Price);
        All_Count = inflate.findViewById(R.id.All_Count);
    }

    @Override
    protected int initLayot() {
        return R.layout.mine_layout;
    }

    @Override
    protected BasePresenterFragment initPresenter() {
        myPresenterFragment = new MyPresenterFragment();
        return myPresenterFragment;
    }

    @Override
    protected void initData() {
        //适配器
        car_expandAdapter = new Car_ExpandAdapter(list, getContext());
        car_expand.setAdapter(car_expandAdapter);

        //请求
        myPresenterFragment.GetInfoCar(MyUrl.SHOPPINGCAR, CarBean.class);
        car_expandAdapter.setCallBack(new Car_ExpandAdapter.ShoppingCallBack() {
            @Override
            public void bigCheck(int bigIndex) {
                boolean b = car_expandAdapter.setisCheck(bigIndex);
                car_expandAdapter.setBigCheck(bigIndex,!b);
                car_expandAdapter.notifyDataSetChanged();
            }

            @Override
            public void smallCheck(int bigIndex, int smallIndex) {
//                boolean statu = list.get(bigIndex).getShoppingCartList().get(smallIndex).isStatu();
//                car_expandAdapter.setSmallCheck(bigIndex,smallIndex,!statu);
//                car_expandAdapter.notifyDataSetChanged();
            }

            @Override
            public void smaalCheckcount(int bigIndex, int smallIndex, int number) {

            }
        });
        All_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                boolean activitAll = car_expandAdapter.isActivitAll();
//                car_expandAdapter.setAllCheck(!activitAll);
//                All_check.setChecked(!activitAll);
//                car_expandAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override//成功
    public void onSuccess(Object o) {
        if (o instanceof CarBean) {
            List<CarBean.ResultBean> result = ((CarBean) o).getResult();
            list.addAll(result);
            Log.e("resulthsl", result.toString());
            car_expandAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onError(String er) {

    }
}
