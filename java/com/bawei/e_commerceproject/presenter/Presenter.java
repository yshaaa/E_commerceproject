package com.bawei.e_commerceproject.presenter;

import com.bawei.e_commerceproject.base.BasePresenter;
import com.bawei.e_commerceproject.contract.Contract;
import com.bawei.e_commerceproject.model.Model;

import java.util.Map;

public class Presenter extends BasePresenter {
    public Model model;
    @Override
    protected void initModel() {
        model=new Model();
    }

    @Override
    public void startInfo(String url, Class cls) {
        model.getInfo(url, cls, new Contract.ModelCallback() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onError(String error) {
                getView().onError(error);
            }
        });
    }

    @Override
    public void startInfoGinseng(String url, Class cls, Map<String, Object> map) {

    }

    @Override
    public void startInfoGinsengHeader(String url, Class cls, Map<String, Object> map) {

    }

    @Override
    public void startpostInfoGinseng(String url, Class cls, Map<String, Object> map, Contract.ModelCallback callback) {

    }
}
