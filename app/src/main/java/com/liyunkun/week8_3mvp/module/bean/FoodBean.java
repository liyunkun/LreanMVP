package com.liyunkun.week8_3mvp.module.bean;

/**
 * Created by liyunkun on 2016/10/12 0012.
 */
public class FoodBean {
    private String keywords;
    private String img;
    private String description;

    public FoodBean() {
    }

    public FoodBean(String keywords, String img, String description) {
        this.keywords = keywords;
        this.img = img;
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
