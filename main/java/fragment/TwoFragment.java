package fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.haoshilong.R;

/*
 *@auther:郝世龙
 *@Date: 2019-12-03
 *@Time:9:19
 *@Description:${DESCRIPTION}
 **/public class TwoFragment extends Fragment {
    private View mview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mview=inflater.inflate(R.layout.two_layout,null);
        return mview;
    }
}
