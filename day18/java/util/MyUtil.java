package util;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import api.MyApi;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
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
 *@Date: 2019-12-18
 *@Time:14:42
 *@Description:${DESCRIPTION}
 **/public class MyUtil  {
    private final MyApi myApi;
    //单例模式

    private MyUtil() {
        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .connectTimeout(5000,TimeUnit.MILLISECONDS)
                .writeTimeout(5000,TimeUnit.MILLISECONDS)
                .addInterceptor(interceptor)
                .addInterceptor(new Interceptor() {
                    String userId = "11311";
                    String sessionId="157675863024611311";
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        if (TextUtils.isEmpty(userId)||TextUtils.isEmpty(sessionId)){
                            return chain.proceed(chain.request());
                        }else {
                            Request request=chain.request().newBuilder()
                                    .addHeader("userId",userId)
                                    .addHeader("sessionId",sessionId)
                                    .build();
                            return chain.proceed(request);
                        }
                    }
                })
                .build();
        Retrofit retrofit=new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(MyUrl.NET)
                //支持RxJAVA
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(MyApi.class);
    }
    private static class UtilHolder{
        private static final MyUtil util=new MyUtil();
    }

    public static MyUtil getInstance() {
        return UtilHolder.util;
    }
    //联动
    public void GetInfo(String url, final Class cls, final HCallBack callBack){
        myApi.getInfo(url).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Log.e("hslcallBack",string);
                            Object o = new Gson().fromJson(string, cls);
                            callBack.onSuccess(o);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //购物车
    public void GetInfoCar(String url, final Class cls, final HCallBack callBack){
        myApi.getInfoCar(url).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Log.e("hslcallBack",string);
                            Object o = new Gson().fromJson(string, cls);
                            callBack.onSuccess(o);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public interface HCallBack<T>{
        void onSuccess(T t);
        void onError(String er);
    }

}
