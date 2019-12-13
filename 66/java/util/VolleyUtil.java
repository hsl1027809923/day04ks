package util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import app.MyApp;
import cotract.Icontract;

/*
 *@auther:郝世龙
 *@Date: 2019-12-03
 *@Time:10:28
 *@Description:${Volley}
 **/public class VolleyUtil {
    RequestQueue queue= Volley.newRequestQueue(MyApp.context);
    //单例模式
    private static class VolleyHoder{
        private static final VolleyUtil util=new VolleyUtil();
    }

    private VolleyUtil() {
    }

    public static VolleyUtil getInstance() {
        return VolleyHoder.util;
    }
    //d)	封装网络判断，可以判断有网无网（3分）
    public boolean GetNet(Context context){
        ConnectivityManager manager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info!=null){
            return info.isConnected();
        }
        return false;
    }
    //get请求
    public void ToGet(String url,final Icontract.CallBack callBack){
        StringRequest request=new StringRequest(0, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.error(error.getMessage());
            }
        });
        queue.add(request);
    }

}
