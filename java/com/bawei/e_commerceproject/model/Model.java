package com.bawei.e_commerceproject.model;

import com.bawei.e_commerceproject.contract.Contract;
import com.bawei.e_commerceproject.util.NetUtils;

import java.util.Map;

public class Model implements Contract.IModel {
    @Override
    public void getInfo(String url, Class cls, Contract.ModelCallback callback) {
        NetUtils.getInstance().getInfo(url, cls, new NetUtils.NetCallBack() {
            @Override
            public void onSuccess(Object o) {
                callback.onSuccess(o);
            }

            @Override
            public void onError(String error) {
                callback.onError(error);
            }
        });
    }

    @Override
    public void getInfoGinseng(String url, Class cls, Map<String, Object> map, Contract.ModelCallback callback) {

    }

    @Override
    public void getInfoGinsengHeader(String url, Class cls, Map<String, Object> map, Contract.ModelCallback callback) {

    }

    @Override
    public void postInfoGinseng(String url, Class cls, Map<String, Object> map, Contract.ModelCallback callback) {

    }
}
