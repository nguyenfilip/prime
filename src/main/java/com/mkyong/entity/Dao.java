package com.mkyong.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maslo on 28.1.17.
 */
public class Dao {

    public List<CatNeed> listAllNeeds() {
        List<CatNeed> result = new ArrayList<CatNeed>();

        result.add(new CatNeed(CatNeed.NeedType.FOOD, "Granule"));

        return result;
    }
}
