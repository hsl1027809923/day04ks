package app;

import android.app.Application;
import android.content.Context;

/*
 *@auther:郝世龙
 *@Date: 2019-12-16
 *@Time:10:26
 *@Description:${DESCRIPTION}
 **/public class MyApp extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }
}
