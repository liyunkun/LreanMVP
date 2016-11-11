package com.liyunkun.week8_3mvp.module.intf;

import com.liyunkun.week8_3mvp.module.bean.FoodBean;

import java.util.List;

/**
 * Created by liyunkun on 2016/10/12 0012.
 */
public interface CallBack {
    void onSuccessful(List<FoodBean> list);
    void onFailed(String msgError);
}
