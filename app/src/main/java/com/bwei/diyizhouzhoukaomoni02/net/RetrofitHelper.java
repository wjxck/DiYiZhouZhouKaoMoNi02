package com.bwei.diyizhouzhoukaomoni02.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitHelper {
    public static OkHttpClient okHttpClient;
    public static ServiceAPI serviceAPI;

    static {
        initOkHttpClient();
    }

    //初始化OkHttpClient
    public static void initOkHttpClient() {
        if (okHttpClient == null) {
            synchronized (RetrofitHelper.class) {
                if (okHttpClient == null) {
                    okHttpClient = new OkHttpClient();
                }
            }
        }
    }

    public static ServiceAPI getServiceAPI() {
        if (serviceAPI == null) {
            synchronized (ServiceAPI.class) {
                if (serviceAPI == null) {
                    serviceAPI = OnCreateApi(ServiceAPI.class,API.BASE_HOST_URL);
                }
            }
        }
        return serviceAPI;
    }

    //定义方法初始化ServiceAPI
    public static <T> T OnCreateApi(Class<T> tClass, String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(tClass);
    }
}
