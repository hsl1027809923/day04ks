package fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.dimensionsofelectricity.R;

/*
 *@auther:郝世龙
 *@Date: 2019-12-04
 *@Time:14:05
 *@Description:${DESCRIPTION}
 **/public class Circle_fragment extends Fragment {
    private View mview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mview=inflater.inflate(R.layout.two_layout,null);
        return mview;
    }
}
