package url;

import java.net.URL;

/*
 *@auther:郝世龙
 *@Date: 2019-12-09
 *@Time:9:27
 *@Description:${DESCRIPTION}
 **/public interface MyUrl {
    //内网
    String BEANURL="http://172.17.8.100/";
    //外网
    String WWANURL="mobile.bwstudent.com";
    //首页
    String SY="small/commodity/v1/commodityList";
    //轮播图
    String BN="small/commodity/v1/bannerShow";

    //登陆
    String LOGIN="small/user/v1/login";
    //注册
    String ZHUCE="small/user/v1/register";
    //订单
    String ORDER="order/verify/v1/findOrderListByStatus";

}
