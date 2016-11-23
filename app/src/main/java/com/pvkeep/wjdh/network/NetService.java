package com.pvkeep.wjdh.network;

import com.pvkeep.wjdh.common.entity.UserVo;
import com.pvkeep.wjdh.mine.entity.User;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Admin on 2016/10/15.
 */
public interface NetService {

    //基础url
    String BASE_URL = "http://www.gank.io/api/";

    //各种请求方法
    @GET("data/all/20/{page}")
    Observable<User> getAndroidData(@Path("page") int page);

    @POST("")
    Observable<UserVo> login(@QueryMap Map<String, String> map);

}
