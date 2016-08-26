package com.bjw.rxjavatest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/7/31 0031.
 */
public interface MovieService {
    @GET("top250")
    Call<WeatherBean> getTopMovie(@Query("start") int start, @Query("count") int count);
}
