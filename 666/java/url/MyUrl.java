package url;

/*
 *@auther:郝世龙
 *@Date: 2019-12-16
 *@Time:9:51
 *@Description:${接口}
 **/public interface MyUrl {
    //内网
    String BANNER="http://172.17.8.100/small/";

    //登陆
    String LOGIN="user/v1/login";
    //订单
    String ORDER="order/verify/v1/findOrderListByStatus";
}
