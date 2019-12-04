package base;

/*
 *@auther:郝世龙
 *@Date: 2019-12-03
 *@Time:9:14
 *@Description:${DESCRIPTION}
 **/public class BasePresenter<V extends BaseActivity> {
    public V v;
    //绑定
    public void attach(V v){
        this.v=v;
    }
    //解绑
    public void Uattch(){
        if (v!=null){
            v=null;
        }
    }


}
