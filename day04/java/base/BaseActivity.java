package base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 *@auther:郝世龙
 *@Date: 2019-12-03
 *@Time:9:09
 *@Description:${DESCRIPTION}
 **/public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
     public P p;
    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(Layout());
        //a)	在Activity中注册ButterKnife绑定控件（3）
        bind = ButterKnife.bind(this);
        p=Payout();
        //绑定
        if (p!=null){
            p.attach(this);
        }
        initView();
        initData();
    }

    protected abstract void initData();


    protected abstract void initView();

    protected abstract int Layout();
    protected abstract P Payout();
    //解绑

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (p!=null){
            p.Uattch();
            p=null;
        }
        if (bind!=null){
            bind.unbind();
        }

    }
}
