package com.mongo.mongo.query;

import com.mongo.sql.query.InsertSqlQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class InsertMongoQuery {

    private String tableName;
    private List<InsertDataMap> insertData;

    public InsertMongoQuery(InsertSqlQuery insertSqlQuery) {

        this.tableName = insertSqlQuery.getTableName();
        this.insertData = getInsertDataMap(insertSqlQuery.getColumnNames(), insertSqlQuery.getColumnValues());
    }

    private List<InsertDataMap> getInsertDataMap(List<String> columnValues, List<List<String>> list) {
        List<InsertDataMap> insertDataMaps = new ArrayList<>();

        for (List<String> columnDataValues : list) {
            if (columnValues.size() == columnDataValues.size()) {
                insertDataMaps.add(new InsertDataMap(columnValues, columnDataValues));
            } else {
                throw new RuntimeException("Data Column & Values are mismatched.");
            }
        }
        return insertDataMaps;
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
