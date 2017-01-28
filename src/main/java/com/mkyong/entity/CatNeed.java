package com.mkyong.entity;

import java.io.Serializable;

/**
 * Created by maslo on 28.1.17.
 */
public class CatNeed implements Serializable {
    private NeedType type;
    private String name;


    public CatNeed(NeedType type, String name) {
        this.type = type;
        this.name = name;
    }

    public CatNeed() {

    }

    public NeedType getType() {
        return type;
    }

    public void setType(NeedType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
