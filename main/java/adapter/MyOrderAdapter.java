package adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.haoshilong.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import bean.OrderBean;

/*
 *@auther:郝世龙
 *@Date: 2019-12-16
 *@Time:11:06
 *@Description:${DESCRIPTION}
 **/public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.Holder> {
    private List<OrderBean.OrderListBean> listBeans;
    private Context context;

    public MyOrderAdapter(List<OrderBean.OrderListBean> listBeans, Context context) {
        this.listBeans = listBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.order_z_layout, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.textView.setText(listBeans.get(position).getOrderId() + "");

        OrderHolderA orderHolderA = new OrderHolderA(listBeans.get(position).getDetailList(), context);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.recyclerView.setAdapter(orderHolderA);
        if (listBeans.get(position).getOrderStatus()==1){
            if (holder.button1.getVisibility()==View.GONE){
                holder.button1.setVisibility(View.VISIBLE);

            }
            holder.button1.setText("取消订单");
            holder.button2.setText("待付款");
        }
        if (listBeans.get(position).getOrderStatus()==2){
            holder.button1.setVisibility(View.GONE);
            holder.button2.setText("已付款");
        }
        if (listBeans.get(position).getOrderStatus()==2){
            holder.button1.setVisibility(View.GONE);
            holder.button2.setText("待评价");
        }

    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        private TextView textView;
        private RecyclerView recyclerView;
        private Button button1,button2;
        public Holder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.order_z_review);
            textView = itemView.findViewById(R.id.order_z_text);
            button1=itemView.findViewById(R.id.order_z_but1);
            button2=itemView.findViewById(R.id.order_z_but2);
        }
    }





    class OrderHolderA extends RecyclerView.Adapter<OrderHolderA.Hoderaa> {
        private List<OrderBean.OrderListBean.DetailListBean> list;
        private Context context;

        public OrderHolderA(List<OrderBean.OrderListBean.DetailListBean> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @NonNull
        @Override
        public Hoderaa onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = View.inflate(context, R.layout.order_s_layout, null);
            return new Hoderaa(view);
        }

        @Override
        public void onBindViewHolder(@NonNull Hoderaa holder, int position) {
            String[] split = list.get(position).getCommodityPic().split(",");
            for (int i = 0; i < split.length; i++) {
                Glide.with(context).load( split[0]+ "").into(holder.imageViews);
            }

            Log.e("hsoadapr",list.get(position).getCommodityPic() + "");
            holder.textView1s.setText(list.get(position).getCommodityName() + "");
            holder.textView2s.setText(list.get(position).getCommodityPrice() + "");
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class Hoderaa extends RecyclerView.ViewHolder {
            private ImageView imageViews;
            private TextView textView1s, textView2s;
            public Hoderaa(@NonNull View itemView) {
                super(itemView);
                imageViews = itemView.findViewById(R.id.order_s_img);
                textView1s = itemView.findViewById(R.id.order_s_text1);
                textView2s = itemView.findViewById(R.id.order_s_text2);
            }
        }
    }
}
