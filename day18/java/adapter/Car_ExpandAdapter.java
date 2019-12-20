package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.shoppingcarlx.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import bean.CarBean;
import okhttp3.Request;
import okhttp3.Response;

/*
 *@auther:郝世龙
 *@Date: 2019-12-19
 *@Time:11:26
 *@Description:${DESCRIPTION}
 **/public class Car_ExpandAdapter extends BaseExpandableListAdapter {
    private List<CarBean.ResultBean> list;
    private Context context;

    public Car_ExpandAdapter(List<CarBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return list.get(groupPosition).getShoppingCartList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        AGroupView agroupView = null;
        if (convertView == null) {
            agroupView = new AGroupView();
            convertView = View.inflate(context, R.layout.car_z_layout, null);
            agroupView.textViewz = convertView.findViewById(R.id.car_z_text);
            agroupView.checkBoxz = convertView.findViewById(R.id.car_z_check);

            convertView.setTag(agroupView);
        } else {
            agroupView = (AGroupView) convertView.getTag();
        }
        agroupView.textViewz.setText(list.get(groupPosition).getCategoryName() + "");
        agroupView.checkBoxz.setChecked(setisCheck(groupPosition));
        //点击
        agroupView.checkBoxz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.bigCheck(groupPosition);
            }
        });

        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        AChildView achildView = null;
        if (convertView == null) {
            achildView = new AChildView();
            convertView = View.inflate(context, R.layout.car_s_layout, null);
            achildView.checkBoxs = convertView.findViewById(R.id.car_s_check);
            achildView.imageViews = convertView.findViewById(R.id.car_s_img);
            achildView.textViews1 = convertView.findViewById(R.id.car_s_text1);
            achildView.textViews2 = convertView.findViewById(R.id.car_s_text2);
            convertView.setTag(achildView);
        } else {
            achildView = (AChildView) convertView.getTag();
        }
        CarBean.ResultBean.ShoppingCartListBean listBean = list.get(groupPosition).getShoppingCartList().get(childPosition);

        achildView.textViews1.setText(listBean.getCommodityName() + "");
        achildView.textViews2.setText(listBean.getPrice() + "");
        Glide.with(context)
                .load(listBean.getPic())
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(achildView.imageViews);
        achildView.checkBoxs.setChecked(listBean.isStatu());
        achildView.checkBoxs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack!=null){
                    callBack.smallCheck(groupPosition,childPosition);
                }
            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class AGroupView {
        private CheckBox checkBoxz;
        private TextView textViewz;
    }

    class AChildView {
        private CheckBox checkBoxs;
        private ImageView imageViews;
        private TextView textViews1, textViews2;
    }

    //接口回调
    public interface ShoppingCallBack {
        //店铺按钮
        void bigCheck(int bigIndex);
        //商品按钮
        void smallCheck(int bigIndex, int smallIndex);
        //商品数量
        void smaalCheckcount(int bigIndex, int smallIndex, int number);
    }
    private ShoppingCallBack callBack;

    public void setCallBack(ShoppingCallBack callBack) {
        this.callBack = callBack;
    }
//-------------------------------------------------@@@@@@@@@@@@@
    //判断商家是否选中
    public boolean setisCheck(int Index) {
        boolean flag = true;
        List<CarBean.ResultBean.ShoppingCartListBean> listBeans
                = list.get(Index).getShoppingCartList();
        for (int i = 0; i < listBeans.size(); i++) {
            if (!listBeans.get(i).isStatu()) {
                flag = false;
                return flag;
            }
        }
        return flag;
    }
    //点击商家的复选框的时候
    public void setBigCheck(int bigIndex,boolean isStatu){
        List<CarBean.ResultBean.ShoppingCartListBean> shoppingCartList = list.get(bigIndex).getShoppingCartList();
        for (int i = 0; i < shoppingCartList.size(); i++) {
            shoppingCartList.get(i).setStatu(isStatu);
        }
    }
    //----------------------------------------------@@@@@@@@@@@@@
    //点击商品让他选中
    public void setSmallCheck(int bigIndex,int smallIndex,boolean isCheck){
        list.get(bigIndex).getShoppingCartList().get(smallIndex).setStatu(isCheck);
    }

    //点击Activity中的全选按钮
    public boolean isActivitAll(){
        boolean All=true;
        for (int i = 0; i < list.size(); i++) {
            List<CarBean.ResultBean.ShoppingCartListBean> shoppingCartList = list.get(i).getShoppingCartList();
            for (int j = 0; j < shoppingCartList.size(); j++) {
                if (!shoppingCartList.get(j).isStatu()){
                    All=false;
                    return All;
                }
            }
        }
        return All;
    }
    //-------------------------------------@@@@@@@@@@@@@@@@@@
    //设置按钮
    public void setAllCheck(boolean isCheck){
        for (int i = 0; i < list.size(); i++) {
            List<CarBean.ResultBean.ShoppingCartListBean> shoppingCartList = list.get(i).getShoppingCartList();
            for (int j = 0; j < shoppingCartList.size(); j++) {
                shoppingCartList.get(j).setStatu(isCheck);
            }
        }
    }


}
