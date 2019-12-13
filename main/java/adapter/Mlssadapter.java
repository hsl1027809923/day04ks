package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.dsxm.R;

import java.util.List;

import bean.HomeBean;
import contract.MyGlide;

/*
 *@auther:郝世龙
 *@Date: 2019-12-10
 *@Time:20:44
 *@Description:${DESCRIPTION}
 **/public class Mlssadapter extends RecyclerView.Adapter<Mlssadapter.OnewAdapter> {
    List<HomeBean.ResultBean.MlssBean.CommodityListBeanXX> list;
    Context context;

    public Mlssadapter(List<HomeBean.ResultBean.MlssBean.CommodityListBeanXX> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public OnewAdapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.rxxp_z_page,null);
        return new OnewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OnewAdapter onewAdapter, int i) {
        onewAdapter.aadapter_texta.setText(list.get(i).getCommodityName()+"");
        onewAdapter.aadapter_textb.setText(list.get(i).getPrice()+"");
        MyGlide.getGlide(context,list.get(i).getMasterPic(),onewAdapter.aadapter_img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class OnewAdapter extends RecyclerView.ViewHolder {
        private ImageView aadapter_img;
        private TextView aadapter_texta,aadapter_textb;
        public OnewAdapter(@NonNull View itemView) {
            super(itemView);
            aadapter_img=itemView.findViewById(R.id.aadapter_img);
            aadapter_texta=itemView.findViewById(R.id.aadapter_texta);
            aadapter_textb=itemView.findViewById(R.id.aadapter_textb);

        }
    }
}
