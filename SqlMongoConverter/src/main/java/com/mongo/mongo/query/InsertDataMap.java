package com.mongo.mongo.query;

import java.util.ArrayList;
import java.util.List;

public class InsertDataMap {

    List<OneColAndData> colData = new ArrayList<>();

    public InsertDataMap(List<String> col, List<String> val) {
        for (int i = 0; i < col.size(); i++) {
            this.colData.add(new OneColAndData(col.get(i), val.get(i)));
        }
    }

    @Override
    public String toString() {
        return colData.toString().replace("[", "").replaceAll("]", "");
    }

    class OneColAndData {

        private String keyData;
        private String keyValue;

        OneColAndData(String keyData, String keyValue) {
            this.keyData = "\"" + keyData + "\"";
            this.keyValue = "\"" + keyValue + "\"";
        }

        @Override
        public String toString() {
            return keyData + ":" + keyValue;
        }

    }


}