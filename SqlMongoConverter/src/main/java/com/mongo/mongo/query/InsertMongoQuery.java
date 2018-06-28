package com.mongo.mongo.query;

import java.util.List;
import java.util.StringJoiner;

public class InsertMongoQuery implements MongoQuery {

    private String tableName;
    private List<InsertDataMap> insertData;

    public InsertMongoQuery() {
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<InsertDataMap> getInsertData() {
        return insertData;
    }

    public void setInsertData(List<InsertDataMap> insertData) {
        this.insertData = insertData;
    }

    @Override
    public String toString() {
        String data = "";
        if (this.insertData.size() == 1) {
            data = "insertOne({" + insertData.get(0) + "})";
        } else {
            StringJoiner stringJoiner = new StringJoiner(",");
            for (InsertDataMap insertDataMap : insertData) {
                stringJoiner.add("{" + insertDataMap + "}");
                data = "insertMany([" + stringJoiner + "])";
            }
        }
        return "db." + this.tableName + "." + data;
    }


}
