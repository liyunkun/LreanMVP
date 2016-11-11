package com.liyunkun.week8_3mvp.presenter;

import android.content.Context;
import android.os.Handler;

import com.liyunkun.week8_3mvp.module.bean.FoodBean;
import com.liyunkun.week8_3mvp.module.impl.IFoodLoadImpl;
import com.liyunkun.week8_3mvp.module.intf.CallBack;
import com.liyunkun.week8_3mvp.module.intf.IFoodLoad;
import com.liyunkun.week8_3mvp.view.adapter.MyAdapter;
import com.liyunkun.week8_3mvp.view.intf.IFood;

import java.util.List;

/**
 * Created by liyunkun on 2016/10/12 0012.
 */
public class FoodPresenter {
    private IFood iFood;
    private IFoodLoad iFoodLoad;
    private Context context;
    private Handler handler=new Handler();

    public FoodPresenter(IFood iFood) {
        this.iFood = iFood;
        iFoodLoad=new IFoodLoadImpl();
        context= (Context) iFood;
    }
    public void load(){
        iFoodLoad.getData(new CallBack() {
            @Override
            public void onSuccessful(final List<FoodBean> list) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iFood.initData(new MyAdapter(list,context));
                    }
                });
            }

            @Override
            public void onFailed(final String msgError) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iFood.showError(msgError);
                    }
                });
            }
        });
    }
}
