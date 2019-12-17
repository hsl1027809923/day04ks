package base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import contract.Icontract;

/*
 *@auther:郝世龙
 *@Date: 2019-12-10
 *@Time:10:43
 *@Description:${DESCRIPTION}
 **/public abstract class BaseFragment<F extends BasePresenter> extends Fragment implements Icontract.IView {
    public F f;
    private View inflate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate=inflater.inflate(initLayout(),container,false);
        return inflate;
    }

    @Override
    public void onStart() {
        super.onStart();
        f=initPresenter();
        f.attch(this);
        initVeiw(inflate);
        initData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (f!=null){

            f=null;
            f.Uattach();
        }
    }

    protected abstract void initData();

    protected abstract void initVeiw(View inflate);

    protected abstract F initPresenter();

    protected abstract int initLayout();
}
