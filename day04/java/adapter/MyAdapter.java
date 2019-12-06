package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.haoshilong.R;
import com.bumptech.glide.Glide;

import java.util.List;

import bean.Shop;

/*
 *@auther:郝世龙
 *@Date: 2019-12-03
 *@Time:11:12
 *@Description:${DESCRIPTION}
 **/public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    List<Shop.ResultBean.RxxpBean.CommodityListBean> list;
    Context context;

    public MyAdapter(List<Shop.ResultBean.RxxpBean.CommodityListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        holder.textView1.setText(list.get(i).getCommodityName()+"");
        holder.textView2.setText(list.get(i).getCommodityId()+"");
        holder.textView3.setText(list.get(i).getPrice()+"");
        holder.textView4.setText(list.get(i).getSaleNum()+"");
        Glide.with(context).load(list.get(i).getMasterPic()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        public Holder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.item_img1);
            textView1=itemView.findViewById(R.id.item_text1);
            textView2=itemView.findViewById(R.id.item_text2);
            textView3=itemView.findViewById(R.id.item_text3);
            textView4=itemView.findViewById(R.id.item_text4);

        }
    }
}
