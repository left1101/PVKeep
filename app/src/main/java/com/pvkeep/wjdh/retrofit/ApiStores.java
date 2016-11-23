package com.pvkeep.wjdh.retrofit;

import com.pvkeep.wjdh.common.entity.UserVo;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Xiexr
 */
public interface ApiStores {
    //baseUrl
    String API_SERVER_URL = "http://182.18.19.152:8089/mobile/";

    @POST("login")
    Observable<UserVo> login(@QueryMap Map<String, String> map);
}
