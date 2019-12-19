package api;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/*
 *@auther:郝世龙
 *@Date: 2019-12-16
 *@Time:9:46
 *@Description:${请求类型}
 **/public interface MyApi {
    //登陆
    @POST
    Observable<ResponseBody> postHave(@Url String url, @QueryMap Map<String,Object> map);
    //订单
    @GET
    Observable<ResponseBody> getHave(@Url String url,@QueryMap Map<String,Object>map);
}
