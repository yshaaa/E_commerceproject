package com.bawei.e_commerceproject.contract;

import java.util.Map;

public interface Contract {

    interface IModel{
        void getInfo(String url,Class cls,ModelCallback callback);
        void getInfoGinseng(String url, Class cls, Map<String,Object>map,ModelCallback callback);
        void getInfoGinsengHeader(String url,Class cls,Map<String,Object>map,ModelCallback callback);
        void postInfoGinseng(String url,Class cls,Map<String,Object>map,ModelCallback callback);
    }
    interface IView<T>{
        void onSuccess(T t);
        void onError(String error);
    }
    interface IPresenter{
        void startInfo(String url,Class cls);
        void startInfoGinseng(String url, Class cls, Map<String,Object>map);
        void startInfoGinsengHeader(String url,Class cls,Map<String,Object>map);
        void startpostInfoGinseng(String url,Class cls,Map<String,Object>map,ModelCallback callback);
    }
    interface ModelCallback<T>{
        void onSuccess(T t);
        void onError(String error);
    }

}
