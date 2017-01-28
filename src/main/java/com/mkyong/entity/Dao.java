package com.mkyong.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maslo on 28.1.17.
 */
public class Dao implements Serializable {
    List<CatNeed> needs = new ArrayList<CatNeed>();

    public Dao() {
        needs.add(new CatNeed(NeedType.FOOD, "Granule"));
    }

    public List<CatNeed> listAllNeeds() {
        return needs;
    }

    public void save(CatNeed newNeed) {
        needs.add(newNeed);
    }
}
