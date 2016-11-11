package com.liyunkun.week8_3mvp.view.intf;

import com.liyunkun.week8_3mvp.view.adapter.MyAdapter;

/**
 * Created by liyunkun on 2016/10/12 0012.
 */
public interface IFood {
    void initData(MyAdapter adapter);
    void showError(String msg);
}
