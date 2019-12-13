package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.dsxm.R;

import java.util.List;

import bean.Home_Bannerbean;
import contract.MyGlide;

/*
 *@auther:郝世龙
 *@Date: 2019-12-10
 *@Time:20:44
 *@Description:${DESCRIPTION}
 **/public class Banneradapter extends RecyclerView.Adapter<Banneradapter.OnewAdapter> {
    List<Home_Bannerbean.ResultBean> list;
    Context context;

    public Banneradapter(List<Home_Bannerbean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public OnewAdapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.banner_z_page,null);
        return new OnewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OnewAdapter onewAdapter, int i) {
        MyGlide.getGlide(context,list.get(i).getImageUrl(),onewAdapter.banner_img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class OnewAdapter extends RecyclerView.ViewHolder {
        private ImageView banner_img;
        public OnewAdapter(@NonNull View itemView) {
            super(itemView);
            banner_img=itemView.findViewById(R.id.banner_img);
        }
    }
}
