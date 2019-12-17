package base;

import contract.Icontract;

/*
 *@auther:郝世龙
 *@Date: 2019-12-16
 *@Time:9:38
 *@Description:${presenter基类}
 **/public abstract class BasePresenter<V extends BaseActivity> implements Icontract.IPresenter {
    public V v;
    //绑定方法
    public void Attach(V v){
        this.v=v;
    }
    //解绑方法
    public void Uttach(){
        if (v!=null){
            v=null;
        }
    }
}
