package com.bawei.e_commerceproject.api;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiService {

    @GET//get无参数
    Observable<ResponseBody>getInfo(@Url String url);

    @GET//get有参数
    Observable<ResponseBody>getInfoGinseng(@Url String url, @QueryMap Map<String,Object>map);

    @GET//get有参数请求头
    Observable<ResponseBody>getInfoGinsengHeader(@Url String url, @HeaderMap Map<String,Object>map);

    @POST//post有参数
    Observable<ResponseBody>postInfoGinseng(@Url String url,@QueryMap Map<String,Object>map);

}
