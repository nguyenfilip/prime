package com.mkyong.entity;

/**
 * Created by maslo on 28.1.17.
 */
public class CatNeed {
    private NeedType needType;
    private String name;


    public CatNeed(NeedType needType, String name) {
        this.needType = needType;
        this.name = name;
    }

    public enum NeedType { FOOD, TOY, SAND}

    public NeedType getNeedType() {
        return needType;
    }

    public void setNeedType(NeedType needType) {
        this.needType = needType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
