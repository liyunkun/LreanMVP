package com.liyunkun.week8_3mvp.module.util;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by liyunkun on 2016/10/12 0012.
 */
public class OkHttpUtils {
    public static OkHttpClient client=new OkHttpClient.Builder()
            .connectTimeout(5*1000, TimeUnit.SECONDS)
            .build();
}
