package base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/*
 *@auther:郝世龙
 *@Date: 2019-12-03
 *@Time:10:50
 *@Description:${DESCRIPTION}
 **/public class BaseFragment<F extends BasePresenter> extends Fragment {
    public F f;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    }
}
