package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bawei.dsxm.R;
import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

import bean.HomeBean;
import bean.Home_Bannerbean;

/*
 *@auther:郝世龙
 *@Date: 2019-12-10
 *@Time:14:02
 *@Description:${DESCRIPTION}
 **/
public class Home_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final int banner=1,rxxp1=2,pzsh1=3,mlss1=4;

    HomeBean.ResultBean home;
    Context context;
    List<Home_Bannerbean.ResultBean> list;
    XBanner.XBannerAdapter xBannerAdapter;

    public Home_Adapter(HomeBean.ResultBean home, Context context, List<Home_Bannerbean.ResultBean> list) {
        this.home = home;
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder holder=null;

        switch (i){
            case banner:
                View bview= LinearLayout.inflate(context,R.layout.banner_page,null);
                holder=new Bbanner(bview);
                break;
            case rxxp1:
                View rview= LinearLayout.inflate(context, R.layout.rxxp_page,null);
                holder=new Rxxp(rview);
                break;

            case pzsh1:
                View pview= LinearLayout.inflate(context, R.layout.pzsh_page,null);
                holder=new Pzsh(pview);
                break;
            case mlss1:
                View mview= LinearLayout.inflate(context, R.layout.mmsl_page,null);
                holder=new Mlss(mview);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof Bbanner){
            if (xBannerAdapter==null){
                Bbanner bbanner= (Bbanner) viewHolder;
                bbanner.banner_x.setData(list,null);

                xBannerAdapter=new XBanner.XBannerAdapter() {
                    @Override
                    public void loadBanner(XBanner banner, Object model, View view, int position) {
                        Home_Bannerbean.ResultBean resultBean = list.get(position);
                        Glide.with(context).load(resultBean.getImageUrl()).into((ImageView) view);
                    }
                };
            bbanner.banner_x.setmAdapter(xBannerAdapter);
            }
        }
       else if (viewHolder instanceof Rxxp){
            Rxxp rxxp= (Rxxp) viewHolder;
            rxxp.rxxp_text.setText("热销新品");
            rxxp.recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
            Rxxpadapter rxxpadapter=new Rxxpadapter(home.getRxxp().getCommodityList(),context);
            rxxp.recyclerView.setAdapter(rxxpadapter);

      }else if (viewHolder instanceof Pzsh){
            ((Pzsh) viewHolder).recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
            ((Pzsh) viewHolder).pzsh_text.setText("品质生活");
            Pzshadapter badapter=new Pzshadapter(home.getPzsh().getCommodityList(),context);
            ((Pzsh) viewHolder).recyclerView.setAdapter(badapter);
        }else if (viewHolder instanceof Mlss){
            ((Mlss) viewHolder).recyclerView.setLayoutManager(new GridLayoutManager(context,2));
            ((Mlss) viewHolder).mlss_text.setText("魔力时尚");
            Mlssadapter cadapter=new Mlssadapter(home.getMlss().getCommodityList(),context);
            ((Mlss) viewHolder).recyclerView.setAdapter(cadapter);
        }
    }

    @Override
    public int getItemCount() {
        int count=0;
        if (list.size()>0){
            count++;
        }
        if (home!=null){
            if (home.getPzsh().getCommodityList().size()>0){
                count++;
            }
            if (home.getRxxp().getCommodityList().size()>0){
                count++;
            }
            if (home.getMlss().getCommodityList().size()>0){
                count++;
            }

        }
        return count;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return banner;
        }else if (position==1){
            return rxxp1;
        }else if (position==2){
            return pzsh1;
        }else if (position==3){
            return mlss1;
        }

        return super.getItemViewType(position);
    }

    class Rxxp extends RecyclerView.ViewHolder {
        private RecyclerView recyclerView;
        private TextView rxxp_text;
        public Rxxp(@NonNull View itemView) {
            super(itemView);
            recyclerView=itemView.findViewById(R.id.rxxp_recyclview);
            rxxp_text=itemView.findViewById(R.id.rxxp_text);
        }
    }
    class Pzsh extends RecyclerView.ViewHolder {
        private RecyclerView recyclerView;
        private TextView pzsh_text;
        public Pzsh(@NonNull View itemView) {
            super(itemView);
            recyclerView=itemView.findViewById(R.id.pzsh_recyclview);
            pzsh_text=itemView.findViewById(R.id.pzsh_text);

        }
    }
    class Mlss extends RecyclerView.ViewHolder {
        private RecyclerView recyclerView;
        private TextView mlss_text;
        public Mlss(@NonNull View itemView) {
            super(itemView);
            recyclerView=itemView.findViewById(R.id.mlss_recyclview);
            mlss_text=itemView.findViewById(R.id.mlss_text);
        }
    }
    class Bbanner extends RecyclerView.ViewHolder {
        private XBanner banner_x;
        public Bbanner(@NonNull View itemView) {
            super(itemView);
            banner_x=itemView.findViewById(R.id.banner_a);
        }
    }


}
