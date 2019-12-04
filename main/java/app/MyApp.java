package app;

import android.content.Context;

import com.uuzuche.lib_zxing.ZApplication;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

/*
 *@auther:郝世龙
 *@Date: 2019-12-03
 *@Time:9:32
 *@Description:${DESCRIPTION}
 **/public class MyApp extends ZApplication {
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        ZXingLibrary.initDisplayOpinion(this);
        context=this;
    }

}
