package com.example.kotchaphan.retrofit;

import retrofit.http.GET;

/**
 * Created by Kotchaphan on 4/9/2558.
 */
public interface SimpleRetrofit {

    @GET("/shots/21603")
    Short getShot();
}
