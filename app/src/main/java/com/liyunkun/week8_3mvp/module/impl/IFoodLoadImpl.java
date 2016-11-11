package com.liyunkun.week8_3mvp.module.impl;

import com.liyunkun.week8_3mvp.module.bean.FoodBean;
import com.liyunkun.week8_3mvp.module.intf.CallBack;
import com.liyunkun.week8_3mvp.module.intf.IFoodLoad;
import com.liyunkun.week8_3mvp.module.util.OkHttpUtils;
import com.liyunkun.week8_3mvp.module.util.ParseJson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by liyunkun on 2016/10/12 0012.
 */
public class IFoodLoadImpl implements IFoodLoad {
    private static String json = null;
    private static String msgError = null;
    private static String httpUrl="http://www.tngou.net/api/food/list";

    @Override
    public void getData(final CallBack callBack) {
        Request request=new Request.Builder()
                .url(httpUrl)
                .build();
        OkHttpUtils.client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String magError=e.getMessage();
                callBack.onFailed(msgError);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String json=response.body().string();
                    List<FoodBean> list = ParseJson.getData2List(json);
                    callBack.onSuccessful(list);
                }
            }
        });

    }
}
