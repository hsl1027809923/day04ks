package adapter;

import android.content.Context;
import android.graphics.Color;
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
 **/public class Home_f_Adapter extends RecyclerView.Adapter<Home_f_Adapter.Holder> {
    List<HomeBean.ResultBean> list;
    Context context;
    int colorposition=0;

    public Home_f_Adapter(List<HomeBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.adapter_f_layout,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int position) {
        holder.textView.setText(list.get(position).getName());
        if (colorposition==position){
            holder.textView.setTextColor(Color.RED);
        }else {
            holder.textView.setTextColor(Color.BLACK);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.setCall(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private TextView textView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.f_text);
        }
    }
    public interface CallBack{
        void setCall(int i);
    }
    private CallBack callBack;

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    public void setColorposition(int colorposition) {
        this.colorposition = colorposition;
        notifyDataSetChanged();
    }
}
