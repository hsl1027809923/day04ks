package base;

import contract.Icontract;

/*
 *@auther:郝世龙
 *@Date: 2019-12-18
 *@Time:10:28
 *@Description:${DESCRIPTION}
 **/public abstract class BasePresenterFragment<V extends BaseFragment>implements Icontract.IPresenter {
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
