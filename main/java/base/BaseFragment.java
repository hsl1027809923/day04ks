package base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import contract.Icontract;

/*
 *@auther:郝世龙
 *@Date: 2019-12-18
 *@Time:13:43
 *@Description:${DESCRIPTION}
 **/public abstract class BaseFragment<F extends BasePresenterFragment> extends Fragment implements Icontract.IView {
    public F f;
    private View inflate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(initLayot(), container, false);
        return inflate;

    }

    @Override
    public void onStart() {
        super.onStart();
        //初始化控件
        initView(inflate);
        //实例化P层
        f = initPresenter();
        if (f!=null){
            //绑定
            f.Attach(this);
        }
        //设置数据
        initData();

    }

    protected abstract void initView(View inflate);

    protected abstract int initLayot();

    protected abstract F initPresenter();

    protected abstract void initData();
//解绑

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (f!=null){
            f.Uttach();
            f=null;
        }
    }
}
