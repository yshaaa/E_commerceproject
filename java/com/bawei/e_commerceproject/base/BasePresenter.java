package com.bawei.e_commerceproject.base;

import com.bawei.e_commerceproject.contract.Contract;

import java.lang.ref.WeakReference;

public abstract class BasePresenter <V extends Contract.IView>implements Contract.IPresenter {

    private WeakReference<V> vWeakReference;

    public BasePresenter(){
        initModel();
    }

    protected abstract void initModel();

    public void Attch(V iView){
        vWeakReference = new WeakReference<>(iView);
    }
    public void onEnd(){
        if (vWeakReference != null) {
            vWeakReference.clear();
            vWeakReference=null;
        }
    }
    public V getView(){
        return vWeakReference.get();
    }


}
