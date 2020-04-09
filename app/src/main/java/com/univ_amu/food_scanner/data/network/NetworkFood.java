package com.univ_amu.food_scanner.data.network;

import java.util.Date;
import java.util.List;

public class NetworkFood {
    String code;
    String name;
    String brands;
    String nutriscore;
    List<NetworkQuantity> quantities;

    public String toString(){

        return "code:"+ code+","+"name:"+name+","+"brands:"+brands+","+"nutriscore:"+nutriscore;
    }

    public static class NetworkQuantity {
        String name;
        int rank;
        int level;
        double value;
        String unit;
        /* TODO */
        public String toString() {

            return "name:" + name + "," + "rank:" + rank + "," + "level:" + level + "," +

                    "value:" + value + "unit:" + unit;
        }
    }
}