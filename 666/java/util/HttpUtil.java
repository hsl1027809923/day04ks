package util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import api.MyApi;
import app.MyApp;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import url.MyUrl;

/*
 *@auther:郝世龙
 *@Date: 2019-12-16
 *@Time:9:53
 *@Description:${网络工具类}
 **/public class HttpUtil {

    private final MyApi myApi;

    //单例模式
    private HttpUtil() {
        //日志拦截器
        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClien=new OkHttpClient.Builder()
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .writeTimeout(5000,TimeUnit.MILLISECONDS)
                .connectTimeout(5000,TimeUnit.MILLISECONDS)
                .addInterceptor(interceptor)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        SharedPreferences hsldg = MyApp.context.getSharedPreferences("hsldg", Context.MODE_PRIVATE);
                        String userId = hsldg.getString("userId", "");
                        String sessionId = hsldg.getString("sessionId", "");
                        //自定义拦截器
                        if (TextUtils.isEmpty(userId)||TextUtils.isEmpty(sessionId)){
                            return chain.proceed(chain.request());
                        }else {
                            Request request=chain.request().newBuilder()
                                    .addHeader("sessionId",sessionId)
                                    .addHeader("userId",userId)
                                    .build();
                            //打印
                            Log.e("userId",userId);
                            Log.e("sessionId",sessionId);
                            return chain.proceed(request);
                        }
                    }
                })
                .build();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(MyUrl.BANNER)
                .client(okHttpClien)
                //允许Gson

                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //允许RxJava
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //api
        myApi = retrofit.create(MyApi.class);

    }
    private static class HttpHolder{
        private static final HttpUtil util=new HttpUtil();
    }

    public static HttpUtil getInstance() {
        return HttpHolder.util;
    }
    //登陆
    public void PostHaveDL(String url, Map<String,Object> map, final Class cls, final HCallBack callBack){
        myApi.postHave(url,map).subscribeOn(Schedulers.io())//被观察者在子线程
                .observeOn(AndroidSchedulers.mainThread())//观察者在主线程
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        //解析
                        try {
                            String string = responseBody.string();
                            Object o = new Gson().fromJson(string, cls);
                            //Log日志
                            Log.e("stringhsl",string);
                            //返回
                            callBack.onSuccess(o);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override//失败
                    public void onError(Throwable e) {
                        callBack.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //订单
    public void GetHaveorder(String url, Map<String,Object> map, final Class cls, final HCallBack callBack){
        myApi.getHave(url,map).subscribeOn(Schedulers.io())//被观察者在子线程
                .observeOn(AndroidSchedulers.mainThread())//观察者在主线程
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        //解析
                        try {
                            String string = responseBody.string();
                            Object o = new Gson().fromJson(string, cls);
                            //Log日志
                            Log.e("stringhsl",string);
                            //返回
                            callBack.onSuccess(o);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override//失败
                    public void onError(Throwable e) {
                        callBack.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //接口回调
    public interface HCallBack<T>{
        void onSuccess(T t);
        void onError(String er);
    }

}
