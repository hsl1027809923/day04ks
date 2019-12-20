package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.shoppingcarlx.R;

import java.util.List;

import bean.HomeBean;

/*
 *@auther:郝世龙
 *@Date: 2019-12-18
 *@Time:20:19
 *@Description:${DESCRIPTION}
 **/public class Home_z_Adapter extends RecyclerView.Adapter<Home_z_Adapter.Holder> {
    List<HomeBean.ResultBean.SecondCategoryVoBean> list;
    Context context;

    public Home_z_Adapter(List<HomeBean.ResultBean.SecondCategoryVoBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.adapter_z_layout,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.textView.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private TextView textView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.z_text);
        }
    }
}
