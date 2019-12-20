package base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import contract.Icontract;

/*
 *@auther:郝世龙
 *@Date: 2019-12-18
 *@Time:10:28
 *@Description:${DESCRIPTION}
 **/public abstract class BaseActivity<P extends BasePresenterActivity> extends AppCompatActivity implements Icontract.IView {
    public P p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (initLayout() != 0) {
            setContentView(initLayout());
            //初始化控件
            initView();
            //实例化P层
            p = initPresenter();
            //绑定
            if (p != null) {
                p.Attach(this);
            }
            initData();
        }
    }


    protected abstract int initLayout();

    protected abstract P initPresenter();

    protected abstract void initView();

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

