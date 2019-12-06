package util;

import android.os.Handler;

import org.greenrobot.greendao.annotation.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import cotract.Icontract;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/*
 *@auther:郝世龙
 *@Date: 2019-12-03
 *@Time:10:27
 *@Description:${DESCRIPTION}
 **/public class OKHttpUtil {
    //日志拦截器
    private final HttpLoggingInterceptor interceptor1;

    private OkHttpClient LokHttpClient;
    //handler通信
    private Handler handler=new Handler(){};

    private Request build;

    //构造函数中做一些初始化的操作
    private OKHttpUtil() {
        //添加日志拦截器
        interceptor1 = new HttpLoggingInterceptor();
        interceptor1.setLevel(HttpLoggingInterceptor.Level.BODY);

//        Okhttp
        LokHttpClient = new OkHttpClient.Builder()
                //秒
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .readTimeout(5000,TimeUnit.MILLISECONDS)
                .writeTimeout(5000,TimeUnit.MILLISECONDS)
                .addInterceptor(interceptor1)
                .build();
    }
    //单例模式
    private static class OKHttpUtilHoder{
        private static final OKHttpUtil util=new OKHttpUtil();
    }

    public static OKHttpUtil getInstance() {
        return OKHttpUtilHoder.util;
    }
    //声明接口

    //异步get请求
    public void asynGet(String url, final Icontract.CallBack callBack){
        //地址
        build = new Request.Builder().url(url).build();

        LokHttpClient.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull final IOException e) {
                final String message = e.getMessage();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //错误
                        callBack.error(message);
                    }
                });
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull final Response response) throws IOException {
                final String string = response.body().string();

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.success(string);
                    }
                });
            }
        });

    }

    //d)	封装网络判断，可以判断有网无网（3分）
//    public boolean GetNet(Context context){
//        ConnectivityManager manager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo info = manager.getActiveNetworkInfo();
//        if (info!=null){
//            return info.isConnected();
//        }
//        return false;
//    }



}
