package base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import contract.Icontract;

/*
 *@auther:郝世龙
 *@Date: 2019-12-16
 *@Time:9:37
 *@Description:${activity基类}
 **/public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements Icontract.IView {
    public P p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (initLayout() != 0) {
            //加载布局
            setContentView(initLayout());
            //初始化控件
            initView();
            //实例化p层
            p = initPresenter();
            //绑定
            if (p != null) {
                p.Attach(this);
            }
            //设置数据
            initData();


        }
    }

    protected abstract int initLayout();

    protected abstract void initView();

    protected abstract P initPresenter();

    protected abstract void initData();
    //解绑


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (p!=null){
            p.Uttach();
            p=null;
        }
    }
}
