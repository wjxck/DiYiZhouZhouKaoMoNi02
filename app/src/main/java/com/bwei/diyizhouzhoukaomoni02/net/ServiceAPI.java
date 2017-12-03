package com.bwei.diyizhouzhoukaomoni02.net;


import com.bwei.diyizhouzhoukaomoni02.bean.GankBean;
import com.bwei.diyizhouzhoukaomoni02.bean.ResultsBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface ServiceAPI {

    @GET("api/data/Android/{size}/{page}")
    Call<GankBean<ResultsBean>> bean(@Path("size")int size, @Path("page")int page);
}
