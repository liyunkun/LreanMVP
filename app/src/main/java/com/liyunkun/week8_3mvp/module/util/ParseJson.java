package com.liyunkun.week8_3mvp.module.util;

import com.liyunkun.week8_3mvp.module.bean.FoodBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyunkun on 2016/10/12 0012.
 */
public class ParseJson {
    private static List<FoodBean> list=new ArrayList<>();
    public static List<FoodBean> getData2List(String json){
        try {
            JSONArray array = new JSONObject(json).optJSONArray("tngou");
            for (int i = 0; i < array.length(); i++) {
                JSONObject foods = array.optJSONObject(i);
                String description = foods.optString("description");
                String keywords = foods.optString("keywords");
                String img = "http://tnfs.tngou.net/image" + foods.optString("img");
                FoodBean foodBean=new FoodBean(keywords,img,description);
                list.add(foodBean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}
