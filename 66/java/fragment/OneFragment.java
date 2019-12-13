package fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.haoshilong.R;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 *@auther:郝世龙
 *@Date: 2019-12-03
 *@Time:9:19
 *@Description:${付款码}
 **/public class OneFragment extends Fragment {
    @BindView(R.id.one_text1)
    TextView oneText1;
    @BindView(R.id.one_img)
    ImageView oneImg;
    @BindView(R.id.one_text2)
    TextView oneText2;
    Unbinder unbinder;
    private View mview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //视图
        mview = inflater.inflate(R.layout.one_layout, null);
        unbinder = ButterKnife.bind(this, mview);
        return mview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String trim = oneText1.getText().toString().trim();
        if (TextUtils.isEmpty(trim)){
            Toast.makeText(getContext(), "空的", Toast.LENGTH_SHORT).show();
        }else {
            //生成二维码
            Bitmap image = CodeUtils.createImage(trim, 300, 300, null);
            oneImg.setImageBitmap(image);
        }
        //图片长按识别
        oneImg.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getContext(),oneText1.getText().toString(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
