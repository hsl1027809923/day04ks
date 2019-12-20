package api;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

/*
 *@auther:郝世龙
 *@Date: 2019-12-18
 *@Time:11:57
 *@Description:${DESCRIPTION}
 **/public interface MyApi {

    //联动
    @GET
    Observable<ResponseBody> getInfo(@Url String url);
    //联动
    @GET
    Observable<ResponseBody> getInfoCar(@Url String url);

}
