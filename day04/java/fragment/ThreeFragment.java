package fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bawei.haoshilong.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/*
 *@auther:郝世龙
 *@Date: 2019-12-03
 *@Time:9:19
 *@Description:${扫一扫}
 **/public class ThreeFragment extends Fragment {
    @BindView(R.id.ss_but)
    Button ssBut;
    Unbinder unbinder;
    private View mview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mview = inflater.inflate(R.layout.three_layout, null);
        unbinder = ButterKnife.bind(this, mview);
        return mview;

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.ss_but)
    public void onViewClicked() {
//        //进入扫一扫
//        Intent intent = new Intent(getActivity(), CaptureActivity.class);
//        startActivityForResult(intent, 1);
    }
}
